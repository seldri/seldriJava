package com.blueJ.chapter04.MusicSystem;
import java.util.ArrayList;

public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    //private MusicPlayer player;
        
    public MusicOrganizer()
    {
        files = new ArrayList<>();
        //player = new MusicPlayer();
    }
    
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /*public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }*/

    /*public void stopPlaying()
    {
        player.stop();
    }*/
    
    public void printOutAllFiles(){
        for(String file : files){
            System.out.println(file);}
        }

    public void printFilesAndIndex(){
        int index = 0;
        for(String file : files){
            System.out.println("Index: " + index + " File: " + file);
            index++;
        }
    }

    public void printElements(){
        int index = 0;
        while(index < files.size()){
            String file = files.get(index);
            System.out.println("Index: " + index + "File: " + file);
            index++;
        }
    }

    public int findFirst(String search){
        
        int index = 0;
        boolean searching = true;

        while(searching && index < files.size()){
            String file = files.get(index);
            if(file.contains(search)){
                searching = false;
            }
            else {
                index++;
            }
        }
        
        if(searching){
            return -1;
        }
        else {
            return index;
        }

    }

    public int findFirst2(String search){
        
        int index = 0;
        boolean searching = true;
        int size = files.size();

        while(searching && index < size){
            String file = files.get(index);
            if(file.contains(search)){
                searching = false;
            }
            else {
                index++;
            }
        }
        
        if(searching){
            return -1;
        }
        else {
            return index;
        }

    }


}