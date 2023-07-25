package org.example.adapter;

public class RoundHole {
    private final int radius;

    public RoundHole(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public boolean fits(RoundPeg roundPeg) {
        return roundPeg.getRadius() <= this.getRadius();
    }
}

