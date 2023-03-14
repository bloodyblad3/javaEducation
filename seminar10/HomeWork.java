package seminar10;

public class HomeWork {

    public static void main(String[] args) {
        // Есть классы: GoldenApple -> Apple -> Fruit
        // Orange -> Fruit
        // Есть класс Box. Нужно:
        // 1. Организовать его так, чтобы он мог хранить только фрукты какого-то типа
        // 2. Реализовать методы добавления фрукта, пересыпания в другую коробку,
        // получение сумарного веса
        // Ограничения:
        // В коробку с апельсинами нельзя добавить яблоки
        // В коробку с золотыми яблоками нельзя добавить апельсины и яблоки
        // Пересыпать из коробки с золотыми яблоками в коробку с яблоками можно!
        // 3.* Реализовать итерируемость по коробке

        Box<Apple> appleBox = new Box<Apple>(new Apple(10));
        Box<Orange> orangeBox = new Box<Orange>();
        Box<GoldenApple> goldenAppleBox = new Box<>(new GoldenApple(15));

        appleBox.add(new Apple(1));
        appleBox.add(new GoldenApple(4));
        System.out.println(appleBox.getWeight());

        orangeBox.add(new Orange(5));
        System.out.println(orangeBox.getWeight());

        goldenAppleBox.add(new GoldenApple(2));
        System.out.println(goldenAppleBox.getWeight());

        goldenAppleBox.moveTo(appleBox);
        System.out.println(goldenAppleBox.getWeight());
        System.out.println(appleBox.getWeight());

        // 3.*
        System.out.println();
        for (Apple apple : appleBox) {
            System.out.println(apple.getWeight());
        }

    }
}
