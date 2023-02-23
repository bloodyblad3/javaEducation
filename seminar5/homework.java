package seminar5;

import java.util.Scanner;
import java.util.Stack;

public class homework {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = getString(sc);
        System.out.printf("%s > %s", text, checkBrackets(text));
    }

    private static String getString(Scanner sc) {
        System.out.println("Для работы введите скобочки, например: []{}((<>))");
        return sc.nextLine();
    }

    private static boolean isInArray(char symb, char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == symb) {
                return true;
            }
        }
        return false;
    }

    private static int indexOf(char symb, char[] arr) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == symb) {
                index = i;
            }
        }
        return index;
    }

    private static boolean checkBrackets(String str) {
        if (str.isBlank()) {
            System.out.println("Строка не может быть пустой!");
            System.exit(0);
        }
        Stack<Character> stack = new Stack<Character>();
        char[] openBrackets = new char[] { '{', '[', '(', '<' };
        char[] closeBrackets = new char[] { '}', ']', ')', '>' };

        for (int i = 0; i < str.length(); i++) {
            char symb = str.charAt(i);
            if (isInArray(symb, openBrackets)) {
                stack.push(symb);
            } else {
                int index = indexOf(symb, closeBrackets);
                if (index != -1) {
                    if (stack.empty()) {
                        return false;
                    }
                    if (stack.pop() != openBrackets[index]) {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }
}
