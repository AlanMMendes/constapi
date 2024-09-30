package com.example.constapi.crawler;

public class CrawlerObject {
    private String title;
    private String url;

    public CrawlerObject(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }


}