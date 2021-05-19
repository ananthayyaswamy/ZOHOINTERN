import java.util.ArrayList;

public class Contact {
	private String firstName;
	private String lastName;
	private String company;
	private String dob;
	private ArrayList<PhoneNumber> phoneNumber;
	private ArrayList<EmailAddress> emailAddress;
	private ArrayList<Address> address;

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ArrayList<PhoneNumber> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(ArrayList<PhoneNumber> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ArrayList<EmailAddress> getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(ArrayList<EmailAddress> emailAddress) {
		this.emailAddress = emailAddress;
	}

	public ArrayList<Address> getAddress() {
		return address;
	}

	public void setAddress(ArrayList<Address> address) {
		this.address = address;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCompany() {
		return company;
	}

	public String getDob() {
		return dob;
	}

}
