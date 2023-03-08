package com.dev.springbootcloudinaryrestapi.entities;

import com.dev.springbootmongorestapi.entities.DataItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.InputStream;
import java.io.Serializable;

@Data
@Getter @Setter
@Document(collection = "photos")
@AllArgsConstructor
public class Photo extends DataItem implements Serializable {

    private String name;
    private String url;
    private long size;
    @Field(name = "data")
    private byte[] data;
    private String description;
    private String publicId;
    private String format;

    public Photo() {

    }
    public Photo(String id, byte[] data) {
        super();
        this.data = data;
    }



    public static class Builder{

        private String name;
        private String url;
        private long size;
        private byte[] data;
        private String description;
        private String publicId;
        private String format;

        public Builder builderName(String name){
            this.name = name;
            return this;
        }

        public Builder builderUrl(String url){
            this.url = url;
            return this;
        }

        public Builder builderSize(long size){
            this.size = size;
            return this;
        }
        public Builder builderData(byte[]data){
            this.data = data;
         /*   byte[] longBytes = new byte[data.length / 2 * 8]; // each group of 8 bytes represents a long
            for (int i = 0, j = 0; i < data.length; i += 4, j += 8) {
                long value = ((long) data[i] << 24) | ((long) data[i + 1] << 16) | ((long) data[i + 2] << 8) | (data[i + 3] & 0xffL);
                longBytes[j] = (byte) (value >> 56);
                longBytes[j + 1] = (byte) (value >> 48);
                longBytes[j + 2] = (byte) (value >> 40);
                longBytes[j + 3] = (byte) (value >> 32);
                longBytes[j + 4] = (byte) (value >> 24);
                longBytes[j + 5] = (byte) (value >> 16);
                longBytes[j + 6] = (byte) (value >> 8);
                longBytes[j + 7] = (byte) value;
            }*/
            return this;
        }

        public Builder builderDescription(String description){
            this.description = description;
            return this;
        }

        public Builder builderPublicId(String publicId){
            this.publicId = publicId;
            return this;
        }

        public Builder builderFormat(String format){
            this.format = format;
            return this;
        }


        public Photo build(){
           return new Photo(this);
        }
    }

    public Photo(Builder builder) {
        this.name = builder.name;
        this.url = builder.url;
        this.size = builder.size;
        this.data = builder.data;
        this.description = builder.description;
        this.publicId = builder.publicId;
        this.format = builder.format;
    }
}
