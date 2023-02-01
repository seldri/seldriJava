// package com.blueJ.chapter12.foxesAndRabbitsV2;

// import java.util.Random;
// import java.util.List;
// import java.util.ArrayList;
// import java.util.Iterator;
// import java.awt.Color;

// public class PopulationGenerator{
   
//     private List<Animal> animals;
    
//     private SimulatorView view;
    
//     private Field field;
    
//     private static final double FOX_CREATION_PROBABILITY = 0.02;
//     // The probability that a rabbit will be created in any given grid position.
//     private static final double RABBIT_CREATION_PROBABILITY = 0.08; 

//     private static final double COYOTE_CREATION_PROBABILITY = 0.03;
    
//     public PopulationGenerator(Field field, SimulatorView view){
//         animals = new ArrayList<>();
//         this.field = field;
//         this.view = view;
//         view.setColor(Rabbit.class, Color.ORANGE);
//         view.setColor(Fox.class, Color.BLUE);
//         view.setColor(Coyote.class, Color.GREEN);
//         setColors();
//     }
    
//     public List<Animal> populate(Random rand) {
//         List<Animal> list = new ArrayList<>();
//         field.clear();
//         for(int row = 0; row < field.getDepth(); row++) {
//             for(int col = 0; col < field.getWidth(); col++) {
//                 Location location = new Location(row, col);
             
//                 if(rand.nextDouble() <= COYOTE_CREATION_PROBABILITY) {
//                     Coyote coyote = new Coyote(true, field, location);
//                     list.add(coyote);
//                 }
//                 else if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
//                     Fox fox = new Fox(true, field, location);
//                     list.add(fox);
//                 }
//                 else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
//                     Rabbit rabbit = new Rabbit(true, field, location);
//                     list.add(rabbit);
//                 }
//                 /* else if(rand.nextDouble() <= COYOTE_CREATION_PROBABILITY) {
//                     Coyote coyote = new Coyote(true, field, location);
//                     list.add(coyote);
//                 } */
//             }
//         }
//         return list;
//     }
    
//     public void setColors(){
//         view.setColor(Rabbit.class, Color.ORANGE);
//         view.setColor(Fox.class, Color.BLUE);
//         view.setColor(Coyote.class, Color.GREEN);
//     }
// }