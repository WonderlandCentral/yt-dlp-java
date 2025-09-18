package com.jfposton.ytdlp.mapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Updated to have more features: <a href="https://github.com/sapher/youtubedl-java/pull/11/">https://github.com/sapher/youtubedl-java/pull/11/</a>
 * @author memento ^
 */
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoInfo {
    private String id;
    private String fulltitle;
    private String title;

    @JsonProperty("upload_date")
    private String uploadDate;

    @JsonProperty("display_id")
    private String displayId;

    private long duration;
    private String description;
    private String thumbnail;
    private String license;

    @JsonProperty("view_count")
    public String viewCount;

    @JsonProperty("like_count")
    public String likeCount;

    @JsonProperty("dislike_count")
    public String dislikeCount;

    @JsonProperty("repost_count")
    public String repostCount;

    @JsonProperty("average_rating")
    public String averageRating;

    @JsonProperty("uploader_id")
    private String uploaderId;

    private String uploader;

    @JsonProperty("player_url")
    private String playerUrl;

    @JsonProperty("webpage_url")
    private String webpageUrl;

    @JsonProperty("webpage_url_basename")
    private String webpageUrlBasename;

    private String resolution;
    private int width;
    private int height;
    private String format;
    private String ext;

    @JsonProperty("http_headers")
    private HttpHeader httpHeader;

    private List<String> categories;
    private List<String> tags;
    private List<VideoFormat> formats;
    private List<VideoThumbnail> thumbnails;

    public String getId() {
        return id;
    }

    public String getFulltitle() {
        return fulltitle;
    }

    public String getTitle() {
        return title;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public String getDisplayId() {
        return displayId;
    }

    public long getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getLicense() {
        return license;
    }

    public String getUploaderId() {
        return uploaderId;
    }

    public String getUploader() {
        return uploader;
    }

    public String getPlayerUrl() {
        return playerUrl;
    }

    public String getWebpageUrl() {
        return webpageUrl;
    }

    public String getWebpageUrlBasename() {
        return webpageUrlBasename;
    }

    public String getResolution() {
        return resolution;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getFormat() {
        return format;
    }

    public String getExt() {
        return ext;
    }

    public HttpHeader getHttpHeader() {
        return httpHeader;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<VideoFormat> getFormats() {
        return formats;
    }

    public List<VideoThumbnail> getThumbnails() {
        return thumbnails;
    }

    public String getViewCount() {
        return viewCount;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public String getDislikeCount() {
        return dislikeCount;
    }

    public String getRepostCount() {
        return repostCount;
    }

    public String getAverageRating() {
        return averageRating;
    }

    @Override
    public String toString() {
        return "VideoInfo [id=" + id + ", fulltitle=" + fulltitle + ", title=" + title + ", uploadDate=" + uploadDate
                + ", displayId=" + displayId + ", duration=" + duration + ", description=" + description
                + ", thumbnail=" + thumbnail + ", license=" + license + ", viewCount=" + viewCount + ", likeCount="
                + likeCount + ", dislikeCount=" + dislikeCount + ", repostCount=" + repostCount + ", averageRating="
                + averageRating + ", uploaderId=" + uploaderId + ", uploader=" + uploader + ", playerUrl=" + playerUrl
                + ", webpageUrl=" + webpageUrl + ", webpageUrlBasename=" + webpageUrlBasename + ", resolution="
                + resolution + ", width=" + width + ", height=" + height + ", format=" + format + ", ext=" + ext
                + ", httpHeader=" + httpHeader + ", categories=" + categories + ", tags=" + tags + ", formats="
                + formats + ", thumbnails=" + thumbnails + "]";
    }
}