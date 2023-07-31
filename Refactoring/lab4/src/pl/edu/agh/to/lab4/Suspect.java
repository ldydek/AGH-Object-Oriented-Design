package pl.edu.agh.to.lab4;

public abstract class Suspect {

    protected final String name;
    protected final String surname;

    public Suspect(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String display() {
        return name + " " + surname;
    }

    public abstract boolean canBeAccused();
}
