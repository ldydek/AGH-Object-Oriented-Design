package pl.agh.edu.dp.factories;

import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;

public class MazeFactory extends AbstractFactory {
    private static MazeFactory instance;

    private MazeFactory() {}

    public static MazeFactory getInstance(){
        if (instance == null){
            instance = new MazeFactory();
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
