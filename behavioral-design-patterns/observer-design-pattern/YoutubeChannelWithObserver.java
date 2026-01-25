import java.util.*;

// Observer Interface
interface Subscriber {
    void update(String videoTitle);
}

// Concreate Observer (Email)
class EmailSubscriber implements Subscriber {
    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("Email sent to " + email + ": New video uploaded - " + videoTitle);
    }
}

// Concrete Observer (Mobile App)
class MobileAppSubscriber implements Subscriber {
    private String username;

    public MobileAppSubscriber(String username) {
        this.username = username;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("In-app notification for " + username + ": New video - " + videoTitle);
    }
}

// Subject (Observable) Interface
interface Channel {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(String videoTitle);
}

// Concrete Subject (Youtube Channel)
class YoutubeChannel implements Channel {
    private String channelName;
    private List<Subscriber> subscribers;

    public YoutubeChannel(String channelName) {
        this.channelName = channelName;
        subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String videoTitle) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(videoTitle);
        }
    }

    // Simulates video upload and trigger notifications
    public void uploadVideo(String videoTitle) {
        System.out.println(channelName + " uploaded: " + videoTitle + "\n");
        notifySubscribers(videoTitle);
    }
}

public class YoutubeChannelWithObserver {
    public static void main(String[] args) {
        YoutubeChannel sanketdaily = new YoutubeChannel("sanketdaily");

        // Add subscribers
        Subscriber sanket = new EmailSubscriber("sanket@gmail.com");
        Subscriber aniket = new EmailSubscriber("aniket@gmail.com");
        Subscriber user =  new MobileAppSubscriber("user");
        sanketdaily.subscribe(sanket);
        sanketdaily.subscribe(aniket);
        sanketdaily.subscribe(user);

        sanketdaily.uploadVideo("Push Day");

        sanketdaily.unsubscribe(aniket);

        sanketdaily.uploadVideo("Legs Day");
    }
}
