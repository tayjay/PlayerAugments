package com.tayjay.playeraugments.proxy;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by tayjm_000 on 2015-10-18.
 *
 * Shared methods between the Server and Client Proxies
 */
public abstract class CommonProxy
{
    public abstract void preInit();
    public abstract void init();
    public abstract void postInit();
    public abstract void registerKeyBindings();

    public abstract EntityPlayer getClientPlayer();
}
