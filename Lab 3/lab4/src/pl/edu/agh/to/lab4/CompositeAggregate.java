package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CompositeAggregate implements SuspectAggregate {

    private final List<SuspectAggregate> aggregates;

    public CompositeAggregate(List<SuspectAggregate> databases) {
        this.aggregates = databases;
    }

    @Override
    public Iterator<Suspect> iterator() {
        Collection<Suspect> suspects = new ArrayList<>();
        aggregates.forEach(data -> {
            Iterator<Suspect> iterator = data.iterator();
            while (iterator.hasNext()) {
                suspects.add(iterator.next());
            }
        });
        return suspects.iterator();
    }

    @Override
    public void generateData() {

    }
}
