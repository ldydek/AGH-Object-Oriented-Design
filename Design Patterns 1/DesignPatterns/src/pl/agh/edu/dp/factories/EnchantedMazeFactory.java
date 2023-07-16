package pl.agh.edu.dp.factories;

import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.products.enchanted.EnchantedDoor;
import pl.agh.edu.dp.products.enchanted.EnchantedRoom;

public class EnchantedMazeFactory extends MazeFactory {

    @Override
    public Room createRoom(int number) {
        return new EnchantedRoom(number);
    }

    @Override
    public Door createDoor(Room r1, Room r2) {
        return new EnchantedDoor(r1, r2);
    }
}
