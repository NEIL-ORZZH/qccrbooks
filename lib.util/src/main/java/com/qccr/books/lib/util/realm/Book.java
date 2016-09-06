package com.qccr.books.lib.util.realm;

import io.realm.RealmObject;

/**
 * @author: zhuhuanhuan
 * @time: 16/9/6-下午4:30.
 * @email: zhuhuanhuan@qccr.com
 * @desc:
 */

public class Book extends RealmObject {

    /**
     * 评价
     */
    private String rating;

    /**
     * 中文书名
     */
    private String title;

    /**
     * 外文书名
     */
    private String orginTitle;

    /**
     * 作者们:每个作者的名字间,用","间隔
     */
    private String author;

    /**
     * 书籍封面
     */
    private String smallPic;

    private String mediumPic;

    private String largePic;

    /**
     * 书籍的isbn号,如果豆瓣的isbn13空的话,选用isbn10
     */
    private String isbn;

    /**
     * 书籍的简介
     */
    private String summary;

    /**
     * 出版社
     */
    private String publisher;

    /**
     * 书籍价钱
     */
    private String price;

    /**
     * 书籍页码
     */
    private String pages;

    /**
     * 豆瓣api能够获取该书籍的api
     */
    private String apiUrl;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrginTitle() {
        return orginTitle;
    }

    public void setOrginTitle(String orginTitle) {
        this.orginTitle = orginTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    public String getMediumPic() {
        return mediumPic;
    }

    public void setMediumPic(String mediumPic) {
        this.mediumPic = mediumPic;
    }

    public String getLargePic() {
        return largePic;
    }

    public void setLargePic(String largePic) {
        this.largePic = largePic;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}
