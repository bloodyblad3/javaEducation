package seminar7;

import java.util.concurrent.ThreadLocalRandom;

public class Melee extends Player {

    private double damage;
    
    public Melee(String name) {
        super(name);
        this.damage = 10;
        super.hp = 100;
    }

    public double attack() {
        return ThreadLocalRandom.current().nextDouble(damage);
    }

    public String playerInfo() {
        return String.format("%s HP: %f Damage: %f ",super.playerInfo(), this.hp, this.damage);
    }
}
