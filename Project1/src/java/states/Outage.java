package states;

import util.State;
import util.StateSwitcher;
import util.Town;
import util.TownCell;

/**
 * @Author Miguel Flores
 * <p>
 * Outage class implements util.TownCell's abstract methods
 * in order to define this class as one that returns util.State.OUTAGE
 * and that changes to the appropriate "State" when next() is called
 */
public class Outage extends TownCell {

    /**
     * Creates a new util.TownCell with it's given util.Town and placement inside that town
     *
     * @param town The town this specific util.TownCell belongs to
     * @param row  The row of which this util.TownCell belongs to
     * @param col  The column of which this util.TownCell belongs to
     */
    public Outage(Town town, int row, int col) {
        super(town, row, col);
    }

    /**
     * Method returns the util.State of this util.TownCell
     * @return util.State.OUTAGE
     */
    @Override
    public State who() {
        return State.OUTAGE;
    }

    /**
     * Determines the cell type in the next cycle.
     * <p>
     * Rules:
     * If 5 or more casual neighbors coverts to Streamer
     * <p>
     * If not then stays the same
     *
     * @param tNew: town of the next cycle
     * @return util.TownCell of the next cycle
     */
    @Override
    public TownCell next(Town tNew) {
        census(TownCell.nCensus);

        if ((TownCell.nCensus[StateSwitcher.CASUAL]) >= 5)
            return new Streamer(tNew, row, col);

        else
            return new Empty(tNew, row, col);
    }
}
