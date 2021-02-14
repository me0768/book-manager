package com.example.bookmanager;

import lombok.Getter;

@Getter
public class Book {
    private long id;
    private String name;
    private String author;

    public void setId(long id) {
        this.id = id;
    }
}
