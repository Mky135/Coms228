/**
 * @author Miguel FLores
 */
public class StateSwitcher {

    // constants to be used as indices.
    public static final int RESELLER = 0;
    public static final int EMPTY = 1;
    public static final int CASUAL = 2;
    public static final int OUTAGE = 3;
    public static final int STREAMER = 4;

    /**
     * Return a State that corresponds to a numerical value
     *
     * @param value A number between 0-4 inclusive
     * @return A State that corresponds to the value
     */
    public static State returnStateFromValue(int value) {
        switch (value) {
            case RESELLER:
                return State.RESELLER;
            case EMPTY:
                return State.EMPTY;
            case CASUAL:
                return State.CASUAL;
            case OUTAGE:
                return State.OUTAGE;
            case STREAMER:
                return State.STREAMER;
        }
        return null;
    }

    /**
     * Returns an integer that corresponds to it's State
     *
     * @param state State that should needs to be converted into an integer
     * @return a numerical value of the corresponding State
     */
    public static int returnValueFromState(State state)
    {
        switch (state) {
            case RESELLER:
                return RESELLER;
            case EMPTY:
                return EMPTY;
            case CASUAL:
                return CASUAL;
            case OUTAGE:
                return OUTAGE;
            case STREAMER:
                return STREAMER;
        }
        return -1;
    }

    /**
     * Returns a single character String that corresponds to the letter of the TownCell type's state
     *
     * @param state State of the TownCell
     * @return Single Letter String
     */
    public static String returnLetterOfCellType(State state) {
        switch (state) {
            case EMPTY:
                return "E";
            case CASUAL:
                return "C";
            case OUTAGE:
                return "O";
            case RESELLER:
                return "R";
            case STREAMER:
                return "S";
        }
        return null;
    }
}
