package pl.agh.edu.dp.labirynth;

public abstract class MazeBuilder {
    abstract void addRoom(Room room);
    abstract void addDoor(Room r1, Room r2) throws Exception;
    abstract void commonWall(Room r1, Room r2);
}
