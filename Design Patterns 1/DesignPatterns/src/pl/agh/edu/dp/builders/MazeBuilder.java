package pl.agh.edu.dp.builders;

import pl.agh.edu.dp.labirynth.Room;

public abstract class MazeBuilder {

    public abstract void addRoom(Room room);
    public abstract void addDoor(Room r1, Room r2) throws Exception;
    abstract void commonWall(Room r1, Room r2);
}
