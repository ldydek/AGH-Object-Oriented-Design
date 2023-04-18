package pl.edu.agh.to.lab4;

public abstract class Suspect {

    private final String name;
    private final String surname;

    public Suspect(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " " + surname;
    }

    public abstract boolean canBeAccused();
}
