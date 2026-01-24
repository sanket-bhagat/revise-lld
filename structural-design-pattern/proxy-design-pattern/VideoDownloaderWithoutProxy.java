// ========== VideoDownloader Class ==========
class VideoDownloader {
    public String downloadVideo(String videoUrl) {
        // caching logic missing
        // filtering logic missing
        // access logic missing
        System.out.println("Downloading video from URL: " + videoUrl);
        String content = "Video content from " + videoUrl;
        System.out.println("Downloaded Content: " + content);
        return content;
    }
}

public class VideoDownloaderWithoutProxy {
    public static void main(String[] args) {
        System.out.println("User 1 tries to download the video.");
        VideoDownloader downloader1 = new VideoDownloader();
        downloader1.downloadVideo("https://video.com/proxy-pattern");

        System.out.println();

        System.out.println("User 2 tries to download the same video again.");
        VideoDownloader downloader2 = new VideoDownloader();
        downloader2.downloadVideo("https://video.com/proxy-pattern");
    }
}
