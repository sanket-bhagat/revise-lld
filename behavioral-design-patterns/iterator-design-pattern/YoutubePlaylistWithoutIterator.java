import java.util.*;

// A sample Video class with title
class Video {
    String title;

    public Video(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// YoutubePlaylist class holds lisst of Video object
class YoutubePlaylist {
    private List<Video> videos;

    public YoutubePlaylist() {
        this.videos = new ArrayList<>();
    }

    // Add a video to the playlist
    public void addVideo(Video video) {
        videos.add(video);
    }

    // Expose the video list
    public List<Video> getVideos() {
        return videos;
    }
}

public class YoutubePlaylistWithoutIterator {
    public static void main(String[] args) {
        YoutubePlaylist playlist = new YoutubePlaylist();
        playlist.addVideo(new Video("LLD Tutorial"));
        playlist.addVideo(new Video("System Design Basics"));

        // Loop through videos and print titles
        for (Video v : playlist.getVideos()) {
            System.out.println(v.getTitle());
        }
    }
}
