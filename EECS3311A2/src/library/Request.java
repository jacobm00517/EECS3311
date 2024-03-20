package library;

public class Request {
	
	
	private String name;
	private String edition;
	private String itemType;
	private String priority;
	private boolean completion;
	
	public Request(String name, String edition, String itemType, String priority, boolean completion) {
		this.name = name;
		this.edition = edition;
		this.itemType = itemType;
		this.priority = priority;
		this.completion= completion;
		
	}
	
	public String notifyPriority(User u) {
		
		return null;
	}
	
	
	// getters and setters
	public boolean isCompletion() {
		return completion;
	}
	public void setCompletion(boolean b){
		completion = b;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}

	
	
	
}
