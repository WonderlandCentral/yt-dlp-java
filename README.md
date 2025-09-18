# yt-dlp-java
A simple java wrapper for [yt-dlp](https://github.com/yt-dlp/yt-dlp) executable

---

# Prerequisites
⚠️ yt-dlp should be installed and available in your `$PATH.

[How to properly install yt-dlp executable](https://github.com/yt-dlp/yt-dlp#installation)

Otherwise, you will get this error:
`Cannot run program "yt-dlp" (in directory "/home/user/Downloads"): error=2, No such file or directory`

or you can later set it with code.

# Installation

---
## Installation on Maven:
```xml
<!-- Inside <repositories> -->
<repository>
    <id>wonderland</id>
    <url>https://raw.github.com/WonderlandCentral/wonderland-repository/main</url>
</repository>

<!-- Inside <dependencies> -->
<dependency>
    <groupId>com.jfposton.ytdlp</groupId>
    <artifactId>yt-dlp-java</artifactId>
    <version>1.0</version>
</dependency>
```
## Installation on Gradle:
```groovy
// Inside repositories{}
maven { url "https://raw.github.com/WonderlandCentral/wonderland-repository/main" }

// Inside dependencies{}
implementation("com.jfposton.ytdlp:yt-dlp-java:1.0")
```

# Usage

---
## Basic Download Request Example
```java
// Video URL to download
String videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";

// Destination directory (e.g., user's home folder)
String directory = System.getProperty("user.home");

// Build the request
YtDlpRequest request = new YtDlpRequest(videoUrl, directory);

// Add yt-dlp options
request.setOption("ignore-errors");                 // --ignore-errors
request.setOption("output", "%(id)s");              // --output "%(id)s"
request.setOption("retries", 10);                   // --retries 10

// Execute the request
YtDlpResponse response = YtDlp.execute(request);

// Handle response
String output = response.getOut();                  // Standard output from yt-dlp
String error = response.getErr();                   // Error output, if any
int exitCode = response.getExitCode();              // Exit code of the process
```

## Using a Download Progress Callback
```java
DownloadProgressCallback callback = new DownloadProgressCallback() {
    @Override
    public void onProgress(String line) {
        System.out.println("Progress: " + line);
    }
};

YtDlpRequest request = new YtDlpRequest("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
request.setOption("progress"); // just to show progress in output (optional)

YtDlpResponse response = YtDlp.execute(request, callback);
```

## Simulating a Download Without Downloading (e.g., for testing)
```java
YtDlpRequest request = new YtDlpRequest("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
request.setOption("simulate"); // --simulate

YtDlpResponse response = YtDlp.execute(request);
System.out.println("Simulated Command: " + response.getCommand());
```

## Getting Video Info as a Java Object
```java
VideoInfo info = YtDlp.getVideoInfo("https://www.youtube.com/watch?v=dQw4w9WgXcQ");

System.out.println("Title: " + info.getTitle());
System.out.println("Uploader: " + info.getUploader());
System.out.println("Duration: " + info.getDuration());
```

## Setting the yt-dlp executable path
```java
YtDlp.setExecutablePath("/home/user/Downloads/yt-dlp");
```

---

# Links
* [yt-dlp documentation](https://github.com/yt-dlp/yt-dlp)

---