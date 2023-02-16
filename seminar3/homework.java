package seminar3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class homework {
    public static void main(String[] args) {

        ArrayList<Integer> list = createList(10);
        System.out.println(list);
        System.out.println(removeEven(list));
        System.out.println();

        findMinMaxAvg(list);
    }

    private static ArrayList<Integer> removeEven(ArrayList<Integer> list) {
        // Пусть дан произвольный список целых чисел, удалить из него четные числа (в языке уже есть что-то готовое для этого)
        ArrayList<Integer> result = list;
        result.removeIf(x -> (x % 2 == 0));
        return result;
    }

    private static void findMinMaxAvg(ArrayList<Integer> list) {
        // Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
        Collections.sort(list);
        int size = list.size();
        int min = list.get(0);
        int max = list.get(size - 1);
        int avg = 0;
        for (int i = 0; i < size; i++) {
            avg += list.get(i);
        }
        avg = avg / size;
        System.out.printf("min: %d\nmax: %d\navg: %d", min, max, avg);
    }

    private static ArrayList<Integer> createList(int size) {
        ArrayList<Integer> list = new ArrayList<Integer>(size);
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            list.add(r.nextInt(0, 20));
        }
        return list;
    }
}
