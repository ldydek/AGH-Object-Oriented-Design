package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;

public class Main {

    public static void main(String[] args) throws Exception {
        MazeGame mazeGame = new MazeGame();
        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze();
        CountingMazeBuilder countingMazeBuilder = new CountingMazeBuilder();

        mazeGame.createMaze(standardBuilderMaze);
        System.out.println("Liczba pokojów w labiryncie: " + standardBuilderMaze.getCurrentMaze().getRoomNumbers());

        mazeGame.createMaze(countingMazeBuilder);
        System.out.println("Liczba elementów w labiryncie: " + countingMazeBuilder.getCounts());
    }
}
