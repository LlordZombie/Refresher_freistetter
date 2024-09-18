package game;

public abstract class GameCharacter {
    private final String name;
    private final String clan;
    private int energy;

    public GameCharacter(String name, String clan, int energy) {
        if (energy < 0) {
            throw new IllegalArgumentException("Energy must be positive");
        }
        this.name = name;
        this.clan = clan;
        this.energy = energy;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+ ": Name: " + name + " Clan: " + clan + " Energy: " + energy;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if (energy < 0) {
            throw new IllegalArgumentException("Energy must be positive");
        }
        this.energy = energy;
    }

    public abstract String getSlogan();
}
