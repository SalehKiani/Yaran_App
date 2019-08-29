package com.example.yaran;

public class News {
    private String author;
    private String description;
    private String enclosureLength;
    private String enclosureType;
    private String enclosureUrl;
    private String link;
    private String pubDate;
    private String title;



    public News(String author, String description, String enclosureLength, String enclosureType, String enclosureUrl, String link, String pubDate, String title) {
        this.author = author;
        this.description = description;
        this.enclosureLength = enclosureLength;
        this.enclosureType = enclosureType;
        this.enclosureUrl = enclosureUrl;
        this.link = link;
        this.pubDate = pubDate;
        this.title = title;



    }



    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getEnclosureLength() {
        return enclosureLength;
    }

    public String getEnclosureType() {
        return enclosureType;
    }

    public String getEnclosureUrl() {
        return enclosureUrl;
    }

    public String getLink() {
        return link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEnclosureLength(String enclosureLength) {
        this.enclosureLength = enclosureLength;
    }

    public void setEnclosureType(String enclosureType) {
        this.enclosureType = enclosureType;
    }

    public void setEnclosureUrl(String enclosureUrl) {
        this.enclosureUrl = enclosureUrl;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
