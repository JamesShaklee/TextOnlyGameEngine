import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("New Game");
        GameMap gameMap = new GameMap();
        gameMap.setGameMap();

        /*
        File rooms = new File("TextFiles/Rooms.txt");
        Scanner scanner = new Scanner(rooms);
        boolean newRoom = true;

        while (scanner.hasNext()) {
            if (scanner.hasNextInt() && newRoom) {
                int id = scanner.nextInt();

                newRoom = false;
                //String name = scanner.next();
            }
            String line = scanner.next();
            if (line.equals("-----")){
                newRoom = true;
            }
            System.out.println(line);
        }
         */

    }
}