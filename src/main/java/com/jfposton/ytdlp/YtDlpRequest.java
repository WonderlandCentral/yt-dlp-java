package com.jfposton.ytdlp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * YtDlp request
 */
@SuppressWarnings("unused")
public class YtDlpRequest {
    /**
     * Executable working directory
     */
    private String directory;

    /**
     * Video Url
     */
    private String url;

    /**
     * List of executable options
     */
    private final Map<String, String> options = new HashMap<>();

    /**
     * Constructor
     */
    public YtDlpRequest() {
    }

    /**
     * Construct a request with a videoUrl
     *
     * @param url
     */
    public YtDlpRequest(String url) {
        this.url = url;
    }

    /**
     * Construct a request with a videoUrl and working directory
     *
     * @param url
     * @param directory
     */
    public YtDlpRequest(String url, String directory) {
        this.url = url;
        this.directory = directory;
    }

    /**
     * Transform options to a string that the executable will execute
     *
     * @return Command string
     */
    protected String buildOptions() {
        StringBuilder builder = new StringBuilder();

        // Set Url
        if (url != null) builder.append(url).append(" ");

        // Build options strings
        Iterator<Entry<String, String>> it = options.entrySet().iterator();

        while (it.hasNext()) {
            Entry<String, String> option = it.next();

            String name = option.getKey();
            String value = option.getValue();

            if (value == null) value = "";

            String optionFormatted = String.format("--%s %s", name, value).trim();
            builder.append(optionFormatted).append(" ");

            it.remove();
        }

        return builder.toString().trim();
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void addOption(String key) {
        options.put(key, null);
    }

    public void addOption(String key, String value) {
        options.put(key, value);
    }

    public void addOption(String key, int value) {
        options.put(key, String.valueOf(value));
    }
}