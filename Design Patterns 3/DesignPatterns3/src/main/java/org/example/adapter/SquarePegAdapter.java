package org.example.adapter;

public class SquarePegAdapter extends RoundPeg {

    private final SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        super(squarePeg.getWidth());
        this.squarePeg = squarePeg;
    }

    @Override
    public int getRadius() {
        return (int) (squarePeg.getWidth() * Math.sqrt(2) / 2);
    }
}

