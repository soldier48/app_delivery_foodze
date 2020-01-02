package com.exarcplus.foodzeetest2.NavDraw.MyOrdersActivity;

public class MyOrdersCurrentModel {

    private String myordercurrentNames;
    private String myordercurrentPrices;
    private String myordercurrentItem;
    private Integer myordercurrentImages;
    private Integer myordercurrentVNV;

    public String getMyordercurrentNames() {
        return myordercurrentNames;
    }

    public void setMyordercurrentNames(String myordercurrentNames) {
        this.myordercurrentNames = myordercurrentNames;
    }

    public String getMyordercurrentPrices() {
        return myordercurrentPrices;
    }

    public void setMyordercurrentPrices(String myordercurrentPrices) {
        this.myordercurrentPrices = myordercurrentPrices;
    }

    public String getMyordercurrentItem() {
        return myordercurrentItem;
    }

    public void setMyordercurrentItem(String myordercurrentItem) {
        this.myordercurrentItem = myordercurrentItem;
    }

    public Integer getMyordercurrentImages() {
        return myordercurrentImages;
    }

    public void setMyordercurrentImages(Integer myordercurrentImages) {
        this.myordercurrentImages = myordercurrentImages;
    }

    public Integer getMyordercurrentVNV() {
        return myordercurrentVNV;
    }

    public void setMyordercurrentVNV(Integer myordercurrentVNV) {
        this.myordercurrentVNV = myordercurrentVNV;
    }

    public MyOrdersCurrentModel(String myordercurrentNames, String myordercurrentPrices, String myordercurrentItem, Integer myordercurrentImages, Integer myordercurrentVNV) {
        this.myordercurrentNames = myordercurrentNames;
        this.myordercurrentPrices = myordercurrentPrices;
        this.myordercurrentItem = myordercurrentItem;
        this.myordercurrentImages = myordercurrentImages;
        this.myordercurrentVNV = myordercurrentVNV;
    }
}
