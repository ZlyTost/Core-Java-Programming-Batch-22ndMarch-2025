package Day12;

import java.util.ArrayList;
import java.util.List;

/*
 21. Social Media Platform
Description: A social media platform that allows users to create posts, 
like them, and view their feed.
 */
//Interface for Social Media Operations
interface SocialMediaOperations {
 void createPost(String content);
 void likePost(int postId);
 void viewFeed();
}

//Class representing a Social Media Platform
class SocialMediaPlatform implements SocialMediaOperations {
 private List<Post> posts = new ArrayList<>();
 private int postIdCounter = 0;

 private class Post {
     int id;
     String content;
     int likes;

     Post(String content) {
         this.id = postIdCounter++;
         this.content = content;
         this.likes = 0;
     }
 }

 @Override
 public void createPost(String content) {
     posts.add(new Post(content));
     System.out.println("Created post: " + content);
 }

 @Override
 public void likePost(int postId) {
     for (Post post : posts) {
         if (post.id == postId) {
             post.likes++;
             System.out.println("Liked post: " + postId);
             return;
         }
     }
     System.out.println("Post not found.");
 }

 @Override
 public void viewFeed() {
     System.out.println("Feed:");
     for (Post post : posts) {
         System.out.println("Post ID: " + post.id + ", Content: " + post.content + ", Likes: " + post.likes);
     }
 }
}

//Main class to test the Social Media Platform
public class p5 {
 public static void main(String[] args) {
     SocialMediaPlatform platform = new SocialMediaPlatform();
     platform.createPost("Hello World!");
     platform.createPost("Java is awesome!");
     platform.likePost(0);
     platform.viewFeed();
 }
}
