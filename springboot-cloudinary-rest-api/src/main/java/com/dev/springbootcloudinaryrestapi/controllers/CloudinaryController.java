package com.dev.springbootcloudinaryrestapi.controllers;

import com.dev.springbootcloudinaryrestapi.controllers.urls.CloudURL;
import com.dev.springbootcloudinaryrestapi.entities.Photo;
import com.dev.springbootcloudinaryrestapi.exceptions.CloudinaryException;
import com.dev.springbootcloudinaryrestapi.exceptions.DatabaseException;
import com.dev.springbootcloudinaryrestapi.exceptions.NotFoundException;
import com.dev.springbootcloudinaryrestapi.models.PhotoUpload;
import com.dev.springbootcloudinaryrestapi.services.ICloudinaryService;
import com.dev.springbootmongorestapi.exceptions.ValidationCode;
import com.dev.springbootmongorestapi.responses.HandlerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(CloudURL.ORG_CLOUD)
public class CloudinaryController {

    @Autowired
    @Qualifier("cloudinaryServiceImpl")
    private ICloudinaryService iCloudinaryService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadPhoto(@RequestParam("file") MultipartFile file,
                                                   @RequestParam("name") String name,
                                                   @RequestParam("description") String description,
                                                   @RequestParam("location") String location,
                                                   @RequestParam("dateTaken") String dateTaken) {
        PhotoUpload photoUpload = null;
        try {
            if(null!= file) {
                photoUpload = iCloudinaryService.upload(file, name, description, location, dateTaken);
                 return HandlerResponse.generateResponse(HttpStatus.CREATED, ValidationCode.CREATED.getCodeNumber(200), "success", photoUpload);
            }
        } catch (Exception e) {
            return HandlerResponse.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, ValidationCode.CREATE_FAILED.getCodeNumber(500),"Faild",photoUpload);
        }
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPhotoById(@PathVariable String id) {
        try {
            Photo photoData = iCloudinaryService.getPhotoById(id);
            if(photoData == null) {photoData = new Photo();}
            byte[] imageBytes = photoData.getData();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return HandlerResponse.generateResponse(HttpStatus.OK,headers,ValidationCode.FOUND.getCodeNumber(203),"Founded",imageBytes);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (DatabaseException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (CloudinaryException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity handleMaxSizeException(MaxUploadSizeExceededException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleOtherExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


}
