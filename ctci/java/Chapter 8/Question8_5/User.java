package Question8_5;

/**
 * User 和 Book类只是存放数据，没有什么真正的功能
 */
public class User {
	private int userId;
	private String details;
	private int accountType;
	
	public void renewMembership() {  }

	public User(int id, String details, int accountType) {
		userId = id;
		this.details = details;
		this.accountType = accountType;
	}
	
	/* getters and setters */
	public int getID() { return userId; }
	public void setID(int id) { userId = id; }
	public String getDetails() { return details; }
	public void setDetails(String details) { this.details = details; }
	public int getAccountType() { return accountType; }
	public void setAccountType(int accountType) { 
		this.accountType = accountType;
	}
}

