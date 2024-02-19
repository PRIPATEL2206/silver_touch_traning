package com.example.user_admin_crud.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class ImageUploadServices {
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    public static Path uploadImage(MultipartFile file) throws IOException {

        // upload image
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());

        return fileNameAndPath;

    }
}
