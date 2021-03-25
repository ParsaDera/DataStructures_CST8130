import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 * This is the Driver class for the assignment and will display output
 * @author Parsa Derakhshan
 *
 */
public class Assign2 {
	public static void menu() {
		System.out.println("Please select one of the following:");
		System.out.println("1: Add Item to Inventory");
		System.out.println("2: Display Current Inventory");
		System.out.println("3: Buy Item(s)");
		System.out.println("4: Sell Item(s)");
		System.out.println("5: Convert from ArrayList to LinkedList");
		System.out.println("6: To Exit");
		System.out.print("> ");
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
		//creating an object of inventory class
		Inventory inventory = new Inventory();


		//Getting the user's choice for the menu
		int menuOption = 0;

		while (menuOption != 6) {

			try {

				menu();

				if (scanner.hasNext(Pattern.compile("[1-6]"))) {        //the choice must be between 1-6

					menuOption = scanner.nextInt();

					switch (menuOption) {

					case 1: 
						if (!inventory.addItem(scanner))
							System.out.println("Error...could not add the item");
						break;
					case 2:
						System.out.println(inventory);
						break;
					case 3: 
						if (!inventory.updateQuantity(scanner, true))
							System.out.println("Error...could not buy the item");
						break;
					case 4:
						if (!inventory.updateQuantity(scanner, false))
							System.out.println("Error...could not sell the item");
						break;
					case 5: 

						List<FoodItem> li = inventory.convertAltoli();
						System.out.println(inventory.liTostring(li));
						break;
					case 6: 
						System.out.println("You quitted the program, have a nice day");
						break;
					default: 
						System.out.println("Something went wrong");
						break;
					}
				}else{
					System.out.println("Incorrect value entered");
					scanner.next();          //will prompt the user for correct value again	
				}
			} catch (Exception e) {
				System.out.println("Error Occurred: " + e.getMessage());
			}
		}
		scanner.close();
	}
}