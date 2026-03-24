package com.example.video.s.record.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
    @Table(name = "videos")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class Video {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String title;

        @Column(nullable = false)
        private String artist;

        @Column(nullable = false)
        private String videoUrl;

        private String thumbnailUrl;

        @Column(name = "created_at")
        private LocalDateTime createdAt;
    }

