package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.BeveragesRecycler;

public class BeveragesModell {

    private String beveragesNames2;
    private String beveragesPrices2;
    private Integer beveragesImages2;
    private Integer beveragesVNV2;
    private int like_status2;
    private int add_status2;

    public String getBeveragesNames2() {
        return beveragesNames2;
    }

    public void setBeveragesNames2(String beveragesNames2) {
        this.beveragesNames2 = beveragesNames2;
    }

    public String getBeveragesPrices2() {
        return beveragesPrices2;
    }

    public void setBeveragesPrices2(String beveragesPrices2) {
        this.beveragesPrices2 = beveragesPrices2;
    }

    public Integer getBeveragesImages2() {
        return beveragesImages2;
    }

    public void setBeveragesImages2(Integer beveragesImages2) {
        this.beveragesImages2 = beveragesImages2;
    }

    public Integer getBeveragesVNV2() {
        return beveragesVNV2;
    }

    public void setBeveragesVNV2(Integer beveragesVNV2) {
        this.beveragesVNV2 = beveragesVNV2;
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

    public BeveragesModell(String beveragesNames2, String beveragesPrices2, Integer beveragesImages2, Integer beveragesVNV2, int like_status2, int add_status2) {
        this.beveragesNames2 = beveragesNames2;
        this.beveragesPrices2 = beveragesPrices2;
        this.beveragesImages2 = beveragesImages2;
        this.beveragesVNV2 = beveragesVNV2;
        this.like_status2 = like_status2;
        this.add_status2 = add_status2;
    }
}
