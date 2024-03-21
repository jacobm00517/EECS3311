package library;

import java.util.List;

public interface NewsletterDatabase {
	

	//allows only 1 instance of ItemDatabase, singleton pattern
	public static NewsletterDatabase getInstance() {
		return null;
	}
	
	void load(String path) throws Exception;

	void update() throws Exception;

	void addNews(NewsletterSystem sys);

	NewsletterSystem getItemByName(String Name);

	List<NewsletterSystem> getNews();

	void setNews(List<NewsletterSystem> systems);


}
