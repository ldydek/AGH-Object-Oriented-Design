package pl.edu.agh.to.lab4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FinderTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PrintStream originalOut;

    private PeopleDataProvider peopleDataProvider;

    private PrisonersDataProvider prisonersDataProvider;

    private Finder suspectFinder;

    private SearchStrategy searchStrategy;

    @Before
    public void setUp() {
        peopleDataProvider = new PeopleDataProvider();
        prisonersDataProvider = new PrisonersDataProvider();
        List<SuspectAggregate> suspectAggregates = new ArrayList<>();
        suspectAggregates.add(peopleDataProvider);
        suspectAggregates.add(prisonersDataProvider);
        searchStrategy = new NameSearchStrategy("Janusz");
        suspectFinder = new Finder(new CompositeAggregate(suspectAggregates));
    }

    @Test
    public void testDisplayingNotJailedPrisoner() {
        addPrisoner(new Prisoner("Jan", "Kowalski", "802104543357", 2000, 1, 30));
        suspectFinder.displayAllSuspects(searchStrategy);
        assertContentIsDisplayed();
    }

    @Test
    public void testDisplayingSuspectedPerson() {
        peopleDataProvider.getAllCracowCitizens().add(new CracowCitizen("Jan", "Kowalski", 20));
        suspectFinder.displayAllSuspects(searchStrategy);
        assertContentIsDisplayed();
    }

    @Test
    public void testNotDisplayingTooYoungPerson() {
        peopleDataProvider.getAllCracowCitizens().add(new CracowCitizen("Jan", "Kowalski", 15));
        suspectFinder.displayAllSuspects(searchStrategy);
        assertContentIsNotDisplayed("Jan Kowalski");
    }

    @Test
    public void testNotDisplayingJailedPrisoner() {
        peopleDataProvider.getAllCracowCitizens().add(new CracowCitizen("Jan", "Kowalski", 20));
        addPrisoner(new Prisoner("Jan", "Kowalski2", "802104543357", 2000, 20, 34));
        suspectFinder.displayAllSuspects(searchStrategy);
        assertContentIsNotDisplayed("Jan Kowalski2");
    }

    private void assertContentIsDisplayed() {
        assertTrue("Application did not contain expected content: " + outContent, outContent.toString()
                .contains("Jan Kowalski"));
    }

    private void assertContentIsNotDisplayed(String expectedContent) {
        assertFalse("Application did contain expected content although it should not: " + outContent, outContent.toString()
                .contains(expectedContent));
    }

    @Before
    public void redirectSystemOut() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void resetSystemOut() {
        System.setOut(originalOut);
    }

    private void addPrisoner(Prisoner news) {
        Map<String, Collection<Prisoner>> allPrisoners = prisonersDataProvider.findAll();
        if (!allPrisoners.containsKey("Wiezeienie stanowe"))
            allPrisoners.put("Wiezeienie stanowe", new ArrayList<>());
        allPrisoners.get("Wiezeienie stanowe").add(news);
    }
}
