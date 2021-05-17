import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Contact {

	private String firstName;
	private String lastName;
	private String company;
	private String homeNumber;
	private String workNumber;
	private String homeEmail;
	private String workEmail;
	private String homeAddress;
	private String workAddress;
	private String dob;
	static Scanner sc = new Scanner(System.in);

	public Contact(String firstName, String lastName, String company, String homeNumber, String workNumber,
			String homeEmail, String workEmail, String homeAddress, String workAddress, String dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.homeNumber = homeNumber;
		this.workNumber = workNumber;
		this.homeEmail = homeEmail;
		this.workEmail = workEmail;
		this.homeAddress = homeAddress;
		this.workAddress = workAddress;
		this.dob = dob;

	}

	public Contact() {

	}

	public void setFirstName(String firstName) {
		if (firstName.isEmpty()) {
			firstName = "-";
		}
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		if (lastName.isEmpty()) {
			lastName = "-";
		}
		this.lastName = lastName;
	}

	public void setCompany(String company) {
		if (company.isEmpty()) {
			company = "-";
		}
		this.company = company;
	}

	public void setHomeNumber(String homeNumber) {
		if (homeNumber.isEmpty()) {
			homeNumber = "-";
		}
		this.homeNumber = homeNumber;
	}

	public void setWorkNumber(String workNumber) {
		if (workNumber.isEmpty()) {
			workNumber = "-";
		}
		this.workNumber = workNumber;
	}

	public void setHomeEmail(String homeEmail) {
		if (homeEmail.isEmpty()) {
			homeEmail = "-";
		}
		this.homeEmail = homeEmail;
	}

	public void setWorkEmail(String workEmail) {
		if (workEmail.isEmpty()) {
			workEmail = "-";
		}
		this.workEmail = workEmail;
	}

	public void setHomeAddress(String homeAddress) {
		if (homeAddress.isEmpty()) {
			homeAddress = "-";
		}
		this.homeAddress = homeAddress;
	}

	public void setWorkAddress(String workAddress) {
		if (workAddress.isEmpty()) {
			workAddress = "-";
		}
		this.workAddress = workAddress;
	}

	public void setDob(String dob) {
		if (dob.isEmpty()) {
			dob = "-";
		}
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

	public String getHomeNumber() {
		return homeNumber;
	}

	public String getWorkNumber() {
		return workNumber;
	}

	public String getHomeEmail() {
		return homeEmail;
	}

	public String getWorkEmail() {
		return workEmail;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public String getWorkAddress() {
		return workAddress;
	}

	public String getDob() {
		return dob;
	}

	
}
