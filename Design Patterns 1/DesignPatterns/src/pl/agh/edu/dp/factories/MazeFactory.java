package pl.agh.edu.dp.factories;

import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;

public abstract class MazeFactory {
    public abstract Room createRoom(int number);
    public abstract Door createDoor(Room r1, Room r2);
}
