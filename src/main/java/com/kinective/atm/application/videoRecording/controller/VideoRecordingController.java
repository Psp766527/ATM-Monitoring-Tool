package com.kinective.atm.application.videoRecording.controller;

import com.kinective.atm.application.videoRecording.service.VideoRecordingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/atm/recordings")
public class VideoRecordingController {

    @Autowired
    private VideoRecordingService mediaService;

    @Operation(summary = "it is used to download the photo or video of the ATM in time range ",
            description = "it is used to download the photo or video of the ATM in time range   ")
    @ApiResponse(responseCode = "200", description = "Returns success if video found successfully.")
    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadMediaByTimeRange(
            @Parameter(description = "startTime,endTime,type", required = true)
            @RequestParam("startTime") String startTimeStr,
            @RequestParam("endTime") String endTimeStr,
            @RequestParam("type") String type) throws IOException {

        LocalDateTime startTime = LocalDateTime.parse(startTimeStr);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr);

        List<File> mediaFiles = mediaService.getMediaByTimeRange(startTime, endTime, "video");

        if (!mediaFiles.isEmpty()) {
            File file = mediaFiles.get(0);
            byte[] data = Files.readAllBytes(file.toPath());

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(type.equalsIgnoreCase("video") ? MediaType.APPLICATION_OCTET_STREAM : MediaType.IMAGE_JPEG);
            headers.setContentDispositionFormData("attachment", file.getName());

            return new ResponseEntity<>(data, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
