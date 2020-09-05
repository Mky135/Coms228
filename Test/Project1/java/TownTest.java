import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import util.State;

import java.io.FileNotFoundException;

public class TownTest {

    @Test
    void testTownFromFile() throws FileNotFoundException {
        Town town = new Town("C:\\Users\\MkyFl\\IdeaProjects\\Coms228\\Project1\\src\\java\\textFiles\\ISP16x16.txt");
        assertEquals(16, town.getLength());
        assertEquals(16, town.getWidth());
        assertEquals(State.RESELLER, town.grid[12][13].who());
    }
}
