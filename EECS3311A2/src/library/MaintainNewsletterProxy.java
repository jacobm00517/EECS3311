package library;

import java.util.ArrayList;
import java.util.List;

public class MaintainNewsletterProxy implements NewsletterDatabase {

	private String newsPath;
	private static NewsletterDatabase newsDatabase = MaintainNewsletter.getInstance();
	private static List<NewsletterSystem> newsList = new ArrayList<NewsletterSystem>();
	
	private void initializeProxy() throws Exception {
		if (newsList.isEmpty()) {
			newsDatabase.load(pathNames.itemDBpath);
			newsList.addAll(newsDatabase.getNews());
		}
	}
	
	@Override
	public void load(String newsPath) throws Exception {
		try {
			initializeProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() throws Exception {
		initializeProxy();
		newsDatabase.setNews(newsList);
		newsDatabase.update();
		
	}

	@Override
	public void setNews(List<NewsletterSystem> subs) {
		this.newsList = new ArrayList<>(newsList);
	}

	@Override
	public void addNews(NewsletterSystem sys) {
		newsList.add(sys);

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

	@Override
	public List<NewsletterSystem> getNews() {
		return this.newsList;
	}


}
