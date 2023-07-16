package pl.agh.edu.dp.main;

import pl.agh.edu.dp.builders.StandardBuilderMaze;
import pl.agh.edu.dp.factories.EnchantedMazeFactory;
import pl.agh.edu.dp.factories.MazeFactory;
import pl.agh.edu.dp.labirynth.*;

public class Main {

    public static void main(String[] args) throws Exception {
        MazeGame mazeGame = new MazeGame();
        MazeFactory mazeFactory = new EnchantedMazeFactory();
        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze();
        mazeGame.createMaze(standardBuilderMaze, mazeFactory);
        System.out.println(standardBuilderMaze.getCurrentMaze().getRoomNumbers());
    }
}
