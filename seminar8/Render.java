package seminar8;

public class Render {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";

    public void render(Object object) {
        if (object instanceof HasHealthPoint hasHealthPoint) {
            int currentHp = hasHealthPoint.getCurrentHealthPoint();
            String result = "ХП: " + currentHp;
            if (currentHp >= 0 && currentHp <= 24) {
                System.out.println(ANSI_BLACK + result + ANSI_RESET);
            } else if (currentHp > 24 && currentHp <= 50) {
                System.out.println(ANSI_RED + result + ANSI_RESET);
            } else {
                System.out.println(ANSI_GREEN + result + ANSI_RESET);
            }
        } if (object instanceof HasEnergy hasEnergy) {
            int currentEnergy = hasEnergy.getCurrentEnergy();
            String result = "Энергия: " + currentEnergy;
            if (currentEnergy >= 0 && currentEnergy <= 24) {
                System.out.println(ANSI_BLACK + result + ANSI_RESET);
            } else if (currentEnergy > 24 && currentEnergy <= 50) {
                System.out.println(ANSI_RED + result + ANSI_RESET);
            } else {
                System.out.println(ANSI_GREEN + result + ANSI_RESET);
            }
        }
    }
}
