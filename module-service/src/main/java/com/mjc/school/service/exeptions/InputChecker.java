package com.mjc.school.service.exeptions;

import com.mjc.school.service.dto.DTO;
import org.apache.commons.lang3.math.NumberUtils;

public class InputChecker {
    private static final int NEWS_TITLE_MIN = 5;
    private static final int NEWS_TITLE_MAX = 30;

    private static final int NEWS_CONTENT_MIN = 5;
    private static final int NEWS_CONTENT_MAX = 255;

    private InputChecker(){}

    public void checkNewsId(String id) throws InputExceptions {
        checkFormatNewsId(id);
        checkId(Long.parseLong(id), Exceptions.ERROR_NEWS_ID_LENGTH.getErrorInfo(id));
    }

    public void checkAuthorId(String id) throws InputExceptions {
        checkFormatAuthorId(id);
        checkId(Long.parseLong(id), Exceptions.ERROR_AUTHOR_ID_LENGTH.getErrorInfo(id));

    }

    public void checkId(long id, String message) throws InputExceptions {
        if(id <= 0) throw new InputExceptions(message);
    }

    public void checkFormatNewsId(String id) throws InputExceptions {
        formatCheck(id, Exceptions.ERROR_NEWS_ID_FORMAT.getErrorInfo());
    }

    public void checkFormatAuthorId(String id) throws InputExceptions {
        formatCheck(id, Exceptions.ERROR_AUTHOR_ID_FORMAT.getErrorInfo());
    }

    public void formatCheck(String string, String message) throws InputExceptions{
        if (!NumberUtils.isParsable(string)) throw new InputExceptions(message);
    }

    public void checkDTO(DTO dto) throws InputExceptions {
        checkTitle(dto.getNewsTitle());
        checkContent(dto.getNewsContent());
    }

    public void checkTitle(String title) throws InputExceptions {
        if(title.length() < NEWS_TITLE_MIN || title.length() > NEWS_TITLE_MAX)
            throw new InputExceptions(Exceptions.ERROR_NEWS_TITLE_LENGTH.getErrorInfo(title));
    }

    public void checkContent(String content) throws InputExceptions {
        if(content.length() < NEWS_CONTENT_MIN || content.length() > NEWS_CONTENT_MAX)
            throw new InputExceptions(Exceptions.ERROR_NEWS_CONTENT_LENGTH.getErrorInfo(content));
    }

    public static InputChecker getInputChecker() {
        return GetNew.INPUT_CHECKER;
    }

    static class GetNew {
        static final InputChecker INPUT_CHECKER = new InputChecker();
        private GetNew(){}
    }
}
