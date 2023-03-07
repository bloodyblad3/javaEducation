package seminar8;

public class Player implements HasHealthPoint, HasEnergy {

    private String name;
    private final int maxHealthPoint;
    private final int maxEnergy;
    private int currentHealthPoint;
    private int currentEnergy;
    private int damage;

    public Player(String name, int hp, int energy, int damage) {
        this.name = name;
        this.maxHealthPoint = hp;
        this.currentHealthPoint = maxHealthPoint;
        this.maxEnergy = energy;
        this.currentEnergy = maxEnergy;
        this.damage = damage;

        Thread backgroundRestoreEnergy = new Thread(() -> {
            while (true) {
                if (currentEnergy != maxEnergy) {
                    currentEnergy += 5;
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundRestoreEnergy.setDaemon(true);
        backgroundRestoreEnergy.start();
    }

    private boolean isTired() {
        if (currentEnergy <= 0) {
            return true;
        }
        return false;
    }

    public void attack(Building build) {
        if (!isTired()) {
            currentEnergy = currentEnergy - 10;
            build.takeDamage(damage);
        } else {
            System.out.println("Персонаж устал!");
        }
    }

    @Override
    public String toString() {
        return String.format("Имя: %s ХП: %d Энергия: %d Урон: %d", name, currentHealthPoint, currentEnergy, damage);
    }

    @Override
    public int getCurrentEnergy() {
        return currentEnergy;
    }

    @Override
    public int getCurrentHealthPoint() {
        return currentHealthPoint;
    }

}
