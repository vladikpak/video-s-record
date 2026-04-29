package com.example.video.s.record.controller;

import com.example.video.s.record.dto.VideoDto;
import com.example.video.s.record.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/videos")
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;

    @GetMapping
    public String listVideos(Model model) {
        model.addAttribute("videos", videoService.getAllVideos());
        model.addAttribute("count", videoService.countTrack());
        return "video/list";
    }

    @GetMapping("/{id}/edit")
    public String listVideos(Model model, @PathVariable Long id) {
        VideoDto video = videoService.getVideoById(id);
        model.addAttribute("video", video);
        return "video/edit";
    }

    @PostMapping("/{id}/edit")
    public String editVideos(@PathVariable Long id, @ModelAttribute VideoDto videoDto) {
        videoService.updateVideo(id, videoDto);
        return "redirect:/videos/" + id;
    }

    @GetMapping("/upload")
    public String showUploadForm(Model model) {
        model.addAttribute("videoDto", new VideoDto());
        return "video/upload";
    }

    @PostMapping("/upload")
    public String uploadVideo(@ModelAttribute VideoDto videoDto) {
        videoService.createVideo(videoDto);
        return "redirect:/videos";
    }

    @GetMapping("/{id}")
    public String watchVideo(@PathVariable Long id, Model model) {
        VideoDto video = videoService.getVideoById(id);
        model.addAttribute("video", video);
        return "video/watch";
    }

    @GetMapping("/search")
    public String searchByArtist(@RequestParam String title, Model model) {
        model.addAttribute("videos", videoService.searchVideo(title));
        model.addAttribute("searchQuery", title);
        return "video/list";
    }

    @PostMapping("{id}/delete")
    public String deleteVideo(@PathVariable Long id) {
        videoService.DeleteById(id);
        return "redirect:/videos";
    }
}
