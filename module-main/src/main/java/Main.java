
import com.mjc.school.dto.NewsDto;
import com.mjc.school.menu.Menu;
import com.mjc.school.controller.NewsController;
import com.mjc.school.operation.UserOperation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        NewsController newsController = NewsController.getInstance();
        UserOperation userOperation = new UserOperation();

        while (true) {
            menu.printMenu();
            Scanner keyValue = new Scanner(System.in);
            String key = keyValue.nextLine();
            switch (key) {
                case "1" -> {
                    newsController.readAll().forEach(System.out::println);
                    continue;
                }
                case "2" -> {
                    Long idReadNews = userOperation.enterId("Operation: Get news by id.\nEnter news id:");
                    NewsDto newsDtoReadById = newsController.readById(idReadNews);
                    if (newsDtoReadById != null) {
                        System.out.println(newsDtoReadById);
                    }
                    continue;
                }
                case "3" -> {
                    NewsDto newsDtoCreate = userOperation.enterNewsData();
                    newsDtoCreate = newsController.create(newsDtoCreate);
                    if (newsDtoCreate != null) {
                        System.out.println(newsDtoCreate);
                    }
                    continue;
                }
                case "4" -> {
                    Long idUpdateNews = userOperation.enterId("Operation: Update news.\nEnter news id:");
                    NewsDto newsDtoUpdate = userOperation.enterNewsData();
                    newsDtoUpdate.setId(idUpdateNews);
                    newsDtoUpdate = newsController.update(newsDtoUpdate);
                    if (newsDtoUpdate != null) {
                        System.out.println(newsDtoUpdate);
                    }
                    continue;
                }
                case "5" -> {
                    Long idDeleteNews = userOperation.enterId("Operation: Remove news by id.\nEnter news id:");
                    if (newsController.delete(idDeleteNews)) {
                        System.out.println(true);
                    }
                    continue;
                }
                case "0" -> {
                    System.exit(0);
                    continue;
                }
            }
            System.out.println("Command not found.\n");
        }
    }


}
