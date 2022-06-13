package com.blueJ;




public class Main {


  public static void printInCapital(String s){
    
    System.out.println(s.toUpperCase());
  }


  public static void change(int i1, int i2){
    int tmp = i1;
    i1 = i2;
    i2 = tmp;
  }


    public static void main(String[] args) {

      
      
      //Main.printInCapital("hello");
      int a = 2;
      int b = 8;
      change(a, b);
      System.out.println("a: " + a + ", b: " + b);

      
    }
}

