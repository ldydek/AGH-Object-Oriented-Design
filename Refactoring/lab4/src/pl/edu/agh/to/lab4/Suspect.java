package pl.edu.agh.to.lab4;

public abstract class Suspect {

    protected final String name;
    protected final String surname;

    protected int age;

    public Suspect(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
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

    public boolean canBeAccused() {
        return this.age >= 18;
    }

    public int getAge() {
        return this.age;
    }
}
