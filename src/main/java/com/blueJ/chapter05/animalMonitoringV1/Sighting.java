package com.blueJ.chapter05.animalMonitoringV1;

public class Sighting{
    //The animal spotted
    private final String animal;
    //The ID of the spotter
    private final int spotter;
    //How many were seen
    private final int count;
    //The ID of the area in which they were seen
    private final int area;
    //The reporting period
    private final int period;

    /**
     * Create a record of a sighting of a particular type of animal.
     * @param animal The animal spotted
     * @param spotter The ID of the spotter
     * @param count How many were seen
     * @param area The ID of the area in which they were seen
     * @param period The reporting period
     */
    public Sighting(String animal, int spotter, int count, int area, int period){
        this.animal = animal;
        this.spotter = spotter;
        this.count = count;
        this.area = area;
        this.period = period;
    }

    /**
     * Returns String of the animals name
     * @return the animal type
     */
    public String getAnimal(){
        return animal;
    }

    /**
     * Returns the ID of the spotter
     * @return the spotters ID
     */
    public int getSpotter(){
        return spotter;
    }

    /**
     * returns the count of how many were seen
     * @return the number seen
     */
    public int getCount(){
        return count;
    }

    /**
     * returns the ID of the area
     * @return where they were seen
     */
    public int getArea(){
        return area;
    }

    /**
     * Returns the time it was reported
     * @return when it was reported
     */
    public int getPeriod(){
        return period;
    }

    public String getDetails(){
        return animal +
            ", Count: " + count +
            ", Area: " + area + 
            ", Spotter: " + spotter +
            ", Period: " + period; 
    }
}