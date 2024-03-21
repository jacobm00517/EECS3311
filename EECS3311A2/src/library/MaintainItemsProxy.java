<<<<<<< Updated upstream
package library;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainItemsProxy implements ItemDatabase {
	private String path;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	private static ItemDatabase itemDatabase = MaintainItems.getInstance();
	private static ArrayList<Item> items = new ArrayList<Item>();

	private void initializeProxy() throws Exception {
		if (items.isEmpty()) {
			itemDatabase.load(pathNames.itemDBpath);
			items.addAll(itemDatabase.getItems());
		}
	}
	
	@Override
	public void load(String path) {
		try {
			initializeProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Needs to be updated before closing
	@Override
	public void update() throws Exception{
		initializeProxy();
		itemDatabase.setItems(items);
		itemDatabase.update();
	}

	@Override
	public void addItem(Item item) {
		items.add(item);
	}
	
	@Override
	public Item getItemByID(String ID) {
		for (Item i : items) {
			if (i.getID().equals(ID)) {
				return i;
			}
		}
		return null;
	}
	
	@Override
	public List<Item> getItems(){
		return this.items;
	}
	
	@Override
	public void setItems(List<Item> items) {
		this.items = new ArrayList<>(items);
	}
	
	@Override
	public Item getItemByTitle(String title) {
		return itemDatabase.getItemByTitle(title);
	}
=======
package library;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainItemsProxy implements ItemDatabase {
	private String path;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	private static ItemDatabase itemDatabase = MaintainItems.getInstance();
	private static ArrayList<Item> items = new ArrayList<Item>();

	private void initializeProxy() throws Exception {
		if (items.isEmpty()) {
			itemDatabase.load(pathNames.itemDBpath);
			items.addAll(itemDatabase.getItems());
		}
	}
	
	@Override
	public void load(String path) {
		try {
			initializeProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Needs to be updated before closing
	@Override
	public void update() throws Exception{
		initializeProxy();
		itemDatabase.setItems(items);
		itemDatabase.update();
	}

	@Override
	public void addItem(Item item) {
		items.add(item);
	}
	
	@Override
	public Item getItemByID(String ID) {
		for (Item i : items) {
			if (i.getID().equals(ID)) {
				return i;
			}
		}
		return null;
	}
	
	@Override
	public List<Item> getItems(){
		return this.items;
	}
	
	@Override
	public void setItems(List<Item> items) {
		this.items = new ArrayList<>(items);
	}
	
	@Override
	public Item getItemByTitle(String title) {
		return itemDatabase.getItemByTitle(title);
	}
>>>>>>> Stashed changes
}