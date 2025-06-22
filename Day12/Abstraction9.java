package Day12;

// Example 10: Using Abstraction in Real-World Terms

// Abstract class
abstract class SocialMedia {
    abstract void postContent(); // Abstract method
}

// Concrete class extending the abstract class
class Instagram extends SocialMedia {
    @Override
    public void postContent() {
        System.out.println("Posting photos on Instagram");
    }
}

// Another concrete class for variety
class YouTube extends SocialMedia {
    @Override
    public void postContent() {
        System.out.println("Uploading videos on YouTube");
    }
}

// Main class
public class Abstraction9 {
    public static void main(String[] args) {

        // Using abstraction: parent reference to child object
        SocialMedia user1 = new Instagram();
        SocialMedia user2 = new YouTube();

        // Calling overridden methods
        user1.postContent(); // Output: Posting photos on Instagram
        user2.postContent(); // Output: Uploading videos on YouTube
    }
}
