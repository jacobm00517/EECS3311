package library;

import java.util.Date;

public class Item {

	private String itemType;
	private String title;
	private String ID;
	private String location;
	private boolean rentable;
	private Date borrowedDate;
	private Date dueDate;
	private User owner;
	private String publisher;
	private Double cost;
	
	
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isRentable() {
		return rentable;
	}
	public void setRentable(String rentable) {
		if (rentable.equals("true")) {
			this.rentable = true;
		}
		else {
			this.rentable = false;
		}
	}
	public Date getBorrowedDate() {
		return borrowedDate;
	}
	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(String email) {
		if (owner.equals("admin")){
			this.owner = null;
		}
		
		else {
			UserDatabase userDatabase = new MaintainUserProxy();
			try {
				this.owner = userDatabase.getRegisteredUserByEmail(email);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error: User does not exist.");
			}
		}
		
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getRentable() {
		// TODO Auto-generated method stub
		return null;
	}

}
