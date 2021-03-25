import java.util.Scanner;



public class Sweetener extends FoodItem {
private String farmName;
	
	
	
	public Sweetener() {
		super();
		farmName = "";
	}
	/**
	 * Reads from the Scanner object passed in and fills the data member fields of the class with valid data;
	 * super keyword is called to use the FoodItem class method
	 * @return Method returns true if program successfully reads in all fields, otherwise returns false
	 */
	@Override
	public boolean addItem(Scanner scanner) {
		if(super.addItem(scanner))
		{
			System.out.print("Enter the name of the farm supplier: ");
			farmName = scanner.next();				
		}
		return true;
	}
	/**
	 * Displays the all data members in the class
	 */
	@Override
	public String toString() {
		return super.toString()+" farm supplier: "+farmName;
	}
}
