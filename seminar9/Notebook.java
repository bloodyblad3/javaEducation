package seminar9;

public class Notebook implements Comparable<Notebook> {
    
    private int cost;
    private int RAM;

    public Notebook(int cost, int RAM) {
        this.cost = cost;
        this.RAM = RAM;
    }

    public int getCost() {
        return cost;
    }

    public int getRAM() {
        return RAM;
    }

    @Override
    public String toString() {
        return String.format("Цена: %d ОЗУ: %d", cost, RAM);
    }

    @Override
    public int compareTo(Notebook o) {
        return this.cost - o.cost;
    }
    
}
