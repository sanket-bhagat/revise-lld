class YoutubeChannel {
    public void uploadNewVideo(String videoTitle) {
        // Upload the video
        System.out.println("Uploading: " + videoTitle + "\n");

        // Manually notify users
        System.out.println("Sending email to user1@example.com");
        System.out.println("Pushing in-app notification to user3@example.com");
    }
}

public class YoutubeChannelWithoutObserver {
    public static void main(String[] args) {
        // Create a channel and upload a new video
        YoutubeChannel channel = new YoutubeChannel();
        channel.uploadNewVideo("Design Patterns in Java");
    }
}
