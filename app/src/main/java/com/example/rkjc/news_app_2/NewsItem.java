package com.example.rkjc.news_app_2;

public class NewsItem {
    private String title;
    private String description;
    private String time;
    private String url;

    public NewsItem(String title,String description,String time,String url){
        this.description="Description" +description;
        this.time= "time" +time;
        this.url="Url"+url;
        this.title= "Title" +title;
    }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public void setTitle(String title) { this.title = title; }

    public void setDescription(String description) { this.description = description; }

    public void setTime(String time) { this.time = time; }

    public String getTitle() { return title; }

    public String getDescription() { return description; }

    public String getTime() { return time; }


}
