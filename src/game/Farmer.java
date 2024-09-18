package game;

public class Farmer extends GameCharacter {
    private final String product;
    private int productivity;


    public Farmer(String name, String clan, int energy, String product, int productivity) {
        super(name, clan, energy);
        if (productivity < 0) {
            throw new IllegalArgumentException("Productivity must be positive");
        }
        this.product = product;
        this.productivity = productivity;
    }

    public int getProductivity() {
        return productivity;
    }
    public void setProductivity(int productivity) {
        if (productivity < 0) {
            throw new IllegalArgumentException("Productivity must be positive");
        }
        this.productivity = productivity;
    }

    @Override
    public String toString() {
        return  super.toString() + " Product: " + product + " Productivity: " + productivity;
    }

    @Override
    public String getSlogan() {
        return "Jetzt moch ma des Farmer Quizzerl gö!";
    }
}
