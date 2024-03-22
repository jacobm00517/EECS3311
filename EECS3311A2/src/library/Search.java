package library;

import java.util.ArrayList;
import java.util.List;

public class Search implements Menu{

	//searches item database according to prompt
	@Override
	public List<Item> strategyInput(String input, ItemDatabase items) {
		ArrayList<Item> searchItems = (ArrayList<Item>) items.getItems();
		ArrayList<Item> returnItems = new ArrayList<Item>();
		for (int i = 0; i < searchItems.size(); i++) {
			String currentItem = searchItems.get(i).getItemType();
			if((currentItem.contains(input)) && (!searchItems.get(i).getIfLost())) {
				returnItems.add(searchItems.get(i));
			}
		}
		return returnItems;
	}
}