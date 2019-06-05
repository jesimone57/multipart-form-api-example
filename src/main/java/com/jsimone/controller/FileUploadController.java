package com.jsimone.controller;

import com.jsimone.entity.DocumentMetadata;
import com.jsimone.service.PersonCSVReaderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(value = "File Upload API", tags = "File Upload API")
public class FileUploadController {

    @Autowired
    private PersonCSVReaderService personCSVReaderService;


    @PostMapping(value = "/document", consumes= {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void handleFileUpload3(@RequestPart("file") MultipartFile file, @RequestPart("metadata") DocumentMetadata metadata) {
        System.out.println(String.format("uploading file %s of %s bytes", file.getOriginalFilename(), file.getSize()));
        personCSVReaderService.readPersonCSV(file, metadata);
    }

}
