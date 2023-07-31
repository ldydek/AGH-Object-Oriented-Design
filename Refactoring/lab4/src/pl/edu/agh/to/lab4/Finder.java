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

    public Finder(PersonDataProvider personDataProvider, PrisonersDatabase prisonersDatabase) {
        this(personDataProvider.getAllCracowCitizens(), prisonersDatabase.findAll());
    }

    public void displayAllSuspectsWithName(String name) {
        ArrayList<Prisoner> suspectedPrisoners = new ArrayList<>();
        ArrayList<CracowCitizen> suspectedCracowCitizens = new ArrayList<>();

        for (Collection<Prisoner> prisonerCollection : allPrisoners.values()) {
            for (Prisoner prisoner : prisonerCollection) {
                if (!prisoner.isJailedNow() && prisoner.getName().equals(name)) {
                    suspectedPrisoners.add(prisoner);
                }
                if (suspectedPrisoners.size() >= 10) {
                    break;
                }
            }
            if (suspectedPrisoners.size() >= 10) {
                break;
            }
        }

        if (suspectedPrisoners.size() < 10) {
            for (CracowCitizen cracowCitizen : allCracowCitizens) {
                if (cracowCitizen.getAge() > 18 && cracowCitizen.getName().equals(name)) {
                    suspectedCracowCitizens.add(cracowCitizen);
                }
                if (suspectedPrisoners.size() + suspectedCracowCitizens.size() >= 10) {
                    break;
                }
            }
        }

        int t = suspectedPrisoners.size() + suspectedCracowCitizens.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Prisoner p : suspectedPrisoners) {
            System.out.println(p.display());
        }

        for (CracowCitizen p : suspectedCracowCitizens) {
            System.out.println(p.display());
        }
    }
}
