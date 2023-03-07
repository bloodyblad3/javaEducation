package seminar8;

public interface HasEnergy {

    int getCurrentEnergy();

}

class EnergyViewer {

    public int viewEnergy(HasEnergy hasEnergy) {
        return hasEnergy.getCurrentEnergy();
    }

}
