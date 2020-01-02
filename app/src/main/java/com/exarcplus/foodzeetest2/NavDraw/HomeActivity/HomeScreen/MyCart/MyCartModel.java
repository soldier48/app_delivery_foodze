package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.MyCart;

public class MyCartModel {

    private String mycartNames;
    private String mycartPrices;
    private String mycartVNVText;
    private Integer itemquantity;
    private Integer mycartImages;
    private Integer mycartVNV;
    private int item_remove;
    private int item_increment;
    private int item_decrement;

    public String getMycartNames() {
        return mycartNames;
    }

    public void setMycartNames(String mycartNames) {
        this.mycartNames = mycartNames;
    }

    public String getMycartPrices() {
        return mycartPrices;
    }

    public void setMycartPrices(String mycartPrices) {
        this.mycartPrices = mycartPrices;
    }

    public String getMycartVNVText() {
        return mycartVNVText;
    }

    public void setMycartVNVText(String mycartVNVText) {
        this.mycartVNVText = mycartVNVText;
    }

    public Integer getItemquantity() {
        return itemquantity;
    }

    public void setItemquantity(Integer itemquantity) {
        this.itemquantity = itemquantity;
    }

    public Integer getMycartImages() {
        return mycartImages;
    }

    public void setMycartImages(Integer mycartImages) {
        this.mycartImages = mycartImages;
    }

    public Integer getMycartVNV() {
        return mycartVNV;
    }

    public void setMycartVNV(Integer mycartVNV) {
        this.mycartVNV = mycartVNV;
    }

    public int getItem_remove() {
        return item_remove;
    }

    public void setItem_remove(int item_remove) {
        this.item_remove = item_remove;
    }

    public int getItem_increment() {
        return item_increment;
    }

    public void setItem_increment(int item_increment) {
        this.item_increment = item_increment;
    }

    public int getItem_decrement() {
        return item_decrement;
    }

    public void setItem_decrement(int item_decrement) {
        this.item_decrement = item_decrement;
    }

    public MyCartModel(String mycartNames, String mycartPrices, String mycartVNVText, Integer itemquantity, Integer mycartImages, Integer mycartVNV, int item_remove, int item_increment, int item_decrement) {
        this.mycartNames = mycartNames;
        this.mycartPrices = mycartPrices;
        this.mycartVNVText = mycartVNVText;
        this.itemquantity = itemquantity;
        this.mycartImages = mycartImages;
        this.mycartVNV = mycartVNV;
        this.item_remove = item_remove;
        this.item_increment = item_increment;
        this.item_decrement = item_decrement;
    }
}
