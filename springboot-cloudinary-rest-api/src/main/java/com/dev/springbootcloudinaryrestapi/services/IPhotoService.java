package com.dev.springbootcloudinaryrestapi.services;

import com.dev.springbootcloudinaryrestapi.entities.Photo;
import com.dev.springbootcloudinaryrestapi.models.PhotoUpload;

public interface IPhotoService {
    Photo save(PhotoUpload photoUpload);
}
