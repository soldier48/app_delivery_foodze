package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.BeveragesRecycler;

public class BeveragesModel {

    private String beveragesNames;
    private String beveragesPrices;
    private Integer beveragesImages;
    private Integer beveragesVNV;
    private int like_status;
    private int add_status;

    public String getBeveragesNames() {
        return beveragesNames;
    }

    public void setBeveragesNames(String beveragesNames) {
        this.beveragesNames = beveragesNames;
    }

    public String getBeveragesPrices() {
        return beveragesPrices;
    }

    public void setBeveragesPrices(String beveragesPrices) {
        this.beveragesPrices = beveragesPrices;
    }

    public Integer getBeveragesImages() {
        return beveragesImages;
    }

    public void setBeveragesImages(Integer beveragesImages) {
        this.beveragesImages = beveragesImages;
    }

    public Integer getBeveragesVNV() {
        return beveragesVNV;
    }

    public void setBeveragesVNV(Integer beveragesVNV) {
        this.beveragesVNV = beveragesVNV;
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

    public BeveragesModel(String beveragesNames, String beveragesPrices, Integer beveragesImages, Integer beveragesVNV, int like_status, int add_status) {
        this.beveragesNames = beveragesNames;
        this.beveragesPrices = beveragesPrices;
        this.beveragesImages = beveragesImages;
        this.beveragesVNV = beveragesVNV;
        this.like_status = like_status;
        this.add_status = add_status;
    }
}
