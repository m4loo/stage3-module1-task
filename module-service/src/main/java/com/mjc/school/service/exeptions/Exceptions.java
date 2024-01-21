package com.mjc.school.service.exeptions;

public enum Exceptions {
    ERROR_COMMAND_NOT_FOUND(Constants.ERROR_CODE_XXXX1, Constants.ERROR_COMMAND_NOT_FOUND),

    ERROR_NEWS_ID_LENGTH(Constants.ERROR_CODE_XXX11, Constants.ERROR_NEWS_ID_LENGTH),
    ERROR_NEWS_ID_FORMAT(Constants.ERROR_CODE_XXX12, Constants.ERROR_NEWS_ID_FORMAT),
    ERROR_NEWS_NOT_EXIST(Constants.ERROR_CODE_XXX13, Constants.ERROR_NEWS_NOT_EXIST),

    ERROR_NEWS_TITLE_LENGTH(Constants.ERROR_CODE_XXX14, Constants.ERROR_NEWS_TITLE_LENGTH),
    ERROR_NEWS_CONTENT_LENGTH(Constants.ERROR_CODE_XXX15, Constants.ERROR_NEWS_CONTENT_LENGTH),

    ERROR_AUTHOR_ID_LENGTH(Constants.ERROR_CODE_XXX21, Constants.ERROR_AUTHOR_ID_LENGTH),
    ERROR_AUTHOR_ID_NOT_EXIST(Constants.ERROR_CODE_XXX22, Constants.ERROR_AUTHOR_ID_NOT_EXIST),
    ERROR_AUTHOR_ID_FORMAT(Constants.ERROR_CODE_XXX23, Constants.ERROR_AUTHOR_ID_FORMAT);

    private String errorCode;
    private String errorMessage;

    Exceptions(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorInfo() {
        return Constants.ERROR_CODE + this.errorCode + " "
                + Constants.ERROR_MESSAGE + this.errorMessage;
    }

    public String getErrorInfo(long id) {
        return Constants.ERROR_CODE + this.errorCode + " "
                + Constants.ERROR_MESSAGE + this.errorMessage.replace("{id}", Long.toString(id));
    }

    public String getErrorInfo(String srt) {
        return Constants.ERROR_CODE + this.errorCode + " "
                + Constants.ERROR_MESSAGE + this.errorMessage.replace("{srt}", srt);
    }

    private Exceptions() {}

    private static class Constants {
        public static final String ERROR_CODE = "ERROR_CODE:";
        public static final String ERROR_MESSAGE = "ERROR_MESSAGE:";

        public static final String ERROR_COMMAND_NOT_FOUND = "Command not found.";

        public static final String ERROR_NEWS_ID_LENGTH = "News id can not be null or less than 1. News id is: {id}";
        public static final String ERROR_NEWS_ID_FORMAT = "News Id should be number";
        public static final String ERROR_NEWS_NOT_EXIST = "News with id {id} does not exist.";

        public static final String ERROR_NEWS_TITLE_LENGTH = "News title can not be less than 5 and more than 30 symbols. News title is: {srt}";
        public static final String ERROR_NEWS_CONTENT_LENGTH = "News content can not be less than 5 and more than 255 symbols. News content is: {srt}";

        public static final String ERROR_AUTHOR_ID_LENGTH = "Author id can not be null or less than 1. Author id is: {id}";
        public static final String ERROR_AUTHOR_ID_NOT_EXIST = "Author Id does not exist. Author Id is: {id}";
        public static final String ERROR_AUTHOR_ID_FORMAT = "Author Id should be number";

        public static final String ERROR_CODE_XXXX1 = "XXXX1";
        public static final String ERROR_CODE_XXX11 = "XXX11";
        public static final String ERROR_CODE_XXX12 = "XXX12";
        public static final String ERROR_CODE_XXX13 = "XXX13";
        public static final String ERROR_CODE_XXX14 = "XXX14";
        public static final String ERROR_CODE_XXX15 = "XXX22";
        public static final String ERROR_CODE_XXX21 = "XXX21";
        public static final String ERROR_CODE_XXX22 = "XXX22";
        public static final String ERROR_CODE_XXX23 = "XXX23";
    }
}
