package com.jfposton.ytdlp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YtDlpRequestTest {
    @Test
    public void testBuildOptionStandalone() {
        YtDlpRequest request = new YtDlpRequest();
        request.addOption("help");

        Assertions.assertEquals("--help", request.buildOptions());
    }

    @Test
    public void testBuildOptionWithValue() {
        YtDlpRequest request = new YtDlpRequest();
        request.addOption("password", "1234");

        Assertions.assertEquals("--password 1234", request.buildOptions());
    }

    @Test
    public void testBuildChainOptionWithValue() {
        YtDlpRequest request = new YtDlpRequest();
        request.addOption("password", "1234");
        request.addOption("username", "1234");

        Assertions.assertEquals("--password 1234 --username 1234", request.buildOptions());
    }
}