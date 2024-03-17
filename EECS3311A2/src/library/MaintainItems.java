package library;

import java.io.FileWriter;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainItems {
	public ArrayList<Item> items = new ArrayList<Item>();
	public String path;
	
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
			else if (reader.get("item").equals("magazine")) {
				item = new Magazine();
			}
			//userType,email,password
			item.setItemType(reader.get("item"));
			item.setTitle(reader.get("title"));
			item.setID(reader.get("ID"));
			item.setLocation(reader.get("location"));
			item.setPublisher(reader.get("publisher"));
			item.setRentable(reader.get("rentable"));
			item.setOwner(reader.get("owner"));
			item.setBorrowedDate(reader.get("borrowedDate"));
			item.setDueDate(reader.get("dueDate"));
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
					csvOutput.write(i.getBorrowedDate());
					csvOutput.write(i.getDueDate());
					csvOutput.write(i.getCost().toString());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
}
