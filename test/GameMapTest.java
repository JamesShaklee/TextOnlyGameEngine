import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Map;


public class GameMapTest {
    private GameMap gameMap;
    private Map testMap;

    @Before
    public void setUp() throws Exception{
        gameMap = new GameMap();
    }

    @Test
    public void testGameMapGetMap() throws Exception{
        testMap = gameMap.getMap();
        Assert.assertEquals(testMap, gameMap.getMap());

    }


}
