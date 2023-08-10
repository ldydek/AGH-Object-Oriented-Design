package pl.edu.agh.to.lab4;

import java.util.Iterator;

public class FlatIterator implements Iterator<Prisoner> {

    private final Iterator<Prisoner> prisonerIterator;

    public FlatIterator(Iterator<Prisoner> prisonerIterator) {
        this.prisonerIterator = prisonerIterator;
    }

    @Override
    public boolean hasNext() {
        return prisonerIterator.hasNext();
    }

    @Override
    public Prisoner next() {
        return prisonerIterator.next();
    }
}
