package com.tayjay.playeraugments.augment;

import net.minecraft.client.resources.I18n;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tayjm_000 on 2015-10-18.
 */
public class Augment
{
    private String augmentName;
    private int augmentId;
    private int typeId;
    private String augmentType;
    private int tier;
    private final String[] types = {"brain","eye","skull","skeleton","arm","heart","energy","leg","dna","special"};
    private List<String> temp = new ArrayList<String>();
    //private String unlocalizedName;

    public Augment(int id,String name,int tier, int typeId)
    {
        this.augmentName = name;
        this.augmentId = id;
        this.tier = tier;
        this.typeId = typeId;
        this.augmentType = types[typeId];
        AugmentRegistry.register(this);
    }

    public String getUnlocalizedName()
    {
        return "augment."+augmentType+"."+augmentName;
    }

    public int getAugmentId()
    {
        return augmentId;
    }

    public int getTypeId()
    {
        return typeId;
    }

    public String getAugmentType()
    {
        return augmentType;
    }

    public int getTier()
    {
        return tier;
    }

    public String getAugmentName()
    {
        return augmentName;
    }

    public String[] getTypes()
    {
        return types;
    }
}
