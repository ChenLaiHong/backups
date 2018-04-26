package com.pojo;

public class Banner {
    private Integer bannerId;

    private String bannerPhoto;

    private Integer bannerState;

    private Integer bannerOrder;

    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerPhoto() {
        return bannerPhoto;
    }

    public void setBannerPhoto(String bannerPhoto) {
        this.bannerPhoto = bannerPhoto == null ? null : bannerPhoto.trim();
    }

    public Integer getBannerState() {
        return bannerState;
    }

    public void setBannerState(Integer bannerState) {
        this.bannerState = bannerState;
    }

    public Integer getBannerOrder() {
        return bannerOrder;
    }

    public void setBannerOrder(Integer bannerOrder) {
        this.bannerOrder = bannerOrder;
    }
}