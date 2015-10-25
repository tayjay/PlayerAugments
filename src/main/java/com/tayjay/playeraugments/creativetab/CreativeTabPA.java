package com.tayjay.playeraugments.creativetab;

import com.tayjay.playeraugments.augment.Augment;
import com.tayjay.playeraugments.augment.AugmentRegistry;
import com.tayjay.playeraugments.init.ModBlocks;
import com.tayjay.playeraugments.init.ModItems;
import com.tayjay.playeraugments.reference.Reference;
import com.tayjay.playeraugments.util.LogHelper;
import com.tayjay.playeraugments.util.NBTHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
