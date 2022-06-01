package com.blueJ.chapter06.techSupport1;

import java.util.HashSet;
import java.util.Scanner;

public class InputReader {
    
    private Scanner reader;

    /**
     * Create new InputReader that reads text from the text terminal.
     */
    public InputReader(){
        reader = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a String.
     * @return A String typed by the user.
     */
    public String getInput(){
        System.out.print("> ");     //print prompt
        String inputLine = reader.nextLine();
        return inputLine;
    }
}
