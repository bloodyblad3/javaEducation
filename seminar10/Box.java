package seminar10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Box<E extends Fruit> implements Iterable<E> {
    private ArrayList<E> fruits;

    public Box(E fruits) {
        this.fruits = new ArrayList<E>(Arrays.asList(fruits));
    }

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void add(E fruits) {
        this.fruits.addAll(Arrays.asList(fruits));
    }

    public int getWeight() {
        if (fruits.size() == 0)
            return 0;
        int weight = 0;
        for (E fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public void moveTo(Box<? super E> target) {
        target.fruits.addAll(this.fruits);
        fruits.clear();
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < fruits.size();
            }

            @Override
            public E next() {
                return fruits.get(index++);
            }
        };
    }
}
