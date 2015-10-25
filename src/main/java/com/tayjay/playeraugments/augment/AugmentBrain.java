package com.tayjay.playeraugments.augment;

/**
 * Created by tayjm_000 on 2015-10-23.
 */
public class AugmentBrain extends Augment
{
    public AugmentBrain(int id, String name, int tier)
    {
        super(id, name, tier, AugmentRegistry.Ids.BRAIN);
    }

    @Override
    public String getAugmentType()
    {
        return "brain";
    }
}
