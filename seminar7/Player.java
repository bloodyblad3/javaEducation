package seminar7;


public class Player {
    private static Long idCounter = 1L;

    private Long id;
    private String name;
    protected double hp;

    public Player(String name) {
        this.id = idCounter++;
        this.name = name;
        this.hp = 100;
    }

    public void decreaseHP(double dps) {
        hp = hp - dps;
    }

    public boolean isDeath() {
        if (hp <= 0) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String playerInfo() {
        return String.format("ID: %d Nick: %s", this.id, this.name);
    }
}
