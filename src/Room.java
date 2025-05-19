import java.util.HashMap;
import java.util.Map;

public class Room {
    private int id;
    private String name;
    private String description;
    private Map exits = new HashMap<String, Integer>();
    private Items items = new Items();

    public Room(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExits(String direction, int id) {
        exits.put(direction, id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getExits(String direction) {
        return (int) exits.getOrDefault(direction, 0);
    }



}
