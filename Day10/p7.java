package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Chat Application: 
Create classes for User11, Message, and ChatRoom. 
Implement methods for sending and receiving messages.
*/

// Enum representing the type of message
enum MessageType {
    TEXT,
    IMAGE
}

// Class representing a User11
class User11 {
    private String User11name;
    private String status;

    public User11(String User11name) {
        this.User11name = User11name;
        this.status = "Online"; // Default status
    }

    public String getUser11name() {
        return User11name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return User11name + " (" + status + ")";
    }
}

// Class representing a Message
class Message {
    private User11 sender;
    private String content;
    private MessageType type;

    public Message(User11 sender, String content, MessageType type) {
        this.sender = sender;
        this.content = content;
        this.type = type;
    }

    public User11 getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public MessageType getType() {
        return type;
    }

    @Override
    public String toString() {
        return sender.getUser11name() + ": " + content + " [" + type + "]";
    }
}

// Class representing a ChatRoom
class ChatRoom {
    private String name;
    private List<User11> User11s;
    private List<Message> messages;

    public ChatRoom(String name) {
        this.name = name;
        this.User11s = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addUser11 (User11 User11) {
        User11s.add(User11);
        System.out.println(User11.getUser11name() + " has joined the chat room: " + name);
    }

    public void sendMessage(User11 sender, String content, MessageType type) {
        Message message = new Message(sender, content, type);
        messages.add(message);
        System.out.println("Message sent: " + message);
    }

    public void displayMessages() {
        System.out.println("Chat Room: " + name);
        for (Message message : messages) {
            System.out.println(message);
        }
    }
}

// Class for managing the Chat Application
class ChatApplication {
    public static void main(String[] args) {
        // Create User11s
        User11 User111 = new User11("Alice");
        User11 User112 = new User11("Bob");

        // Create a chat room
        ChatRoom chatRoom = new ChatRoom("General Chat");

        // Add User11s to the chat room
        chatRoom.addUser11 (User111);
        chatRoom.addUser11 (User112);

        // User11s send messages
        chatRoom.sendMessage(User111, "Hello, everyone!", MessageType.TEXT);
        chatRoom.sendMessage(User112, "Hi Alice!", MessageType.TEXT);
        chatRoom.sendMessage(User111, "Check out this image!", MessageType.IMAGE);

        // Display messages in the chat room
        chatRoom.displayMessages();
    }
}
