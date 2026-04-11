package com.example.video.s.record.service;

import com.example.video.s.record.dto.VideoDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VideoService {
    @Transactional
    VideoDto createVideo(VideoDto dto);

    VideoDto getVideoById(Long id);

    List<VideoDto> getAllVideos();

    void DeleteById(Long id);

    List<VideoDto> searchVideo(String name);

    String getEmbedUrl(String videoUrl);
}
