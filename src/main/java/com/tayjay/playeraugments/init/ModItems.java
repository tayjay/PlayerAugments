package com.tayjay.playeraugments.init;

import com.tayjay.playeraugments.item.ItemAugment;
import com.tayjay.playeraugments.item.ItemBrainImplant;
import com.tayjay.playeraugments.item.ItemEnergyCell;
import com.tayjay.playeraugments.item.ItemPA;
import com.tayjay.playeraugments.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by tayjm_000 on 2015-10-18.
 * Register Items
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID) //Stop other people from messing with your item registry
public class ModItems
{
    /*
     * Declare all Items
     */
    //public static ItemPA augment;
    public static ItemPA brainImplant;
    public static ItemPA energyCell;

    /**
     * Initiate the Item objects
     */
    public static void init()
    {
        //augment = new ItemAugment();
        energyCell = new ItemEnergyCell();
        brainImplant = new ItemBrainImplant();

    }

    /**
     * Try to register an item.
     *
     * @param item  Item to register.
     */
    public static void register(final ItemPA item)
    {
        String name = item.getUnwrappedUnlocalizedName(item.getUnlocalizedName());
        if(isEnabled(item)) GameRegistry.registerItem(item, name.substring(name.indexOf(":") + 1));
    }

    /**
     * Check is an item can be registered.
     *
     * @param item  Item to check.
     * @return      Item is NOT on blacklist.
     */
    public static boolean isEnabled(Item item)
    {
        //return !ConfigHandler.disabledNamesList.contains(item.getUnlocalizedName());
        return true;
    }
}
