import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import util.StateSwitcher;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class TownCellTest {

    @Test
    void testCensus() throws FileNotFoundException {
        Town town = new Town("C:\\Users\\MkyFl\\IdeaProjects\\Coms228\\Project1\\src\\java\\textFiles\\ISP4x4.txt");
        town.grid[3][3].census(TownCell.nCensus);
        assertEquals(TownCell.nCensus[StateSwitcher.RESELLER], 2); //nCensus[0]
        assertEquals(TownCell.nCensus[StateSwitcher.EMPTY], 0);//nCensus[1]
        assertEquals(TownCell.nCensus[StateSwitcher.CASUAL], 0); //nCensus[2]
        assertEquals(TownCell.nCensus[StateSwitcher.OUTAGE], 1);//nCensus[3]
        assertEquals(TownCell.nCensus[StateSwitcher.STREAMER], 1); //nCensus[4]
    }
}
