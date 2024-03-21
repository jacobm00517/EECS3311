package library;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MaintainSubscriptionsProxy implements SubscriptionDatabase {

	private String subPath;
	private static SubscriptionDatabase subDatabase = MaintainSubscriptions.getInstance();
	private static List<Subscription> subs = new ArrayList<Subscription>();
	
	private void initializeProxy() throws Exception {
		if (subs.isEmpty()) {
			subDatabase.load(pathNames.itemDBpath);
			subs.addAll(subDatabase.getSubs());
		}
	}
	
	@Override
	public void load(String subPath) throws Exception {
		try {
			initializeProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() throws Exception {
		initializeProxy();
		subDatabase.setSubs(subs);
		subDatabase.update();
		
	}

	@Override
	public void addSub(Subscription subscription) {
		subs.add(subscription);
		
	}

	@Override
	public List<Subscription> getSubs() {
		return this.subs;
	
	}

	@Override
	public void setSubs(List<Subscription> subs) {
		this.subs = new ArrayList<>(subs);
	}

}
