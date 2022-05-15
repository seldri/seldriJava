package com.blueJ.chapter04.ClubSystem;

import java.util.ArrayList;

public class Club{
    //The instance variable in which the arrayList of members is saved
    private ArrayList<Membership> members;

    /**
     * The constructor of the class Club
     */
    public Club(){
        members = new ArrayList<>();
    }

    /**
     * @param member a new member
     * Adds a new member to the club
     */
    public void join(Membership member){
        members.add(member);
    }

    /**
     * Returns the amount of members in the club
     */
    public int numberOfMembers(){
        return members.size();
    }
}