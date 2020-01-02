package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SecondBeverages;

public class SecondBeveragesExtraModel {

    private String beveragesviewNames;
    private Integer beveragesviewImages;
    private Integer beveragesviewVNV;

    public String getBeveragesviewNames() {
        return beveragesviewNames;
    }

    public void setBeveragesviewNames(String beveragesviewNames) {
        this.beveragesviewNames = beveragesviewNames;
    }

    public Integer getBeveragesviewImages() {
        return beveragesviewImages;
    }

    public void setBeveragesviewImages(Integer beveragesviewImages) {
        this.beveragesviewImages = beveragesviewImages;
    }

    public Integer getBeveragesviewVNV() {
        return beveragesviewVNV;
    }

    public void setBeveragesviewVNV(Integer beveragesviewVNV) {
        this.beveragesviewVNV = beveragesviewVNV;
    }

    public SecondBeveragesExtraModel(String beveragesviewNames, Integer beveragesviewImages, Integer beveragesviewVNV) {
        this.beveragesviewNames = beveragesviewNames;
        this.beveragesviewImages = beveragesviewImages;
        this.beveragesviewVNV = beveragesviewVNV;
    }
}
