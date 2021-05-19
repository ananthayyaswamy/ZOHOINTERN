
public class EmailAddress {
	private String emailAddress;

	public EmailAddress(String emailAddress, String type) {
		super();
		this.emailAddress = emailAddress;
		this.type = type;
	}

	public EmailAddress() {
		// TODO Auto-generated constructor stub
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String type;

}
