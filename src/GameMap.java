import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameMap {

    private Map map = new HashMap<Integer, Room>();
    //private File rooms = new File("TextFiles/Rooms.txt");
    private Map exits = new HashMap<String, Integer>();

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

    public Map connectRooms(Scanner scanner) {
        Map exits = new HashMap<String, Integer>();
        while (scanner.hasNext()) {
            String direction = scanner.next();
            if(direction.equals("-----")){
                break;
            }
            int id = Integer.parseInt(scanner.next());
            exits.put(direction, id);

        }
        return exits;
    }

}
