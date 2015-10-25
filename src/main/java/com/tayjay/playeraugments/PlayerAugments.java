package com.tayjay.playeraugments;

import com.tayjay.playeraugments.augment.AugmentRegistry;
import com.tayjay.playeraugments.init.ModBlocks;
import com.tayjay.playeraugments.init.ModItems;
import com.tayjay.playeraugments.item.ItemBrainImplant;
import com.tayjay.playeraugments.proxy.CommonProxy;
import com.tayjay.playeraugments.reference.Reference;
import com.tayjay.playeraugments.util.NBTHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemStack;

/**
 * Created by tayjm_000 on 2015-10-18.
 *
 * Main Class for the mod.
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class PlayerAugments
{

    /**
     * Instance of the mod.
     */
    @Mod.Instance
    public static PlayerAugments instance;

    /**
     * Create the sided proxy.
     */
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    /**
     * Server starting Event
     * This is where commands should be registered.
     */
    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event)
    {
        //event.registerServerCommand(new CommandName());
    }

    /**
     * Pre-Initialization Event
     * Load Items,Blocks, TileEntities, Networking
     *
     * @param event
     */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        AugmentRegistry.init();

        ModItems.init();
        ModBlocks.init();
    }

    /**
     * Initialization Event
     * Register Event Handlers, Recipes.
     *
     * @param event
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        ItemStack brainImplant0 = new ItemStack(ModItems.brainImplant,1);
        NBTHelper.setString(brainImplant0,"augmentName","brainImplant1");
        GameRegistry.addShapelessRecipe(brainImplant0, new ItemStack(Items.diamond));
    }

    /**
     * Post-Initialization
     * Load after everything else.
     *
     * @param event
     */
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
