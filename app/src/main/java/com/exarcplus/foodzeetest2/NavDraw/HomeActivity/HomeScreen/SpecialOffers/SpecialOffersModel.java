package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SpecialOffers;

public class SpecialOffersModel {

    private String specialofferNames;
    private Integer specialofferImages;
    private int like_status;

    public String getSpecialofferNames() {
        return specialofferNames;
    }

    public void setSpecialofferNames(String specialofferNames) {
        this.specialofferNames = specialofferNames;
    }

    public Integer getSpecialofferImages() {
        return specialofferImages;
    }

    public void setSpecialofferImages(Integer specialofferImages) {
        this.specialofferImages = specialofferImages;
    }

    public int getLike_status() {
        return like_status;
    }

    public void setLike_status(int like_status) {
        this.like_status = like_status;
    }

    public SpecialOffersModel(String specialofferNames, Integer specialofferImages, int like_status) {
        this.specialofferNames = specialofferNames;
        this.specialofferImages = specialofferImages;
        this.like_status = like_status;
    }
}
