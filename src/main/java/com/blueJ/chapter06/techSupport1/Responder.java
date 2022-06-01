package com.blueJ.chapter06.techSupport1;

import java.util.ArrayList;
import java.util.Random;

public class Responder {
    
    private Random randomGenerator;
    private ArrayList<String> responseList;
    /**
     * Constructor of Responder
     */
    public Responder(){
        randomGenerator = new Random();
        responseList = new ArrayList<>();
        generateResponseList();
    }

    /**
     * Generate a response
     * @return A String that should be displayed as the response
     */
    public String generateResponse(){
        //return "That sound interesting. Tell me more...";
        return responseList.get(randomGenerator.nextInt(responseList.size()));
    }

    public void generateResponseList(){
        responseList.add("That sounds interesting. Tell me more...");
        responseList.add("Have you tried restarting it?");
        responseList.add("Have you updated the application?");
        responseList.add("Somebody will contact you soon.");
    }
}