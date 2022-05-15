package com.blueJ.chapter04.ClubSystem;

public class ClubDemo{
    //Instance variable in which the club is stored
    private Club club;

    /**
     * Constructor of the class ClubDemo
     */
    public Clubdemo(){
        club = new Club();
    }

    /**
     * Add a member to the club and show how many members there are
     * @param the new member
     */
    public void addMember(Membership member){
        club.join(member);
        System.out.println("The clubs has: " + club.numberOfMembers() + " members.");
    }
}
