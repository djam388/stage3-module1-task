package com.mjc.shool.contoller.operation;

import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.validator.Validator;
import com.mjc.shool.contoller.NewsController;

import java.util.Scanner;

public class UserOperation {

    public void Operation (Command command) {
        switch (command) {
             case ShowNewsList -> {
                 System.out.println("Operation: Get all news.");
                 NewsController.getInstance().readAll().forEach(System.out::println);
             }
            case ShowNewsById -> {
                NewsDto newsDto = NewsController
                        .getInstance()
                        .readById(enterId("Operation: Get news by id.\nEnter news id:"));
                if (newsDto != null){
                    System.out.println(newsDto);
                }
            }
            case CreateNews -> {
                NewsDto newsDto = new NewsDto();

                System.out.println("Operation: Create news.");
                newsDto = NewsController.getInstance().create(enterNewsData(newsDto));
                if (newsDto != null) {
                    System.out.println(newsDto);
                }
            }
            case UpdateNews -> {
                NewsDto newsDto = new NewsDto();
                System.out.println("Operation: Update news.");
                System.out.println("Enter news id:");
                newsDto.setId(Long.parseLong(requestEnterValue()));

                newsDto = NewsController.getInstance().update(enterNewsData(newsDto));
                if (newsDto != null) {
                    System.out.println(newsDto);
                }
            }
            case DeleteNews -> {
                System.out.println(NewsController
                        .getInstance()
                        .delete(enterId("Operation: Remove news by id.\nEnter news id:")));
            }
        }

    }
    private NewsDto enterNewsData(NewsDto newsDto) {
        System.out.println("Enter news title:");
        newsDto.setTitle(requestEnterValue());
        System.out.println("Enter news content:");
        newsDto.setContent(requestEnterValue());
        newsDto.setAuthorId(enterId("Enter author id:"));
        return newsDto;
    }
    private Long enterId (String operationType) {
        Boolean isNumber = false;
        Long enteredId;
        do {
            System.out.println(operationType);
            enteredId = new Validator().validateNewsReadBy(requestEnterValue());
            if (enteredId != null) {
                isNumber = true;
            }
        }
        while (!isNumber);
        return enteredId;
    }
    private String requestEnterValue() {
        Scanner typedValue = new Scanner(System.in);
        return typedValue.nextLine();
    }
}
