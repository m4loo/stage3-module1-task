package com.mjc.school.service.exeptions;

import com.mjc.school.service.DTO.DTO;
import org.apache.commons.lang3.*;
import org.apache.commons.lang3.math.NumberUtils;

public class InputChecker {
    private static final int NEWS_TITLE_MIN = 5;
    private static final int NEWS_TITLE_MAX = 30;

    private static final int NEWS_CONTENT_MIN = 5;
    private static final int NEWS_CONTENT_MAX = 255;

    private InputChecker(){}

    public void checkNewsId(long id) throws InputExceptions {
        checkId(id, Exceptions.ERROR_NEWS_ID_LENGTH.getERROR_INFO(id));
    }

    public void checkAuthorId(long id) throws InputExceptions {
        checkId(id, Exceptions.ERROR_AUTHOR_ID_NOT_EXIST.getERROR_INFO(id));
    }

    public void checkFormatNewsId(String id) throws InputExceptions {
        formatCheck(id, Exceptions.ERROR_NEWS_ID_FORMAT.getERROR_INFO());
    }

    public void checkFormatAuthorId(String id) throws InputExceptions {
        formatCheck(id, Exceptions.ERROR_AUTHOR_ID_FORMAT.getERROR_INFO());
    }

    public void checkId(long id, String message) throws InputExceptions {
        if(id <= 0) throw new InputExceptions(message);
    }

    public void checkDTO(DTO dto) throws InputExceptions {
        checkTitle(dto.getNewsTitle());
        checkContent(dto.getNewsContent());
        checkAuthorId(dto.getAuthorId());
    }

    public void checkTitle(String title) throws InputExceptions {
        if(title.length() < NEWS_TITLE_MIN || title.length() > NEWS_TITLE_MAX)
            throw new InputExceptions(Exceptions.ERROR_NEWS_TITLE_LENGTH.getERROR_INFO(title));
    }

    public void checkContent(String content) throws InputExceptions {
        if(content.length() < NEWS_CONTENT_MIN || content.length() > NEWS_CONTENT_MAX)
            throw new InputExceptions(Exceptions.ERROR_NEWS_CONTENT_LENGTH.getERROR_INFO(content));
    }

    public void formatCheck(String string, String message) throws InputExceptions{
        if (!NumberUtils.isParsable(string)) throw new InputExceptions(message);
    }
    public static InputChecker getInputChecker() {
        return getNew.INPUT_CHECKER;
    }

    static class getNew {
        static final InputChecker INPUT_CHECKER = new InputChecker();
        private getNew(){}
    }
}
