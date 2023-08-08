package pl.edu.agh.to.lab4;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        ArrayList<SuspectAggregate> suspectAggregates = new ArrayList<>();

        suspectAggregates.add(new PrisonersDataProvider());
        suspectAggregates.add(new PeopleDataProvider());

        CompositeAggregate allSuspects = new CompositeAggregate(suspectAggregates);
        Finder suspects = new Finder(allSuspects);
        suspects.displayAllSuspectsWithName("Janusz");
    }
}
