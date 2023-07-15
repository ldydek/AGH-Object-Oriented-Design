package pl.agh.edu.dp.labirynth;

public class CountingMazeBuilder extends MazeBuilder {

    private int elementsNumber = 0;

    @Override
    void addRoom(Room room) {
        this.elementsNumber += 5;
    }

    @Override
    void addDoor(Room r1, Room r2) {
        this.commonWall(r1, r2);
    }

    @Override
    void commonWall(Room r1, Room r2) {
        this.elementsNumber--;
    }

    public int getCounts() {
        return this.elementsNumber;
    }
}
