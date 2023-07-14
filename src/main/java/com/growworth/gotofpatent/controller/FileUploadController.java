package com.growworth.gotofpatent.controller;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.growworth.gotofpatent.dto.FileResponseDto;
import com.growworth.gotofpatent.storage.StorageFileNotFoundException;
import com.growworth.gotofpatent.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/file")
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("")
    public ResponseEntity<List<FileResponseDto>> handleFileUpload(@RequestParam("file") List<MultipartFile> files) {
        try {
            List<FileResponseDto> fileResponses = new ArrayList<>();

            // Store each file
            for (MultipartFile file : files) {
                String originalFileName = file.getOriginalFilename();
                String fileExtension = getFileExtension(originalFileName);
                String uniqueFileName = generateUniqueFileName(fileExtension);

                String imagePath = storageService.store(file, uniqueFileName);

                // Create a FileResponseDto object
                FileResponseDto fileResponseDto = new FileResponseDto();
                fileResponseDto.setOriginalFile(originalFileName);
                fileResponseDto.setCreatedFile(imagePath);

                fileResponses.add(fileResponseDto);
            }

            // Return the list of file responses
            return ResponseEntity.ok(fileResponses);
        } catch (Exception e) {
            // Error handling for file upload failure
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            return fileName.substring(dotIndex);
        }
        return "";
    }

    private String generateUniqueFileName(String fileExtension) {
        String uuid = UUID.randomUUID().toString();
        return uuid + fileExtension;
    }
//    @GetMapping("/files/{filename:.+}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
//        // Load the file as a resource
//        Resource file = storageService.loadAsResource(filename);
//
//        // Check if the file exists
//        if (file.exists()) {
//            // Set the response headers for file download
//            HttpHeaders headers = new HttpHeaders();
//            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"");
//
//            // Return the file as the response with appropriate headers
//            return ResponseEntity.ok()
//                    .headers(headers)
//                    .body(file);
//        } else {
//            // File not found
//            return ResponseEntity.notFound().build();
//        }
//    }


    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
