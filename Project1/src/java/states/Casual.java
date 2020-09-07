package states;

import util.State;
import util.StateSwitcher;
import util.Town;
import util.TownCell;

public class Casual extends TownCell {

    /**
     * Creates a new util.TownCell with it's given util.Town and placement inside that town
     *
     * @param town The town this specific util.TownCell belongs to
     * @param row  The row of which this util.TownCell belongs to
     * @param col  The column of which this util.TownCell belongs to
     */
    public Casual(Town town, int row, int col) {
        super(town, row, col);
    }

    @Override
    public State who() {
        return State.CASUAL;
    }

    @Override
    public TownCell next(Town tNew) {
        census(TownCell.nCensus);
        if ((TownCell.nCensus[StateSwitcher.EMPTY] + TownCell.nCensus[StateSwitcher.OUTAGE]) <= 1)
            return new Reseller(tNew, row, col);

        else if (TownCell.nCensus[StateSwitcher.RESELLER] >= 1)
            return new Outage(tNew, row, col);

        else if (TownCell.nCensus[StateSwitcher.STREAMER] >= 1)
            return new Streamer(tNew, row, col);

        else if ((TownCell.nCensus[StateSwitcher.CASUAL] - 1) >= 5)
            return new Streamer(tNew, row, col);

        else
            return new Casual(tNew, row, col);
    }
}
