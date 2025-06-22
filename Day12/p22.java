package Day12;

import java.util.ArrayList;
import java.util.List;

/*
 15. Music Library System
Description: A music library system that allows users to add songs, 
play them, and display the song list.
 */
//Abstract class representing a Music
abstract class Music {
 protected String title;
 protected String artist;

 public Music(String title, String artist) {
     this.title = title;
     this.artist = artist;
 }

 public abstract void play();
 public abstract void displayInfo();
}

//Class representing a Song
class Song extends Music {
 public Song(String title, String artist) {
     super(title, artist);
 }

 @Override
 public void play() {
     System.out.println("Playing: " + title + " by " + artist);
 }

 @Override
 public void displayInfo() {
     System.out.println("Song: " + title + ", Artist: " + artist);
 }
}

//Class representing a Music Library
class MusicLibrary {
 private List<Music> songs = new ArrayList<>();

 public void addSong(Music song) {
     songs.add(song);
     System.out.println("Added song: " + song.title);
 }

 public void playAll() {
     for (Music song : songs) {
         song.play();
     }
 }
}

//Main class to test the Music Library System
public class p22 {
 public static void main(String[] args) {
     MusicLibrary library = new MusicLibrary();
     library.addSong(new Song("Shape of You", "Ed Sheeran"));
     library.addSong(new Song("Blinding Lights", "The Weeknd"));
     library.playAll();
 }
}
