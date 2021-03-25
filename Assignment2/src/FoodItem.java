
import java.util.Scanner;


public class FoodItem {
	
	private int itemCode;
	private float itemCost;
	private String itemName;
	private float itemPrice;
	private int itemQuantityInStock;

	/**
	 * Default Constructor: To initialize all the instance variables.
	 */
	public FoodItem() {
		itemCode = 0;
		itemName = "";
		itemPrice = 0.0f;
		itemCost = 0.0f;
		itemQuantityInStock = 0;
	}

	/**
	 * Reads from the Scanner object passed in and fills the data member fields of the class with valid data.
	 * @param scanner - Scanner to use for input
	 * @return returns true if program successfully reads in all fields, otherwise returns false
	 */
	public boolean addItem(Scanner scanner) {
		boolean valid = false;
		System.out.print("Enter the name for the item: ");
		itemName = scanner.next();
		// Input quantity
		while (!valid) {
			System.out.print("Enter the quantity for the item: ");
			if (scanner.hasNextInt()) {
				itemQuantityInStock = scanner.nextInt();
				if (itemQuantityInStock < 0) {
					valid = false;
					System.out.println("Invalid input");
					itemQuantityInStock = 0;
				} else
					valid = true;
			} else {
				System.out.println("Invalid input");
				scanner.next();
				valid = false;
			}
		}

		// Input the cost
		valid = false;
		while (!valid) {
				System.out.print("Enter the cost of the item: ");
			if (scanner.hasNextFloat()) {
				itemCost = scanner.nextFloat();
				if (itemCost < 0) {
					valid = false;
					System.out.println("Invalid entry");
					itemCost = 0;
				} else
					valid = true;
			} else {
				System.out.println("Invalid entry");
				scanner.next();
				valid = false;
			}
		}

		// Input the price
		valid = false;
		while (!valid) {
				System.out.print("Enter the sales price of the item: ");
			if (scanner.hasNextFloat()) {
				itemPrice = scanner.nextFloat();
				if (itemPrice < 0) {
					valid = false;
					System.out.println("Invalid entry");
					itemPrice = 0;
				} else
					valid = true;
			} else {
				System.out.println("Invalid entry");
				scanner.next();
				valid = false;
			}
		}
		return true;
	}

	/**
	 * Returns the item code so it may be used to compare objects
	 *
	 * @return Value of itemCode data member
	 */
	public int getItemCode() {
		return itemCode;
	}

	/**
	 * Reads a valid itemCode from the Scanner object and returns true/false if successful.
	 * @param scanner - Scanner to use for input
	 * @return returns true if the code is the valid, returns false otherwise.
	 */
	public boolean inputCode(Scanner scanner) {
		boolean validInput = false;
		while (!validInput) {
				System.out.print("Enter the code for the item: ");
			if (scanner.hasNextInt()) {
				itemCode = scanner.nextInt();
				validInput = true;
			} else {
				System.out.println("Invalid entry");
				// Clear the invalid input
				scanner.next();
			}
		}
		return validInput;
	}

	/**
	 * Method returns true if the itemCode of the object being acted on and the item object parameter are the same value.
	 * @param item - object to compare with
	 * @return returns true if the object of the object being acted on and the item object parameter are the same value returns false otherwise.
	 */
	public boolean isEqual(FoodItem item) {
		return itemCode == item.itemCode;
	}

	@Override
	public String toString() {
		return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $"
				+ String.format("%.2f", itemPrice) + " cost: $" + String.format("%.2f", itemCost);
	}

	/**
	 * Updates the quantity field by amount (note amount could be positive or negative);
	 * @param amount - what to update by, either can be positive or negative
	 * @return Method returns true if successful, otherwise returns false
	 */
	public boolean updateItem(int amount) {
		
		if(amount < 0 && itemQuantityInStock < (amount*-1)) {        // check that we have enough stock
			return false;
		}
		itemQuantityInStock += amount;
		return true;
	}

}