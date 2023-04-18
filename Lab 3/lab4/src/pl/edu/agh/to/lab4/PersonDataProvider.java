package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PersonDataProvider implements SuspectAggregate {

    private final Collection<Person> cracowCitizens = new ArrayList<>();

    public PersonDataProvider() {

    }

    @Override
    public Iterator<Suspect> iterator() {
        return new SuspectIterator(cracowCitizens.iterator());
    }

    public void generateData() {
        addCracowCitizen("Jan", "Kowalski", 30);
        addCracowCitizen("Janusz", "Krakowski", 30);
        addCracowCitizen("Janusz", "Mlodociany", 10);
        addCracowCitizen("Kasia", "Kosinska", 19);
        addCracowCitizen("Piotr", "Zgredek", 29);
        addCracowCitizen("Tomek", "Gimbus", 14);
        addCracowCitizen("Janusz", "Gimbus", 15);
        addCracowCitizen("Alicja", "Zaczarowana", 22);
        addCracowCitizen("Janusz", "Programista", 77);
        addCracowCitizen("Pawel", "Pawlowicz", 32);
        addCracowCitizen("Krzysztof", "Mendel", 30);
    }

    public Collection<Person> getAllCracowCitizens() {
        return cracowCitizens;
    }

    private void addCracowCitizen(String firstName, String lastName, int age) {
        this.cracowCitizens.add(new Person(firstName, lastName, age));
    }
}
