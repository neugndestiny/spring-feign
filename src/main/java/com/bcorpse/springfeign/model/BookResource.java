package com.bcorpse.springfeign.model;

public class BookResource {
    private Book book;

    // standard constructor, getters and setters
    public BookResource(){

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
