package stateTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import util.State;
import util.Town;

import java.io.FileNotFoundException;

public class StreamerTest {

    @Test
    void nextTest() throws FileNotFoundException {
        Town town = new Town("C:\\Users\\MkyFl\\IdeaProjects\\Coms228\\Project1\\src\\java\\textFiles\\Example4x4.txt");
        assertEquals(town.grid[2][1].next(town).who(), State.OUTAGE);
    }
}
