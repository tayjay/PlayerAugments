package com.tayjay.playeraugments.augment;

/**
 * Created by tayjm_000 on 2015-10-23.
 */
public class AugmentEnergy extends Augment
{
    public AugmentEnergy(int id, String name, int tier)
    {
        super(id, name, tier, AugmentRegistry.Ids.ENERGY);
    }

    @Override
    public String getAugmentType()
    {
        return "energy";
    }
}
