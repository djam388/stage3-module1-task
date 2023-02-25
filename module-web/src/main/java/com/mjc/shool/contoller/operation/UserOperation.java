package com.mjc.shool.contoller.operation;

import com.mjc.school.service.dto.NewsDto;
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
                System.out.println("Operation: Get news by id.");
                System.out.println("Enter news id:" );
                Scanner enteredValue = new Scanner(System.in);
                long id = enteredValue.nextLong();
                System.out.println(NewsController.getInstance().readById(id));
            }
            case CreateNews -> {
                System.out.println("Operation: Create news.");
                NewsDto news = new NewsDto();
                System.out.println("Enter news title:" );
                news.setTitle(requestEnterValue());
                System.out.println("Enter news content:" );
                news.setContent(requestEnterValue());
                System.out.println("Enter author id:" );
                news.setAuthorId(Long.parseLong(requestEnterValue()));
                System.out.println(NewsController.getInstance().create(news));
            }
            case UpdateNews -> {
                System.out.println("Operation: Update news.");
                NewsDto news = new NewsDto();
                System.out.println("Enter news id:");
                news.setId(Long.parseLong(requestEnterValue()));
                System.out.println("Enter news title:");
                news.setTitle(requestEnterValue());
                System.out.println("Enter news content:");
                news.setContent(requestEnterValue());
                System.out.println("Enter author id:");
                news.setAuthorId(Long.parseLong(requestEnterValue()));
                System.out.println(NewsController.getInstance().update(news));
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
