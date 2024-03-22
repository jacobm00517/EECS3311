package library;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

	public class MaintainItems implements ItemDatabase {
	private List<Item> items = new ArrayList<Item>();
	private String path;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	private static MaintainItems database = null;
	
	//private constructor
	private MaintainItems() {
        
    }
	
	//allows only 1 instance of maintainItems, singleton pattern
	public static ItemDatabase getInstance() {
		if (database == null) {
			database = new MaintainItems();
		}
		return database;
	}
	
	@Override
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			Item item;
			if (reader.get("item").equals("book")) {
				item = new Book();
				
			}
			else if (reader.get("item").equals("CD")) {
				item = new CD();
			}
			else {
				item = new Magazine();
			}
			//userType,email,password
			item.setItemType(reader.get("item"));
			item.setTitle(reader.get("title"));
			item.setID(reader.get("ID"));
			item.setLocation(reader.get("location"));
			item.setPublisher(reader.get("publisher"));
			item.setRentable(reader.get("rentable"));
			String itemOwner = reader.get("owner");
			//To do: Figure out how to assign to librarian/library
				if (itemOwner.equals("admin")){
					item.setOwner(null);
				}
				
				else {
					UserDatabase userDatabase = new MaintainUserProxy();
					try {
						item.setOwner(userDatabase.getRegisteredUserByEmail(itemOwner));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("Error: User does not exist.");
					}
				}
			item.setBorrowedDate(formatter.parse(reader.get("borrowedDate")));
			item.setDueDate(formatter.parse(reader.get("dueDate")));
			double d = Double.parseDouble(reader.get("cost"));
			item.setCost(d);
			item.setEdition(reader.get("edition"));
			
			items.add(item);
			
		}
	}
	
	@Override
	public void update() throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(pathNames.itemDBpath, false), ',');
				//name,userType,email,password
				csvOutput.write("item");
		    	csvOutput.write("title");
				csvOutput.write("ID");
				csvOutput.write("location");
				csvOutput.write("publisher");
				csvOutput.write("rentable");
				csvOutput.write("owner");
				csvOutput.write("borrowedDate");
				csvOutput.write("dueDate");
				csvOutput.write("cost");
				csvOutput.write("edition");
				csvOutput.write("purchasable");
				csvOutput.write("onDiscount");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(Item i: items){
					csvOutput.write(i.getItemType());
			    	csvOutput.write(i.getTitle());
					csvOutput.write(i.getID());
					csvOutput.write(i.getLocation());
					csvOutput.write(i.getPublisher());
					csvOutput.write(i.getRentable());
					csvOutput.write(i.getOwner().getEmail());
					csvOutput.write(formatter.format(i.getBorrowedDate()));
					csvOutput.write(formatter.format(i.getDueDate()));
					csvOutput.write(i.getCost().toString());
					csvOutput.write(i.getEdition());
					csvOutput.write(i.getPurchasable());
					csvOutput.write(i.getOnDiscount());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
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
		for (Item i : this.items){
			if (title.equals(i.getTitle())){
				return i;
			}
		}
		return null;
	}
}
