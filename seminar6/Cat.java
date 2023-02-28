package seminar6;


public class Cat {

    private String name;
    private int appetite;
    private volatile int satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;

        Thread backgroundSatietyManagement = new Thread(() -> {
            while (true) {
                if (satiety == 0) {
                    continue;                    
                } else {
                    satiety--;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundSatietyManagement.setDaemon(true);
        backgroundSatietyManagement.start();
    }

    public void eat(Plate plate) {
        if (isEnoughToEat(plate)) {
            plate.decreaseFood(appetite - satiety);
            satiety = appetite;
        } else {
            satiety += plate.food;
            plate.decreaseFood(satiety);
        }
    }

    public boolean isHungry() {
        if (satiety <= appetite/2) {
            return true;
        }
        return false;
    }

    public boolean isEnoughToEat(Plate plate) {
        if (plate.food < appetite - satiety) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + "{appetite=" + appetite + ", satiety=" + satiety + "}";
    }
}
