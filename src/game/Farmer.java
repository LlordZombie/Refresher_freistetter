package game;

public class Farmer extends GameCharacter {
    private String product;
    private int productivity;


    public Farmer(String name, String clan, int energy, String product, int productivity) {
        super(name, clan, energy);
        this.product = product;
        this.productivity = productivity;
    }

    public int getProductivity() {
        return productivity;
    }
    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + super.toString() + " Product: " + product + " Productivity: " + productivity;
    }

    @Override
    public String getSlogan() {
        return "Jetzt moch ma des Farmer Quizzerl gö!";
    }
}
