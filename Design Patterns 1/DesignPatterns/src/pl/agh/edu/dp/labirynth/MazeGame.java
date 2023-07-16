package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.builders.MazeBuilder;
import pl.agh.edu.dp.builders.StandardBuilderMaze;
import pl.agh.edu.dp.factories.MazeFactory;

public class MazeGame {
    public void createMaze(MazeBuilder mazeBuilder, MazeFactory mazeFactory) throws Exception {
        Room r1 = mazeFactory.createRoom(1);
        Room r2 = mazeFactory.createRoom(2);
        Room r3 = mazeFactory.createRoom(3);

        mazeBuilder.addRoom(r1);
        mazeBuilder.addRoom(r2);
        mazeBuilder.addRoom(r3);
        mazeBuilder.addDoor(r1, r2);
        mazeBuilder.addDoor(r2, r3);
    }
}
