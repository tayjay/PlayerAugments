package com.tayjay.playeraugments.properties;

import com.tayjay.playeraugments.util.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

/*
Since we are first making variables specific to EntityPlayer, we will call this
class "ExtendedPlayer" so it's always obvious what kind of entity can use it. This
will be important if you add different variables to different entities.
*/
public class ExtendedPlayer implements IExtendedEntityProperties
{

    /*
	Here I create a constant EXT_PROP_NAME for this class of properties
	You need a unique name for every instance of IExtendedEntityProperties
	you make, and doing it at the top of each class as a constant makes
	it very easy to organize and avoid typos. It's easiest to keep the same
	constant name in every class, as it will be distinguished by the class
	name: ExtendedPlayer.EXT_PROP_NAME vs. ExtendedEntity.EXT_PROP_NAME

	Note that a single entity can have multiple extended properties, so each
	property should have a unique name. Try to come up with something more
	unique than the tutorial example.
	*/
    public final static String EXT_PROP_NAME = "ExtendedPlayer";

    // I always include the entity to which the properties belong for easy access
    // It's final because we won't be changing which player it is
    private final EntityPlayer player;
    private int currentEnergy, maxEnergy;
    private boolean isAugmented;

    /*
	The default constructor takes no arguments, but I put in the Entity
	so I can initialize the above variable 'player'

	Also, it's best to initialize any other variables you may have added,
	just like in any constructor.
	*/
    public ExtendedPlayer(EntityPlayer player)
    {
        this.player = player;
        this.currentEnergy = 0;
        this.maxEnergy = 0;
        this.isAugmented = false;
    }

    public int getCurrentEnergy()
    {
        return currentEnergy;
    }

    public void setCurrentEnergy(int energy)
    {
        this.currentEnergy = (energy > maxEnergy) ? maxEnergy : energy;
    }

    public int getMaxEnergy()
    {
        return maxEnergy;
    }

    public void setMaxEnergy(int energy)
    {
        this.maxEnergy = energy;
    }

    /**
     * Used to register these extended properties for the player during EntityConstructing event
     * This method is for convenience only; it will make your code look nicer
     */
    public static final void register(EntityPlayer player)
    {
        player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(player));
    }

    /**
     * Returns ExtendedPlayer properties for player
     * This method is for convenience only; it will make your code look nicer
     */
    public static final ExtendedPlayer get(EntityPlayer player)
    {
        return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
    }






    @Override
    public void saveNBTData(NBTTagCompound compound)
    {
        // We need to create a new tag compound that will save everything for our Extended Properties
        NBTTagCompound properties = new NBTTagCompound();

        // We only have 2 variables currently; save them both to the new tag
        properties.setInteger("CurrentEnergy", this.currentEnergy);
        properties.setInteger("MaxEnergy", this.maxEnergy);

        // Now add our custom tag to the player's tag with a unique name (our property's name)
        // This will allow you to save multiple types of properties and distinguish between them
        // If you only have one type, it isn't as important, but it will still avoid conflicts between
        // your tag names and vanilla tag names. For instance, if you add some "Items" tag,
        // that will conflict with vanilla. Not good. So just use a unique tag name.
        compound.setTag(EXT_PROP_NAME, properties);
        LogHelper.info("Saved ExtendedPlayer data to NBT.");
    }

    @Override
    public void loadNBTData(NBTTagCompound compound)
    {
        NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);

        this.currentEnergy = properties.getInteger("CurrentEnergy");
        this.maxEnergy = properties.getInteger("MaxEnergy");
        LogHelper.info("Loaded ExtendedPlayer data from NBT");
    }

    /*
	I personally have yet to find a use for this method. If you know of any,
	please let me know and I'll add it in!
	*/
    @Override
    public void init(Entity entity, World world)
    {

    }

    public boolean consumeEnergy(int amount)
    {
        boolean sufficient = amount <= this.currentEnergy;

        this.currentEnergy -= (amount < this.currentEnergy ? amount : this.currentEnergy);

        return sufficient;
    }

    public void fillEnergy()
    {
        this.currentEnergy = this.maxEnergy;
    }
}
