package com.example.video.s.record.service;

import com.example.video.s.record.dto.VideoDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VideoService {
    @Transactional
    VideoDto createVideo(VideoDto dto);

    VideoDto getVideoById(Long id);

    List<VideoDto> getAllVideos();

    String getEmbedUrl(String videoUrl);
}
