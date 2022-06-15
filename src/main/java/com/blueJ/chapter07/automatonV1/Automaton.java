package com.blueJ.chapter07.automatonV1;

import java.util.Arrays;


public class Automaton
{
    // The number of cells.
    private final int numberOfCells;
    // The state of the cells.
    private int[] state;
    
    /**
     * Create a 1D automaton consisting of the given number of cells.
     * @param numberOfCells The number of cells in the automaton.
     */
    public Automaton(int numberOfCells, int wolframCode)
    {
        this.numberOfCells = numberOfCells;
        state = new int[numberOfCells + 1];

        state = computeTable(wolframCode);
        // Seed the automaton with a single 'on' cell in the middle.
        state[numberOfCells / 2] = 1;
        //state[numberOfCells / 4] = 1;
    }
    
    public int[] computeTable(int wolframCode){
        int[] computeTable = new int[8];
        for(int i = 0; i < computeTable.length; i++){
            if(wolframCode % 2 == 0){
                computeTable[i] = 0;
                wolframCode = wolframCode / 2;
            }
            else{
                computeTable[i] = 1;
                wolframCode = wolframCode / 2;
            }
        }
        return computeTable;
    }

    /**
     * Print the current state of the automaton.
     */
    public void print()
    {
        for(int cellValue : state) {
            if(cellValue == 1) {
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }   
    
    /**
     * Update the automaton to its next state.
     */
    /*public void update()
    {
        // Build the new state in a separate array.
        int[] nextState = new int[state.length];
        // Naively update the state of each cell
        // based on the state of its two neighbors.
        for(int i = 0; i < state.length; i++) {
            int left, center, right;
            left = i == 0 ? 0 : state[i - 1];
            /*if(i == 0) {
                left = 0;
            }
            else {
                left = state[i - 1];
            }
            center = state[i];
            right = i + 1 < state.length ? state[i + 1] : 0;
            /*if(i + 1 < state.length) {
                right = state[i + 1];
            }
            else {
                right = 0;
            }
            nextState[i] = (left + center + right) % 2;
        }
        state = nextState;
    }*/
    
    /*public void update2()
    {
        // Naively update the state of each cell
        // based on the state of its two neighbors.
        int oldLeft = 0;
        for(int i = 0; i < state.length; i++) {
            
            int left, center, right;
            
            left = oldLeft;
            
            center = state[i];
            
            right = i + 1 < state.length ? state[i + 1] : 0;
            
            state[i] = (left + center + right) % 2;

            oldLeft = center;
        }
    }*/
    
    /*public void update3()
    {
        // Naively update the state of each cell
        // based on the state of its two neighbors.
        int[] nextState = new int[state.length];
        int left = 0;
        int center = state[0];
        for(int i = 0; i < state.length; i++) {
            
            int right = i + 1 < state.length ? state[i + 1] : 0;
            
            nextState[i] = calculateNextState(left, center, right);

            left = center;
            center = right;
        }
        state = nextState;
    }*/

    public void update()
    {
        // Naively update the state of each cell
        // based on the state of its two neighbors.
        int[] nextState = new int[state.length];
        int left = 0;
        int center = state[0];
        for(int i = 0; i < numberOfCells; i++) {
            
            int right = state[i + 1];
            
            nextState[i] = calculateNextState(left, center, right);

            left = center;
            center = right;
        }
        state = nextState;
    }

    

    public int calculateNextState(int left, int center, int right){
        return left + center + right % 2;
    }
    

    /**
     * Reset the automaton.
     */
    public void reset()
    {
        Arrays.fill(state, 0);
        // Seed the automaton with a single 'on' cell.
        state[numberOfCells / 2] = 1;
            
    }
}
