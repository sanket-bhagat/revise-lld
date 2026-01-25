import java.util.*;

// Video class representing a single video
class Video {
    private String title;

    public Video(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// YoutubePlaylist class
class YoutubePlaylist {
    private List<Video> videos;

    public YoutubePlaylist() {
        videos = new ArrayList<>();
    }

    // Method to add video to playlist
    public void addVideo(Video video) {
        videos.add(video);
    }

    // Method to expose internal video list
    public List<Video> getVideos() {
        return videos;
    }
}

// Iterator interface
interface PlaylistIterator {
    boolean hasNext();
    Video next();
}

// Concrete Iterator class
class YoutubePlaylistIterator implements PlaylistIterator {
    private YoutubePlaylist playlist;
    private int position;

    // Constructor takes the YoutubePlaylist
    public YoutubePlaylistIterator(YoutubePlaylist playlist) {
        this.playlist = playlist;
        position = 0;
    }

    // Checks if more videos are left to iterate
    @Override
    public boolean hasNext() {
        return position < playlist.getVideos().size();
    }

    // Returns the next video in sequence
    @Override
    public Video next() {
        return hasNext() ? playlist.getVideos().get(position++) : null;
    }
}

public class YoutubePlaylistWithIterator {
    public static void main(String[] args) {
        // Create a playlist and add videos
        YoutubePlaylist playlist = new YoutubePlaylist();
        playlist.addVideo(new Video("LLD Tutorial"));
        playlist.addVideo(new Video("System Design Basics"));

        // Client directly creates the iterator using internal list (not ideal)
        PlaylistIterator iterator = new YoutubePlaylistIterator(playlist);

        // Use the iterator to loop through the playlist
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }
    }
}
