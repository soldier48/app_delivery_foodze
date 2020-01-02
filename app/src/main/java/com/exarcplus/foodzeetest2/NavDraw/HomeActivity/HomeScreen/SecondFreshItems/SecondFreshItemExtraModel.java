package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SecondFreshItems;

public class SecondFreshItemExtraModel {

    private String freshitemviewNames;
    private Integer freshitemviewImages;
    private Integer freshitemviewVNV;

    public String getFreshitemviewNames() {
        return freshitemviewNames;
    }

    public void setFreshitemviewNames(String freshitemviewNames) {
        this.freshitemviewNames = freshitemviewNames;
    }

    public Integer getFreshitemviewImages() {
        return freshitemviewImages;
    }

    public void setFreshitemviewImages(Integer freshitemviewImages) {
        this.freshitemviewImages = freshitemviewImages;
    }

    public Integer getFreshitemviewVNV() {
        return freshitemviewVNV;
    }

    public void setFreshitemviewVNV(Integer freshitemviewVNV) {
        this.freshitemviewVNV = freshitemviewVNV;
    }

    public SecondFreshItemExtraModel(String freshitemviewNames, Integer freshitemviewImages, Integer freshitemviewVNV) {
        this.freshitemviewNames = freshitemviewNames;
        this.freshitemviewImages = freshitemviewImages;
        this.freshitemviewVNV = freshitemviewVNV;
    }
}
