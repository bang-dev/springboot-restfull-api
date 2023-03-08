package com.dev.springbootcloudinaryrestapi.models;

import com.dev.springbootcloudinaryrestapi.entities.Photo;
import com.dev.springbootmongorestapi.entities.DataItem;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@Setter @Getter
@Document(collection = "photos_upload")
public class PhotoUpload extends DataItem implements Serializable {
     private String name;
     private String description;
     private String location;
     private String dateTaken;
     private MultipartFile file;
     public Photo photo;

     public static class Builder{
          private String name;
          private String description;
          private String location;
          private String dateTaken;
          private MultipartFile file;
          private Photo photo;


          public Builder buildName(String name){
               this.name = name;
               return this;
          }
          public Builder buildDescription(String description){
               this.description = description;
               return this;
          }
          public Builder buildLocation(String location){
               this.location = location;
               return this;
          }
          public Builder buildDateTaken(String dateTaken){
               this.dateTaken = dateTaken;
               return this;
          }

          public Builder buildMultipartFile(MultipartFile file){
               this.file = file;
               return this;

          }
          public Builder buildPhoto(Photo photo){
               this.photo = photo;
               return this;
          }

          public PhotoUpload build(){
               return new PhotoUpload(this);
          }

     }

     public PhotoUpload(Builder builder) {
          this.name = builder.name;
          this.description = builder.description;
          this.location = builder.location;
          this.dateTaken = builder.dateTaken;
          this.file = builder.file;
          this.photo = builder.photo;
     }
}
