package seminar6;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Кот (имя, аппетит, сытность)
        // Тарелка (содержит какое-то количество еды)
        // Кот ест из тарлеки. Если в тарелке недостаточно еды - кот ее не трогает

        // ДЗ:
        // while (true) -> while (!plate.isEmpty()) done!
        // 1. Создать массив котов. Пусть все коты из массива по очереди едят из одной
        // тарелки. done!
        // В конце каждого цикла мы досыпаем в тарелку еду. done!
        // Для досыпания еды сделать метод increaseFood в классе Plate. done!
        // 2. Поменять поле satiety у кота с boolean на int.
        // Допустим у кота апптит 10, сытность 3. Значит кот захочет поесть 7 единиц.
        // done!
        // 3. * Доработать поток thread в классе Cat, чтобы он каждую секунду уменьшал
        // сытость кота на 1. done!

        ArrayList<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat("Murzik", 15));
        cats.add(new Cat("Barsik", 15));
        Plate plate = new Plate(100);
        System.out.println(plate);
        System.out.println(cats);
        while (!plate.isEmpty()) {
            for (int i = 0; i < cats.size(); i++) {
                Cat cat = cats.get(i);
                if (cat.isHungry()) {
                    cat.eat(plate);
                }
                System.out.println(cat);
                System.out.printf("Кол-во еды в миске после того как поел кот %d\n", plate.food);
            }
            plate.increaseFood(2);
            System.out.printf("Кол-во еды в миске после того как мы подсыпали корма %d\n", plate.food);
            Thread.sleep(1500);
        }
        System.out.println("В миске закончилась еда!");
    }
}