package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.FreshItemsRecycler;

public class FreshItemsModell {

    private String freshitemsNames2;
    private String freshitemsPrices2;
    private Integer freshitemsImages2;
    private Integer freshitemsVNV2;
    private int like_status2;
    private int add_status2;

    public String getFreshitemsNames2() {
        return freshitemsNames2;
    }

    public void setFreshitemsNames2(String freshitemsNames2) {
        this.freshitemsNames2 = freshitemsNames2;
    }

    public String getFreshitemsPrices2() {
        return freshitemsPrices2;
    }

    public void setFreshitemsPrices2(String freshitemsPrices2) {
        this.freshitemsPrices2 = freshitemsPrices2;
    }

    public Integer getFreshitemsImages2() {
        return freshitemsImages2;
    }

    public void setFreshitemsImages2(Integer freshitemsImages2) {
        this.freshitemsImages2 = freshitemsImages2;
    }

    public Integer getFreshitemsVNV2() {
        return freshitemsVNV2;
    }

    public void setFreshitemsVNV2(Integer freshitemsVNV2) {
        this.freshitemsVNV2 = freshitemsVNV2;
    }

    public int getLike_status2() {
        return like_status2;
    }

    public void setLike_status2(int like_status2) {
        this.like_status2 = like_status2;
    }

    public int getAdd_status2() {
        return add_status2;
    }

    public void setAdd_status2(int add_status2) {
        this.add_status2 = add_status2;
    }

    public FreshItemsModell(String freshitemsNames2, String freshitemsPrices2, Integer freshitemsImages2, Integer freshitemsVNV2, int like_status2, int add_status2) {
        this.freshitemsNames2 = freshitemsNames2;
        this.freshitemsPrices2 = freshitemsPrices2;
        this.freshitemsImages2 = freshitemsImages2;
        this.freshitemsVNV2 = freshitemsVNV2;
        this.like_status2 = like_status2;
        this.add_status2 = add_status2;
    }
}
