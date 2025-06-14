package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Game Development: 
Develop classes for Player, Game, and Score. 
Use inheritance for different types of games and polymorphism for scoring methods.
*/

// Class representing a Player
class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0; // Initial score is 0
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int points) {
        score += points; // Update player's score
    }
}

// Base class representing a Game
abstract class Game {
    protected String title;
    protected Player player;

    public Game(String title, Player player) {
        this.title = title;
        this.player = player;
    }

    public abstract void play(); // Abstract method to play the game
    public abstract void calculateScore(); // Abstract method to calculate score
}

// Class representing an Action Game
class ActionGame extends Game {
    public ActionGame(String title, Player player) {
        super(title, player);
    }

    @Override
    public void play() {
        System.out.println(player.getName() + " is playing " + title + " (Action Game)");
        // Simulate gameplay
        player.updateScore(10); // Example score update
    }

    @Override
    public void calculateScore() {
        System.out.println(player.getName() + "'s score in " + title + ": " + player.getScore());
    }
}

// Class representing a Puzzle Game
class PuzzleGame extends Game {
    public PuzzleGame(String title, Player player) {
        super(title, player);
    }

    @Override
    public void play() {
        System.out.println(player.getName() + " is playing " + title + " (Puzzle Game)");
        // Simulate gameplay
        player.updateScore(5); // Example score update
    }

    @Override
    public void calculateScore() {
        System.out.println(player.getName() + "'s score in " + title + ": " + player.getScore());
    }
}

// Class for managing the game system
class GameManager {
    private List<Game> games;

    public GameManager() {
        games = new ArrayList<>();
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void startGames() {
        for (Game game : games) {
            game.play();
            game.calculateScore();
        }
    }
}

// Main class to run the Game Development system
public class p23 {
    public static void main(String[] args) {
        // Create players
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        // Create games
        Game actionGame = new ActionGame("Super Action", player1);
        Game puzzleGame = new PuzzleGame("Mystery Puzzle", player2);

        // Manage games
        GameManager gameManager = new GameManager();
        gameManager.addGame(actionGame);
        gameManager.addGame(puzzleGame);

        // Start games
        gameManager.startGames();
    }
}
