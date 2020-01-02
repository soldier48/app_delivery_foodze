package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SecondFreshItems;

public class SecondFreshItemReviewModel {

    private String freshitemreviewNames;
    private String freshitemreviewRating;
    private String freshitemreviewText;
    private Integer freshitemreviewImages;

    public String getFreshitemreviewNames() {
        return freshitemreviewNames;
    }

    public void setFreshitemreviewNames(String freshitemreviewNames) {
        this.freshitemreviewNames = freshitemreviewNames;
    }

    public String getFreshitemreviewRating() {
        return freshitemreviewRating;
    }

    public void setFreshitemreviewRating(String freshitemreviewRating) {
        this.freshitemreviewRating = freshitemreviewRating;
    }

    public String getFreshitemreviewText() {
        return freshitemreviewText;
    }

    public void setFreshitemreviewText(String freshitemreviewText) {
        this.freshitemreviewText = freshitemreviewText;
    }

    public Integer getFreshitemreviewImages() {
        return freshitemreviewImages;
    }

    public void setFreshitemreviewImages(Integer freshitemreviewImages) {
        this.freshitemreviewImages = freshitemreviewImages;
    }

    public SecondFreshItemReviewModel(String freshitemreviewNames, String freshitemreviewRating, String freshitemreviewText, Integer freshitemreviewImages) {
        this.freshitemreviewNames = freshitemreviewNames;
        this.freshitemreviewRating = freshitemreviewRating;
        this.freshitemreviewText = freshitemreviewText;
        this.freshitemreviewImages = freshitemreviewImages;
    }
}
