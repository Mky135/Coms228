package util;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Random;


/**
 *  @author Miguel Flores
 *
 */
public class Town {
	
	private int length, width;  //Row and col (first and second indices)
	public TownCell[][] grid;
	
	/**
	 * Constructor to be used when user wants to generate grid randomly, with the given seed.
	 * This constructor does not populate each cell of the grid (but should assign a 2D array to it).
	 * @param length The length corresponds to the number of rows in the grid
	 * @param width The width corresponds to the number of columns in the gird
	 */
	public Town(int length, int width) {
		this.length = length;
		this.width = width;
		grid = new TownCell[length][width];
	}
	
	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of catching it.
	 * Ensure that you close any resources (like file or scanner) which is opened in this function.
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException {
		FileHandler fileHandler = new FileHandler(inputFileName);

		if(!fileHandler.exists())
		{
			throw new FileNotFoundException();
		}

		String size = fileHandler.getLine(0);
		this.length = Integer.parseInt(size.substring(0,size.indexOf(" ")));
		this.width = Integer.parseInt(size.substring(size.indexOf(" ")+1));
		grid = new TownCell[length][width];

		for (int i = 0; i < length; i++) {
			String row = fileHandler.getLine(i+1).replaceAll(" ", "");
			for (int j = 0; j < width; j++) {
				State state = StateSwitcher.returnStateFromString(row.charAt(j));
				grid[i][j] = StateSwitcher.returnTownCellFromState(Objects.requireNonNull(state), this, i, j);
			}
		}
	}
	
	/**
	 * @return Returns width of the grid.
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @return Returns length of the grid.
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following class object:
	 * states.Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);
		for (int i = 0; i < getLength(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				int randomNumber = rand.nextInt(5);
				grid[i][j] = StateSwitcher.returnTownCellFromState(Objects.requireNonNull(StateSwitcher.returnStateFromValue(randomNumber)), this, i, j);
			}
		}
	}

	
	/**
	 * Output the town grid. For each square, output the first letter of the cell type.
	 * Each letter should be separated either by a single space or a tab.
	 * And each row should be in a new line. There should not be any extra line between 
	 * the rows.
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < getLength(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				s.append(StateSwitcher.returnLetterOfCellType(grid[i][j].who())).append(" ");
			}
			s.append("\n");
		}
		return s.toString();
	}
}
