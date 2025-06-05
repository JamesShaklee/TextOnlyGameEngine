import java.io.Serializable;

public class Player implements Serializable {
    private int location = 1;

    public Player(int location) {
        this.location = location;
    }

    public void setLocation(int location) {
        if(location == 0){
            System.out.println("You can not go in this direction");
            return;
        }
        this.location = location;
    }

    public int getLocation() {
        return location;
    }
}
