package com.example.video.s.record.service;

import com.example.video.s.record.dto.TrackDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TrackService {
    @Transactional
    TrackDto createTrack(TrackDto dto, MultipartFile audioFile, MultipartFile coverFile);

    void DeleteById(Long id);

    TrackDto getTrackById(Long id);

    Page<TrackDto> getAllTracks(Pageable pageable);

    List<TrackDto> searchByArtist(String artist);

    List<TrackDto> searchByGenre(String genre);
}
