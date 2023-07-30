package pl.edu.agh.internetshop;

import java.util.ArrayList;

public class CompositeSearchStrategy implements SearchStrategy {

    private final ArrayList<SearchStrategy> searchStrategies;

    public CompositeSearchStrategy() {
        this.searchStrategies = new ArrayList<>();
    }

    public void addStrategy(SearchStrategy searchStrategy) {
        searchStrategies.add(searchStrategy);
    }

    @Override
    public boolean search(Order order) {
        return this.searchStrategies
                .stream()
                .allMatch(searchStrategy -> searchStrategy.search(order));
    }
}
