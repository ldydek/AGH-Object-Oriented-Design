package pl.agh.edu.dp.main;

import pl.agh.edu.dp.builders.CountingMazeBuilder;
import pl.agh.edu.dp.builders.MazeBuilder;
import pl.agh.edu.dp.builders.StandardBuilderMaze;
import pl.agh.edu.dp.factories.BombedMazeFactory;
import pl.agh.edu.dp.factories.MazeFactory;
import pl.agh.edu.dp.labirynth.*;

public class Main {

    public static void main(String[] args) throws Exception {
        MazeGame mazeGame = new MazeGame();
        MazeFactory mazeFactory = new BombedMazeFactory();
        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze();
        CountingMazeBuilder countingMazeBuilder = new CountingMazeBuilder();
        mazeGame.createMaze(standardBuilderMaze, mazeFactory);
        mazeGame.createMaze(countingMazeBuilder, mazeFactory);
        System.out.println("Liczba pokojów w labiryncie: " +
                standardBuilderMaze.getCurrentMaze().getRoomNumbers());
        System.out.println("Liczba utworzonych komponentów w labiryncie: " +
                countingMazeBuilder.getCounts());
    }
}
