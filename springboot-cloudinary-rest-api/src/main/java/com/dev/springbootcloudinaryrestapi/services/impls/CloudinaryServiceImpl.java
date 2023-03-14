package com.dev.springbootcloudinaryrestapi.services.impls;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.dev.springbootcloudinaryrestapi.entities.Photo;
import com.dev.springbootcloudinaryrestapi.entities.Video;
import com.dev.springbootcloudinaryrestapi.exceptions.DatabaseException;
import com.dev.springbootcloudinaryrestapi.exceptions.InvalidRequestException;
import com.dev.springbootcloudinaryrestapi.models.PhotoUpload;
import com.dev.springbootcloudinaryrestapi.models.VideoUpload;
import com.dev.springbootcloudinaryrestapi.services.ICloudinaryService;
import com.dev.springbootmongorestapi.utils.AlphabetUtils;
import com.dev.springbootmongorestapi.utils.DateTimeUtils;
import com.mongodb.MongoException;

import org.apache.commons.io.IOUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.*;

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
                if (uploadResult != null) {
                    byte[] data = file.getBytes();
                    Map<String, String> options = new HashMap<>();
                    options.put("resource_type", "auto");
                    options.put("public_id", file.getOriginalFilename().split("\\.")[0]);
                    options.put("access_mode", "private");
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
                }
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
        if (null == photo) {
            photo = new Photo();
        }
        url = photo.getUrl();
        try (InputStream inputStream = new URL(url).openStream()) {
            byte[] imageBytes = IOUtils.toByteArray(inputStream);
            Photo image = new Photo(id, imageBytes);
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


    @Override
    public VideoUpload upload(MultipartFile file, String name, String title, String description, String location, String dateTaken) {
        try {
            File uploadFile = convertMultiPartFileToFile(file);
            try {
                Map<?, ?> uploadResult = cloudinary.uploader().upload(uploadFile,
                        ObjectUtils.asMap(
                                "resource_type", "video",
                                "access_type", "private",
                                "public_id", file.getOriginalFilename().split("\\.")[0],
                                "eager", Arrays.asList(
                                        new EagerTransformation().width(300).height(300).crop("pad").audioCodec("none"),
                                        new EagerTransformation().width(160).height(100).crop("crop").gravity("south").audioCodec("none")),
                                "eager_async", true,
                                "eager_notification_url", null

                        )
                );
                VideoUpload result = null;
                Video videoResource = null;
                if (null != uploadResult) {
                    Map<String, String> options = new HashMap<>();
                    options.put("resource_type", "video");
                    options.put("chunk_size", "6000000");
                    options.put("public_id", file.getOriginalFilename().split("\\.")[0]);
                    options.put("access_type", "private");
                    byte[] data = file.getBytes();

                    Video video = new Video.Builder()
                            .builderName(file.getOriginalFilename())
                            .builderTitle((AlphabetUtils.generateNewAlphabetRandom() + "_" + DateTimeUtils.convertFromDateToString(new Date())))
                            .builderDescription("")
                            .builderPublicId((String) uploadResult.get("public_id"))
                            .builderUrl((String) uploadResult.get("secure_url"))
                            .builderResource(options.put("resource_type", "video"))
                            .builderFormat((String) uploadResult.get("format"))
                            .builderChunkSize(options.put("chunk_size", "6000000"))
                            .builderSize(Long.parseLong(String.valueOf(uploadResult.get("bytes"))))
                            .builderData(data)
                            .builderIsPrivate(false)
                            .build();
                    videoResource = this.mongoTemplate.insert(video);
                    if (!file.isEmpty()) {
                        VideoUpload videoUpload = new VideoUpload.Builder()
                               // .builderFile(file)
                                .builderTitle("")
                                .builderName(name)
                                .builderDescription(description)
                                .builderLocation(location)
                                .builderDateTaken(dateTaken)
                                .builderVideo(videoResource).build();
                        result = this.mongoTemplate.insert(videoUpload);
                        return result;
                    }
                }
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
    public Video getVideoById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Video video = this.mongoTemplate.findOne(query, Video.class);
        String url = "";
        if (null == video) {
            video = new Video();
        }
        url = video.getUrl();
        try (InputStream inputStream = new URL(url).openStream()) {
            byte[] videoBytes = IOUtils.toByteArray(inputStream);
            Video videoSource = new Video(id, videoBytes);

            String videoUrl = cloudinary.url().resourceType("video").format("mp4").generate(videoSource.getPublicId());
            Video rs = new Video(id, videoUrl);
            return rs;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e) {
            throw new InvalidRequestException("Invalid id format: " + id);
        } catch (MongoException e) {
            throw new DatabaseException("Error fetching video with id: " + id, e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
