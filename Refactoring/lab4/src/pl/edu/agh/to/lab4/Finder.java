package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class Finder {
    private final Collection<CracowCitizen> allCracowCitizens;

    private final Map<String, Collection<Prisoner>> allPrisoners;

    public Finder(Collection<CracowCitizen> allCracowCitizens, Map<String, Collection<Prisoner>> allPrisoners) {
        this.allCracowCitizens = allCracowCitizens;
        this.allPrisoners = allPrisoners;
    }

    public Finder(PeopleDataProvider peopleDataProvider, PrisonersDataProvider prisonersDataProvider) {
        this(peopleDataProvider.getAllCracowCitizens(), prisonersDataProvider.findAll());
    }

    public void displayAllSuspectsWithName(String name) {
        ArrayList<Prisoner> suspectedPrisoners = new ArrayList<>();
        ArrayList<CracowCitizen> suspectedCracowCitizens = new ArrayList<>();

        for (Collection<Prisoner> prisonerCollection : allPrisoners.values()) {
            for (Prisoner prisoner : prisonerCollection) {
                if (isAppropriateSuspect(name, prisoner)) {
                    suspectedPrisoners.add(prisoner);
                }
                if (suspectedPrisoners.size() == 10) {
                    break;
                }
            }
            if (suspectedPrisoners.size() == 10) {
                break;
            }
        }

        if (suspectedPrisoners.size() < 10) {
            for (CracowCitizen cracowCitizen : allCracowCitizens) {
                if (isAppropriateSuspect(name, cracowCitizen)) {
                    suspectedCracowCitizens.add(cracowCitizen);
                }
                if (suspectedPrisoners.size() + suspectedCracowCitizens.size() == 10) {
                    break;
                }
            }
        }

        int numberOfSuspects = suspectedPrisoners.size() + suspectedCracowCitizens.size();
        System.out.println("Znalazlem " + numberOfSuspects + " pasujacych podejrzanych!");

        for (Prisoner prisoner : suspectedPrisoners) {
            System.out.println(prisoner.display());
        }

        for (CracowCitizen cracowCitizen : suspectedCracowCitizens) {
            System.out.println(cracowCitizen.display());
        }
    }

    private boolean isAppropriateSuspect(String name, Suspect suspect) {
        return suspect.canBeAccused() && suspect.getName().equals(name);
    }
}
