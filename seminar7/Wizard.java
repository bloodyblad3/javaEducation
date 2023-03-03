package seminar7;

import java.util.concurrent.ThreadLocalRandom;

public class Wizard extends Player {

    private double damage;
    
    public Wizard(String name) {
        super(name);
        this.damage = 20;
        super.hp = 80;
    }

    public double attack() {
        return ThreadLocalRandom.current().nextDouble(damage);
    }

    public String playerInfo() {
        return String.format("%s HP: %f Damage: %f ",super.playerInfo(), this.hp, this.damage);
    }
}
