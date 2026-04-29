package com.example.video.s.record.service.impl;

import com.example.video.s.record.dto.TrackDto;
import com.example.video.s.record.model.Track;
import com.example.video.s.record.repository.TrackRepository;
import com.example.video.s.record.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {
    private final TrackRepository trackRepository;
    private final FileService fileService;

    @Transactional
    @Override
    public TrackDto createTrack(TrackDto dto, MultipartFile audioFile, MultipartFile coverFile) {
        String audioUrl = fileService.saveMusicFile(audioFile);

        if (audioUrl == null) {
            throw new RuntimeException("Аудиофайл обязателен");
        }

        String coverUrl = fileService.saveCoverFile(coverFile);

        Track track = Track.builder()
                .title(dto.getTitle())
                .artist(dto.getArtist())
                .album(dto.getAlbum())
                .genre(dto.getGenre())
                .duration(dto.getDuration())
                .audioUrl(audioUrl)
                .coverUrl(coverUrl)
                .createdAt(LocalDateTime.now())
                .build();

        Track saved = trackRepository.save(track);
        return convertToDto(saved);
    }

    @Override
    public void DeleteById(Long id) {
        trackRepository.deleteById(id);
    }

    @Override
    public TrackDto getTrackById(Long id) {
        Track track = trackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Трек не найден"));
        return convertToDto(track);
    }

    @Override
    public Page<TrackDto> getAllTracks(Pageable pageable) {
        return trackRepository.findAll(pageable)
                .map(this::convertToDto);
    }

    @Override
    public TrackDto updateTrack(Long id, TrackDto videoDto) {
        Track video = trackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пусто"));

        if (videoDto.getTitle() != null) {
            video.setTitle(videoDto.getTitle());
        }

        if (videoDto.getArtist() != null) {
            video.setArtist(videoDto.getArtist());
        }
        if (videoDto.getAlbum() != null) {
            video.setAlbum(videoDto.getAlbum());
        }
        if (videoDto.getGenre() != null) {
            video.setGenre(videoDto.getGenre());
        }
        if (videoDto.getDuration() != null) {
            video.setDuration(videoDto.getDuration());
        }
        if (videoDto.getAudioUrl() != null) {
            video.setAudioUrl(videoDto.getAudioUrl());
        }
        if (videoDto.getCoverUrl() != null) {
            video.setCoverUrl(videoDto.getCoverUrl());
        }

        Track saved = trackRepository.save(video);
        return convertToDto(saved);
    }

    @Override
    public List<TrackDto> searchByArtist(String artist) {
        return trackRepository.findByArtistContainingIgnoreCase(artist).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public long countTrack() {
        return trackRepository.count();
    }


    private TrackDto convertToDto(Track track) {
        return TrackDto.builder()
                .id(track.getId())
                .title(track.getTitle())
                .artist(track.getArtist())
                .album(track.getAlbum())
                .genre(track.getGenre())
                .duration(track.getDuration())
                .audioUrl(track.getAudioUrl())
                .coverUrl(track.getCoverUrl())
                .createdAt(track.getCreatedAt())
                .build();
    }
}
