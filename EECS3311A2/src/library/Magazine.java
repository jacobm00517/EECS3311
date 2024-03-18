package library;

import java.util.Date;

public class Magazine implements Item {

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
	
	@Override
	public String getItemType() {
		return itemType;
	}
	@Override
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	@Override
	public String getTitle() {
		return title;
	}
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String getID() {
		return ID;
	}
	@Override
	public void setID(String iD) {
		this.ID = iD;
	}
	@Override
	public String getLocation() {
		return location;
	}
	@Override
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public boolean isRentable() {
		return rentable;
	}
	@Override
	public void setRentable(String rentable) {
		if (rentable.equals("true")) {
			this.rentable = true;
		}
		else {
			this.rentable = false;
		}
	}
	@Override
	public Date getBorrowedDate() {
		return borrowedDate;
	}
	@Override
	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}
	@Override
	public Date getDueDate() {
		return dueDate;
	}
	@Override
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public User getOwner() {
		return owner;
	}
	@Override
	public void setOwner(User user) {
		this.owner = user;
		
	}
	@Override
	public String getPublisher() {
		return publisher;
	}
	@Override
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public Double getCost() {
		return cost;
	}
	@Override
	public void setCost(Double cost) {
		this.cost = cost;
	}
	@Override
	public String getRentable() {
		if (rentable == true) {
			return "true";
		}
		else {
			return "false";
		}
	}

}
