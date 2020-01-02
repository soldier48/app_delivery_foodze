package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SecondBeverages;

public class SecondBeveragesReviewModel {

    private String beveragesreviewNames;
    private String beveragesreviewRating;
    private String beveragesreviewText;
    private Integer beveragesreviewImages;

    public String getBeveragesreviewNames() {
        return beveragesreviewNames;
    }

    public void setBeveragesreviewNames(String beveragesreviewNames) {
        this.beveragesreviewNames = beveragesreviewNames;
    }

    public String getBeveragesreviewRating() {
        return beveragesreviewRating;
    }

    public void setBeveragesreviewRating(String beveragesreviewRating) {
        this.beveragesreviewRating = beveragesreviewRating;
    }

    public String getBeveragesreviewText() {
        return beveragesreviewText;
    }

    public void setBeveragesreviewText(String beveragesreviewText) {
        this.beveragesreviewText = beveragesreviewText;
    }

    public Integer getBeveragesreviewImages() {
        return beveragesreviewImages;
    }

    public void setBeveragesreviewImages(Integer beveragesreviewImages) {
        this.beveragesreviewImages = beveragesreviewImages;
    }

    public SecondBeveragesReviewModel(String beveragesreviewNames, String beveragesreviewRating, String beveragesreviewText, Integer beveragesreviewImages) {
        this.beveragesreviewNames = beveragesreviewNames;
        this.beveragesreviewRating = beveragesreviewRating;
        this.beveragesreviewText = beveragesreviewText;
        this.beveragesreviewImages = beveragesreviewImages;
    }
}
