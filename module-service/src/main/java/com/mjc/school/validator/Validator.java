package com.mjc.school.validator;

import com.mjc.school.dto.AuthorDto;
import com.mjc.school.dto.NewsDto;

import java.util.List;

public class Validator {
    private static final int MIN_LENGTH_TITLE = 5;
    private static final int MAX_LENGTH_TITLE = 30;
    private static final int MIN_LENGTH_CONTENT = 5;
    private static final int MAX_LENGTH_CONTENT = 255;
    public Long validateNewsReadBy(String value) {
        try
        {
             return Long.parseLong(value);
        }
        catch(NumberFormatException ex)
        {
            System.out.println("ERROR_CODE: 000013 ERROR_MESSAGE: Id should be number");
            return null;
        }
    }
    public void validateId(Long id, List<NewsDto> newsDtoList) throws HandledException {
        if (id > newsDtoList.size() - 1) {
            throw new HandledException("000001", String.format("News with id %s does not exist.\n", id));
        }

    }

    public void validateTitleLength(String title) throws HandledException {

        if (title.length() < MIN_LENGTH_TITLE || title.length() > MAX_LENGTH_TITLE) {
            throw new HandledException("000012", String.format("News title can not be less than 5 and more than 30 symbols. News title is %s\n", title));
        }
    }

    public void validateContentLength(String content) throws HandledException {
        if (content.length() < MIN_LENGTH_CONTENT || content.length() > MAX_LENGTH_CONTENT) {
            throw new HandledException("000012", String.format("News content can not be less than 5 and more than 255 symbols. News content is %s\n", content));
        }

    }

    public void validateNewsId(Long id, List<NewsDto> newsDtoList) throws HandledException {
        if (id > newsDtoList.size() - 1) {
            throw new HandledException("000001", String.format("News with id %s does not exist.\n", id));
        }
    }

    public void validateAuthorId(Long id, List<AuthorDto> authorDtoList) throws HandledException {
        if (id > authorDtoList.size()) {
            throw new HandledException("000002", String.format("Author Id does not exist. Author Id is: %s\n", id));
        }
    }
}
