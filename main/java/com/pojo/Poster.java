package com.pojo;

public class Poster {
    private Integer posterId;

    private String posterPhoto;

    public Integer getPosterId() {
        return posterId;
    }

    public void setPosterId(Integer posterId) {
        this.posterId = posterId;
    }

    public String getPosterPhoto() {
        return posterPhoto;
    }

    public void setPosterPhoto(String posterPhoto) {
        this.posterPhoto = posterPhoto == null ? null : posterPhoto.trim();
    }
}