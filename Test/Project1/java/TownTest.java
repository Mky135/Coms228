import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import util.State;
import util.Town;

import java.io.FileNotFoundException;

public class TownTest {

    @Test
    void testTownFromFile() throws FileNotFoundException {
        Town town = new Town("C:\\Users\\MkyFl\\IdeaProjects\\Coms228\\Project1\\src\\java\\textFiles\\ISP4x4.txt");
        assertEquals(4, town.getLength());
        assertEquals(4, town.getWidth());
        assertEquals(State.CASUAL, town.grid[1][2].who());
    }
}
