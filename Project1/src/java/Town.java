import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


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
		//TODO: Write your code here.
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
	 * Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);
		for (int i = 0; i < getLength(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				int randomNumber = rand.nextInt(5);
				grid[i][j] = new TownCell(this, i, j) {
					@Override
					public State who() {
						return StateSwitcher.returnStateFromValue(randomNumber);
					}

					@Override
					public TownCell next(Town tNew) {
						//Todo: Figure out what to do here
						return null;
					}
				};
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
