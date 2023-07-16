package pl.agh.edu.dp.builders;

import pl.agh.edu.dp.labirynth.Room;

public abstract class MazeBuilder {
    abstract void addRoom(Room room);
    abstract void addDoor(Room r1, Room r2) throws Exception;
    abstract void commonWall(Room r1, Room r2);
}
