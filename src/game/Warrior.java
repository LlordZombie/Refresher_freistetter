package game;

public class Warrior extends GameCharacter {
    private final String weapon;
    private int force;

    public Warrior(String name, String clan, int energy, String weapon, int force) {
        super(name, clan, energy);
        if (force < 0) {
            throw new IllegalArgumentException("Force must be positive");
        }
        this.weapon = weapon;
        this.force = force;
    }

    @Override
    public String toString() {
        return super.toString() + " Weapon: " + weapon + " Force: " + force;
    }

    @Override
    public String getSlogan() {
        return "Kampf den bösen Mächten!";
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        if (force < 0) {
            throw new IllegalArgumentException("Force must be positive");
        }
        this.force = force;
    }
}
