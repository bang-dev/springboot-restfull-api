package com.dev.springbootcloudinaryrestapi;

import com.cloudinary.Cloudinary;
import com.cloudinary.SingletonManager;
import com.cloudinary.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootCloudinaryRestApiApplication {
    private static final Logger logger = LoggerFactory.getLogger(SpringbootCloudinaryRestApiApplication.class);
    public static void main(String[] args) {
        connectToCloudinary();
        SpringApplication.run(SpringbootCloudinaryRestApiApplication.class, args);
    }
    static void connectToCloudinary(){
        /**
         @author: Bang Vo Anh
         @since: 03/03/2023 09:57 AM
         @description:
         https://cloudinary.com
         account by email: anhbangluckystar@gmail.com
         @update:


         **/
        final String CLOUD_NAME_VALUE= "do20urnhr";
        final String CLOUD_API_KEY="923335259698874";
        final String CLOUD_API_SECRET="VphL4JPzZYIxEXdAiT8JNyouPuM";
        CloudInfo cloudInfo = new CloudInfoBuilder()
                .buildCloudName(CLOUD_NAME_VALUE)
                .buildApiKey(CLOUD_API_KEY)
                .buildApiSecret(CLOUD_API_SECRET)
                .build();
        Cloudinary cloudinary =
                new Cloudinary(ObjectUtils
                        .asMap(
                                "cloud_name",cloudInfo.getCloudName(),
                                "api_key",cloudInfo.getApiKey(),
                                "api_secret",cloudInfo.getApiSecret()
                        ));
        SingletonManager manager = new SingletonManager();
        manager.setCloudinary(cloudinary);
        manager.init();

    }

    static class CloudInfo{
        private static String cloudName;
        private static String apiKey;
        private static String apiSecret;

        public String getCloudName() {
            return cloudName;
        }

        public void setCloudName(String cloudName) {
            CloudInfo.cloudName = cloudName;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            CloudInfo.apiKey = apiKey;
        }

        public String getApiSecret() {
            return apiSecret;
        }

        public void setApiSecret(String apiSecret) {
            CloudInfo.apiSecret = apiSecret;
        }
    }
    static class CloudInfoBuilder{
        private static CloudInfo cloudInfo;

        public CloudInfoBuilder() {
            if(cloudInfo ==null){
                cloudInfo = new CloudInfo();
            }
        }

        public CloudInfoBuilder buildCloudName(String cloudName){
            if(null != cloudInfo){
                cloudInfo.setCloudName(cloudName);
                return this;
            }
          return null;
        }

        public CloudInfoBuilder buildApiKey(String apiKey){
            if(null != cloudInfo) {
                cloudInfo.setApiKey(apiKey);
                return this;
            }
            return null;
        }

        public CloudInfoBuilder buildApiSecret(String apiSecret){
            if(null != cloudInfo) {
                cloudInfo.setApiSecret(apiSecret);
                return this;
            }
            return null;
        }
        public CloudInfo build(){
            return cloudInfo;
        }


        public static CloudInfo getCloudInfo() {
            return cloudInfo;
        }

        public static void setCloudInfo(CloudInfo cloudInfo) {
            CloudInfoBuilder.cloudInfo = cloudInfo;
        }
    }



}


