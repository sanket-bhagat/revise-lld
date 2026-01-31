import java.util.*;

// Mediator Interface
interface DocumentSessionMediator {
    void broadcastChange(String change, User sender);
    void join(User user);
}

// Concrete Mediator Class
class CollaborativeDocument implements DocumentSessionMediator {
    private List<User> users = new ArrayList<>();

    @Override
    public void join(User user) {
        users.add(user);
    }
    @Override
    public void broadcastChange(String change, User sender) {
        for (User user : users) {
            if(!user.equals(sender)) {
                user.receiveChange(change, sender);
            }
        }
    }

}

// User Class
class User {
    private String name;
    private DocumentSessionMediator mediator;

    public User(String name, DocumentSessionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        this.mediator.join(this);
    }

    // Method for users to make a change
    public void makeChange(String change) {
        System.out.println(name + " edited the document: " + change);
        mediator.broadcastChange(change, this);
    }

    // Method to receive a change from another users
    public void receiveChange(String change, User sender) {
        System.out.println(name + " saw change from " + sender.name + ": \"" + change + "\"");
    }
}

public class DocumentSessionWithMediator {
    public static void main(String[] args) {
        DocumentSessionMediator doc =  new CollaborativeDocument();

        // Creating users
        User alice = new User("Alice", doc);
        User bob = new User("Bob", doc);
        User charlie = new User("Charlie", doc);

        // Users making changes
        alice.makeChange("Added project title");
        bob.makeChange("Corrected grammar in paragraph 2");
    }
}
