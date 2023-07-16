package pl.agh.edu.dp.builders;


import pl.agh.edu.dp.labirynth.*;

public class StandardBuilderMaze extends MazeBuilder {

    private final Maze currentMaze;

    public StandardBuilderMaze() {
        this.currentMaze = new Maze();
    }

    @Override
    public void addRoom(Room room) {
        room.setSide(Direction.North, new Wall());
        room.setSide(Direction.East, new Wall());
        room.setSide(Direction.South, new Wall());
        room.setSide(Direction.West, new Wall());
        this.currentMaze.addRoom(room);
    }

    @Override
    public void addDoor(Room r1, Room r2) throws Exception {
        if (checkIfRoomsHaveADoor(r1, r2)) {
            throw new Exception("These rooms already have a common door!");
        }
        this.commonWall(r1, r2);
        Direction firstRoomCommonWallDirection = null;
        for (Direction direction: Direction.values()) {
            MapSite r1CommonWallDirection = r1.getSide(direction);
            MapSite r2CommonWallDirection = r2.getSide(direction.getOppositeDirection());
            if (r1CommonWallDirection.equals(r2CommonWallDirection)) {
                firstRoomCommonWallDirection = direction;
                break;
            }
        }
        if (firstRoomCommonWallDirection == null) throw new Exception("These rooms don't have a common wall!");
        else {
            Door door = new Door(r1, r2);
            r1.setSide(firstRoomCommonWallDirection, door);
            r2.setSide(firstRoomCommonWallDirection.getOppositeDirection(), door);
        }
    }

    @Override
    public void commonWall(Room r1, Room r2) {
        Wall wall = new Wall();
        Direction direction = findDirectionForCommonWall(r1, r2);
        r1.setSide(direction, wall);
        r2.setSide(direction.getOppositeDirection(), wall);
    }

    public Maze getCurrentMaze() {
        return this.currentMaze;
    }

    private Direction findDirectionForCommonWall(Room r1, Room r2) {
        Direction[] directionList = Direction.values();
        for (Direction currentDirection : directionList) {
            Direction oppositeDirection = currentDirection.getOppositeDirection();
            if (r1.getSide(currentDirection).getClass() == r2.getSide(oppositeDirection).getClass()) {
                return currentDirection;
            }
        }
        throw new IllegalArgumentException("Cannot make door between Room1 (id: " + r1.getRoomNumber() +
                ") i Room2 (id: " + r2.getRoomNumber() + ")");
    }

    private boolean checkIfRoomsHaveADoor(Room r1, Room r2) {
        Direction[] directions = Direction.values();
        for (Direction direction: directions) {
            if ((r1.getSide(direction).getClass() == Door.class) &&
                    (r2.getSide(direction.getOppositeDirection()).getClass() == Door.class)) {
                return true;
            }
        }
        return false;
    }
}
