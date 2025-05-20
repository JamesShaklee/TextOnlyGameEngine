import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Map;


public class GameMapTest {
    private GameMap gameMap;
    private Map testMap;
    File roomsTest = new File("TextFilesTest/Rooms.txt");
    File rooms = new File("TextFilesTest/Rooms.txt");

    @Before
    public void setUp() throws Exception{
        gameMap = new GameMap();
        gameMap.setGameMap(roomsTest);
        testMap = gameMap.getMap();
    }

    @Test
    public void testGameMapGetMap() throws Exception{
        Assert.assertEquals(testMap, gameMap.getMap());
    }

    @Test
    public void testGameMapSetMap() throws Exception{
        gameMap.setGameMap(rooms);
        Assert.assertEquals(testMap, gameMap.getMap());
    }


}
