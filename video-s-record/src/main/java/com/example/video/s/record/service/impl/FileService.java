package com.example.video.s.record.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {
    private static final String MUSIC_DIR = "uploads/music/";
    private static final String COVER_DIR = "uploads/covers/";

    public String saveMusicFile(MultipartFile file) {
        return saveFile(file, MUSIC_DIR);
    }

    public String saveCoverFile(MultipartFile file) {
        return saveFile(file, COVER_DIR);
    }

    private String saveFile(MultipartFile file, String dir) {
        try {
            if (file == null || file.isEmpty()) {
                return null;
            }

            String basePath = System.getProperty("user.dir");
            File uploadDir = new File(basePath, dir);


            if (!uploadDir.exists()) {
                boolean created = uploadDir.mkdirs();
                System.out.println("Создана папка: " + created);
            }

            String originalFilename = file.getOriginalFilename();
            String extension = "";

            if (originalFilename != null && originalFilename.contains(".")) {
                extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            }

            String fileName = System.currentTimeMillis() + extension;

            File dest = new File(uploadDir, fileName);

            file.transferTo(dest);

            String webPath = "/" + dir + fileName;

            return webPath;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка сохранения файла: " + e.getMessage());
        }
    }
}