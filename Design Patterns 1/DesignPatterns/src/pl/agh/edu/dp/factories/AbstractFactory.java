package pl.agh.edu.dp.factories;

import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;

public abstract class AbstractFactory {
    public abstract Room createRoom(int number);
    public abstract Door createDoor(Room r1, Room r2);
    public abstract Wall createWall();
}
