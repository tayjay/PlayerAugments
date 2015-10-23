package com.tayjay.playeraugments.event;

import com.tayjay.playeraugments.properties.ExtendedPlayer;
import com.tayjay.playeraugments.util.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;

/**
 * Created by tayjm_000 on 2015-10-18.
 *
 * Handle Events that occur.
 */
public class EventHandlerPA
{
    /**
     * Fires when an entity is created
     * (Join world, spawn, respawn, change dimension)
     * @param event EntityConstructing event
     */
    @SubscribeEvent
    public void onEntityConstucting(EntityEvent.EntityConstructing event)
    {
        /*
            If the entity is a player and they do not have ExtendedPlayer data.
         */
        if(event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer)event.entity)==null)
        {
            LogHelper.debug("Constructing EntityPlayer with ExtendedPlayer properties!");
            ExtendedPlayer.register((EntityPlayer) event.entity);
        }
    }
}
