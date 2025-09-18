package com.jfposton.ytdlp;

import com.jfposton.ytdlp.mapper.VideoFormat;
import com.jfposton.ytdlp.mapper.VideoInfo;
import com.jfposton.ytdlp.mapper.VideoThumbnail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class YtDlpTest {
    private static final String DIRECTORY = System.getProperty("java.io.tmpdir");
    private static final String VIDEO_URL = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    private static final String NONE_EXISTENT_VIDEO_URL = "https://www.youtube.com/watch?v=dQw4w9WgXcZ";

    /**
     * @Test public void testUsingOwnExecutablePath() throws YtDlpException {
     * YtDlp.setExecutablePath("/usr/bin/yt-dlp"); Assertions.assertNotNull(YtDlp.getVersion()); }
     */
    @Test
    public void testGetVersion() throws YtDlpException {
        Assertions.assertNotNull(YtDlp.getVersion());
    }

    @Test
    public void testElapsedTime() throws YtDlpException {
        long startTime = System.nanoTime();

        YtDlpRequest request = new YtDlpRequest();
        request.addOption("version");
        YtDlpResponse response = YtDlp.execute(request);

        int elapsedTime = (int) (System.nanoTime() - startTime);

        Assertions.assertTrue(elapsedTime > response.getElapsedTime());
    }

    @Test
    public void testSimulateDownload() throws YtDlpException {
        YtDlpRequest request = new YtDlpRequest();
        request.setUrl(VIDEO_URL);
        request.addOption("simulate");

        YtDlpResponse response = YtDlp.execute(request);

        Assertions.assertEquals(
                YtDlp.getExecutablePath() + " " + VIDEO_URL + " --simulate",
                response.getCommand()
        );
    }

    @Test
    public void testDirectory() throws YtDlpException {
        YtDlpRequest request = new YtDlpRequest(VIDEO_URL, DIRECTORY);
        request.addOption("simulate");

        YtDlpResponse response = YtDlp.execute(request);

        Assertions.assertEquals(DIRECTORY, response.getDirectory());
    }

    @Test
    public void testGetVideoInfo() throws YtDlpException {
        VideoInfo videoInfo = YtDlp.getVideoInfo(VIDEO_URL);
        Assertions.assertNotNull(videoInfo);
    }

    @Test
    public void testGetFormats() throws YtDlpException {
        List<VideoFormat> formats = YtDlp.getFormats(VIDEO_URL);
        Assertions.assertNotNull(formats);
        Assertions.assertFalse(formats.isEmpty());
    }

    @Test
    public void testGetThumbnails() throws YtDlpException {
        List<VideoThumbnail> thumbnails = YtDlp.getThumbnails(VIDEO_URL);
        Assertions.assertNotNull(thumbnails);
        Assertions.assertFalse(thumbnails.isEmpty());
    }

    @Test
    public void testGetTags() throws YtDlpException {
        List<String> tags = YtDlp.getTags(VIDEO_URL);
        Assertions.assertNotNull(tags);
        Assertions.assertFalse(tags.isEmpty());
    }

    @Test
    public void testGetCategories() throws YtDlpException {
        List<String> categories = YtDlp.getCategories(VIDEO_URL);
        Assertions.assertNotNull(categories);
        Assertions.assertFalse(categories.isEmpty());
    }

    @Test
    public void testFailGetNonExistentVideoInfo() {
        Assertions.assertThrows(YtDlpException.class, () -> YtDlp.getVideoInfo(NONE_EXISTENT_VIDEO_URL));
    }

    /**
     * @author memento <a href="https://github.com/sapher/youtubedl-java/pull/11/">https://github.com/sapher/youtubedl-java/pull/11/</a>
     * @throws YtDlpException
     */
    @Test
    public void testGetVideoInfoInDetails() throws YtDlpException {
        VideoInfo videoInfo = YtDlp.getVideoInfo(VIDEO_URL);
        Assertions.assertNotNull(videoInfo);

        //Let's check if we can access key elements from video info

        Assertions.assertNotNull(videoInfo.getId());
        Assertions.assertNotNull(videoInfo.getTitle());
        Assertions.assertNotNull(videoInfo.getFulltitle());
        Assertions.assertNotNull(videoInfo.getDescription());
        Assertions.assertNotNull(videoInfo.getThumbnail());
        Assertions.assertNotNull(videoInfo.getUploaderId());
        Assertions.assertNotNull(videoInfo.getUploader());
        Assertions.assertNotNull(videoInfo.getUploadDate());
        //Assertions.assertNotNull(videoInfo.getDuration());
        Assertions.assertNotNull(videoInfo.getViewCount());
        Assertions.assertNotNull(videoInfo.getLikeCount());
        Assertions.assertNotNull(videoInfo.getDislikeCount());
        Assertions.assertNotNull(videoInfo.getAverageRating());
    }
}