package library;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainSubscriptions implements SubscriptionDatabase {
	private List<Subscription> subs = new ArrayList<Subscription>();
	private String subPath;
	private static MaintainSubscriptions database = null;

	//private constructor
	private MaintainSubscriptions() {

	}

	//allows only 1 instance of maintainItems, singleton pattern
	public static SubscriptionDatabase getInstance() {
		if (database == null) {
			database = new MaintainSubscriptions();
		}
		return database;
	}

	@Override
	public void load(String subPath) throws Exception{
		CsvReader reader = new CsvReader(subPath); 
		reader.readHeaders();
		

		while(reader.readRecord()){ 
			Subscription sub;
		
			sub = new Subscription();
			
			// newsletter system, status
			sub.setStatus(reader.get("status"));
			sub.setCompanyName(reader.get("companyName"));
			sub.setSite(reader.get("site"));
		
			String subOwner = reader.get("owner");
			// assign to user

			SubscriptionDatabase subDatabase = new MaintainSubscriptionsProxy();
			UserDatabase userDatabase = new MaintainUserProxy();
			try {


				sub.setU(userDatabase.getRegisteredUserByEmail(subOwner));

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error: User does not exist.");
			}
			
			sub.setSite(reader.get("site"));
			sub.setCompanyName(reader.get("companyName"));
			sub.setStatus(reader.get("status"));
			subs.add(sub);
		}
		
		
	}


	@Override
	public void update() throws Exception{
		try {		
			CsvWriter csvOutput = new CsvWriter(new FileWriter(pathNames.subPath, false), ',');
			
			//name,userType,email,password
			csvOutput.write("user");
			csvOutput.write("site");
			csvOutput.write("companyName");
			csvOutput.write("status");
		
			csvOutput.endRecord();

			// else assume that the file already has the correct header line
			// write out a few records
			
			for(Subscription s: subs){
				
				csvOutput.write(s.getU().getEmail());
				csvOutput.write(s.getSite());
				csvOutput.write(s.getCompanyName());
				csvOutput.write(s.isStatus());
				
				csvOutput.endRecord();
			}
			csvOutput.close();

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addSub(Subscription subscription) {
		subs.add(subscription);
	}

	@Override
	public List<Subscription> getSubs(){
		return this.subs;
	}

	@Override
	public void setSubs(List<Subscription> subs) {
		this.subs = new ArrayList<>(subs);
	}
}


