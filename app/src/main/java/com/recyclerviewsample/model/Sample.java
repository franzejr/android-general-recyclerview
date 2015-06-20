package com.recyclerviewsample.model;

/**
 * Created by franzejr on 16/06/15.
 */
public class Sample {

    private String title;
    private String content;

    public Sample(String title, String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
