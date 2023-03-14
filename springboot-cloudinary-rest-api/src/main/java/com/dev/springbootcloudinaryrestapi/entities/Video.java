package com.dev.springbootcloudinaryrestapi.entities;

import com.dev.springbootmongorestapi.entities.DataItem;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Data
@Document(collection = "videos")
@Getter @Setter
public class Video extends  DataItem implements Serializable {
    private String name;
    private String title;
    private String description;
    private String url;
    private String format;
    private String publicId;
    private String resourceType;
    private String chunkSize;
    private long size;
    private byte[] data;
    public boolean isPrivate;
    public static class Builder {
        private String name;
        private String title;
        private String description;
        private String url;
        private String format;
        private String publicId;
        private String resourceType;
        private String chunkSize;
        private long size;
        private byte[] data;
        public boolean isPrivate;

        public Builder builderName(String name){
            this.name = name;
            return this;
        }

        public Builder builderTitle(String title){
            this.title = title;
            return this;
        }

        public Builder builderDescription(String description){
            this.description = description;
            return this;
        }

        public Builder builderUrl(String url){
            this.url = url;
            return this;
        }

        public Builder builderFormat( String format){
            this.format = format;
            return this;
        }

        public Builder builderPublicId(String publicId){
            this.publicId = publicId;
            return this;
        }

        public Builder builderResource(String resourceType){
            this.resourceType = resourceType;
            return this;
        }

        public Builder builderChunkSize(String chunkSize){
            this.chunkSize = chunkSize;
            return this;
        }

        public Builder builderSize(long size){
            this.size = size;
            return this;
        }

        public Builder builderData(byte[]data){
            this.data = data;
            return this;
        }

        public Builder builderIsPrivate(boolean isPrivate){
            this.isPrivate = isPrivate;
            return this;
        }

        public Video build(){

            return new Video(this);
        }

    }

    public Video() {
    }

    public Video(String id, byte[] data) {
        super();
        this.data = data;
    }

    public Video(String id, String url) {
        super();
        this.url = url;
    }

    public Video(Builder builder) {
        this.name = builder.name;
        this.title = builder.title;
        this.description = builder.description;
        this.url = builder.url;
        this.publicId = builder.publicId;
        this.resourceType = builder.resourceType;
        this.chunkSize = builder.chunkSize;
        this.size = builder.size;
        this.data = builder.data;
        this.isPrivate = builder.isPrivate;
    }
}
