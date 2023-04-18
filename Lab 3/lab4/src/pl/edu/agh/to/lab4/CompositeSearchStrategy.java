package pl.edu.agh.to.lab4;

import java.util.ArrayList;

public class CompositeSearchStrategy implements SearchStrategy {

    private final ArrayList<SearchStrategy> filters;

    public CompositeSearchStrategy(ArrayList<SearchStrategy> filters) {
        this.filters = filters;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return filters.stream().allMatch(s -> s.filter(suspect));
    }
}
