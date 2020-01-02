package com.exarcplus.foodzeetest2.NavDraw.MyOrdersActivity;

import java.util.ArrayList;

public class MyOrdersPastModel {

    ArrayList<MyOrdersPastItem> myOrdersPastItems = new ArrayList<>();
    private String pastorderID;
    private String pastorderTime;
    private String pastdeliveryTime;

    public static class MyOrdersPastItem {

        private String myorderpastNames;
        private String myorderpastPrices;
        private String myorderpastItem;
        private Integer myorderpastImages;
        private Integer myorderpastVNV;

        public String getMyorderpastNames() {
            return myorderpastNames;
        }

        public void setMyorderpastNames(String myorderpastNames) {
            this.myorderpastNames = myorderpastNames;
        }

        public String getMyorderpastPrices() {
            return myorderpastPrices;
        }

        public void setMyorderpastPrices(String myorderpastPrices) {
            this.myorderpastPrices = myorderpastPrices;
        }

        public String getMyorderpastItem() {
            return myorderpastItem;
        }

        public void setMyorderpastItem(String myorderpastItem) {
            this.myorderpastItem = myorderpastItem;
        }

        public Integer getMyorderpastImages() {
            return myorderpastImages;
        }

        public void setMyorderpastImages(Integer myorderpastImages) {
            this.myorderpastImages = myorderpastImages;
        }

        public Integer getMyorderpastVNV() {
            return myorderpastVNV;
        }

        public void setMyorderpastVNV(Integer myorderpastVNV) {
            this.myorderpastVNV = myorderpastVNV;
        }

        public MyOrdersPastItem(String myorderpastNames, String myorderpastPrices, String myorderpastItem, Integer myorderpastImages, Integer myorderpastVNV) {
            this.myorderpastNames = myorderpastNames;
            this.myorderpastPrices = myorderpastPrices;
            this.myorderpastItem = myorderpastItem;
            this.myorderpastImages = myorderpastImages;
            this.myorderpastVNV = myorderpastVNV;
        }
    }

    public ArrayList<MyOrdersPastItem> getMyOrdersPastItems() {
        return myOrdersPastItems;
    }

    public void setMyOrdersPastItems(ArrayList<MyOrdersPastItem> myOrdersPastItems) {
        this.myOrdersPastItems = myOrdersPastItems;
    }

    public String getPastorderID() {
        return pastorderID;
    }

    public void setPastorderID(String pastorderID) {
        this.pastorderID = pastorderID;
    }

    public String getPastorderTime() {
        return pastorderTime;
    }

    public void setPastorderTime(String pastorderTime) {
        this.pastorderTime = pastorderTime;
    }

    public String getPastdeliveryTime() {
        return pastdeliveryTime;
    }

    public void setPastdeliveryTime(String pastdeliveryTime) {
        this.pastdeliveryTime = pastdeliveryTime;
    }

    public MyOrdersPastModel(ArrayList<MyOrdersPastItem> myOrdersPastItems, String pastorderID, String pastorderTime, String pastdeliveryTime) {
        this.myOrdersPastItems = myOrdersPastItems;
        this.pastorderID = pastorderID;
        this.pastorderTime = pastorderTime;
        this.pastdeliveryTime = pastdeliveryTime;
    }
}
