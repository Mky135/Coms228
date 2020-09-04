import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StateSwitcherTest {

    /**
     * Tests to see if when given the value 1 it returns State.Empty
     * Used to test whether or not the integer value given returns the correct State
     */
    @Test
    void testReturnStateFromValue() {
        assertEquals(State.EMPTY, StateSwitcher.returnStateFromValue(1));
    }

    /**
     * Tests to see if when given State.Reseller it returns 0
     * Used to test whether or not the State given returns the proper integer value
     */
    @Test
    void testReturnValueFromState() {
        assertEquals(0, StateSwitcher.returnValueFromState(State.RESELLER));
    }

    /**
     * Tests to see if when given State.Streamer it returns "S"
     * Used to test whether or not the State given
     * returns the proper single character string that pertains to the State's first letter
     */
    @Test
    void testReturnLetterOfCellType() {
        assertEquals("S", StateSwitcher.returnLetterOfCellType(State.STREAMER));
    }
}
