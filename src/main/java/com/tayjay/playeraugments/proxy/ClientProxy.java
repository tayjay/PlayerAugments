package com.tayjay.playeraugments.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by tayjm_000 on 2015-10-18.
 *
 * Client side proxy.
 */
public class ClientProxy extends CommonProxy
{

    @Override
    public void preInit()
    {

    }


    @Override
    public void registerKeyBindings()
    {
        /*
        //ClientRegistry.registerKeyBinding(Keybindings.charge);
        //ClientRegistry.registerKeyBinding(Keybindings.release);
        //ClientRegistry.registerKeyBinding(Keybindings.EXPLODE.getKeybind());
        FMLCommonHandler.instance().bus().register(new KeyInputHandler());
        for(Keybindings key : Keybindings.values())
        {
            ClientRegistry.registerKeyBinding(key.getKeybind());
        }
        */
    }


    @Override
    public  void init()
    {

    }

    @Override
    public void postInit()
    {

    }

    @Override
    public EntityPlayer getClientPlayer()
    {
        return Minecraft.getMinecraft().thePlayer;
    }
}
