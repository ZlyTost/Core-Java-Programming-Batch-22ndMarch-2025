package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Social Media Platform: 
Create classes for User2, Post, and Comment. 
Implement methods for creating posts, adding comments, and displaying User2 feeds.
*/

// Class representing a Comment
class Comment {
    private String content;
    private User2 User2;

    public Comment(String content, User2 User2) {
        this.content = content;
        this.User2 = User2;
    }

    public String getContent() {
        return content;
    }

    public User2 getUser2 () {
        return User2;
    }

    @Override
    public String toString() {
        return User2.getUser2name() + ": " + content;
    }
}

// Class representing a Post
class Post {
    private String content;
    private User2 User2;
    private List<Comment> comments;

    public Post(String content, User2 User2) {
        this.content = content;
        this.User2 = User2;
        this.comments = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public String getContent() {
        return content;
    }

    public User2 getUser2 () {
        return User2;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        StringBuilder postDetails = new StringBuilder(User2.getUser2name() + ": " + content + "\nComments:\n");
        for (Comment comment : comments) {
            postDetails.append(" - ").append(comment.toString()).append("\n");
        }
        return postDetails.toString();
    }
}

// Class representing a User2
class User2 {
    private String User2name;
    private List<Post> posts;

    public User2(String User2name) {
        this.User2name = User2name;
        this.posts = new ArrayList<>();
    }

    public String getUser2name() {
        return User2name;
    }

    public void createPost(String content) {
        Post post = new Post(content, this);
        posts.add(post);
        System.out.println(User2name + " created a new post: " + content);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void displayFeed() {
        System.out.println(User2name + "'s Feed:");
        for (Post post : posts) {
            System.out.println(post.toString());
        }
    }
}

// Class representing the Social Media Platform
class SocialMediaPlatform {
    private List<User2> User2s;

    public SocialMediaPlatform() {
        User2s = new ArrayList<>();
    }

    public void addUser2 (User2 User2) {
        User2s.add(User2);
        System.out.println("User2  added: " + User2.getUser2name());
    }

    public void displayAllFeeds() {
        for (User2  User2 : User2s) {
            User2.displayFeed();
        }
    }
}

// Main class to run the Social Media Platform
public class p19 {
    public static void main(String[] args) {
        // Create a social media platform
        SocialMediaPlatform platform = new SocialMediaPlatform();

        // Create User2s
        User2 User21 = new User2("Alice");
        User2 User22 = new User2("Bob");

        // Add User2s to the platform
        platform.addUser2 (User21);
        platform.addUser2 (User22);

        // User2s create posts
        User21.createPost("Hello, world!");
        User22.createPost("Good morning, everyone!");

        // User2s add comments to posts
        Post post1 = User21.getPosts().get(0);
        post1.addComment(new Comment("Nice to see you!", User22));

        Post post2 = User22.getPosts().get(0);
        post2.addComment(new Comment("Thank you!", User21));

        // Display all User2 feeds
        platform.displayAllFeeds();
    }
}
