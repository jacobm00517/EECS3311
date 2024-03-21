package library;

public class NewsletterSystem {

	private String company; //name
	private String website; //website path
	
	
	// req2/4 involve newsletter systems and subscriptions
	public NewsletterSystem(String company, String website) {
		this.company = company;
		this.website = website;
	}
	
	
	public NewsletterSystem() {
		// TODO Auto-generated constructor stub
	}


	//getters
	public String getCompany() {
		return company;
	}

	
	public String getWebsite() {
		return website;
	}
	
	// setters, but no need. just use constructor.
	public void setWebsite(String website) {
		this.website = website;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
}
