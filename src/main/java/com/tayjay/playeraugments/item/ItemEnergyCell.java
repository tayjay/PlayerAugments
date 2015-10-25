package com.tayjay.playeraugments.item;

import com.tayjay.playeraugments.augment.Augment;
import com.tayjay.playeraugments.augment.AugmentRegistry;
import com.tayjay.playeraugments.creativetab.CreativeTabPA;
import com.tayjay.playeraugments.init.ModItems;
import com.tayjay.playeraugments.reference.Names;
import com.tayjay.playeraugments.reference.Reference;
import com.tayjay.playeraugments.util.LogHelper;
import com.tayjay.playeraugments.util.NBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

import java.util.List;

/**
 * Created by tayjm_000 on 2015-10-19.
 */
public class ItemEnergyCell extends ItemAugment
{
    public ItemEnergyCell()
    {
        super(AugmentRegistry.Ids.ENERGY);
        this.setUnlocalizedName(Names.Items.ENERGY_CELL);
        ModItems.register(this);
    }
}
