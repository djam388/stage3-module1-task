package com.mjc.shool.contoller.operation;

import com.mjc.school.service.dto.NewsDto;
import com.mjc.shool.contoller.NewsController;

import java.util.Scanner;

public class UserOperation {

    public void Operation (Command command) {
        switch (command) {
             case ShowNewsList -> {
                 System.out.println("Operation: Get all news.");
                 NewsController.getInstance().readAllNews().forEach(System.out::println);
             }
            case ShowNewsById -> {
                System.out.println("Operation: Get news by id.");
                System.out.println("Enter news id:" );
                Scanner enteredValue = new Scanner(System.in);
                long id = enteredValue.nextLong();
                System.out.println(NewsController.getInstance().readById(id));
            }
            case CreateNews -> {
                System.out.println("Operation: Create news.");
                NewsDto newsDto = new NewsDto();
                System.out.println("Enter news title:" );
                newsDto.setTitle(requestEnterValue());
                System.out.println("Enter news content:" );
                newsDto.setContent(requestEnterValue());
                System.out.println("Enter author id:" );
                newsDto.setAuthorId(Long.parseLong(requestEnterValue()));
                System.out.println(NewsController.getInstance().create(newsDto));
            }
            case UpdateNews -> {
                System.out.println("Operation: Update news.");
                NewsDto newsDto = new NewsDto();
                System.out.println("Enter news id:");
                newsDto.setId(Long.parseLong(requestEnterValue()));
                System.out.println("Enter news title:");
                newsDto.setTitle(requestEnterValue());
                System.out.println("Enter news content:");
                newsDto.setContent(requestEnterValue());
                System.out.println("Enter author id:");
                newsDto.setAuthorId(Long.parseLong(requestEnterValue()));
                System.out.println(NewsController.getInstance().update(newsDto));
            }
            case DeleteNews -> {
                System.out.println("Operation: Remove news by id.");
                System.out.println("Enter news id:");
                long id = Long.parseLong(requestEnterValue());
                System.out.println(NewsController.getInstance().delete(id));
            }
        }
    }
    private String requestEnterValue() {
        Scanner typedValue = new Scanner(System.in);
        return typedValue.nextLine();
    }
}
