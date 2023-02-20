package seminar4;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class homework {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            LinkedList<String> list = new LinkedList<String>();
            System.out.println("Для ввода используйте формат (text~num)\nДля вывода используйте формат (print~num)");
            while (true) {
                String text = sc.nextLine();
                String[] split = text.split("~");
                String word = split[0];
                int num = Integer.parseInt(split[1]);
                if (word.equals("print")) {
                    if (list.isEmpty()) {
                        System.out.println("Список пуст!");
                    } else {
                        try {
                            for (int i = 0; i < list.size(); i++) {
                                String string = list.get(i);
                                String[] tempsplit = string.split("~");
                                int findnum = Integer.parseInt(tempsplit[1]);
                                if (num == findnum) {
                                    System.out.println(list.get(i));
                                }
                            }
                        } catch (NoSuchElementException e) {
                            System.out.println("В списке нету элемента с таким номером!");
                        }
                    }
                } else if (text.equals("exit")) {
                    break;
                } else {
                    list.add(text);
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
