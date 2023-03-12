package com.mjc.school.operation;

import com.mjc.school.dto.NewsDto;
import com.mjc.school.validator.Validator;
import java.util.Scanner;

public class UserOperation {

    public NewsDto enterNewsData() {
        NewsDto newsDto = new NewsDto();
        System.out.println("Enter news title:");
        newsDto.setTitle(requestEnterValue());
        System.out.println("Enter news content:");
        newsDto.setContent(requestEnterValue());
        newsDto.setAuthorId(enterId("Enter author id:"));
        return newsDto;
    }
    public Long enterId (String operationType) {
        boolean isNumber = false;
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
