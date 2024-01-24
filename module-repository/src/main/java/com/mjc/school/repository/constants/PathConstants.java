package com.mjc.school.repository.constants;

public class PathConstants {
    private static final String AUTHOR_FILE_REPOSITORY = "module-repository/src/main/resources/author.txt";
    private static final String CONTENT_FILE_REPOSITORY = "module-repository/src/main/resources/content.txt";
    private static final String TITLE_FILE_REPOSITORY = "module-repository/src/main/resources/news.txt";

    public String getAuthorFileRepository() {
        return AUTHOR_FILE_REPOSITORY;
    }

    public String getContentFileRepository() {
        return CONTENT_FILE_REPOSITORY;
    }

    public String getTitleFileRepository() {
        return TITLE_FILE_REPOSITORY;
    }
}