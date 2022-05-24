package com.blueJ.chapter04.MusicSystem;

import java.util.ArrayList;
import java.util.Iterator;
//import java.util.Random;
//import java.util.Collections;


public class MusicOrganizer
{
    // An ArrayList for storing music tracks.
    private ArrayList<Track> tracks;
    // A player for the music tracks.
    //private MusicPlayer player;
    // A reader that can read music files and load them as tracks.
    private TrackReader reader;
    // An Object of the Random Class
    //private Random random;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        tracks = new ArrayList<>();
        //player = new MusicPlayer();
        reader = new TrackReader();
        //random = new Random();
        readLibrary("../audio");
        System.out.println("Music library loaded. " + getNumberOfTracks() + " tracks.");
        System.out.println();
    }
    
    /**
     * Add a track file to the collection.
     * @param filename The file name of the track to be added.
     */
    public void addFile(String filename)
    {
        tracks.add(new Track(filename));
    }
    
    /**
     * Add a track to the collection.
     * @param track The track to be added.
     */
    public void addTrack(Track track)
    {
        tracks.add(track);
    }
    
    /**
     * Play a track in the collection.
     * @param index The index of the track to be played.
     */
    /*public void playTrack(int index)
    {
        if(indexValid(index)) {
            stopPlaying();
            Track track = tracks.get(index);
            player.startPlaying(track.getFilename());
            System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
            track.incrementPlayFrequency();
            if(track.getPlayFrequency() >= 5){
                addToFavorites(index);
            }
        }
    }*/
    
    /*public void shuffle(){
        stopPlaying();
        int index = random.nextInt(tracks.size());
        Track track = tracks.get(index);
        player.startPlaying(track.getFilename());
        System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
        track.incrementPlayFrequency();
        if(track.getPlayFrequency() >= 5) {
            addToFavorites(index);
        }
    }*/
    
    /*public void shuffleList(){
        stopPlaying();        
        ArrayList<Track> temporary = new ArrayList<>(tracks);
        while(temporary.size() > 0){
            int index = random.nextInt(temporary.size());
            Track track = temporary.remove(index);
            player.playSample(track.getFilename());
        }
    }*/
    
    /*public void shuffleList2(){
        ArrayList<Track> temporary = new ArrayList<>(tracks);
        Collections.shuffle(temporary);
        for(Track track : temporary){
            player.playSample(track.getFilename());
        }
    }*/
    
    /**
     * Return the number of tracks in the collection.
     * @return The number of tracks in the collection.
     */
    public int getNumberOfTracks()
    {
        return tracks.size();
    }
    
    /**
     * List a track from the collection.
     * @param index The index of the track to be listed.
     */
    public void listTrack(int index)
    {
        System.out.print("Track " + index + ": ");
        Track track = tracks.get(index);
        System.out.println(track.getDetails());
    }
    
    /**
     * Show a list of all the tracks in the collection.
     */
    public void listAllTracks()
    {
        System.out.println("Track listing: ");
        for(Track track : tracks) {
            System.out.println(track.getDetails());
        }
        System.out.println();
    }
    
    public void listAllTracks3()
    {
        tracks.stream().map(s -> s.getDetails()).forEach(detail -> System.out.println("Track listing: " + detail));
    }

    public void listAllTracks2(){
        System.out.println("Track listing: ");
        Iterator<Track> it = tracks.iterator();
        while(1 < 4){
            Track t = it.next();
            System.out.println(t.getDetails());
        }
    }
    
    public void listByArtist2(String artist){
        tracks.stream().filter(s -> artist.equals(s.getArtist()))
        .map(s -> s.getDetails()).forEach(detail -> System.out.println(detail));
    }

    /**
     * List all tracks by the given artist.
     * @param artist The artist's name.
     */
    public void listByArtist(String artist)
    {
        for(Track track : tracks) {
            if(track.getArtist().contains(artist)) {
                System.out.println(track.getDetails());
            }
        }
    }
    
    public void addToFavorites(int index){
        if(indexValid(index)){
            Track track = tracks.get(index);
            track.setFavorite();
            System.out.println("The track: " + track.getTitle() + " has been now added to your favorites!");
        }
    }
    
    public void removeArtist(String artist){
        Iterator<Track> it = tracks.iterator();
        while(it.hasNext()){
            Track t = it.next();
            if(t.getArtist().contains(artist)){
                it.remove();
                System.out.println("The artist: " + t.getArtist() + " has been removed!");
            }
        }
    }
    
    public void checkFavoriteStatus(int index){
        Track track = tracks.get(index);
        if(track.getFavorite() == true){
            System.out.println("This track is part of your favorite Songs!");
        }
        else { System.out.println("This track is not part of your favorite Songs!");
        }
    }
    
    /**
     * Remove a track from the collection.
     * @param index The index of the track to be removed.
     */
    public void removeTrack(int index)
    {
        if(indexValid(index)) {
            tracks.remove(index);
        }
    }
    
    /**
     * Play the first track in the collection, if there is one.
     */
    /*public void playFirst()
    {
        if(tracks.size() > 0) {
            stopPlaying();
            player.startPlaying(tracks.get(0).getFilename());
            Track track = tracks.get(0);
            System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
            track.incrementPlayFrequency();
            if(track.getPlayFrequency() >= 5){
                addToFavorites(0);
            }
        }
    }*/
    
    /**
     * Stop the player.
     */
    /*public void stopPlaying()
    {
        player.stop();
    }*/

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean indexValid(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= tracks.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
    
    private void readLibrary(String folderName)
    {
        ArrayList<Track> tempTracks = reader.readTracks(folderName, ".mp3");

        // Put all the tracks into the organizer.
        for(Track track : tempTracks) {
            addTrack(track);
        }
    }
}