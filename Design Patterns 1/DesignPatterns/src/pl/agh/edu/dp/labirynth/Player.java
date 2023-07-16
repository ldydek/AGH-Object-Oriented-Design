package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.products.bombed.BombedRoom;

public class Player {
    private Room currentRoom;
    private static Player instance;

    private Player() {}

    public static Player getInstance(){
        if (instance == null){
            instance = new Player();
        }
        return instance;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void move(char x) throws Exception {
        switch (x) {
            case 'a' -> {
                this.moveLeft();
            }
            case 'd' -> {
                this.moveRight();
            }
            case 'w' -> {
                this.moveUp();
            }
            case 's' -> {
                this.moveDown();
            }
        }
        System.out.println("Aktualny numer pokoju: " + this.currentRoom.getRoomNumber());
        if (this.currentRoom.getClass() == BombedRoom.class) {
            throw new Exception();
        }
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    private void moveLeft() {
        if (canGoTo(Direction.East)) {
            currentRoom.getSide(Direction.East).Enter(this);
        }
    }

    private void moveRight() {
        if (canGoTo(Direction.West)) {
            currentRoom.getSide(Direction.West).Enter(this);
        }
    }

    private void moveUp() {
        if (canGoTo(Direction.North)) {
            currentRoom.getSide(Direction.North).Enter(this);
        }
    }

    private void moveDown() {
        if (canGoTo(Direction.South)) {
            currentRoom.getSide(Direction.South).Enter(this);
        }
    }

    private boolean canGoTo(Direction direction) {
        return currentRoom.getSide(direction) instanceof Door;
    }
}
