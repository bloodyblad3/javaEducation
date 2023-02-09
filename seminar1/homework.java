package seminar1;
import java.util.Arrays;

public class homework {

    public static void main(String[] args) {
        System.out.println(isSumBetween10And20(5, 15)); // true
        System.out.println(isSumBetween10And20(7, 15)); // false

        System.out.println(isPositive(5));

        printString("abcd", 5); // abcdabcdabcdabcdabcd
        System.out.println(isLeapYear(1992)); // true
        System.out.println(Arrays.toString(createArray(5, 10))); // [10, 10, 10, 10, 10]

        // int[][] array = new int[4][4]; // [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, x],
        // [0, 0, 0, 1]]
        // int x = array[2][3];

        String[] stringArray = { "aaa", "aab", "aa" };
        System.out.println(findCommonPrefix(stringArray)); // aa
        String[] stringArray2 = { "abc", "bca", "cda" };
        System.out.println(findCommonPrefix(stringArray2)); // ""
    }

    /**
     * 1. Написать метод, принимающий на вход два целых числа и проверяющий,
     * что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть
     * true, в противном случае – false.
     */
    private static boolean isSumBetween10And20(int a, int b) {
        // проверить, что сумма a и b лежит между 10 и 20
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        }
        return false;
    }

    private static boolean isPositive(int x) {
        // проверить, что х положительное
        if (x > 0) {
            return true;
        }
        return false;
    }

    private static void printString(String source, int repeat) {
        // напечатать строку source repeat раз
        System.out.println(source.repeat(repeat));
        // или
        String result = "";
        for (int i = 0; i < repeat; i++) {
            result += source;
        }
        System.out.println(result);
    }

    private static boolean isLeapYear(int year) {
        // проверить, является ли год високосным. если да - return true
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    private static int[] createArray(int len, int initalValue) {
        // должен вернуть массив длины len, каждое значение которого равно initialValue
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initalValue;
        }
        return array;
    }

    private static String findCommonPrefix(String[] source) {
        /**
         * Найти общий префикс среди слов из одного массива.
         * ["aaa", "aab", "aa"] -> "aa", ["abc", "bca", "cda"] -> ""
         */
        return null;
    }

    /**
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия
     * заменить 0 на 1, 1 на 0;
     * 2. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему
     * циклом, и числа меньшие 6 умножить на 2;
     * 3. Создать квадратный двумерный целочисленный массив (количество строк и
     * столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно
     * только одну из диагоналей, если обе сложно).
     * Определить элементы одной из диагоналей можно по следующему принципу: индексы
     * таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
     * 4. Задать одномерный массив и найти в нем минимальный и максимальный элементы
     * ;
     */
}
