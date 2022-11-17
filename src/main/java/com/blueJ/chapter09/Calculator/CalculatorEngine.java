package com.blueJ.chapter09.Calculator;

public class CalculatorEngine {
    
    private String title;
    private int displayValue;
    private char previousOperator;
    private String author;
    private String version;
    private int leftOperand;

    public CalculatorEngine(){
        title = "Calculator";
        displayValue = 0;
        previousOperator = ' ';
        author = "Drini";
        version = "0.0.1";
        leftOperand = 0;
    }

    public void plus(){
        previousOperator = '+';
        applePreviousOperator();
        displayValue = 0;
    }

    public void minus(){
        previousOperator = '-';
        applePreviousOperator();
        displayValue = 0;
    }

    public void equals(){
        if(previousOperator == '+'){
            displayValue = leftOperand + displayValue;
        }
        else{
            displayValue = leftOperand - displayValue;
        }
        displayValue = 0;
    }

    public String getTitle(){
        return title;
    }

    public int getDisplayValue(){
        return displayValue;
    }

    public char getOperandPressed(){
        return previousOperator;
    }

    public String getAuthor(){
        return author;
    }

    public String getVersion(){
        return version;
    }

    public void clear(){
        displayValue = 0;
    }

    public void numberPressed(int number){
        displayValue = displayValue * 10 + number;
    }

    public void applePreviousOperator(){
        if(previousOperator == '+'){
            leftOperand += displayValue; 
        }
        if(previousOperator == '-'){
            leftOperand -= displayValue;
        }
        else{
            leftOperand = displayValue;
        }
    }
}