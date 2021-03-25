/**
 * CET - CS Academic Level 3
 * Inventory class represents our inventory of items.The quantities of items will get updated here after buying or selling
 * 
 * Student Name: Parsa Derakhshan
 * Student Number: 040 978675 
 * Course: CST8130 - Data Structures
 * @author/ Parsa Derakhshan
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Iterator;


public class Inventory {
	
	private ArrayList<FoodItem> inventory;
   /**
    * No-argument constructor/ Note that the maximum numbers of items in inventory is 20 
    */
	public Inventory() {
		inventory = new ArrayList<FoodItem>(20);
	}

	public boolean addItem(Scanner scanner) {
		boolean option = false;          //boolean to repeat the menu after wrong input
		
		FoodItem item = null;
		
		
		while (!option) {
			
				System.out.print("Do you wish to add a fruit(f), vegetable(v), preserve(p) or sweetener(s)? ");
				
			if (scanner.hasNext(Pattern.compile("[fFvVpPSs]"))) {
				String choice = scanner.next();
				switch (choice) {        
				case "f":
					item = new Fruit();
					break;
				case "v":
					item = new Vegetable();
					break;
				case "p":
					item = new Preserve();
					break;
				case "s":
					item = new Sweetener();
					break;
				default: 
					item = new FoodItem();
					break;
				}
				option = true;
			} else {
				System.out.println("Invalid entry. Please Try Again");
				scanner.next();
				option = false;             //repeat the loop
			}
		}
		
		if (item.inputCode(scanner)) {          
			if (alreadyExists(item) < 0) {             //checks if the item code already exists in inventory or not
				if (item.addItem(scanner)) {
					insertItem(item);
					return true;
				}
				return false;
			} else {
				System.out.println("Item code already exists");
				return false;
			}
		}
		return true;
	}

	
	public int alreadyExists(FoodItem item) {
		
		return binarySearch(item.getItemCode(), 0, inventory.size()-1);
	}

	/**
	 * Search for the code using a binary search algorithm
	 * @param itemCode - Code to search for
	 * @param start - Index to start at
	 * @param end - Index to end at
	 * @return - Index of the found item or -1 if it is not found
	 */
	private int binarySearch(int itemCode, int start, int end) {
		int middle = (start + end) / 2;
		if (start > end)
			return -1;
		if (inventory.isEmpty())
			return -1;
		if (inventory.get(middle).getItemCode() == itemCode)
			return middle;
		if (inventory.get(middle).getItemCode() > itemCode)
			return binarySearch(itemCode, start, middle - 1);
		if (inventory.get(middle).getItemCode() < itemCode)
			return binarySearch(itemCode, middle + 1, end);
		return -1;
	}

	/**
	 * Inserts an item into the inventory and maintains sort order
	 * 
	 * @param item - Item to add to the inventory
	 */
	private void insertItem(FoodItem item) {
		FoodItemComparator comp = new FoodItemComparator();
		for (int i = 0; i < inventory.size(); i++) {
			if (comp.compare(inventory.get(i), item) >= 0) {
				inventory.add(i, item);
				return;
			}
		}
		inventory.add(item);
	}

	
	
	
	
	public List convertAltoli() {

        List<FoodItem> li = new LinkedList<>();
        for(int i = 0; i < this.inventory.size(); i++) {
            li.add(this.inventory.get(i));
        }

        return li;
    }
	

	/**
	 * to find the code when searching for item
	 * 
	 * @param scanner - Scanner to use for input
	 */
	public void searchForItem(Scanner scanner) {
		FoodItem itemToSearchFor = new FoodItem();
		itemToSearchFor.inputCode(scanner);
		int index = binarySearch(itemToSearchFor.getItemCode(), 0, inventory.size()-1);
		if (index == -1)
			System.out.println("Code not found in inventory...");
		else
			System.out.println(inventory.get(index).toString());
	}

	@Override
	public String toString() {
		String returnString = "Inventory:\n";
		ListIterator<FoodItem> items = inventory.listIterator();
		while (items.hasNext())
			returnString += items.next().toString() + "\n";
		return returnString;
	}

	/**
	 * Update the quanity stored in the food item
	 * @param scanner - Input device to use 
	 * @param buyOrSell - If we are to add to quantity 
	 * @return returns false to terminate the loop...
	 */
	public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
		// If there are no items then we can't update, return
		if (inventory.isEmpty())
			return false;

		FoodItem x = new FoodItem();
		x.inputCode(scanner);
		int index = alreadyExists(x);
		if (index != -1) {
			String buySell = buyOrSell ? "buy" : "sell";         //ternary operator to return true or false 
			System.out.print("Enter valid quantity to " + buySell + ": ");
			if (scanner.hasNextInt()) {
				int amount = scanner.nextInt();
				if (amount > 0) {
					return inventory.get(index).updateItem(buyOrSell ? amount : amount * -1);
				} else {
					System.out.println("Invalid quantity...");
				}
			} else {
				System.out.println("Invalid quantity...");
			}
		}
		return false;
	}
	
	/**
	 * string method of linked list for output
	 * @param li of the List declared before
	 * @return returns the string rep of linked list of inventory
	 */
	
	public String liTostring (List li) {

	       String returnString ="Inventory in Linked List: \n";
	       Iterator it = li.iterator();
	       while(it.hasNext()){
	           returnString += (it.next())+ "\n";
	       }

	       return returnString;
	   }
	
	
	
	
	
	
	
	
	
	
	
	
	
}