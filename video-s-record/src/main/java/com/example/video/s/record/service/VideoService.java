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

    VideoDto updateVideo(Long id, VideoDto videoDto);

    String getEmbedUrl(String videoUrl);

    long countTrack();
}
