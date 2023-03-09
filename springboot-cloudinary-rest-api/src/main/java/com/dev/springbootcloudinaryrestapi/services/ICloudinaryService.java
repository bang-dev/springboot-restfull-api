package com.dev.springbootcloudinaryrestapi.services;

import com.dev.springbootcloudinaryrestapi.entities.Photo;
import com.dev.springbootcloudinaryrestapi.entities.Video;
import com.dev.springbootcloudinaryrestapi.models.PhotoUpload;
import com.dev.springbootcloudinaryrestapi.models.VideoUpload;
import org.springframework.web.multipart.MultipartFile;

public interface ICloudinaryService {
    PhotoUpload upload(MultipartFile file,String name, String description, String location, String dateTaken);
    Photo getPhotoById(String id);

    VideoUpload upload(MultipartFile file,String name, String title, String description, String location, String dateTaken);
    Video getVideoById(String id);
}
