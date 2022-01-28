package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static int size = 3;
    private static int WIDTH = 11 * size - 6;
    private static int HEIGHT = 10 * size;
    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    /**
     * Fills the given 2D array of tiles with RANDOM tiles.
     * @param tiles
     */
    public static void fillWithRandomTiles(TETile[][] tiles) {
        int height = tiles[0].length;
        int width = tiles.length;
        for (int x = 0; x < width; x += 1) {
            for (int y = 0; y < height; y += 1) {
                tiles[x][y] = Tileset.NOTHING;
            }
        }
    }

    /** Picks a RANDOM tile with a 33% change of being
     *  a wall, 33% chance of being a flower, and 33%
     *  chance of being empty space.
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(3);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.GRASS;
            default: return Tileset.LOCKED_DOOR;
        }
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        System.out.println(WIDTH);
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        fillWithRandomTiles(world);
        fillHexagon(world);
        ter.renderFrame(world);
    }

    public static void fillHexagon(TETile[][] tiles) {
        int[] num_hexagon_cols = new int[]{3,4,5,4,3};
        int[] heights = new int[]{2,1,0,1,2};
        int width = 2 * size - 1;

        for (int i = 0; i < 5; ++i) {
            fillHexagonInCol(tiles, i * width, heights[i] * size, num_hexagon_cols[i]);
        }
    }
    public static void fillHexagonInCol(TETile[][] tiles, int x, int y, int num) {
        for (int i = 0; i < num; ++i) {
            fillOneHexagon(tiles, x, y, randomTile());
            y += 2 * size;
        }
    }

    public static void fillOneHexagon(TETile[][] tiles,  int x, int y, TETile pattern) {
        int start_x = x + size - 1;
        int start_y = y;
        // lower half
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < (size + 2*i); ++j) {
                tiles[start_x - i + j][start_y+i] = pattern;
            }
        }
        start_y += 2 * size - 1;
        // upper half
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < (size + 2*i); ++j) {
                tiles[start_x - i + j][start_y - i] = pattern;
            }
        }
    }

}