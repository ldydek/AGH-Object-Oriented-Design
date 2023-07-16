package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.builders.MazeBuilder;
import pl.agh.edu.dp.factories.AbstractFactory;

public class MazeGame {
    public void createMaze(MazeBuilder mazeBuilder, AbstractFactory abstractFactory) throws Exception {
        Room r1 = abstractFactory.createRoom(1);
        Room r2 = abstractFactory.createRoom(2);
        Room r3 = abstractFactory.createRoom(3);

        mazeBuilder.addRoom(r1);
        mazeBuilder.addRoom(r2);
        mazeBuilder.addRoom(r3);
        mazeBuilder.addDoor(r1, r2);
        mazeBuilder.addDoor(r2, r3);
    }
}
