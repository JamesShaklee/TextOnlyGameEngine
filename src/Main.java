import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("New Game or continue?");
        String response = "";
        Scanner scanner = new Scanner(System.in);
        response = scanner.nextLine();
        GameMap gameMap = new GameMap();
        Player player = new Player(1);

        if(response.equals("New Game") || !(new File("TextFiles/SaveData.txt").exists())) {
            File rooms = new File("TextFiles/Rooms.txt");
            gameMap.setGameMap(rooms);
        }
        else{
            FileInputStream fileIn = new FileInputStream("TextFiles/SaveData.txt");
            ObjectInputStream saveData = new ObjectInputStream(fileIn);
            gameMap = (GameMap) saveData.readObject();
            player = (Player) gameMap.getSaveData().get("player");
        }


        Map map = gameMap.getMap();

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