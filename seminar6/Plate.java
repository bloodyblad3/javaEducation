package seminar6;

public class Plate {

    int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int foodToDecrease) {
        if (food >= foodToDecrease) {
            food = food - foodToDecrease;
        }
    }

    public void increaseFood(int foodToIncrease) {
        if (foodToIncrease > 0) {
            food = food + foodToIncrease;
        }
    }

    public boolean isEmpty() {
        if (food == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Plate[" + food + "]";
    }

}
