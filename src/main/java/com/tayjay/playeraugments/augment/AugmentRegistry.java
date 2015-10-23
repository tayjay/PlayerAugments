package com.tayjay.playeraugments.augment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tayjm_000 on 2015-10-18.
 */
public class AugmentRegistry
{
    public static List<Augment> augmentList = new ArrayList<Augment>();
    /* 1: Make an object of the augment.*/
    public static Augment brainImplant0;
    public static Augment brainImplant1;
    public static Augment brainImplant2;
    public static Augment brainImplant3;
    public static Augment brainImplant4;
    public static Augment energyCell0;
    public static Augment energyCell1;
    public static Augment energyCell2;
    public static Augment energyCell3;
    public static Augment energyCell4;


    public static int totalAugments;

    public static void init()
    {
        registerAugments();
    }

    public static void registerAugments()
    {
        int id = -1;
        /* 2: Initialize the object.*/
        brainImplant0 = new Augment(++id,"brainImplant0",0,0);
        brainImplant1 = new Augment(++id,"brainImplant1",1,0);
        brainImplant2 = new Augment(++id,"brainImplant2",2,0);
        brainImplant3 = new Augment(++id,"brainImplant3",3,0);
        brainImplant4 = new Augment(++id,"brainImplant4",4,0);
        energyCell0 = new Augment(++id,"energyCell0",0,6);
        energyCell1 = new Augment(++id,"energyCell1",1,6);
        energyCell2 = new Augment(++id,"energyCell2",2,6);
        energyCell3 = new Augment(++id,"energyCell3",3,6);
        energyCell4 = new Augment(++id,"energyCell4",4,6);

        totalAugments = id;
    }

    /**
     * Called in the Augment constructor. Handles its own registering to the Augment List.
     * @param augmentIn Augment being called.
     */
    public static void register(Augment augmentIn)
    {
        augmentList.add(augmentIn.getAugmentId(), augmentIn);
    }

    public static Augment getAugmentById(int id)
    {
        return augmentList.get(id);
    }

    /**
     * Get the total number of items in this type.
     * @param type  The type ID of the type being counted.
     * @return      The number of elements in the target type.
     */
    public static int getTotalByType(int type)
    {
        int totalType = 0;
        for(Augment target : augmentList)
        {
            if(target.getTypeId() == type)
            {
                totalType++;
            }
        }
        return totalType;
    }

    public static Augment getAugmentFromTierAndType(int tier, int type)
    {
        for(Augment target : augmentList)
        {
            if(target.getTier()==tier && target.getTypeId()==type)
            {
                return target;
            }
        }
        return null;
    }

    public static class Ids
    {
        public static final int BRAIN = 0;
        public static final int ENERGY = 6;
    }
}
