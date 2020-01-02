package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.FreshItemsRecycler;

public class FreshItemsModel {

    private String freshitemsNames;
    private String freshitemsPrices;
    private Integer freshitemsImages;
    private Integer freshitemsVNV;
    private int like_status;
    private int add_status;

    public String getFreshitemsNames() {
        return freshitemsNames;
    }

    public void setFreshitemsNames(String freshitemsNames) {
        this.freshitemsNames = freshitemsNames;
    }

    public String getFreshitemsPrices() {
        return freshitemsPrices;
    }

    public void setFreshitemsPrices(String freshitemsPrices) {
        this.freshitemsPrices = freshitemsPrices;
    }

    public Integer getFreshitemsImages() {
        return freshitemsImages;
    }

    public void setFreshitemsImages(Integer freshitemsImages) {
        this.freshitemsImages = freshitemsImages;
    }

    public Integer getFreshitemsVNV() {
        return freshitemsVNV;
    }

    public void setFreshitemsVNV(Integer freshitemsVNV) {
        this.freshitemsVNV = freshitemsVNV;
    }

    public int getLike_status() {
        return like_status;
    }

    public void setLike_status(int like_status) {
        this.like_status = like_status;
    }

    public int getAdd_status() {
        return add_status;
    }

    public void setAdd_status(int add_status) {
        this.add_status = add_status;
    }

    public FreshItemsModel(String freshitemsNames, String freshitemsPrices, Integer freshitemsImages, Integer freshitemsVNV, int like_status, int add_status) {
        this.freshitemsNames = freshitemsNames;
        this.freshitemsPrices = freshitemsPrices;
        this.freshitemsImages = freshitemsImages;
        this.freshitemsVNV = freshitemsVNV;
        this.like_status = like_status;
        this.add_status = add_status;
    }
}
