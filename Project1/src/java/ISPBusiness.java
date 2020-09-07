import util.Town;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Miguel Flores
 *
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different util.TownCell types.
 *
 */
public class ISPBusiness {
	
	/**
	 * Returns a new util.Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current util.Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		//TODO: Write your code here.
		return tNew;
	}
	
	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) {
		//TODO: Write/update your code here.
		return 0;
	}
	

	/**
	 * Main method. Interact with the user and ask if user wants to specify elements of grid
	 *  via an input file (option: 1) or wants to generate it randomly (option: 2).
	 *  
	 *  Depending on the user choice, create the util.Town object using respective constructor and
	 *  if user choice is to populate it randomly, then populate the grid here.
	 *  
	 *  Finally: For 12 billing cycle calculate the profit and update town object (for each cycle).
	 *  Print the final profit in terms of %. You should only print the integer part (Just print the 
	 *  integer value. Example if profit is 35.56%, your output should be just: 35).
	 *  
	 * Note that this method does not throws any exception, thus you need to handle all the exceptions
	 * in it.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String []args) throws FileNotFoundException {
		//TODO: Write your code here.
		Scanner scanner = new Scanner(System.in);
		Town town;
		//Option 1: call util.Town(rows, cols) and call randomInit(Seed)
		System.out.print("How to populate grid (type 1 or 2): 1: from a file. 2: randomly with seed \n");
		int option = scanner.nextInt();
		if (option == 1)
		{
			System.out.print("Please enter file path:");
			String file = scanner.nextLine();
			town = new Town(file);
			System.out.println();
		}
		else if (option == 2)
		{
			System.out.print("Provide rows, cols and seed integer separated by spaces: \n");
			scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			int length = Integer.parseInt(input.substring(0, input.indexOf(" ")));
			input = input.substring(input.indexOf(" ")+1);
			int width = Integer.parseInt(input.substring(0, input.indexOf(" ")));
			input = input.substring(input.indexOf(" ")+1);
			int seed = Integer.parseInt(input);
			town = new Town(length, width);
			town.randomInit(seed);
			System.out.println(town);
		}

	}
}
