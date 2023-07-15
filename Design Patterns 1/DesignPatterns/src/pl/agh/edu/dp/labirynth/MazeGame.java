package pl.agh.edu.dp.labirynth;

public class MazeGame {
    public void createMaze(MazeBuilder builder) throws Exception {
        Room r1 = new Room(1);
        Room r2 = new Room(2);

        builder.addRoom(r1);
        builder.addRoom(r2);
        builder.addDoor(r1, r2);
    }
}
