package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.MyCart.Checkout;

public class CheckoutStep2Model {

    private String checkoutstep2Names;
    private String checkoutstep2CardNumber;
    private String checkoutstep2ExpiryDate;
    private Integer checkoutstep2Select;
    private int card_remove;

    public String getCheckoutstep2Names() {
        return checkoutstep2Names;
    }

    public void setCheckoutstep2Names(String checkoutstep2Names) {
        this.checkoutstep2Names = checkoutstep2Names;
    }

    public String getCheckoutstep2CardNumber() {
        return checkoutstep2CardNumber;
    }

    public void setCheckoutstep2CardNumber(String checkoutstep2CardNumber) {
        this.checkoutstep2CardNumber = checkoutstep2CardNumber;
    }

    public String getCheckoutstep2ExpiryDate() {
        return checkoutstep2ExpiryDate;
    }

    public void setCheckoutstep2ExpiryDate(String checkoutstep2ExpiryDate) {
        this.checkoutstep2ExpiryDate = checkoutstep2ExpiryDate;
    }

    public Integer getCheckoutstep2Select() {
        return checkoutstep2Select;
    }

    public void setCheckoutstep2Select(Integer checkoutstep2Select) {
        this.checkoutstep2Select = checkoutstep2Select;
    }

    public int getCard_remove() {
        return card_remove;
    }

    public void setCard_remove(int card_remove) {
        this.card_remove = card_remove;
    }

    public CheckoutStep2Model(String checkoutstep2Names, String checkoutstep2CardNumber, String checkoutstep2ExpiryDate, Integer checkoutstep2Select, int card_remove) {
        this.checkoutstep2Names = checkoutstep2Names;
        this.checkoutstep2CardNumber = checkoutstep2CardNumber;
        this.checkoutstep2ExpiryDate = checkoutstep2ExpiryDate;
        this.checkoutstep2Select = checkoutstep2Select;
        this.card_remove = card_remove;
    }
}
