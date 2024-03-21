<<<<<<< Updated upstream
package library;

import java.util.Date;

public interface Item {
	
	String getItemType();
	void setItemType(String itemType);

	String getTitle();
	void setTitle(String title);

	String getID();
	void setID(String iD);

	String getLocation();
	void setLocation(String location);

	boolean isRentable();
	void setRentable(String rentable);
	
	String getRentable();

	Date getBorrowedDate();
	void setBorrowedDate(Date borrowedDate);

	Date getDueDate();
	void setDueDate(Date dueDate);
	
	Date getLostDate();
	void setLostDate(Date lostDate);

	User getOwner();
	void setOwner(User user);

	String getPublisher();
	void setPublisher(String publisher);
	
	boolean isPurchasable();
	void setPurchasable(String purchasable);
	String getPurchasable();
	
	boolean isOnDiscount();
	void setOnDiscount(String onDiscount);
	String getOnDiscount();
	
	Double getCost();
	void setCost(Double cost);
	void calcCost(Date time);
	void considerIfLost(Date time);
	
	boolean getIfLost();
	
	void setEdition(String string);
	String getEdition();
	
=======
package library;

import java.util.Date;

public interface Item {
	
	String getItemType();
	void setItemType(String itemType);

	String getTitle();
	void setTitle(String title);

	String getID();
	void setID(String iD);

	String getLocation();
	void setLocation(String location);

	boolean isRentable();
	void setRentable(String rentable);
	
	String getRentable();

	Date getBorrowedDate();
	void setBorrowedDate(Date borrowedDate);

	Date getDueDate();
	void setDueDate(Date dueDate);
	
	Date getLostDate();
	void setLostDate(Date lostDate);

	User getOwner();
	void setOwner(User user);

	String getPublisher();
	void setPublisher(String publisher);
	
	boolean isPurchasable();
	void setPurchasable(String purchasable);
	String getPurchasable();
	
	boolean isOnDiscount();
	void setOnDiscount(String onDiscount);
	String getOnDiscount();
	
	Double getCost();
	void setCost(Double cost);
	void calcCost(Date time);
	void considerIfLost(Date time);
	
	boolean getIfLost();
	
	void setEdition(String string);
	String getEdition();
	
>>>>>>> Stashed changes
}