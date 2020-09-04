/**
 * @author Miguel Flores
 * Also provide appropriate comments for this class
 */
public abstract class TownCell {

    protected Town town;
    protected int row;
    protected int col;

    public static final int NUM_CELL_TYPE = 5;

    //Use this static array to take census.
    public static final int[] nCensus = new int[NUM_CELL_TYPE];

    /**
     * Creates a new TownCell with it's given Town and placement inside that town
     *
     * @param town The town this specific TownCell belongs to
     * @param row  The row of which this TownCell belongs to
     * @param col  The column of which this TownCell belongs to
     */
    public TownCell(Town town, int row, int col) {
        this.town = town;
        this.row = row;
        this.col = col;
    }

    /**
     * Censuses all cell types in the 3 X 3 neighborhood
     * Use who() method to get who is present in the cell
     *
     * @param nCensus counts of all customers
     */
    public void census(int[] nCensus) {
        //TODO: Figure out why I need to use nCensus

        // zero the counts of all customers
        nCensus[StateSwitcher.RESELLER] = 0;
        nCensus[StateSwitcher.EMPTY] = 0;
        nCensus[StateSwitcher.CASUAL] = 0;
        nCensus[StateSwitcher.OUTAGE] = 0;
        nCensus[StateSwitcher.STREAMER] = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int r = row + i;
                int c = col + j;

                if ((r < 0 || r > town.getLength()) || (c < 0 || c > town.getWidth()))
                    continue;

                nCensus[StateSwitcher.returnValueFromState(town.grid[r][c].who())]++;
            }
        }
    }

    /**
     * Gets the identity of the cell.
     *
     * @return State
     */
    public abstract State who();

    /**
     * Determines the cell type in the next cycle.
     *
     * @param tNew: town of the next cycle
     * @return TownCell
     */
    public abstract TownCell next(Town tNew);
}
