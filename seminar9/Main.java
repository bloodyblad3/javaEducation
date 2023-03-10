package seminar9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        Comparator<Notebook> descendingByRAM = (n1, n2) -> (n1.getRAM() == n2.getRAM())? (n2.getCost() - n1.getCost()) : (n2.getRAM() - n1.getRAM());
        Comparator<Notebook> descendingByCost = (n1, n2) -> n2.getCost() - n1.getCost();
        ArrayList<Notebook> list = new ArrayList<>();
        ArrayList<Notebook> descendingRAM = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(new Notebook(ThreadLocalRandom.current().nextInt(1000), ThreadLocalRandom.current().nextInt(64)));
            descendingRAM.add(new Notebook(ThreadLocalRandom.current().nextInt(1000), 32));
        }
        // Сортировка по возрастанию  цены
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        System.out.println();

        // Сортировка по убыванию цены
        System.out.println(list);
        Collections.sort(list, descendingByCost);
        System.out.println(list);
        System.out.println();

        // Сортировка по убыванию цены, если ОЗУ равны, и по убыванию ОЗУ если не равны
        System.out.println(descendingRAM);
        Collections.sort(descendingRAM, descendingByRAM);
        System.out.println(descendingRAM);
    }
    
}
