package library;

import java.util.List;

public interface ItemDatabase {
	
	//allows only 1 instance of ItemDatabase, singleton pattern
	public static ItemDatabase getInstance() {
		return null;
	}
	
	void load(String path) throws Exception;

	void update() throws Exception;

	void addItem(Item item);

	Item getItemByID(String ID);

	Item getItemByTitle(String title);

	List<Item> getItems();

	void setItems(List<Item> items);

}
