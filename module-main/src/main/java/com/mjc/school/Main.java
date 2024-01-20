package com.mjc.school;

import com.mjc.school.web.menu.MenuControl;


public class Main {
    public static void main(String[] args) {
        run();
    }

    static void run() {
        new MenuControl().printMainMenu();
    }
}