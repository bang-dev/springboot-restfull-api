package com.dev.springbootcloudinaryrestapi.services;

import com.dev.springbootcloudinaryrestapi.entities.Photo;
import com.dev.springbootcloudinaryrestapi.models.PhotoUpload;
import org.springframework.web.multipart.MultipartFile;

public interface ICloudinaryService {
    PhotoUpload upload(MultipartFile file,String name, String description, String location, String dateTaken);
}
