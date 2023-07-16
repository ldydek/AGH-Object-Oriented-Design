package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.builders.StandardBuilderMaze;
import pl.agh.edu.dp.factories.AbstractFactory;
import pl.agh.edu.dp.factories.BombedMazeFactory;
import pl.agh.edu.dp.factories.MazeFactory;

import java.util.Scanner;

public class MazeGame {

    private final Player player = Player.getInstance();

    public MazeGame() throws Exception {
        this.createMaze();
    }

    public void start() {
        System.out.println("Witaj w labiryncie!");
        System.out.println("Spróbuj znaleźć wyjście, ale uważaj na wybuchowe pokoje!");
        System.out.println("Użyj przycisków (a, w, s, d) do poruszania się.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                char input = scanner.next().charAt(0);
                this.player.move(input);
                if (input == 'q') {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Przegrałeś! Trafiłeś na wybuchowy pokój!");
                return;
            }
        }
    }

    private void createMaze() throws Exception {
        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze();


        AbstractFactory bombedMazeFactory = BombedMazeFactory.getInstance();
        System.out.println(bombedMazeFactory);
        bombedMazeFactory = BombedMazeFactory.getInstance();
        System.out.println(bombedMazeFactory);


        AbstractFactory mazeFactory = MazeFactory.getInstance();
        Room r1 = mazeFactory.createRoom(1);
        Room r2 = mazeFactory.createRoom(2);
        Room r3 = bombedMazeFactory.createRoom(3);

        standardBuilderMaze.addRoom(r1);
        standardBuilderMaze.addRoom(r2);
        standardBuilderMaze.addRoom(r3);
        standardBuilderMaze.addDoor(r1, r2);
        standardBuilderMaze.addDoor(r2, r3);

        this.player.setCurrentRoom(r1);
    }
}
