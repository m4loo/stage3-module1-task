package com.mjc.school.repository;

public class Author {

    private long authorId;
    private String authorName;

    public Author() {}

    public Author (long authorId, String authorName){
        this.authorId = authorId;
        this.authorName = authorName;
    }

    public long getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }
}