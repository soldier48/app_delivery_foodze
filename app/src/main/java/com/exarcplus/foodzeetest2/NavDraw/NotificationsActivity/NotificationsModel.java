package com.exarcplus.foodzeetest2.NavDraw.NotificationsActivity;

public class NotificationsModel {

    private String notificationsNames;
    private String notificationsContent;
    private Integer notificationsImages;

    public String getNotificationsNames() {
        return notificationsNames;
    }

    public void setNotificationsNames(String notificationsNames) {
        this.notificationsNames = notificationsNames;
    }

    public String getNotificationsContent() {
        return notificationsContent;
    }

    public void setNotificationsContent(String notificationsContent) {
        this.notificationsContent = notificationsContent;
    }

    public Integer getNotificationsImages() {
        return notificationsImages;
    }

    public void setNotificationsImages(Integer notificationsImages) {
        this.notificationsImages = notificationsImages;
    }

    public NotificationsModel(String notificationsNames, String notificationsContent, Integer notificationsImages) {
        this.notificationsNames = notificationsNames;
        this.notificationsContent = notificationsContent;
        this.notificationsImages = notificationsImages;
    }
}
