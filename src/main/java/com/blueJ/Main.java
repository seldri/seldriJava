package com.blueJ;

import com.blueJ.chapter07.LogAnalyzer;

public class Main {


    public static void main(String[] args) {

    LogAnalyzer la1 = new LogAnalyzer("weblog.txt");
    la1.analyzeDailyData();
    la1.numberOfHourlyAccesses();


      
    }
}

