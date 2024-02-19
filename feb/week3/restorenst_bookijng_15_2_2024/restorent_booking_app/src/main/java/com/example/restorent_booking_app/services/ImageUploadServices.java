package com.example.restorent_booking_app.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

public class ImageUploadServices {
    private static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
    public static String PRODUCT_UPLOAD_DIRECTORY = "/products";
    public static String COMPLAINT_UPLOAD_DIRECTORY = "/complaint";

    public static Path uploadImage(String uploadTo, MultipartFile file) throws IOException {

        // upload image
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY + "/" + uploadTo, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        return fileNameAndPath.getFileName();

    }

    public static Resource getFile(String getFrom, String fileName) throws MalformedURLException {
        Path root = Paths.get(UPLOAD_DIRECTORY + getFrom + "/");
        Path file = root.resolve(fileName);
        return new UrlResource(file.toUri());
    }
}
