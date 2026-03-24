package com.example.video.s.record.service.impl;

import com.example.video.s.record.dto.VideoDto;
import com.example.video.s.record.model.Video;
import com.example.video.s.record.repository.VideoRepository;
import com.example.video.s.record.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository;

    @Transactional
    @Override
    public VideoDto createVideo(VideoDto dto) {
        Video video = Video.builder()
                .title(dto.getTitle())
                .artist(dto.getArtist())
                .videoUrl(dto.getVideoUrl())
                .thumbnailUrl(dto.getThumbnailUrl())
                .createdAt(LocalDateTime.now())
                .build();

        Video saved = videoRepository.save(video);
        return convertToDto(saved);
    }

    @Override
    public VideoDto getVideoById(Long id) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Видео не найдено"));
        return convertToDto(video);
    }

    @Override
    public List<VideoDto> getAllVideos() {
        return videoRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public String getEmbedUrl(String videoUrl) {
        if (videoUrl.contains("youtube.com")) {
            String videoId = extractYouTubeId(videoUrl);
            return "https://www.youtube.com/embed/" + videoId;
        }

        if (videoUrl.contains("vimeo.com")) {
            String videoId = videoUrl.substring(videoUrl.lastIndexOf("/") + 1);
            return "https://player.vimeo.com/video/" + videoId;
        }
        return videoUrl;
    }

    private String extractYouTubeId(String url) {
        String[] parts = url.split("v=");
        if (parts.length > 1) {
            return parts[1].split("&")[0];
        }
        return "";
    }

    private VideoDto convertToDto(Video video) {
        return VideoDto.builder()
                .id(video.getId())
                .title(video.getTitle())
                .artist(video.getArtist())
                .videoUrl(video.getVideoUrl())
                .embedUrl(getEmbedUrl(video.getVideoUrl()))
                .thumbnailUrl(video.getThumbnailUrl())
                .createdAt(video.getCreatedAt())
                .build();
    }
}
