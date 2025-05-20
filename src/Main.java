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
        Player player = new Player(1);
        String response = "";

        Map map = gameMap.getMap();

        Scanner scanner = new Scanner(System.in);
        while (!response.equals("quit")) {
            Room room = (Room) gameMap.getMap().get(player.getLocation());
            System.out.println(room.getName());
            System.out.println(room.getDescription());
            response = scanner.nextLine();

            if(room.getExits(response) != -1) {
                player.setLocation(room.getExits(response));
            }
        }

    }
}