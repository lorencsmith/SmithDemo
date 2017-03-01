package com.example.lorensmith.smithdemo.bean;

import java.io.Serializable;

/**
 * Created by Loren Smith on 2/15/2017.
 */

public class Book implements Serializable {
    private String name;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
