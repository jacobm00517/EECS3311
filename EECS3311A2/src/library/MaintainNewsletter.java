package library;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainNewsletter implements NewsletterDatabase {

	private List<NewsletterSystem> newsList = new ArrayList<NewsletterSystem>();
	private String newsPath;
	private static MaintainNewsletter database = null;

	//private constructor
	private MaintainNewsletter() {

	}

	//allows only 1 instance of maintainItems, singleton pattern
	public static NewsletterDatabase getInstance() {
		if (database == null) {
			database = new MaintainNewsletter();
		}
		return database;
	}

	@Override
	public void load(String newsPath) throws Exception{
		CsvReader reader = new CsvReader(newsPath); 
		reader.readHeaders();
		

		while(reader.readRecord()){ 
			NewsletterSystem newsl;
		
			newsl = new NewsletterSystem();
			
			// newsletter system, status
			newsl.setCompany(reader.get("companyName"));
			newsl.setWebsite(reader.get("site"));
		
			String subOwner = reader.get("owner");
			// assign to user

			NewsletterDatabase subDatabase = new MaintainNewsletterProxy();
//			UserDatabase userDatabase = new MaintainUserProxy();
//			try {
//
//
//				sub.setU(userDatabase.getRegisteredUserByEmail(subOwner));
//
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("Error: User does not exist.");
//			}
			
			newsl.setCompany(reader.get("companyName"));
			newsl.setWebsite(reader.get("site"));
			newsList.add(newsl);
		}
		
		
	}


	@Override
	public void update() throws Exception{
		try {		
			CsvWriter csvOutput = new CsvWriter(new FileWriter(pathNames.newsPath, false), ',');
			
			//name,userType,email,password
	
			csvOutput.write("companyName");
			csvOutput.write("site");
	
			csvOutput.endRecord();

			// else assume that the file already has the correct header line
			// write out a few records
			
			for(NewsletterSystem s: newsList){
				
			
				csvOutput.write(s.getCompany());
				csvOutput.write(s.getWebsite());
				
				csvOutput.endRecord();
			}
			csvOutput.close();

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addNews(NewsletterSystem newsl) {
		newsList.add(newsl);
	}

	@Override
	public List<NewsletterSystem> getNews(){
		return this.newsList;
	}

	@Override
	public void setNews(List<NewsletterSystem> news) {
		this.newsList = new ArrayList<>(news);
	}

	@Override
	public NewsletterSystem getItemByName(String Name) {
		for (NewsletterSystem i : newsList) {
			if (i.getCompany().equals(Name)) {
				return i;
			}
		}
		return null;
	}
	
}
