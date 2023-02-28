package com.mjc.school.service.validator;

import com.mjc.school.repository.implementation.AuthorRepository;
import com.mjc.school.repository.implementation.NewsRepository;

public class Validator {
    NewsRepository newsRepository = NewsRepository.getInstance();
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
    public Boolean validateId(Long id) {
        if (id <= newsRepository.readAll().size()) {
            return true;
        }
        else {
            System.out.printf("ERROR_CODE: 000001 ERROR_MESSAGE: News with id %s does not exist.\n", id);
            return false;
        }
    }

    public Boolean validateTitleLength(String title) {
        if (title.length() > 4 && title.length() < 31) {
            return true;
        }
        System.out.printf("ERROR_CODE: 000012 ERROR_MESSAGE: News title can not be less than 5 and more than 30 symbols. News title is %s\n", title);
        return false;
    }

    public Boolean validateContentLength(String content) {
        if (content.length() > 4 && content.length() < 256) {
            return true;
        }
        System.out.printf("ERROR_CODE: 000012 ERROR_MESSAGE: News content can not be less than 5 and more than 255 symbols. News content is %s\n", content);
        return false;
    }

    public Boolean validateNewsId(Long id) {
        if (id > newsRepository.readAll().size()) {
            System.out.printf("ERROR_CODE: 000001 ERROR_MESSAGE: News with id %s does not exist.\n", id);
            return false;
        }
        return true;
    }

    public Boolean validateAuthorId(Long id) {
        if (id > AuthorRepository.getInstance().readAll().size()) {
            System.out.printf("ERROR_CODE: 000002 ERROR_MESSAGE: Author Id does not exist. Author Id is: %s\n", id);
            return false;
        }
        return true;
    }

}
