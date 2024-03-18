package library;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainItems {
	private ArrayList<Item> items = new ArrayList<Item>();
	private String path;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	
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
			items.add(item);
		}
	}
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
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
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void addItem(Item item) {
		items.add(item);
		
	}
}
