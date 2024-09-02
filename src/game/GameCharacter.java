package game;

public abstract class GameCharacter {
    private final String name;
    private final String clan;
    private int energy;

    public GameCharacter(String name, String clan, int energy) {
        this.name = name;
        this.clan = clan;
        this.energy = energy;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Clan: " + clan + " Energy: " + energy;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public abstract String getSlogan();
}
