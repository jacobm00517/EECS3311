package library;

public class Request {
	
	
	String name;
	String edition;
	String itemType;
	String priority;
	boolean completion;
	
	public Request(String name, String edition, String itemType, String priority) {
		this.name = name;
		this.edition = edition;
		this.itemType = itemType;
		this.priority = priority;
		
	}
	
	public String notifyPriority(User u) {
		
		return null;
	}
	
	public void updateCompletion(boolean b){
		completion = b;
	}
	
}
