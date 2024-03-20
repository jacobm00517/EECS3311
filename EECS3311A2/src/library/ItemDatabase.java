package library;

import java.util.List;

public interface ItemDatabase {

	void load(String path) throws Exception;

	void update() throws Exception;

	void addItem(Item item);

	Item getItemByID(String ID);

	List<Item> getItems();

	void setItems(List<Item> items);

}
