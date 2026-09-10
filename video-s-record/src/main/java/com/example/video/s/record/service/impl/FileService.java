package com.example.video.s.record.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {

    private static final String UPLOAD_DIR = "uploads/";

    private String getBasePath() {
        String userDir = System.getProperty("user.dir");
        if (userDir.equals("/app")) {
            return "/app/uploads/";
        }
        return System.getProperty("user.dir") + "/" + UPLOAD_DIR;
    }

    public String saveMusicFile(MultipartFile file) {
        return saveFile(file, getBasePath() + "music/");
    }

    public String saveCoverFile(MultipartFile file) {
        return saveFile(file, getBasePath() + "covers/");
    }

    private String saveFile(MultipartFile file, String dir) {
        try {
            if (file == null || file.isEmpty()) return null;

            File uploadDir = new File(dir);
            if (!uploadDir.exists()) {
                boolean created = uploadDir.mkdirs();
                System.out.println("Создана папка: " + uploadDir.getAbsolutePath() + " -> " + created);
            }

            String originalFilename = file.getOriginalFilename();
            String extension = "";
            if (originalFilename != null && originalFilename.contains(".")) {
                extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            }

            String fileName = System.currentTimeMillis() + extension;
            File dest = new File(uploadDir, fileName);

            file.transferTo(dest);
            System.out.println("Файл сохранён: " + dest.getAbsolutePath());

            // Web-путь
            String webPath = "/uploads/" + dir.replace(getBasePath(), "") + fileName;
            return webPath;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка сохранения файла: " + e.getMessage());
        }
    }
}