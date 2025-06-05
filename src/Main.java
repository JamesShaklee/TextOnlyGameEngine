import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("New Game");
        File rooms = new File("TextFiles/Rooms.txt");
        GameMap gameMap = new GameMap();
        gameMap.setGameMap(rooms);
        Player player = new Player(1);
        String response = "";

        Map map = gameMap.getMap();

        Scanner scanner = new Scanner(System.in);
        while (!response.equals("QUIT")) { //This starts the game and ends when quit is entered
            Room room = (Room) gameMap.getMap().get(player.getLocation());
            System.out.println(room.getName());
            System.out.println(room.getDescription());
            response = scanner.nextLine().toUpperCase();

            if(room.getExits(response) != -1) {
                player.setLocation(room.getExits(response));
            }

            if(response.equals("SAVE")){
                gameMap.saveGame(player);

                try
                {
                    FileOutputStream fileOut = new FileOutputStream("TextFiles/SaveData.txt");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(gameMap);
                    System.out.println("The game has been saved");
                    out.close();
                    fileOut.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }

        }

    }
}