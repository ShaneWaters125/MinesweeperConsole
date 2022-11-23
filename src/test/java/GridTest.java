import com.sun.source.tree.AssertTree;
import org.example.Grid;
import org.example.Tile;
import org.example.TileENUM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GridTest {

    @Test
    public void testConstructor(){
        Grid grid = new Grid(10, 10);
        Assertions.assertEquals(10, grid.getCols());
        Assertions.assertEquals(10, grid.getHeight());
    }

    @Test
    public void testGenerateGrid(){
        Grid grid = new Grid(10, 10);
        Tile[][] tiles = grid.getTiles();
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                Assertions.assertEquals(false, tiles[x][y].isCleared());
            }
        }
    }

    @Test
    public void testBombGeneration(){
        Grid grid = new Grid(10, 10);
        boolean hasBombBeenGenerated = false;
        for(int repeat = 0; repeat < 100; repeat++){
            Tile[][] tiles = grid.getTiles();
            for(int x = 0; x < 10; x++){
                for(int y = 0; y < 10; y++){
                    if (tiles[x][y].getType() == TileENUM.BOMB) {
                        hasBombBeenGenerated = true;
                        break;
                    }
                }
            }
        }
        Assertions.assertEquals(true, hasBombBeenGenerated);
    }

    @Test
    public void testFlagAndUnflagTile(){
        Grid grid = new Grid(3, 3);
        Tile[][] tiles = grid.getTiles();
        tiles[0][0].setFlagged(true);
        Assertions.assertEquals(true, tiles[0][0].isFlagged());
        tiles[0][0].setFlagged(false);
        Assertions.assertEquals(false, tiles[0][0].isFlagged());
    }


    @Test
    public void testCalcBombs(){
        Grid grid = new Grid(3, 3);
        Tile[][] tiles = grid.getTiles();
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                if(x == 1 && y == 1){
                    tiles[x][y].setType(TileENUM.EMPTY);
                } else{
                    tiles[x][y].setType(TileENUM.BOMB);
                }
            }
        }
        Assertions.assertEquals(8, grid.calcBombs(1, 1));
    }

    @Test
    public void testAutoReveal(){
        //Make a 3x3 Grid
        Grid grid = new Grid(3, 3);
        Tile[][] tiles = grid.getTiles();
        //Set all tiles to empty
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                tiles[x][y].setType(TileENUM.EMPTY);
            }
        }
        //Set 1 tile to have a bomb
        tiles[2][2].setType(TileENUM.BOMB);
        //Run the auto reveal function
        grid.autoClear(0, 0);
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                //The tile which contains the bomb should be the only tile not to be revealed
                if(x == 2 && y == 2){
                    Assertions.assertEquals(false, tiles[x][y].isCleared());
                } else{
                    Assertions.assertEquals(true, tiles[x][y].isCleared());
                }
            }
        }
    }

    @Test
    public void testCheckValidInput(){
        Grid grid = new Grid(3, 3);
        Assertions.assertEquals(true, grid.checkValidInput(0, 0));
        Assertions.assertEquals(false, grid.checkValidInput(5, 5));
        Assertions.assertEquals(false, grid.checkValidInput(-5, -5));
        Assertions.assertEquals(false, grid.checkValidInput(0, 4));
    }

    @Test
    public void testWin(){
        Grid grid = new Grid(3, 3);
        Tile[][] tiles = grid.getTiles();
        //Check win has its return condition reversed
        Assertions.assertEquals(true, grid.checkWin());
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                tiles[x][y].setType(TileENUM.EMPTY);
                tiles[x][y].setCleared(true);
            }
        }
        Assertions.assertEquals(false, grid.checkWin());
    }



    @Test
    public void testPrint(){
        Grid grid = new Grid(3, 3);
        grid.printGrid(true);
        grid.printGrid(false);
        Assertions.assertTrue(true);
    }


}
