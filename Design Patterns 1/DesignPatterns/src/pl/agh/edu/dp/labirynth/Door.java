package pl.agh.edu.dp.labirynth;

public class Door extends MapSite {

    private final Room room1;
    private final Room room2;

    public Door(Room r1, Room r2) {
        this.room1 = r1;
        this.room2 = r2;
    }

    @Override
    public void Enter(Player player) {
        Room r1 = player.getCurrentRoom();
        if (this.room1.equals(r1)) {
            room2.Enter(player);
        } else {
            room1.Enter(player);
        }
    }
}
