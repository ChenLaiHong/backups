package com.pojo;

public class Detailed {
    private Integer detailedId;

    private String detailedName;

    private String detailedPhoto;

    private Integer secondId;

    private String detailedComment;

    public Integer getDetailedId() {
        return detailedId;
    }

    public void setDetailedId(Integer detailedId) {
        this.detailedId = detailedId;
    }

    public String getDetailedName() {
        return detailedName;
    }

    public void setDetailedName(String detailedName) {
        this.detailedName = detailedName == null ? null : detailedName.trim();
    }

    public String getDetailedPhoto() {
        return detailedPhoto;
    }

    public void setDetailedPhoto(String detailedPhoto) {
        this.detailedPhoto = detailedPhoto == null ? null : detailedPhoto.trim();
    }

    public Integer getSecondId() {
        return secondId;
    }

    public void setSecondId(Integer secondId) {
        this.secondId = secondId;
    }

    public String getDetailedComment() {
        return detailedComment;
    }

    public void setDetailedComment(String detailedComment) {
        this.detailedComment = detailedComment == null ? null : detailedComment.trim();
    }
}