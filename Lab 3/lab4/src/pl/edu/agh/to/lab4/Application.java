package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        PrisonersDatabase prisonersDatabase = new PrisonersDatabase();
        prisonersDatabase.generateData();
        PersonDataProvider personDataProvider = new PersonDataProvider();
        personDataProvider.generateData();
        List<SuspectAggregate> databases = new ArrayList<>();
        databases.add(personDataProvider);
        databases.add(prisonersDatabase);
        CompositeAggregate compositeAggregate = new CompositeAggregate(databases);
        Finder suspects = new Finder(compositeAggregate);
        suspects.displayAllSuspectsWithName("Janusz");
    }
}
