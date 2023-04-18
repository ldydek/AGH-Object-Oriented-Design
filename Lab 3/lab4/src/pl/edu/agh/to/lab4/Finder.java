package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Iterator;

public class Finder {

    private final CompositeAggregate compositeAggregate;

    public Finder(CompositeAggregate compositeAggregate) {
        this.compositeAggregate = compositeAggregate;
    }

    public void displayAllSuspectsWithName(String name) {
        ArrayList<Suspect> suspects = new ArrayList<>();
        Iterator<? extends Suspect> suspectIterator = compositeAggregate.iterator();

        while (suspectIterator.hasNext()) {
            Suspect tempSuspect = suspectIterator.next();
            if (isSuitableSuspect(tempSuspect, name)) {
                suspects.add(tempSuspect);
                if (suspects.size() >= 10) {
                    break;
                }
            }
        }

        System.out.println("Znalazlem " + suspects.size() + " pasujacych podejrzanych!");
        suspects.forEach(suspect -> System.out.println(suspect.toString()));
    }


    private boolean isSuitableSuspect(Suspect suspect, String name) {
        return suspect.canBeAccused() && suspect.getName().equals(name);
    }
}
