package seminar8;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Building build = new Building(100);
        Player keruvim = new Player("keruvim", 100, 150, 5);
        Render render = new Render();
        System.out.println(build);
        System.out.println(keruvim);
        while (true) {
            if (!build.isBroke()) {
                keruvim.attack(build);
                render.render(build);
                render.render(keruvim); 
            } else {
                System.out.println("Здание сломано!");
                break;
            }
            Thread.sleep(1000);
        }
    }
}
