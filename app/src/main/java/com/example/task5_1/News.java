package com.example.task5_1;


import java.io.Serializable;
import java.util.List;

public class News implements Serializable {
    private String title;
    private String description;
    private String imageUrl;
    private List<News> relatedNews;

    public News(String title, String description, String imageUrl, List<News> relatedNews) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.relatedNews = relatedNews;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<News> getRelatedNews() {
        return relatedNews;
    }

    public void setRelatedNews(List<News> relatedNews) {
        this.relatedNews = relatedNews;
    }
}
