package com.blueJ;
import com.blueJ.chapter04.MusicOrganizer;
import com.blueJ.chapter04.ArrayListTraining;

//import com.blueJ.chapter03.*;
//import com.blueJ.chapter03.Clock.Clockdisplay;

    

    
public class Main {

    public static void calculate(int a, int b){

        int sum = 0;
        while(a < b - 1){
            a++;
            sum = sum + a;
        }
        System.out.println(sum);
    }

    public static void calculate2(int a, int b){

        int sum = 0;
        while(a <= b){
            sum = sum + a;
            a++;
        }
        System.out.println(sum);
    }


    public static boolean isPrime(int n){
        int a = 2;
        while(a < n){
            int c = n % a;
            if(c == 0){
                return false;
            }
            a ++;
        }
        return true;

    }


    public static void main(String[] args) {

        /*MusicOrganizer m1 = new MusicOrganizer();
        m1.addFile("A");
        m1.addFile("B");
        m1.addFile("C");
        m1.addFile("D");
        m1.printElements(); */

        /*ArrayListTraining a1 = new ArrayListTraining();
        a1.addToList();
        a1.selectiveSearch2("e");*/

        
        System.out.println(isPrime(18));
        
        
    }
} 