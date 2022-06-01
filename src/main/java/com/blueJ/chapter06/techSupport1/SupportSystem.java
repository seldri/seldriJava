package com.blueJ.chapter06.techSupport1;

public class SupportSystem {
    
    private InputReader reader;
    private Responder responder;

    /**
     * Create a technical support system.
     */
    public SupportSystem(){
        reader = new InputReader();
        responder = new Responder();
    }

    /**
     * Start the technical support system. This will print a welcome
     * message and enter into a dialog with the user, until the user
     * ends the dialog.
     */
    public void start(){
        
        boolean finished = false;
        printWelcome();

        while(!finished){
            String input = reader.getInput().trim().toLowerCase();

            if(input.equals("bye")){
                finished = true;
            }
            else{
                String response = responder.generateResponse();
                System.out.println(response);
            }
        }
        printGoodbye();
    }

    /**
     * Print a welcome message to the screen
     */
    private void printWelcome(){
        System.out.println("Welcome to DodgySoft Technical Support System.");
        System.out.println();
        System.out.println("Please explain your problem.");
        System.out.println("We will assist you with any problem you might have.");
        System.out.println("Please type 'bye' to exit our system.");
    }

    /**
     * Print a goodbye message to the screen.
     */
    private void printGoodbye(){
        System.out.println("Nice talking to you. Bye...");
    }
}