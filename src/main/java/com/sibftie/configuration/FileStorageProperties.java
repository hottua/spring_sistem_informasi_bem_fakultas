package com.sibftie.configuration;


import org.springframework.context.annotation.Configuration;

@Configuration("imageStorage")
public class FileStorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "src\\main\\resources\\static\\file";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
