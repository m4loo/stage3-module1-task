package com.mjc.school.web.menu;

public enum Buttons {
    GET_ALL_NEWS(1, "Get all news."),
    GET_NEWS_BY_ID(2, "Get news by id."),
    CREATE_NEWS(3, "Create news."),
    UPDATE_NEWS(4, "Update news."),
    REMOVE_NEWS_BY_ID(5, "Remove news by id."),
    EXIT(0, "Exit.");

    private final int buttonId;
    private final String button;

    Buttons(int buttonId, String button){
        this.buttonId = buttonId;
        this.button = button;
    }

    public int getButtonId() {
        return this.buttonId;
    }

    public String getButton() {
        return this.button;
    }
}