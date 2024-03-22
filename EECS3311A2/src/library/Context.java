package library;

import java.util.List;

public class Context {
	private Menu menu;
	
	public Context(Menu menu){
		this.menu = menu;
	}
	public List<Item> strategyInput(String input, ItemDatabase items){
		return menu.strategyInput(input, items);
	}
}
