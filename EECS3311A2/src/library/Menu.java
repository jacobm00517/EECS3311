package library;

import java.util.List;

public interface Menu {
	//strategy pattern
	public List<Item> strategyInput(String input, ItemDatabase items);
}