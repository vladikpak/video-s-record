package com.example.video.s.record.repository;

import com.example.video.s.record.model.Track;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
    List<Track> findByArtistContainingIgnoreCase(String artist);
    List<Track> findByGenre(String genre);
    Page<Track> findAll(Pageable pageable);
}
