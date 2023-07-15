package pl.agh.edu.dp.labirynth;

import java.util.Vector;

public class Maze {
    private final Vector<Room> rooms;

    Maze() {
        this.rooms = new Vector<>();
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public int getRoomNumbers()
    {
        return rooms.size();
    }
}