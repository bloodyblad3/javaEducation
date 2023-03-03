package seminar7;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Wizard> wizards = new ArrayList<>();
        wizards.add(new Wizard("keruvim"));
        wizards.add(new Wizard("keruvim2"));
        ArrayList<Melee> melees = new ArrayList<>();
        melees.add(new Melee("murcielago"));
        melees.add(new Melee("murcielago2"));
        boolean state = true;

        while (state) {
            for (int i = 0; i < wizards.size(); i++) {
                for (int j = 0; j < melees.size(); j++) {
                    int randTurn = ThreadLocalRandom.current().nextInt(0, 2);
                    Wizard wizard = wizards.get(i);
                    Melee melee = melees.get(i);
                    if (randTurn == 0) {
                        if (!melee.isDeath()) {
                            double dps = wizard.attack();
                            melee.decreaseHP(dps);
                            System.out.printf("Волшебник: %s нанес %f урона %s\n", wizard.getName(), dps,
                                    melee.getName());
                            System.out.println(melee.playerInfo());
                            break;
                        } else {
                            System.out.println("Игра закончена победили волшебники!");
                            state = false;
                        }
                    } else {
                        if (!wizard.isDeath()) {
                            double dps = melee.attack();
                            wizard.decreaseHP(dps);
                            System.out.printf("Милишник: %s нанес %f урона %s\n", melee.getName(), dps,
                                    wizard.getName());
                            System.out.println(wizard.playerInfo());
                            break;
                        } else {
                            System.out.println("Игра закончена победили милишники!");
                            state = false;
                        }
                    }
                }
            }
            Thread.sleep(2000);
        }
    }
}
