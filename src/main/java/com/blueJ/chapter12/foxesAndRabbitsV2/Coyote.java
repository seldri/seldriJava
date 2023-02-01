// package com.blueJ.chapter12.foxesAndRabbitsV2;

// import java.util.List;
// import java.util.Iterator;

// public class Coyote extends Animal{

//     private static final int BREEDING_AGE = 10;

//     private static final int MAX_AGE = 100;

//     private static final double BREEDING_PROBABILITY = 0.1;

//     private static final int MAX_LITTER_SIZE = 3;

//     private static final int FOX_FOOD_VALUE = 6;

//     private int foodLevel;


//     public Coyote(boolean randomAge, Field field, Location location) {
//         super(field, location);
//         if(randomAge) {
//             setAge(rand.nextInt(MAX_AGE));
//             foodLevel = rand.nextInt(FOX_FOOD_VALUE);
//         }
//         else {
//             foodLevel = FOX_FOOD_VALUE;
//         }
//     }

//     public void act(List newCoyotes) { 
//         incrementAge(); 
//         incrementHunger(); 
//         if(isAlive()) { 
//             giveBirth(newCoyotes); 
//             // Move towards a source of food if found. 
//             Location newLocation = findFood(); 
//             if(newLocation == null) { 
//                 // No food found - try to move to a free location. 
//                 newLocation = getField().freeAdjacentLocation(getLocation()); 
//             } 
//             // See if it was possible to move. 
//             if(newLocation != null) {
//                  setLocation(newLocation); 
//             } 
//             else { 
//                 // Overcrowding. 
//                 setDead(); 
//             } 
//         }
//     }

//    /*  protected void act(List<Animal> newCoyotes)
//     {
//         incrementAge();
//         incrementHunger();
//         if(isAlive()) {
//             giveBirth(newCoyotes);            
//             // Move towards a source of food if found.
//             Location newLocation = findFood();
//             if(newLocation == null) { 
//                 // No food found - try to move to a free location.
//                 newLocation = getField().freeAdjacentLocation(getLocation());
//             }
//             // See if it was possible to move.
//             if(newLocation != null) {
//                 setLocation(newLocation);
//             }
//             else {
//                 // Overcrowding.
//                 setDead();
//             }
//         }
//     } */
//     /* public void act(List newCoyotes) 
//     {
//         incrementAge(); 
//         incrementHunger();
//         if(isAlive()) { 
//             giveBirth(newCoyotes);
//              // Move towards a source of food if found. 
//             Location newLocation = findFood();
//             if(newLocation == null) { 
//                 // No food found - try to move to a free location.
//                 newLocation = getField().freeAdjacentLocation(getLocation());
//             } // See if it was possible to move. 
//             if(newLocation != null) {
//                 setLocation(newLocation); 
//             } else {
//                  // Overcrowding.
//                   setDead(); 
//                 } 
//             } 
//         } */

//     protected int getBreedingAge() {
//         return BREEDING_AGE;
//     }

//     protected int getMaxAge() {
//         return MAX_AGE;
//     }

//     protected double getBreedingProbability() {
//         return BREEDING_PROBABILITY;
//     }

//     protected int getMaxLitterSize() {
//         return MAX_LITTER_SIZE;
//     }

//     protected void incrementHunger()
//     {
//         foodLevel--;
//         if(foodLevel <= 0) {
//             setDead();
//         }
//     }

//     private Location findFood()
//     {
//         Field field = getField();
//         List<Location> adjacent = field.adjacentLocations(getLocation());
//         Iterator<Location> it = adjacent.iterator();
//         while(it.hasNext()) {
//             Location where = it.next();
//             Object animal = field.getObjectAt(where);
//             if(animal instanceof Fox) {
//                 Fox fox = (Fox) animal;
//                 if(fox.isAlive()) { 
//                     fox.setDead();
//                     foodLevel = FOX_FOOD_VALUE;
//                     return where;
//                 }
//             }
//         }
//         return null;
//     }

//     protected Animal createAnimal(boolean randomAge, Field field, Location loc){
//         return new Coyote(randomAge, field, loc);
//     }
// }