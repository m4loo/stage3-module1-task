package com.mjc.school.web.menu;

import com.mjc.school.service.DTO.DTO;

import com.mjc.school.service.dataService.NewsOperations;
import com.mjc.school.service.exeptions.Exceptions;
import com.mjc.school.service.exeptions.InputChecker;
import com.mjc.school.service.exeptions.InputExceptions;

import java.util.Scanner;

import static java.lang.System.*;

public class MenuControl {

    NewsOperations operation = new NewsOperations();
    InputChecker inputChecker = InputChecker.getInputChecker();

    public void printMainMenu() {
        while (true) {
            out.println(ConstantsString.MAIN_MENU_TITLE);
            for (Buttons b : Buttons.values()) {
                out.println(b.getButtonId() + " - " + b.getButton());
            }
            Scanner input = new Scanner(in);

            switch (input.nextLine()) {
                case "1" -> getAllNewsMenu();
                case "2" -> getNewsByIdMenu(input);
                case "3" -> createNewsMenu(input);
                case "4" -> updateNewsMenu(input);
                case "5" -> removeNewsByIdMenu(input);
                case "0" -> System.exit(0);
                default -> out.println(Exceptions.ERROR_COMMAND_NOT_FOUND.getERROR_INFO());
            }
        }
    }

    public void getAllNewsMenu() {
        out.println("Operation: " + Buttons.GET_ALL_NEWS.getButton());
        out.println(operation.toString(operation.getAllNews()));
    }

    public void getNewsByIdMenu(Scanner input) {
        out.println("Operation: " + Buttons.GET_NEWS_BY_ID.getButton());
        out.println(ConstantsString.ENTER_NEWS_ID);
        String newsId = input.nextLine();

        try {
            inputChecker.checkNewsId(newsId);
            out.println(operation.toString(operation.getNewsById(Long.parseLong(newsId) - 1)));
        } catch (InputExceptions e) {
            out.println(e.getErrorInfo());
        }
    }

    public void createNewsMenu(Scanner input) {
        out.println("Operation: " + Buttons.CREATE_NEWS.getButton());
        out.println(ConstantsString.ENTER_NEWS_TITLE);
        String title = input.nextLine();
        out.println(ConstantsString.ENTER_NEWS_CONTENT);
        String content = input.nextLine();
        out.println(ConstantsString.ENTER_AUTHOR_ID);
        String authorId = input.nextLine();

        try {
            inputChecker.checkAuthorId(authorId);
            DTO dto = new DTO(title, content, Long.parseLong(authorId));
            inputChecker.checkDTO(dto);
            out.println(operation.toString(operation.createNews(dto)));
        } catch (InputExceptions e) {
            out.println(e.getErrorInfo());
        }
    }

    public void updateNewsMenu(Scanner input) {
        out.println("Operation: " + Buttons.UPDATE_NEWS.getButton());
        out.println(ConstantsString.ENTER_NEWS_ID);
        String newsId = input.nextLine();
        out.println(ConstantsString.ENTER_NEWS_TITLE);
        String title = input.nextLine();
        out.println(ConstantsString.ENTER_NEWS_CONTENT);
        String content = input.nextLine();
        out.println(ConstantsString.ENTER_AUTHOR_ID);
        String authorId = input.nextLine();

        try {
            inputChecker.checkNewsId(newsId);
            inputChecker.checkAuthorId(authorId);
            DTO dto = new DTO(title, content, Long.parseLong(authorId));
            inputChecker.checkDTO(dto);
            out.println(operation.toString(operation.updateNewsById(Long.parseLong(newsId) - 1, dto)));
        } catch (InputExceptions e) {
            out.println(e.getErrorInfo());
        }
    }

    public void removeNewsByIdMenu(Scanner input) {
        out.println("Operation: " + Buttons.REMOVE_NEWS_BY_ID.getButton());
        out.println(ConstantsString.ENTER_NEWS_ID);
        String newsId = input.nextLine();
        try {
            inputChecker.checkNewsId(newsId);
            out.println(operation.removeNewsById(Long.parseLong(newsId) - 1));
        } catch (InputExceptions e) {
            out.println(e.getErrorInfo());
        }
    }
}