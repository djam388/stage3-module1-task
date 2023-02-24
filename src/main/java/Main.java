import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Integer> listTest = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Test");


        listTest.add(0, 1);
        listTest.add(2);
        listTest.add(3);
        printList();

        listTest.remove(1);
        printList();
        listTest.add(1, 2);
        printList();

        listTest.add(1, 22);
        printList();




    }
    public static void printList() {

        for (Integer integer : listTest) {
            System.out.println("Integers in the list: " + integer);

        }
        System.out.println();
    }
}
