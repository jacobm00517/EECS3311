package library;

public class Subscription {
	

	private User u; 
	//^^ this isnt necessary because the user will own a list of subscription objects 
	
	private NewsletterSystem subscribedTo;
	private boolean status;


	public Subscription(NewsletterSystem n, User u) {

		this.u = u;
		// ^^ this isnt necessary because the user will own a list of subscription objects
		
		this.subscribedTo = n;
		status = true;

	}

	// getter
	public NewsletterSystem getSubscribedTo() {
		return subscribedTo;
	}
	public boolean isStatus() {
		return status;
	}
	
	
	// setter
	// req: unsubscribe [boolean= false]
	public void setStatus(boolean status) {
		this.status = status;
	}

	//  no need for other setter. we dont change it after made.
	public void setSubscribedTo(NewsletterSystem subscribedTo) {
		this.subscribedTo = subscribedTo;
	}

}
