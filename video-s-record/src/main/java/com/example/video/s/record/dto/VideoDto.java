package com.example.video.s.record.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoDto {
    private Long id;
    private String title;
    private String artist;
    private String videoUrl;
    private String embedUrl;
    private String thumbnailUrl;
    private LocalDateTime createdAt;
}