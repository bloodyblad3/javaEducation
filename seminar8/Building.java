package seminar8;

public class Building implements HasHealthPoint {

    private final int maxHealthPoint;
    private int currentHealthPoint;

    public Building(int hp) {
        this.maxHealthPoint = hp;
        this.currentHealthPoint = maxHealthPoint;
    }

    public boolean isBroke() {
        if (currentHealthPoint == 0) {
            return true;
        }
        return false;
    }

    public void takeDamage(int damage) {
        currentHealthPoint = currentHealthPoint - damage;
    }

    @Override
    public String toString() {
        return String.format("ХП: %d", currentHealthPoint);
    }

    @Override
    public int getCurrentHealthPoint() {
        return currentHealthPoint;
    }

}
