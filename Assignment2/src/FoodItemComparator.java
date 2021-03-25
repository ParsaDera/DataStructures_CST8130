import java.util.Comparator;


public class FoodItemComparator implements Comparator<FoodItem> {
	
	@Override
	public int compare(FoodItem o1, FoodItem o2) {
		return o1.getItemCode() - o2.getItemCode();
	}

}