package com.example.isaac.m8uf2provafinal;

public class ImageUploadInfo {
    public String imageName;
    public String imageURL;
    public String imageLocation;
    public boolean status;

    public ImageUploadInfo() {
    }

    public ImageUploadInfo(String imageName, String imageURL, String imageLocation, boolean status) {
        this.imageName = imageName;
        this.imageURL = imageURL;
        this.status = status;
        this.imageLocation = imageLocation;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
