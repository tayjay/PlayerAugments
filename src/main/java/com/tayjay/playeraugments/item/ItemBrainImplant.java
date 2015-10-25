package com.tayjay.playeraugments.item;

import com.tayjay.playeraugments.augment.Augment;
import com.tayjay.playeraugments.augment.AugmentRegistry;
import com.tayjay.playeraugments.creativetab.CreativeTabPA;
import com.tayjay.playeraugments.init.ModItems;
import com.tayjay.playeraugments.reference.Names;


/**
 * Created by tayjm_000 on 2015-10-22.
 */
public class ItemBrainImplant extends ItemAugment
{
    public ItemBrainImplant()
    {
        super(AugmentRegistry.Ids.BRAIN);
        this.setUnlocalizedName(Names.Items.BRAIN_IMPLANT);
        ModItems.register(this);
    }
}
