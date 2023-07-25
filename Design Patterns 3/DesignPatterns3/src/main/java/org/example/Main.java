package org.example;

import org.example.adapter.RoundHole;
import org.example.adapter.SquarePeg;
import org.example.adapter.SquarePegAdapter;

public class Main {
    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(5);

        SquarePeg smallSquarePeg = new SquarePeg(5);
        SquarePeg largeSquarePeg = new SquarePeg(10);

        SquarePegAdapter smallSquarePegAdapter = new SquarePegAdapter(smallSquarePeg);
        SquarePegAdapter largeSquarePegAdapter = new SquarePegAdapter(largeSquarePeg);

        System.out.println(roundHole.fits(smallSquarePegAdapter));
        System.out.println(roundHole.fits(largeSquarePegAdapter));
    }
}