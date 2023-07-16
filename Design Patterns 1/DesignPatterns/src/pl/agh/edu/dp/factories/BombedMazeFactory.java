package pl.agh.edu.dp.factories;

import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;
import pl.agh.edu.dp.products.bombed.BombedRoom;
import pl.agh.edu.dp.products.bombed.BombedWall;

public class BombedMazeFactory extends MazeFactory {
    @Override
    public Room createRoom(int number) {
        return new BombedRoom(number);
    }

    @Override
    public Door createDoor(Room r1, Room r2) {
        return null;
    }

    @Override
    public Wall createWall() {
        return new BombedWall();
    }
}
