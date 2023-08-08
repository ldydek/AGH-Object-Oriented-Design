package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StudentsDataProvider implements SuspectAggregate {

    private final Collection<Student> students = new ArrayList<>();

    public StudentsDataProvider() {
        students.add(new Student("Jan", "Student", 24, "305123"));
        students.add(new Student("Janusz", "Pilny", 30, "305124"));
        students.add(new Student("Janusz", "Len", 30, "305125"));
        students.add(new Student("Kasia", "Imprezowa", 21, "305126"));
        students.add(new Student("Piotr", "Nowak", 22, "305127"));
        students.add(new Student("Tomek", "Kwiatkowski", 23, "305128"));
        students.add(new Student("Janusz", "Kwiat", 24, "305129"));
        students.add(new Student("Alicja", "Czar", 25, "305133"));
        students.add(new Student("Janusz", "Ptak", 22, "305143"));
        students.add(new Student("Pawel", "Gawlowski", 21, "305153"));
        students.add(new Student("Krzysztof", "Kot", 20, "305163"));
    }

    public Collection<Student> getAllStudentsCitizens() {
        return this.students;
    }

    @Override
    public Iterator<? extends Suspect> iterator() {
        return students.iterator();
    }
}
