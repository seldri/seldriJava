package com.blueJ.chapter04.ClubSystem;

public class Membership{
    //name of the member
    private String name;
    //month the member joined
    private int month;
    //year the member joined
    private int year;

    /**Constructor of the class Membership
     * @param String name of the member
     * @param int month the member joined
     * @param int year the member joined
     */
    public Membership(String name, int month, int year)
        throws IllegalArgumentException {
            if(month < 1 || month > 12){
                throw new IllegalArgumentException("Month must be between 1 and 12!");
            }
            this.name = name;
            this.month = month;
            this.year = year;
        }

        /**
         * @return the name of the member
         */
        public String getName(){
            return name;
        }

        /**
         * @return the month in which the member joined
         */

        public int getMonth(){
            return month;
        }

        /**
         * @return the year in which the member joined 
        */
        public int getYear(){
            return year;
        }

        /**
         * @return a String representation of this Membership 
        */
        public String toString(){
            return "Name: " + name + ", joined in " + month + " of " + year;
        }
}