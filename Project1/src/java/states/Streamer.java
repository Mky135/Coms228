package states;

import util.State;
import util.StateSwitcher;
import util.Town;
import util.TownCell;

/**
 * @Author Miguel Flores
 * <p>
 * Streamer class implements util.TownCell's abstract methods
 * in order to define this class as one that returns util.State.STREAMER
 * and that changes to the appropriate "State" when next() is called
 */
public class Streamer extends TownCell {

    /**
     * Creates a new util.TownCell with it's given util.Town and placement inside that town
     *
     * @param town The town this specific util.TownCell belongs to
     * @param row  The row of which this util.TownCell belongs to
     * @param col  The column of which this util.TownCell belongs to
     */
    public Streamer(Town town, int row, int col) {
        super(town, row, col);
    }

    /**
     * Method returns the util.State of this util.TownCell
     * @return util.State.STREAMER
     */
    @Override
    public State who() {
        return State.STREAMER;
    }

    /**
     * Determines the cell type in the next cycle.
     * <p>
     * Rules:
     * If has at most one empty neighbor OR one outage neighbor converts to Reseller.
     * <p>
     * If there is any reseller in its neighborhood coverts to Outage
     * <p>
     * If any neighbor is an Outage then converts to Empty
     * <p>
     * If none apply then stays the same
     *
     * @param tNew: town of the next cycle
     * @return util.TownCell of the next cycle
     */
    @Override
    public TownCell next(Town tNew) {
        census(TownCell.nCensus);

        if ((TownCell.nCensus[StateSwitcher.EMPTY] + TownCell.nCensus[StateSwitcher.OUTAGE]) <= 1)
            return new Reseller(tNew, row, col);

        else if(TownCell.nCensus[StateSwitcher.RESELLER] >= 1)
            return new Outage(tNew, row, col);

        else if(TownCell.nCensus[StateSwitcher.OUTAGE] >= 1)
            return new Empty(tNew, row, col);

        else
            return new Streamer(tNew, row, col);
    }
}
