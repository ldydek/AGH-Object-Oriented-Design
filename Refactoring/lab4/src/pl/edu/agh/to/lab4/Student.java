package pl.edu.agh.to.lab4;

public class Student extends Suspect {
    private final String index;

    public Student(String name, String surname, int age, String index) {
        super(name, surname, age);
        this.index = index;
    }
}
