package com.exarcplus.foodzeetest2.NavDraw.WishlistActivity;

public class WishlistModel {

    private String wishlistNames;
    private String wishlistPrices;
    private Integer wishlistImages;
    private Integer wishlistVNV;
    private int wishlist_remove;
    private int add_status;

    public String getWishlistNames() {
        return wishlistNames;
    }

    public void setWishlistNames(String wishlistNames) {
        this.wishlistNames = wishlistNames;
    }

    public String getWishlistPrices() {
        return wishlistPrices;
    }

    public void setWishlistPrices(String wishlistPrices) {
        this.wishlistPrices = wishlistPrices;
    }

    public Integer getWishlistImages() {
        return wishlistImages;
    }

    public void setWishlistImages(Integer wishlistImages) {
        this.wishlistImages = wishlistImages;
    }

    public Integer getWishlistVNV() {
        return wishlistVNV;
    }

    public void setWishlistVNV(Integer wishlistVNV) {
        this.wishlistVNV = wishlistVNV;
    }

    public int getWishlist_remove() {
        return wishlist_remove;
    }

    public void setWishlist_remove(int wishlist_remove) {
        this.wishlist_remove = wishlist_remove;
    }

    public int getAdd_status() {
        return add_status;
    }

    public void setAdd_status(int add_status) {
        this.add_status = add_status;
    }

    public WishlistModel(String wishlistNames, String wishlistPrices, Integer wishlistImages, Integer wishlistVNV, int wishlist_remove, int add_status) {
        this.wishlistNames = wishlistNames;
        this.wishlistPrices = wishlistPrices;
        this.wishlistImages = wishlistImages;
        this.wishlistVNV = wishlistVNV;
        this.wishlist_remove = wishlist_remove;
        this.add_status = add_status;
    }
}
