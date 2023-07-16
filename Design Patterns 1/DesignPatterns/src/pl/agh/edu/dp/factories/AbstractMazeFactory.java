package pl.agh.edu.dp.factories;

import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;

public class AbstractMazeFactory extends AbstractFactory {
    private static AbstractMazeFactory instance;

    private AbstractMazeFactory() {}

    public static AbstractMazeFactory getInstance(){
        if (instance == null){
            instance = new AbstractMazeFactory();
        }
        return instance;
    }

    @Override
    public Room createRoom(int number) {
        return new Room(number);
    }

    @Override
    public Door createDoor(Room r1, Room r2) {
        return new Door(r1, r2);
    }
    @Override
    public Wall createWall() {
        return new Wall();
    }
}
