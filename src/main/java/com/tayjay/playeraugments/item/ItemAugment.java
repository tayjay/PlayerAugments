package com.tayjay.playeraugments.item;

import com.tayjay.playeraugments.augment.Augment;
import com.tayjay.playeraugments.augment.AugmentRegistry;
import com.tayjay.playeraugments.creativetab.CreativeTabPA;
import com.tayjay.playeraugments.init.ModItems;
import com.tayjay.playeraugments.reference.Names;
import com.tayjay.playeraugments.util.LogHelper;
import com.tayjay.playeraugments.util.NBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by tayjm_000 on 2015-10-18.
 */
public abstract class ItemAugment extends ItemPA
{
    private int typeId;

    public  ItemAugment(int typeId)
    {
        super();
        this.typeId = typeId;
        //this.setUnlocalizedName(Names.Items.AUGMENT);
        //setHasSubtypes(true);
        //setMaxDamage(0);
        setCreativeTab(CreativeTabPA.AUGMENT_TAB);
        //ModItems.register(this);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        List<Augment> augmentList = AugmentRegistry.getAllOfType(typeId);
        for(int i = 0;i<augmentList.size();i++)
        {
            augmentList.get(i).registerIcon(iconRegister);
            LogHelper.info("Icon Name:" + augmentList.get(i).getIcon().getIconName());
        }
    }

    @Override
    public IIcon getIconIndex(ItemStack itemStack)
    {
        //LogHelper.info(NBTHelper.getString(itemStack,"augmentName"));
        Augment augment = AugmentRegistry.getAugmentFromName(NBTHelper.getString(itemStack, "augmentName"));
        //LogHelper.info(augment.getAugmentName());
        if(augment!=null)
        {
            IIcon icon = augment.getIcon();
            if (icon != null)
            {
                return augment.getIcon();
            } else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list)
    {
        List<Augment> augmentList = AugmentRegistry.getAllOfType(typeId);
        for(int i = 0; i<augmentList.size();i++)
        {
            ItemStack energyStack = new ItemStack(item);

            NBTHelper.setString(energyStack,"augmentName",augmentList.get(i).getAugmentName());

            list.add(energyStack);
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
        Augment augment = AugmentRegistry.getAugmentFromName(NBTHelper.getString(itemStack, "augmentName"));
        if(augment!=null)
        {
            return StatCollector.translateToLocal(augment.getUnlocalizedName() + ".name");
        }
        return "NO NAME FOUND, REPORT TO MOD AUTHOR!";
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean p_77624_4_)
    {
        Augment augment = AugmentRegistry.getAugmentFromName(NBTHelper.getString(itemStack, "augmentName"));
        if(augment!=null)
        {
            list.add("ID: " + augment.getAugmentId());
            list.add("Name: " + augment.getAugmentName());
            list.add("TypeId: " + augment.getTypeId());
            list.add("Tier: " + augment.getTier());
            list.add("TypeName: " + augment.getAugmentType());
        }
        else
        {
            list.add("NO AUGMENT FOUND, REPORT TO MOD AUTHOR!");
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
    }
}
