package com.blueJ.chapter06.techSupport1;

import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Responder{

    private Random randomGenerator;
    private ArrayList<String> responses;
    private HashMap<String, String> responseList;
    private String message;
    private String defaultMessage;

    public Responder(){
        randomGenerator = new Random();
        responses = new ArrayList<>();
        responseList = new HashMap<>();
        fillResponses();
        fillResponseList();
    }

    /**
     * Get a random response out of the list.
     * @return Random response out of the responses.
     */
    public String generateResponse(HashSet<String> input){
        
        for(String word : input){
            String answer = responseList.get(word);
            if(word != null){
                return answer;
            }
        }
        message = responses.get(randomGenerator.nextInt(responses.size()));
        if(!message.equals(defaultMessage)){
            defaultMessage = message;
            return message;
        }
        return generateResponse(input);
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
        responses.add("This sounds too imprecise. Do you have an Expert \n " + "Which is near you?");
        responses.add("This is no mistake, this is a system feature!");
        responses.add("Could you describe it differently?");
        responses.add("Did you try to use the app on your mobile phone?");
        responses.add("I just checked on StackOverflow as well, there is also no solution.");
    }

    public void fillResponseList(){
        responseList.put("froze", "End the system with your TaskManager and restart it again.");
        responseList.put("slow", "This is a hardware problem, you should update your CPU.");
        responseList.put("error", "The connection failed. You must be connected to the WiFi.");
        responseList.put("battery low", "Your battery is low. You must recharge your device.");
        responseList.put("old", "Your version is old. You must update your device.");
    }
}