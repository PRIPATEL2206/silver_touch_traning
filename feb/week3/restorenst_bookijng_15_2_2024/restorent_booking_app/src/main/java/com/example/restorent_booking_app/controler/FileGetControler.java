package com.example.restorent_booking_app.controler;

import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.restorent_booking_app.services.ImageUploadServices;

@Controller
public class FileGetControler {
    @GetMapping("/products/{filename:.+}")
    public ResponseEntity<Resource> getProductImage(@PathVariable String filename) throws MalformedURLException {
        Resource files = ImageUploadServices.getFile(ImageUploadServices.PRODUCT_UPLOAD_DIRECTORY, filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + files.getFilename() + "\"")
                .body(files);
    }

    @GetMapping("/complaints/{filename:.+}")
    public ResponseEntity<Resource> getComplaintsImage(@PathVariable String filename) throws MalformedURLException {
        Resource files = ImageUploadServices.getFile(ImageUploadServices.COMPLAINT_UPLOAD_DIRECTORY, filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + files.getFilename() + "\"")
                .body(files);
    }
}
