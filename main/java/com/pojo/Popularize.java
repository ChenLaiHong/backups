package com.pojo;

public class Popularize {
    private Integer popularizeId;

    private String popularizePhoto;

    public Integer getPopularizeId() {
        return popularizeId;
    }

    public void setPopularizeId(Integer popularizeId) {
        this.popularizeId = popularizeId;
    }

    public String getPopularizePhoto() {
        return popularizePhoto;
    }

    public void setPopularizePhoto(String popularizePhoto) {
        this.popularizePhoto = popularizePhoto == null ? null : popularizePhoto.trim();
    }
}