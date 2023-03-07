package seminar8;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Building build = new Building(1000);
        Player keruvim = new Player("keruvim", 100, 150, 50);
        Render render = new Render();
        HealthPointViewer healthPointViewer = new HealthPointViewer();
        EnergyViewer energyViewer = new EnergyViewer();
        while (!build.isBroke()) {
            keruvim.attack(build);
            render.render(build.getCurrentHealthPoint());
            render.render(healthPointViewer.viewHealthPoint(keruvim));
            render.render(energyViewer.viewEnergy(keruvim));
            Thread.sleep(1000);
        }
    }
}
