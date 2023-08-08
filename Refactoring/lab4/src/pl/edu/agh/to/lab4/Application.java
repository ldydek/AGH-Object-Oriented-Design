package pl.edu.agh.to.lab4;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        ArrayList<SuspectAggregate> suspectAggregates = new ArrayList<>();

        suspectAggregates.add(new PrisonersDataProvider());
        suspectAggregates.add(new PeopleDataProvider());
        suspectAggregates.add(new StudentsDataProvider());

        CompositeAggregate allSuspects = new CompositeAggregate(suspectAggregates);
        CompositeSearchStrategy compositeSearchStrategy = new CompositeSearchStrategy();
        compositeSearchStrategy.addStrategy(new NameSearchStrategy("Janusz"));
        compositeSearchStrategy.addStrategy(new AgeSearchStrategy(30));
        Finder suspects = new Finder(allSuspects);
        suspects.displayAllSuspects(compositeSearchStrategy);
    }
}
