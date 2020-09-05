import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import util.State;
import util.StateSwitcher;

public class StateSwitcherTest {

    /**
     * Tests to see if when given the value 1 it returns util.State.Empty
     * Used to test whether or not the integer value given returns the correct util.State
     */
    @Test
    void testReturnStateFromValue() {
        assertEquals(State.EMPTY, StateSwitcher.returnStateFromValue(1));
    }

    /**
     * Tests to see if when given util.State.Reseller it returns 0
     * Used to test whether or not the util.State given returns the proper integer value
     */
    @Test
    void testReturnValueFromState() {
        assertEquals(0, StateSwitcher.returnValueFromState(State.RESELLER));
    }

    /**
     * Tests to see if when given util.State.Streamer it returns "S"
     * Used to test whether or not the util.State given
     * returns the proper single character string that pertains to the util.State's first letter
     */
    @Test
    void testReturnLetterOfCellType() {
        assertEquals("S", StateSwitcher.returnLetterOfCellType(State.STREAMER));
    }
}
