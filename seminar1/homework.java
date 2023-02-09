package seminar1;
import java.util.Arrays;

public class homework {

    public static void main(String[] args) {
        System.out.println(isSumBetween10And20(5, 15)); // true
        System.out.println(isSumBetween10And20(7, 15)); // false
        System.out.println();

        System.out.println(isPositive(5));
        System.out.println();

        printString("abcd", 5); // abcdabcdabcdabcdabcd
        System.out.println();

        System.out.println(isLeapYear(1992)); // true
        System.out.println();

        System.out.println(Arrays.toString(createArray(5, 10))); // [10, 10, 10, 10, 10]
        System.out.println();

        int[] array = new int[] { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        System.out.println(Arrays.toString(array)); // [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]
        System.out.println(Arrays.toString(swap0to1(array))); // [0, 0, 1, 1, 0, 1, 0, 0, 1, 1]
        System.out.println();

        int[] array2 = new int[] { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println(Arrays.toString(array2)); // [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        System.out.println(Arrays.toString(pow(array2)));
        System.out.println();

        int[][] array3 = create2dArray(5, 5);
        Arrays.stream(array3).forEach(arr -> System.out.println(Arrays.toString(arr)));
        System.out.println();

        minmax(array2); // min: 2 max: 11
        System.out.println();

        String[] stringArray = { "aaa", "aab", "aa" };
        System.out.println(findCommonPrefix(stringArray)); // aa
        String[] stringArray2 = { "abc", "bca", "cda" };
        System.out.println(findCommonPrefix(stringArray2)); // ""
    }

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

    private static int[] swap0to1(int[] array) {
        // Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1,
        // 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 1) ? 0 : 1;
        }
        return array;
    }

    private static int[] pow(int[] array) {
        // Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        // и числа меньшие 6 умножить на 2;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        return array;
    }

    private static int[][] create2dArray(int row, int column) {
        // Создать квадратный двумерный целочисленный массив (количество строк и
        // столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами
        // (можнотолько одну из диагоналей, если обе сложно).
        int[][] array = new int[row][column];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][i] = 1;
                array[i][array.length - 1 - i] = 1;
            }
        }
        return array;
    }

    private static void minmax(int[] array) {
        // Задать одномерный массив и найти в нем минимальный и максимальный элементы
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
            }
            if (array[i] <= min) {
                min = array[i];
            }
        }
        System.out.printf("min: %d max: %d", min, max);
        // или
        System.out.println();
        Arrays.sort(array);
        System.out.printf("min: %d max: %d", array[0], array[array.length - 1]);
        System.out.println();
    }

    private static String findCommonPrefix(String[] source) {
        // Найти общий префикс среди слов из одного массива.
        // ["aaa", "aab", "aa"] -> "aa", ["abc", "bca", "cda"] -> ""
        if (source.length == 0)
            return "";
        String prefix = source[0];
        for (var str : source)
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        return prefix;
    }
}
