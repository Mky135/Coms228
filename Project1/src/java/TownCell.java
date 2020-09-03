/**
 * 
 * @author Miguel Flores
 *	Also provide appropriate comments for this class
 *
 */
public abstract class TownCell {

	protected Town town;
	protected int row;
	protected int col;
	
	
	// constants to be used as indices.
	protected static final int RESELLER = 0;
	protected static final int EMPTY = 1;
	protected static final int CASUAL = 2;
	protected static final int OUTAGE = 3;
	protected static final int STREAMER = 4;
	
	public static final int NUM_CELL_TYPE = 5;
	
	//Use this static array to take census.
	public static final int[] nCensus = new int[NUM_CELL_TYPE];

	/**
	 * Creates a new TownCell with it's given Town and placement inside that town
	 * @param town The town this specific TownCell belongs to
	 * @param row The row of which this TownCell belongs to
	 * @param col The column of which this TownCell belongs to
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
		nCensus[RESELLER] = 0; 
		nCensus[EMPTY] = 0; 
		nCensus[CASUAL] = 0; 
		nCensus[OUTAGE] = 0; 
		nCensus[STREAMER] = 0;

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int r = row + i;
				int c = col + j;

				if((r < 0 || r > town.getLength()) || (c < 0 || c > town.getWidth()))
					continue;

				if(town.grid[r][c].who() == State.RESELLER)
					nCensus[RESELLER]++;
				else if(town.grid[r][c].who() == State.EMPTY)
					nCensus[EMPTY]++;
				else if(town.grid[r][c].who() == State.CASUAL)
					nCensus[CASUAL]++;
				else if(town.grid[r][c].who() == State.OUTAGE)
					nCensus[OUTAGE]++;
				else if(town.grid[r][c].who() == State.STREAMER)
					nCensus[STREAMER]++;
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
