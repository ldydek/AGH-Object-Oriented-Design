package pl.edu.agh.to.lab4;

public class CracowCitizen extends Suspect {

    private final int age;

    public CracowCitizen(String name, String surname, int age) {
        super(name, surname);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
