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
public class TrackDto {
    private Long id;
    private String title;
    private String artist;
    private String album;
    private String genre;
    private Integer duration;
    private String audioUrl;
    private String coverUrl;
    private LocalDateTime createdAt;
}
