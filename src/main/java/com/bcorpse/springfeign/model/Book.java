package com.bcorpse.springfeign.model;

public class Book {
    private String isbn;
    private String author;
    private String title;
    private String synopsis;
    private String language;

    public Book(){

    }

    public Book(String isbn,String author,String title,String synopsis,String language){
        this.setIsbn(isbn);
        this.setAuthor(author);
        this.setTitle(title);
        this.setSynopsis(synopsis);
        this.setLanguage(language);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    // standard constructor, getters and setters
}