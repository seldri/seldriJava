package com.blueJ.chapter06.starWars;

public class NameGenerator{

    public NameGenerator(){}
    

    public static void generateStarWarsName(String lastName, String firstName, String mothersLastName, String birthPlace){
        String starWarsName = lastName.substring(0, 3) + firstName.substring(0, 3) + " " + mothersLastName.substring(0, 2) + birthPlace.substring(0, 3);
        System.out.println(starWarsName.toLowerCase());
    }
}