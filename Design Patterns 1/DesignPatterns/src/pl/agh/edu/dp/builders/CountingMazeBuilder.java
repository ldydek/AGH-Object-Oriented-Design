package pl.agh.edu.dp.builders;

import pl.agh.edu.dp.labirynth.Room;

public class CountingMazeBuilder extends MazeBuilder {

    private int elementsNumber = 0;

    @Override
    public void addRoom(Room room) {
        System.out.println("Dodano pokój nr " + room.getRoomNumber());
        this.elementsNumber += 5;
    }

    @Override
    public void addDoor(Room r1, Room r2) {
        this.commonWall(r1, r2);
        System.out.println("Dodano drzwi pomiędzy pokojem " + r1.getRoomNumber() + " a " +
                r2.getRoomNumber());
    }

    @Override
    void commonWall(Room r1, Room r2) {
        this.elementsNumber--;
    }

    public int getCounts() {
        return this.elementsNumber;
    }
}
