package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CompositeAggregate implements SuspectAggregate {

    private final List<SuspectAggregate> suspectAggregates;

    public CompositeAggregate(List<SuspectAggregate> suspectAggregates) {
        this.suspectAggregates = suspectAggregates;
    }

    @Override
    public Iterator<? extends Suspect> iterator() {
        Collection<Suspect> suspects = new ArrayList<>();
        for (SuspectAggregate suspectAggregate: suspectAggregates) {
            Iterator<? extends Suspect> suspectIterator = suspectAggregate.iterator();
            while (suspectIterator.hasNext()) suspects.add(suspectIterator.next());
        }
        return suspects.iterator();
    }
}
