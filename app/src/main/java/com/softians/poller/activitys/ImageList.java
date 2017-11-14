package com.softians.poller.activitys;

/**
 * Created by Lenovo on 11/14/2017.
 */

public class ImageList {

    private int id;
    String name;
    public String images;

    public ImageList(String id, String name, String images) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpEndTimer() {
        return name;
    }

    public void setpEndTimer(String pEndTimer) {
        this.name = pEndTimer;
    }

    public String getpTopicName() {
        return images;
    }

    public void setpTopicName(String pTopicName) {
        this.images = pTopicName;
    }
}
