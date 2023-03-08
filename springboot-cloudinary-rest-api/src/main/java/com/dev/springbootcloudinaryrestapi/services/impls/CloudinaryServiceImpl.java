package com.dev.springbootcloudinaryrestapi.services.impls;

import com.cloudinary.Cloudinary;
import com.cloudinary.Singleton;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.dev.springbootcloudinaryrestapi.entities.Photo;
import com.dev.springbootcloudinaryrestapi.exceptions.DatabaseException;
import com.dev.springbootcloudinaryrestapi.exceptions.InvalidRequestException;
import com.dev.springbootcloudinaryrestapi.exceptions.NotFoundException;
import com.dev.springbootcloudinaryrestapi.models.PhotoUpload;
import com.dev.springbootcloudinaryrestapi.services.ICloudinaryService;
import com.dev.springbootcloudinaryrestapi.services.IPhotoService;
import com.mongodb.MongoException;
import com.mongodb.client.gridfs.model.GridFSFile;

import org.apache.commons.io.IOUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class CloudinaryServiceImpl implements ICloudinaryService {

    @Autowired
    private MongoTemplate mongoTemplate;
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Cloudinary cloudinary = Singleton.getCloudinary();


    private File convertMultiPartFileToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convertedFile);
        fos.write(file.getBytes());
        fos.close();
        return convertedFile;
    }

    @Override
    public PhotoUpload upload(MultipartFile file, String name, String description, String location, String dateTaken) {
        try {
            File uploadFile = convertMultiPartFileToFile(file);
            try {

                Map uploadResult = cloudinary.uploader().upload(uploadFile, ObjectUtils.emptyMap());
                byte[] data = file.getBytes();
                Map<String, String> options = new HashMap<>();
                options.put("resource_type", "auto");
                options.put("public_id", file.getOriginalFilename().split("\\.")[0]);
                Photo photo = new Photo.Builder()
                        .builderName(file.getOriginalFilename())
                        .builderDescription("")
                        .builderPublicId((String) uploadResult.get("public_id"))
                        .builderUrl((String) uploadResult.get("url"))
                        .builderFormat((String) uploadResult.get("format"))
                        .builderSize(Long.valueOf(String.valueOf(uploadResult.get("bytes"))))
                        .builderData(data).build();
                this.mongoTemplate.insert(photo);
                PhotoUpload photoUpload = new PhotoUpload.Builder()
                        .buildName(name)
                        .buildDescription(description)
                        .buildLocation(location)
                        .buildDateTaken(dateTaken)
                        .buildPhoto(photo).build();
                PhotoUpload result = this.mongoTemplate.insert(photoUpload);
                return result;
            } catch (IOException exc) {
                exc.printStackTrace();
            }/*finally {
            uploadFile.delete();
        }*/
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return null;
    }

    @Override
    public Photo getPhotoById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Photo photo = this.mongoTemplate.findOne(query, Photo.class);
        String url = "";
        if (null == photo){
            photo = new Photo();
        }
        url = photo.getUrl();
        try ( InputStream inputStream = new URL(url).openStream()) {
            byte[] imageBytes = IOUtils.toByteArray(inputStream);
            Photo image = new Photo(id,imageBytes);
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e) {
            throw new InvalidRequestException("Invalid id format: " + id);
        } catch (MongoException e) {
            throw new DatabaseException("Error fetching image with id: " + id, e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
