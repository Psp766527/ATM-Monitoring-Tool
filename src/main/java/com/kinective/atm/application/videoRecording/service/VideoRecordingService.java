package com.kinective.atm.application.videoRecording.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoRecordingService {

    @Value("${video.recording.path}")
    private String videoRecordingDPath;

    public List<File> getMediaByTimeRange(LocalDateTime startTime, LocalDateTime endTime, String type) {
        List<File> mediaFiles = new ArrayList<>();


        File directory = new File(videoRecordingDPath);
        File[] files = directory.listFiles((dir, name) -> {

            LocalDateTime fileTime = extractTimeFromFileName(name);
            boolean isWithinRange = fileTime != null && !fileTime.isBefore(startTime) && !fileTime.isAfter(endTime);
            boolean isMatchingType = name.toLowerCase().endsWith(type.equalsIgnoreCase("video") ? ".mp4" : ".jpg");
            return isWithinRange && isMatchingType;
        });
        if (files != null) {
            mediaFiles.addAll(Arrays.asList(files));
        }
        return mediaFiles;
    }

    // Helper method to extract timestamp from the file name
    private LocalDateTime extractTimeFromFileName(String fileName) {
        try {
            // Assuming the file name contains a timestamp, e.g., "video-2023-10-01T10-00-00.mp4"
            String[] parts = fileName.split("-");
            String timePart = parts[1].replace(".mp4", "").replace(".jpg", "");
            return LocalDateTime.parse(timePart);
        } catch (Exception e) {
            return null;
        }
    }
}
