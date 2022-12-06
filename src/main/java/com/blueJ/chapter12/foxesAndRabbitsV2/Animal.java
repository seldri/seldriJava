package com.blueJ.chapter12.foxesAndRabbitsV2;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * A class representing shared characteristics of animals.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (2)
 */
public abstract class Animal implements Actor
{
    protected static final Random rand = Randomizer.getRandom(); 
    // Whether the animal is alive or not.
    private boolean alive;
    // The animal's field.
    private Field field;
    // The animal's position in the field.
    private Location location;
    
    private int age;
    
    /**
     * Create a new animal at location in field.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Animal(Field field, Location location)
    {
        alive = true;
        this.field = field;
        setLocation(location);
        age = 0;
    }
    
    protected int getAge(){
        return age;
    }
    
    protected void setAge(int age){
        this.age = age;
    }
    
    /**
     * Make this animal act - that is: make it do
     * whatever it wants/needs to do.
     * @param newAnimals A list to receive newly born animals.
     */
    //abstract protected void act(List<Animal> newAnimals);

    public boolean isActive(){
        return alive;
    }
    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    protected boolean isAlive()
    {
        return isActive();
    }

    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Return the animal's location.
     * @return The animal's location.
     */
    protected Location getLocation()
    {
        return location;
    }
    
    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    /**
     * Return the animal's field.
     * @return The animal's field.
     */
    protected Field getField()
    {
        return field;
    }
    
    abstract protected int getBreedingAge();
    
    protected boolean canBreed(){
        return getAge() >= getBreedingAge();
    }
    
    abstract protected int getMaxAge();
    
    protected void incrementAge(){
        setAge(getAge() + 1);
        if(getAge() > getMaxAge()){
            setDead();
        }
    }
    
    protected int breed(){
        int births = 0;
        if(canBreed() && rand.nextDouble() <= getBreedingProbability()) {
            births = rand.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }
    
    abstract protected double getBreedingProbability();
    
    abstract protected int getMaxLitterSize();
    
    abstract protected Animal createAnimal(boolean randomAge, Field fiel, Location loc);
    
    /* protected void giveBirth(List<Animal> newAnimals){
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Animal young = createAnimal(false, field, loc);
            newAnimals.add(young);
        }
    } */

    protected void giveBirth(List newAnimals) { 
        Field field = getField(); 
        List free = field.getFreeAdjacentLocations(getLocation()); 
        int births = breed(); 
        for(int b = 0; b < births && free.size() > 0; b++) { 
            Location loc = (Location) free.remove(0); 
            Animal young = createAnimal(false, field, loc); 
            newAnimals.add(young); 
        } 
    }
}
