package com.edu.ulab.app.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BookEntity extends EntityStorage {
    private Long userId;
    private String title;
    private String author;
    private long pageCount;

    public void update(BookEntity book){
        this.author = book.getAuthor();
        this.title = book.getTitle();
        this.userId = book.getUserId();
        this.pageCount = book.getPageCount();
        this.id = book.getId();
    }
}
