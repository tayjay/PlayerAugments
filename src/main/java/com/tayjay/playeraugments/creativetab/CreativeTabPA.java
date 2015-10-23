package com.tayjay.playeraugments.creativetab;

import com.tayjay.playeraugments.init.ModBlocks;
import com.tayjay.playeraugments.init.ModItems;
import com.tayjay.playeraugments.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by tayjm_000 on 2015-10-22.
 */
public class CreativeTabPA
{
    public static final CreativeTabs AUGMENT_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.energyCell;
        }

    };
}
