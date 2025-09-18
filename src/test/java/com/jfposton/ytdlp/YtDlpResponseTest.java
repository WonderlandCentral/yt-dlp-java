package com.jfposton.ytdlp;

import com.jfposton.ytdlp.mapper.VideoInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YtDlpResponseTest {
    @Test
    public void getFormatsCanHandleLargerVideos() throws YtDlpException {
        VideoInfo videoInfo = YtDlp.getVideoInfo("https://www.youtube.com/watch?v=jPTO3lcPpik");
        Assertions.assertEquals("jPTO3lcPpik", videoInfo.getId());
        Assertions.assertNotNull(videoInfo.getFormats());
        Assertions.assertFalse(videoInfo.getFormats().isEmpty());
    }
}