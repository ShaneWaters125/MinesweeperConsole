import org.example.Tile;
import org.example.TileENUM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TileTest {

    @Test
    public void testConstructor(){
        Tile tile = new Tile(0, 0, TileENUM.EMPTY);
        Assertions.assertEquals(false, tile.isCleared());
    }



}
