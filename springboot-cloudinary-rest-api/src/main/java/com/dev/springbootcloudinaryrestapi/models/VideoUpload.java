package com.dev.springbootcloudinaryrestapi.models;

import com.dev.springbootcloudinaryrestapi.entities.Video;
import com.dev.springbootmongorestapi.entities.DataItem;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@Document(collection = "videos_upload")
@Getter @Setter
public class VideoUpload extends DataItem implements Serializable {
    @Override
    public void setId(String id) {
        id = id + ".mp4";
        super.setId(id);
    }

    private String title;
    private String name;
    private String description;
    private String location;
    private String dateTaken;
    private MultipartFile file;
    private Video video;

    public static class Builder{
        private String title;
        private String name;
        private String description;
        private String location;
        private String dateTaken;
        private MultipartFile file;
        private Video video;


        public  Builder builderTitle(String title){
            this.title = title;
            return this;
        }
        public Builder builderName(String name){
            this.name = name;
            return this;
        }

        public Builder builderDescription(String description){
            this.description = description;
            return this;
        }

        public Builder builderLocation(String location){
            this.location = location;
            return this;
        }

        public Builder builderDateTaken(String dateTaken){
            this.dateTaken = dateTaken;
            return this;
        }

        public Builder builderFile(MultipartFile file){
            this.file = file;
            return this;
        }

        public Builder builderVideo(Video source){
            this.video = source;
            return this;
        }

        public VideoUpload build(){
            return new VideoUpload(this);
        }

    }

    public VideoUpload(Builder builder) {
        this.title = builder.title;
        this.name = builder.name;
        this.description = builder.description;
        this.location = builder.location;
        this.dateTaken = builder.dateTaken;
        this.file = builder.file;
        this.video =builder.video;
    }

    public VideoUpload() {
    }
}
