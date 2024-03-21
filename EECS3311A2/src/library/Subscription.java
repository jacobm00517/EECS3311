package library;

import java.util.Date;

public class Subscription {
	

	private User u; 
	private String site;
	private String companyName;
	private boolean status; // will return as string when "isstatus", is str in .csv


	public Subscription(String site, String companyName, User u, boolean status) {

		this.setU(u);
		this.site = site;
		this.companyName = companyName;
		status = true;

	}

	//default
	public Subscription() {
		
		
	}

	// getter
	public String isStatus() {
		if (this.status == true) {
			return "true";
		}
		else {
			return "false";
		}
	}
	
	
	// setter
	// req: unsubscribe [boolean= false]
	public void setStatus(String string) {
		if (string.equals("true")) {
			this.status = true;
		}
		else {
			this.status = false;
		}
	}

	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	

	
//	public void setSubscribedTo(NewsletterSystem subscribedTo) {
//	this.subscribedTo = subscribedTo;
//}
//public NewsletterSystem getSubscribedTo() {
//return subscribedTo;
//}

}