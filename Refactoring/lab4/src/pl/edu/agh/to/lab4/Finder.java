package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Iterator;

public class Finder {
    private final SuspectAggregate allCracowCitizens;
    private final SuspectAggregate allPrisoners;

    public Finder(PeopleDataProvider peopleDataProvider, PrisonersDataProvider prisonersDataProvider) {
        this.allCracowCitizens = peopleDataProvider;
        this.allPrisoners = prisonersDataProvider;
    }

    public void displayAllSuspectsWithName(String name) {
        ArrayList<Suspect> suspects = new ArrayList<>();

        Iterator<? extends Suspect> prisonersIterator = allPrisoners.iterator();
        Iterator<? extends Suspect> cracowCitizensIterator = allCracowCitizens.iterator();

        while (prisonersIterator.hasNext() && suspects.size() < 10) {
            Suspect suspect = prisonersIterator.next();
            if (isAppropriateSuspect(name, suspect)) suspects.add(suspect);
        }

        while (cracowCitizensIterator.hasNext() && suspects.size() < 10) {
            Suspect suspect = cracowCitizensIterator.next();
            if (isAppropriateSuspect(name, suspect)) suspects.add(suspect);
        }

        int numberOfSuspects = suspects.size();
        System.out.println("Znalazlem " + numberOfSuspects + " pasujacych podejrzanych!");

        suspects.forEach(suspect -> System.out.println(suspect.display()));
    }

    private boolean isAppropriateSuspect(String name, Suspect suspect) {
        return suspect.canBeAccused() && suspect.getName().equals(name);
    }
}
