package com.dev.springbootcloudinaryrestapi.services.impls;

import com.dev.springbootcloudinaryrestapi.entities.Photo;
import com.dev.springbootcloudinaryrestapi.models.PhotoUpload;
import com.dev.springbootcloudinaryrestapi.services.ICloudinaryService;
import com.dev.springbootcloudinaryrestapi.services.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements IPhotoService {

    @Autowired
    private ICloudinaryService iCloudinaryService;

    @Override
    public Photo save(PhotoUpload photoUpload) {
        return null;
    }
}
