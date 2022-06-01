package com.blueJ.chapter06.techSupport1;

import java.util.Random;
import java.util.ArrayList;

public class Responder{

    private Random randomGenerator;
    private ArrayList<String> responses;

    public Responder(){
        randomGenerator = new Random();
        responses = new ArrayList<>();
        fillResponses();
    }

    /**
     * Get a random response out of the list.
     * @return Random response out of the responses.
     */
    public String generateResponse(){
        return responses.get(randomGenerator.nextInt(responses.size()));
    }

    /**
     * Fill the list of responses.
     */
    public void fillResponses(){
        responses.add("This sounds weird. Can you describe this more precise?");
        responses.add("Until now no customer has complained about this. \n " + "Which system configuration do you have?");
        responses.add("I need more precise answers.");
        responses.add("Did you check if there is a conflict with DLL?");
        responses.add("This is described in the manual. Did you read the manual?");
        responses.add("This sounds too unprecise. Do you have an Expert \n " + "Which is near you?");
        responses.add("This is no mistake, this is a system feature!");
        responses.add("Could you describe it differently?");
        responses.add("Did you try to use the app on your mobile phone?");
        responses.add("I just checked on StackOverflow as well, there is also no solution.");
    }
}