package com.blueJ;
import com.blueJ.chapter04.FirstPart.*;
import com.blueJ.*;

//import com.blueJ.chapter03.*;
//import com.blueJ.chapter03.Clock.Clockdisplay;

public class Main {


    public static void main(String[] args) {

        MusicOrganizer m1 = new MusicOrganizer();
        m1.addFile("A");
        m1.addFile("B");
        m1.addFile("C");
        m1.addFile("D");
        m1.printFilesAndIndex();
    }
} 