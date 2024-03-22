package library;

import java.util.ArrayList;
import java.util.List;

public class DiscountOffers implements Menu{

	@Override
	public List<Item> strategyInput(String input, ItemDatabase items) {
		ArrayList<Item> searchItems = (ArrayList<Item>) items.getItems();
		ArrayList<Item> returnItems = new ArrayList<Item>();
		for (int i = 0; i < searchItems.size(); i++) {
			if(searchItems.get(i).isOnDiscount()) {
				returnItems.add(searchItems.get(i));
			}
		}
		return returnItems;
		
	}
}