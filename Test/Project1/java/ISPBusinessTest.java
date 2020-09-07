import org.junit.jupiter.api.Test;
import util.Town;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ISPBusinessTest {

    @Test
    void testUpdatePlain() throws FileNotFoundException {
        Town tOld = new Town("C:\\Users\\MkyFl\\IdeaProjects\\Coms228\\Project1\\src\\java\\textFiles\\Example4x4.txt");
        Town tNew =  ISPBusiness.updatePlain(tOld);
        Town town = new Town("C:\\Users\\MkyFl\\IdeaProjects\\Coms228\\Project1\\src\\java\\textFiles\\Example24x4.txt");
        assertEquals(tNew.toString(), town.toString());
    }

    @Test
    void testGetProfit() throws FileNotFoundException {
        Town town = new Town("C:\\Users\\MkyFl\\IdeaProjects\\Coms228\\Project1\\src\\java\\textFiles\\Example4x4.txt");
        assertEquals(1, ISPBusiness.getProfit(town));
    }
}
