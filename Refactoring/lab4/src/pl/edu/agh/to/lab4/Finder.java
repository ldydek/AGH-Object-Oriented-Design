package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Iterator;

public class Finder {

    private final CompositeAggregate compositeAggregate;

    public Finder(CompositeAggregate compositeAggregate) {
        this.compositeAggregate = compositeAggregate;
    }

    public void displayAllSuspects(SearchStrategy searchStrategy) {
        ArrayList<Suspect> suspects = new ArrayList<>();

        Iterator<? extends Suspect> suspectIterator = compositeAggregate.iterator();

        while (suspectIterator.hasNext() && suspects.size() < 10) {
            Suspect suspect = suspectIterator.next();
            if (isAppropriateSuspect(searchStrategy, suspect)) suspects.add(suspect);
        }

        int numberOfSuspects = suspects.size();
        System.out.println("Znalazlem " + numberOfSuspects + " pasujacych podejrzanych!");

        suspects.forEach(suspect -> System.out.println(suspect.display()));
    }

    private boolean isAppropriateSuspect(SearchStrategy searchStrategy, Suspect suspect) {
        return suspect.canBeAccused() && searchStrategy.filter(suspect);
    }
}
