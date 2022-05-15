package com.blueJ;

import com.blueJ.chapter04.ClubSystem.*;
    
public class Main {

    public static void main(String[] args) {

        Club club1 = new Club();
        Membership member1 = new Membership("Bob", 4, 2004);
        Membership member2 = new Membership("Tom", 4, 2004);

        Membership member3 = new Membership("Jim", 6, 2004);
        Membership member4 = new Membership("Abe", 4, 2005);
        Membership member5 = new Membership("Bob", 8, 2007);

        club1.join(member1);
        club1.join(member2);
        club1.join(member3);
        club1.join(member4);
        club1.join(member5);

        System.out.println(club1.numberOfMembers());
        System.out.println(club1.remove(4, 2004));
        System.out.println(club1.numberOfMembers());
    }
} 