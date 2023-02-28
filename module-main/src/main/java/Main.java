
import com.mjc.school.service.implementation.NewsService;
import com.mjc.school.service.menu.Menu;
import com.mjc.shool.contoller.operation.Command;
import com.mjc.shool.contoller.NewsController;
import com.mjc.shool.contoller.operation.UserOperation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NewsService newsService = new NewsService();
        NewsController newsController;
        Menu menu = new Menu();

        while (true) {
            menu.printMenu();
            Scanner keyValue = new Scanner(System.in);
            String key = keyValue.nextLine();
            switch (key) {
                case "1":
                    new UserOperation().Operation(Command.ShowNewsList);
                    continue;
                case "2":
                    new UserOperation().Operation(Command.ShowNewsById);
                    continue;
                case "3":
                    new UserOperation().Operation(Command.CreateNews);
                    continue;
                case "4":
                    new UserOperation().Operation(Command.UpdateNews);
                    continue;
                case "5":
                    new UserOperation().Operation(Command.DeleteNews);
                    continue;
                case "0":
                    System.exit(0);
                    continue;

            }
            System.out.println("Command not found.\n");
        }
    }


}
