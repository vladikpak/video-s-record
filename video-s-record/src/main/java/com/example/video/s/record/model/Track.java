package com.example.video.s.record.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tracks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String artist;

    private String album;
    private String genre;
    private Integer duration; // в секундах

    @Column(nullable = false)
    private String audioUrl;   // /uploads/music/123.mp3

    private String coverUrl;    // /uploads/covers/123.jpg

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}