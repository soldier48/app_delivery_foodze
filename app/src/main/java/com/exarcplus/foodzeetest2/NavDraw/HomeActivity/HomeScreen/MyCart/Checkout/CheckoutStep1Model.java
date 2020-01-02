package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.MyCart.Checkout;

public class CheckoutStep1Model {

    private String checkoutstep1Names;
    private String checkoutstep1Address;
    private Integer checkoutstep1Select;
    private int address_remove;
    private int address_edit;

    public String getCheckoutstep1Names() {
        return checkoutstep1Names;
    }

    public void setCheckoutstep1Names(String checkoutstep1Names) {
        this.checkoutstep1Names = checkoutstep1Names;
    }

    public String getCheckoutstep1Address() {
        return checkoutstep1Address;
    }

    public void setCheckoutstep1Address(String checkoutstep1Address) {
        this.checkoutstep1Address = checkoutstep1Address;
    }

    public Integer getCheckoutstep1Select() {
        return checkoutstep1Select;
    }

    public void setCheckoutstep1Select(Integer checkoutstep1Select) {
        this.checkoutstep1Select = checkoutstep1Select;
    }

    public int getAddress_remove() {
        return address_remove;
    }

    public void setAddress_remove(int address_remove) {
        this.address_remove = address_remove;
    }

    public int getAddress_edit() {
        return address_edit;
    }

    public void setAddress_edit(int address_edit) {
        this.address_edit = address_edit;
    }

    public CheckoutStep1Model(String checkoutstep1Names, String checkoutstep1Address, Integer checkoutstep1Select, int address_remove, int address_edit) {
        this.checkoutstep1Names = checkoutstep1Names;
        this.checkoutstep1Address = checkoutstep1Address;
        this.checkoutstep1Select = checkoutstep1Select;
        this.address_remove = address_remove;
        this.address_edit = address_edit;
    }
}
