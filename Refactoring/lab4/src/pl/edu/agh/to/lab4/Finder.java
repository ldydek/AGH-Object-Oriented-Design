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
        ArrayList<Suspect> suspects = new ArrayList<>();

        for (Collection<Prisoner> prisonerCollection : allPrisoners.values()) {
            for (Prisoner prisoner : prisonerCollection) {
                if (isAppropriateSuspect(name, prisoner)) {
                    suspects.add(prisoner);
                }
                if (suspects.size() == 10) {
                    break;
                }
            }
            if (suspects.size() == 10) {
                break;
            }
        }

        if (suspects.size() < 10) {
            for (CracowCitizen cracowCitizen : allCracowCitizens) {
                if (isAppropriateSuspect(name, cracowCitizen)) {
                    suspects.add(cracowCitizen);
                }
                if (suspects.size() + suspects.size() == 10) {
                    break;
                }
            }
        }

        int numberOfSuspects = suspects.size() + suspects.size();
        System.out.println("Znalazlem " + numberOfSuspects + " pasujacych podejrzanych!");

        for (Suspect suspect : suspects) {
            System.out.println(suspect.display());
        }
    }

    private boolean isAppropriateSuspect(String name, Suspect suspect) {
        return suspect.canBeAccused() && suspect.getName().equals(name);
    }
}
