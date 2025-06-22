package Day12;

import java.util.ArrayList;
import java.util.List;

/*
18. Note Taking Application
Description: A note-taking application that allows users to create, 
view, and delete notes.
 */
//Interface for Note Operations
interface NoteOperations {
 void createNote(String note);
 void viewNotes();
 void deleteNote(String note);
}

//Class representing a Note Manager
class NoteManager implements NoteOperations {
 private List<String> notes = new ArrayList<>();

 @Override
 public void createNote(String note) {
     notes.add(note);
     System.out.println("Created note: " + note);
 }

 @Override
 public void viewNotes() {
     System.out.println("Notes:");
     for (String note : notes) {
         System.out.println("- " + note);
     }
 }

 @Override
 public void deleteNote(String note) {
     if (notes.remove(note)) {
         System.out.println("Deleted note: " + note);
     } else {
         System.out.println("Note not found.");
     }
 }
}

//Main class to test the Note Taking Application
public class p25 {
 public static void main(String[] args) {
     NoteManager manager = new NoteManager();
     manager.createNote("Buy groceries");
     manager.createNote("Finish homework");
     manager.viewNotes();
     manager.deleteNote("Buy groceries");
     manager.viewNotes();
 }
}
