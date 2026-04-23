package com.example.video.s.record.controller;

import com.example.video.s.record.dto.TrackDto;
import com.example.video.s.record.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/tracks")
@RequiredArgsConstructor
public class TrackController {
    private final TrackService trackService;

    @GetMapping
    public String listTracks(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 8);
        Page<TrackDto> tracks = trackService.getAllTracks(pageable);

        model.addAttribute("tracks", tracks.getContent()); // данные
        model.addAttribute("currentPage", tracks.getNumber()); // текущая страница
        model.addAttribute("totalPages", tracks.getTotalPages());  // всего записей треков
        model.addAttribute("Next", tracks.hasNext()); // следующая страница
        model.addAttribute("Previous", tracks.hasPrevious()); // предыдыщая страница
        model.addAttribute("count", trackService.countTrack()); // подсчет треков
        return "track/list";
    }

    @GetMapping("/upload")
    public String showUploadForm(Model model) {
        model.addAttribute("trackDto", new TrackDto());
        return "track/upload";
    }

    @PostMapping("/upload")
    public String uploadTrack(@ModelAttribute TrackDto trackDto,
                              @RequestParam("audioFile") MultipartFile audioFile,
                              @RequestParam("coverFile") MultipartFile coverFile) {
        trackService.createTrack(trackDto, audioFile, coverFile);
        return "redirect:/tracks";
    }

    @GetMapping("/{id}")
    public String playTrack(@PathVariable Long id, Model model) {
        TrackDto track = trackService.getTrackById(id);
        model.addAttribute("track", track);
        return "track/play";
    }

    @GetMapping("/search")
    public String searchByArtist(@RequestParam String artist, Model model) {
        model.addAttribute("tracks", trackService.searchByArtist(artist));
        model.addAttribute("searchQuery", artist);
        model.addAttribute("count", trackService.countTrack());
        return "track/list";
    }

    @PostMapping("/{id}/delete")
    public String deleteTrackById(@PathVariable Long id) {
        trackService.DeleteById(id);
        return "redirect:/tracks";
    }
}
