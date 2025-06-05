import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameMap implements Serializable {

    private Map map = new HashMap<Integer, Room>();
    //private File rooms = new File("TextFiles/Rooms.txt");
    private Map exits = new HashMap<String, Integer>();
    private Map<String, Object> saveData = new HashMap<>();

    public void setGameMap(File rooms) throws FileNotFoundException {
        Scanner scanner = new Scanner(rooms);
        int id = 0;
        String name = "";
        String description = "";
        Room room;
        boolean newRoom = true;

        while (scanner.hasNext()) {
            if (scanner.hasNextInt() && newRoom) {
                id = scanner.nextInt();
                scanner.nextLine(); //This is to get rid of an empty line due to a bug with nextInt and nextLine

                newRoom = false;
                name = scanner.nextLine();
            }
            String line = scanner.nextLine();
            if(line.equals("(end)")){
                exits = connectRooms(scanner);
                newRoom = true;
                room = new Room(id, name, description, exits);
                map.put(id, room);
                description = "";
            }
            else{
                description = description.concat(line + "\n");
            }

        }
    }

    public Map getMap() {
        return map;
    }

    public Map getSaveData() {
        return saveData;
    }

    public Map connectRooms(Scanner scanner) {
        Map exits = new HashMap<String, Integer>();
        while (scanner.hasNext()) {
            String direction = scanner.next().toUpperCase();
            if(direction.equals("-----")){
                break;
            }
            int id = Integer.parseInt(scanner.next());
            exits.put(direction, id);

        }
        return exits;
    }



    public  void saveGame(Player player){


        saveData = new HashMap<>();
        saveData.put("map",   map);
        saveData.put("player", player);



        //Map<String, Integer> test = new HashMap<>();
        //test.put("apple", 1);
        //test.put("banana", 2);
        /*
        try
        {
            FileOutputStream fileOut = new FileOutputStream("TextFiles/SaveData.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(saveData);
            System.out.println("The game has been saved");
            out.close();
            fileOut.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

         */
    }

}
