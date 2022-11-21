import org.example.Tile;
import org.example.TileENUM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TileTest {

    @Test
    public void testConstructor(){
        Tile tile = new Tile(0, 0, TileENUM.EMPTY);
        Assertions.assertEquals(0, tile.getX(), "x value does not match value given");
        Assertions.assertEquals(0, tile.getY(), "y value does not match value given");
        Assertions.assertEquals(TileENUM.EMPTY, tile.getType(), "type does not match type given");
    }

    @Test
    public void testSetters(){
        Tile tile = new Tile(0, 0, TileENUM.EMPTY);
        tile.setX(1);
        Assertions.assertEquals(1, tile.getX(), "x value does not match value given");
        tile.setY(1);
        Assertions.assertEquals(1, tile.getY(), "Y value does not match value given");
        tile.setType(TileENUM.BOMB);
        Assertions.assertEquals(TileENUM.BOMB, tile.getType(), "type does not match type given");
    }
}
