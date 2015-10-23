package com.tayjay.playeraugments.item;

import com.tayjay.playeraugments.augment.Augment;
import com.tayjay.playeraugments.augment.AugmentRegistry;
import com.tayjay.playeraugments.init.ModItems;
import com.tayjay.playeraugments.reference.Names;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by tayjm_000 on 2015-10-18.
 */
public class ItemAugment extends ItemPA
{
    public ItemAugment()
    {
        super();
        this.setUnlocalizedName(Names.Items.AUGMENT);
        setHasSubtypes(true);
        setMaxDamage(0);
        ModItems.register(this);
    }

    @Override
    public IIcon getIconFromDamage(int meta)
    {
        return super.getIconFromDamage(meta);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list)
    {
        //super.getSubItems(item, tabs, list);
        for (int i = 0; i <= AugmentRegistry.totalAugments; ++i)
        {
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_)
    {
        super.onUpdate(itemStack, world, entity, p_77663_4_, p_77663_5_);
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return AugmentRegistry.getAugmentById(this.getDamage(itemStack)).getAugmentName();
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean p_77624_4_)
    {
        //super.addInformation(itemStack, player, list, p_77624_4_);
        Augment augment = AugmentRegistry.getAugmentById(this.getDamage(itemStack));
        list.add("ID: "+augment.getAugmentId());
        list.add("TypeId: "+augment.getTypeId());
        list.add("TypeName: "+augment.getAugmentType());
    }

    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        String str="";
        while(str =="hi")
        {

        }
        return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
    }
}
