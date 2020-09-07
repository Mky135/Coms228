package states;

import util.State;
import util.StateSwitcher;
import util.Town;
import util.TownCell;

public class Reseller extends TownCell {

    /**
     * Creates a new util.TownCell with it's given util.Town and placement inside that town
     *
     * @param town The town this specific util.TownCell belongs to
     * @param row  The row of which this util.TownCell belongs to
     * @param col  The column of which this util.TownCell belongs to
     */
    public Reseller(Town town, int row, int col) {
        super(town, row, col);
    }

    @Override
    public State who() {
        return State.RESELLER;
    }

    @Override
    public TownCell next(Town tNew) {
        census(TownCell.nCensus);

        if(TownCell.nCensus[StateSwitcher.EMPTY] >= 3)
            return new Empty(tNew, row, col);

        else if(TownCell.nCensus[StateSwitcher.CASUAL] <= 3)
            return new Empty(tNew, row, col);

        else if ((TownCell.nCensus[StateSwitcher.CASUAL]) >= 5)
            return new Streamer(tNew, row, col);

        else
            return new Reseller(tNew, row, col);
    }
}
