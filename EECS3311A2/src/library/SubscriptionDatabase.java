package library;

import java.util.List;

public interface SubscriptionDatabase {
	
	//allows only 1 instance of SubscriptionDatabase, singleton pattern
	public static SubscriptionDatabase getInstance() {
		return null;
	}
	
	void load(String subPath) throws Exception;
	void update() throws Exception;

	void addSub(Subscription subscription);
//	Subscription getSubByID(String ID);
	
	List<Subscription> getSubs();
	void setSubs(List<Subscription> subs);

}
