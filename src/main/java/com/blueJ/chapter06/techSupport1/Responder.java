package com.blueJ.chapter06.techSupport1;

import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Responder{

    private Random randomGenerator;
    private ArrayList<String> defaultResponses;
    private HashMap<String, String> responses;
    private String message;
    private String lastDefault;

    public Responder(){
        randomGenerator = new Random();
        defaultResponses = new ArrayList<>();
        responses = new HashMap<>();
        fillDefaultResponses();
        fillResponses();
    }

    /**
     * Get a random response out of the list.
     * @return Random response out of the defaultResponses.
     */
    public String generateResponse(HashSet<String> input){
        
        for(String word : input){
            String answer = responses.get(word);
            if(word != null){
                return answer;
            }
        }
        message = defaultResponses.get(randomGenerator.nextInt(defaultResponses.size()));
        if(!message.equals(lastDefault)){
            lastDefault = message;
            return message;
        }
        return generateResponse(input);
    }

    public String generateResponse3(HashSet<String> words){
        int counter = 0;
        //Create Array of matching keywords from user input
        String[] matches = new String[words.size()];
        String response = "";

        for(String word : words){
            matches[counter] = responses.get(word);
            if(matches != null){
                counter++;
            }
        }
        
        //Piece together a response, multiple pieces of advice, if multiple matches
        for(counter = 0; counter < matches.length; counter++){
            if(matches[counter] != null){
                response = response + matches[counter] + "\n";
            }
        }
        
        if(response.length() > 1)
            return response;
            
        //If no match found, provide default response
        message = defaultResponses.get(randomGenerator.nextInt(defaultResponses.size()));
        if(!message.equals(lastDefault)){
            lastDefault = message;
            return message;
        }
        
        return generateResponse3(words);
    }

    /**
     * Fill the list of defaultResponses.
     */
    public void fillDefaultResponses(){
        defaultResponses.add("This sounds weird. Can you describe this more precise?");
        defaultResponses.add("Until now no customer has complained about this. \n " + "Which system configuration do you have?");
        defaultResponses.add("I need more precise answers.");
        defaultResponses.add("Did you check if there is a conflict with DLL?");
        defaultResponses.add("This is described in the manual. Did you read the manual?");
        defaultResponses.add("This sounds too imprecise. Do you have an Expert \n " + "Which is near you?");
        defaultResponses.add("This is no mistake, this is a system feature!");
        defaultResponses.add("Could you describe it differently?");
        defaultResponses.add("Did you try to use the app on your mobile phone?");
        defaultResponses.add("I just checked on StackOverflow as well, there is also no solution.");
    }

    public void fillResponses(){
        responses.put("froze", "End the system with your TaskManager and restart it again.");
        responses.put("slow", "This is a hardware problem, you should update your CPU.");
        responses.put("error", "The connection failed. You must be connected to the WiFi.");
        responses.put("battery low", "Your battery is low. You must recharge your device.");
        responses.put("battery", "Your battery is low. You must recharge your device.");
        responses.put("low battery", "Your battery is low. You must recharge your device.");
        responses.put("old", "Your version is old. You must update your device.");
    }
}