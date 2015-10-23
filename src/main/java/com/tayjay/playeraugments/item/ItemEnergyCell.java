package com.tayjay.playeraugments.item;

import com.tayjay.playeraugments.augment.Augment;
import com.tayjay.playeraugments.augment.AugmentRegistry;
import com.tayjay.playeraugments.creativetab.CreativeTabPA;
import com.tayjay.playeraugments.init.ModItems;
import com.tayjay.playeraugments.reference.Names;
import com.tayjay.playeraugments.reference.Reference;
import com.tayjay.playeraugments.util.LogHelper;
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
public class ItemEnergyCell extends ItemPA
{

    public ItemEnergyCell()
    {
        super();
        this.setUnlocalizedName(Names.Items.ENERGY_CELL);
        setHasSubtypes(true);
        setMaxDamage(0);
        setCreativeTab(CreativeTabPA.AUGMENT_TAB);
        ModItems.register(this);
    }

    @SideOnly(Side.CLIENT)
    private IIcon icons[];


    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        icons = new IIcon[AugmentRegistry.getTotalByType(AugmentRegistry.Ids.ENERGY)];
        for(int i = 0; i<icons.length;i++)
        {
            icons[i] = iconRegister.registerIcon((this.getUnlocalizedName().substring(5)) + i);
        }
    }

    @Override
    public IIcon getIconFromDamage(int meta)
    {
        return icons[meta];
    }


    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list)
    {
        for (int i = 0; i < AugmentRegistry.getTotalByType(AugmentRegistry.Ids.ENERGY); ++i)
        {
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        Augment augment = AugmentRegistry.getAugmentFromTierAndType(itemStack.getItemDamage(), AugmentRegistry.Ids.ENERGY);
        return StatCollector.translateToLocal(augment.getUnlocalizedName()+".name");
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean p_77624_4_)
    {
        Augment augment = AugmentRegistry.getAugmentFromTierAndType(this.getDamage(itemStack), AugmentRegistry.Ids.ENERGY);
        list.add("ID: "+augment.getAugmentId());
        list.add("TypeId: "+augment.getTypeId());
        list.add("Tier: "+augment.getTier());
        list.add("TypeName: "+augment.getAugmentType());
    }
}
