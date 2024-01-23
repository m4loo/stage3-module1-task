package com.mjc.school.repository.implementation.model;

public class AuthorModel {

    private long authorId;
    private String authorName;

    public AuthorModel() {}

    public AuthorModel(long authorId, String authorName){
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