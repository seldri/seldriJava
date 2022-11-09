package com.blueJ.chapter04.ClubSystem;

import java.util.ArrayList;
import java.util.Iterator;

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

    /**
     * Get the number of members that joined in a specific month
     * @param the month
     * @return the number of members
     */
    public int joinedInMonth(int month){
        int quantity = 0;
        if(month < 1 || month > 12){
            System.out.println("Month must be in between 1 and 12!");
            return 0;
        }
        else {
            for(Membership member : members){
                if(member.getMonth() == month){
                    quantity++;
                }    
            }
            return quantity;
        }
    }


    /**
     * Remove all members which joined in a specific month 
     * and return them in a separate list
     * @param month they joined
     * @param year they joined
     * @return list of the removed members
     */
    public ArrayList<Membership> remove(int month, int year){
        ArrayList<Membership> removedMembers = new ArrayList<>();
        if(month < 1 || month > 12){
            System.out.println("Month must be in between 1 and 12!");
            return removedMembers;
        }
        else if(year < 2000 || year > 2022){
            System.out.println("Year must be in between 2000 and 2022");
            return removedMembers;
        }
        else{
            Iterator<Membership> it = members.iterator();
            while(it.hasNext()){
                Membership member = it.next();
                if(member.getMonth() == month && member.getYear() == year){
                    removedMembers.add(member);
                    it.remove();
                }
            }
            return removedMembers;
        }
    }
}