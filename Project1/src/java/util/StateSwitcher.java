package util;

/**
 * @author Miguel FLores
 * This class is for ease of switching between States and whatever is needed
 * This should centeralize everything so it's easier to look at and find
 */
public class StateSwitcher {

    // constants to be used as indices.
    public static final int RESELLER = 0;
    public static final int EMPTY = 1;
    public static final int CASUAL = 2;
    public static final int OUTAGE = 3;
    public static final int STREAMER = 4;

    /**
     * Return a util.State that corresponds to a numerical value
     *
     * @param value A number between 0-4 inclusive
     * @return A util.State that corresponds to the value
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
     * Returns an integer that corresponds to it's util.State
     *
     * @param state util.State that should needs to be converted into an integer
     * @return a numerical value of the corresponding util.State
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
     * Returns a single character String that corresponds to the letter of the util.TownCell type's state
     *
     * @param state util.State of the util.TownCell
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

    /**
     * Returns the util.State that corresponds with it's single letter String
     * @param letter The letter of which the util.State represents
     * @return util.State of which the letter corresponds to
     */
    public static State returnStateFromString(char letter) {
        switch (letter) {
            case 'E':
                return State.EMPTY;
            case 'C':
                return State.CASUAL;
            case 'O':
                return State.OUTAGE;
            case 'R':
                return State.RESELLER;
            case 'S':
                return State.STREAMER;
        }
        return null;
    }

    /**
     * Returns util.TownCell corresponds with it's single letter String
     * @param state util.State
     * @param town The town this specific util.TownCell belongs to
     * @param row  The row of which this util.TownCell belongs to
     * @param col  The column of which this util.TownCell belongs to
     * @return util.TownCell of that State
     */
    public static TownCell returnTownCellFromState(State state, Town town, int row, int col)
    {
        switch (state) {
            case EMPTY:
                return new states.Empty(town, row, col);
            case CASUAL:
                return new states.Casual(town, row, col);
            case OUTAGE:
                return new states.Outage(town, row, col);
            case RESELLER:
                return new states.Reseller(town, row, col);
            case STREAMER:
                return new states.Streamer(town, row, col);
        }
        return null;
    }
}
