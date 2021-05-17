

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

	public void addContact(Contact contact, FileWriter fw) throws IOException {

		PrintWriter pw = new PrintWriter(fw);
		pw.println(contact.firstName + "," + contact.lastName + "," + contact.company + "," + contact.homeNumber + ","
				+ contact.workNumber + "," + contact.homeEmail + "," + contact.workEmail + "," + contact.homeAddress
				+ "," + contact.workAddress + "," + contact.dob);
		
		pw.close();

	}

	public void DeleteContact() throws IOException {
		String fname;
		String lname;
		sc.nextLine();

		System.out.println("Enter fisrtname");
		fname = sc.nextLine();
		System.out.println("Enter last name");
		lname = sc.nextLine();
		
		int recordNum = getContacts(fname, lname);
		if(recordNum==-1){
			return;
		}
		File file1 = new File("tempContactDetails.txt");
		FileReader fr1 = new FileReader(file1);
		File file = new File("javaContactDetails.txt");
		FileWriter fw = new FileWriter(file);
		BufferedReader br1 = new BufferedReader(fr1);
		PrintWriter pw = new PrintWriter(fw);
		String line;
		int index = 0;
		while ((line = br1.readLine()) != null) {
			index++;
			String values[] = line.split(",");
			Contact contact = new Contact();
			contact.firstName = values[0];

			contact.lastName = values[1];

			contact.company = values[2];

			contact.homeNumber = values[3];

			contact.workNumber = values[4];

			contact.homeEmail = values[5];

			contact.workEmail = values[6];

			contact.homeAddress = values[7];

			contact.workAddress = values[8];

			contact.dob = values[9];

			if (index != recordNum) {

				pw.println(contact.firstName + "," + contact.lastName + "," + contact.company + "," + contact.homeNumber
						+ "," + contact.workNumber + "," + contact.homeEmail + "," + contact.workEmail + ","
						+ contact.homeAddress + "," + contact.workAddress + "," + contact.dob);
				System.out.println("ADDED SUCCESFULLLY in delete");

			}
		}
		pw.close();
		br1.close();
		fw.close();
		fr1.close();

	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", company=" + company + ", homeNumber="
				+ homeNumber + ", workNumber=" + workNumber + ", homeEmail=" + homeEmail + ", workEmail=" + workEmail
				+ ", homeAddress=" + homeAddress + ", workAddress=" + workAddress + ", dob=" + dob + "]";
	}

	public int getContacts(String fname, String lname) throws IOException {
		File file = new File("javaContactDetails.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		File file1 = new File("tempContactDetails.txt");
		FileWriter fw1 = new FileWriter(file1);
		PrintWriter pw1 = new PrintWriter(fw1);
		String line;
		int index = 0;
		int found = 0;
		int returnValue = -1;
		while ((line = br.readLine()) != null) {
			index++;
			String values[] = line.split(",");
			Contact contact = new Contact();
			contact.firstName = values[0];

			contact.lastName = values[1];

			contact.company = values[2];

			contact.homeNumber = values[3];

			contact.workNumber = values[4];

			contact.homeEmail = values[5];

			contact.workEmail = values[6];

			contact.homeAddress = values[7];

			contact.workAddress = values[8];

			contact.dob = values[9];
			if (fname.equals(values[0]) && lname.equals(values[1])) {
				found++;
				returnValue = index;
				System.out.println("firstname:" + values[0]);
				System.out.println("lastname:" + values[1]);
				System.out.println("company name:" + values[2]);
				System.out.println("Home Number:" + values[3]);
				System.out.println("Work Number:" + values[4]);
				System.out.println("Home Address:" + values[5]);
				System.out.println("Work Address:" + values[6]);
				System.out.println("Home Email:" + values[7]);
				System.out.println("Work Email:" + values[8]);
				System.out.println("DOB:" + values[9]);

				System.out.println("RECORD NUMBER: " + index);

				pw1.println(
						contact.firstName + "," + contact.lastName + "," + contact.company + "," + contact.homeNumber
								+ "," + contact.workNumber + "," + contact.homeEmail + "," + contact.workEmail + ","
								+ contact.homeAddress + "," + contact.workAddress + "," + contact.dob);

			} else {
				// System.out.println("firstname:" + values[0]);
				// System.out.println("lastname:" + values[1]);
				// System.out.println("company name:" + values[2]);
				// System.out.println("Home Number:" + values[3]);
				// System.out.println("Work Number:" + values[4]);
				// System.out.println("Home Address:" + values[5]);
				// System.out.println("Work Address:" + values[6]);
				// System.out.println("Home Email:" + values[7]);
				// System.out.println("Work Email:" + values[8]);
				// System.out.println("DOB:" + values[9]);

				pw1.println(
						contact.firstName + "," + contact.lastName + "," + contact.company + "," + contact.homeNumber
								+ "," + contact.workNumber + "," + contact.homeEmail + "," + contact.workEmail + ","
								+ contact.homeAddress + "," + contact.workAddress + "," + contact.dob);

			}
		}
		pw1.close();
		fw1.close();
		br.close();
		fr.close();
		//System.out.println("found=" + found);
		if (found > 1) {
			System.out.println("Multiple Records found with same firstname and LastName");
			System.out.println("Please specify the record  :");
			returnValue = sc.nextInt();

		}
		if (found == 0) {
			System.out.println("NO RECORDS FOUND WITH GIVEN VALUES");
			System.out.println("press enter to continue");
			sc.nextLine();

		}
		if (found == 1) {
			System.out.println("one record found");
			System.out.println("press enter to continue");
			sc.nextLine();
		}
		return returnValue;

	}

	public Contact getDetails(Contact contact) {
		sc.nextLine();
		System.out.println("Enter fisrtname");
		contact.firstName = sc.nextLine();
		if (contact.firstName.isEmpty()) {
			contact.firstName = "-";
		}
		System.out.println("Enter last name");
		contact.lastName = sc.nextLine();
		if (contact.lastName.isEmpty()) {
			contact.lastName = "-";
		}
		System.out.println("Enter company name");
		contact.company = sc.nextLine();
		if (contact.company.isEmpty()) {
			contact.company = "-";
		}
		System.out.println("Enter home phone");
		contact.homeNumber = sc.nextLine();
		if (contact.homeNumber.isEmpty()) {
			contact.homeNumber = "-";
		}
		System.out.println("Enter work phone");
		contact.workNumber = sc.nextLine();
		if (contact.workNumber.isEmpty()) {
			contact.workNumber = "-";
		}
		System.out.println("Enter home email");
		contact.homeEmail = sc.nextLine();
		if (contact.homeEmail.isEmpty()) {
			contact.homeEmail = "-";
		}
		System.out.println("Enter work email");
		contact.workEmail = sc.nextLine();
		if (contact.workEmail.isEmpty()) {
			contact.workEmail = "-";
		}
		System.out.println("Enter home address");
		contact.homeAddress = sc.nextLine();
		if (contact.homeAddress.isEmpty()) {
			contact.homeAddress = "-";
		}
		System.out.println("Enter work address");
		contact.workAddress = sc.nextLine();
		if (contact.workAddress.isEmpty()) {
			contact.workAddress = "-";
		}
		System.out.println("Enter dob");
		contact.dob = sc.nextLine();
		if (contact.dob.isEmpty()) {
			contact.dob = "-";
		}
		return contact;
	}

	public void editContact() throws IOException {
		String fname;
		String lname;
		sc.nextLine();

		System.out.println("Enter fisrtname");
		fname = sc.nextLine();
		System.out.println("Enter last name");
		lname = sc.nextLine();
		int recordNum = getContacts(fname, lname);
		if(recordNum==-1){
			return;
		}
		File file1 = new File("tempContactDetails.txt");
		FileReader fr1 = new FileReader(file1);
		File file = new File("javaContactDetails.txt");
		FileWriter fw = new FileWriter(file);
		BufferedReader br1 = new BufferedReader(fr1);
		PrintWriter pw = new PrintWriter(fw);
		String line;
		int index = 0;
		while ((line = br1.readLine()) != null) {
			index++;
			String values[] = line.split(",");
			Contact contact = new Contact();
			contact.firstName = values[0];

			contact.lastName = values[1];

			contact.company = values[2];

			contact.homeNumber = values[3];

			contact.workNumber = values[4];

			contact.homeEmail = values[5];

			contact.workEmail = values[6];

			contact.homeAddress = values[7];

			contact.workAddress = values[8];

			contact.dob = values[9];

			if (index != recordNum) {

				pw.println(contact.firstName + "," + contact.lastName + "," + contact.company + "," + contact.homeNumber
						+ "," + contact.workNumber + "," + contact.homeEmail + "," + contact.workEmail + ","
						+ contact.homeAddress + "," + contact.workAddress + "," + contact.dob);
				//System.out.println("ADDED SUCCESFULLLY in edit");

			} else {
				int choice = -1;
				System.out.println("1. Edit firstname");
				System.out.println("2. Edit lastname");
				System.out.println("3. Edit company");
				System.out.println("4. Edit home number");
				System.out.println("5. Edit work number");
				System.out.println("6. Edit home email");
				System.out.println("7. Edit work email");
				System.out.println("8. Edit home Address");
				System.out.println("9. Edit work Address");
				System.out.println("10. Edit dob");
				System.out.println("0. Exit");
				System.out.println("please enter the attribute you want to edit:");
				choice = sc.nextInt();
				sc.nextLine();
				String newValue;
				switch (choice) {
				case 1:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.firstName = newValue;
					break;
				case 2:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.lastName = newValue;
					break;
				case 3:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.company = newValue;
					break;
				case 4:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.homeAddress = newValue;
					break;
				case 5:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.workAddress = newValue;
					break;
				case 6:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.homeEmail = newValue;
					break;
				case 7:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.workEmail = newValue;
					break;
				case 8:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.homeAddress = newValue;
					break;
				case 9:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.workAddress = newValue;
					break;
				case 10:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.dob = newValue;
					break;
				case 0:
					return;
				}
				pw.println(contact.firstName + "," + contact.lastName + "," + contact.company + "," + contact.homeNumber
						+ "," + contact.workNumber + "," + contact.homeEmail + "," + contact.workEmail + ","
						+ contact.homeAddress + "," + contact.workAddress + "," + contact.dob);
				
			}
		}
		pw.close();
		br1.close();
		fw.close();
		fr1.close();
		System.out.println("CONTACT UPDATED SUCCESFULLY");
		System.out.println("press enter to continue");
		sc.nextLine();

	}
	public void SearchContact() throws IOException{
		File file = new File("javaContactDetails.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String value;
		System.out.println("enter value to be searched");
		sc.nextLine();
		value=sc.nextLine();
		String line;
		int found=0;
		while ((line = br.readLine()) != null) {
			
			String values[] = line.split(",");
			Contact contact = new Contact();
			contact.firstName = values[0];

			contact.lastName = values[1];

			contact.company = values[2];

			contact.homeNumber = values[3];

			contact.workNumber = values[4];

			contact.homeEmail = values[5];

			contact.workEmail = values[6];

			contact.homeAddress = values[7];

			contact.workAddress = values[8];

			contact.dob = values[9];
			if(line.indexOf(value)!=-1){
				System.out.println("firstname:" + values[0]);
				System.out.println("lastname:" + values[1]);
				System.out.println("company name:" + values[2]);
				System.out.println("Home Number:" + values[3]);
				System.out.println("Work Number:" + values[4]);
				System.out.println("Home Address:" + values[5]);
				System.out.println("Work Address:" + values[6]);
				System.out.println("Home Email:" + values[7]);
				System.out.println("Work Email:" + values[8]);
				System.out.println("DOB:" + values[9]);
				found++;
			}
		
		}
		if(found==0){
			System.out.println("NO VALUES MATCHED");
			sc.nextLine();
			System.out.println("press enter to continue");
			
		}
		else{
			System.out.println("press enter to continue");
			sc.nextLine();
		}
		br.close();
		fr.close();
		
	}

	public static void main(String args[]) throws IOException,InterruptedException {

		int choice = -1;
		boolean condition = true;
                 
		while (condition) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
			System.out.println("CONTACT MANAGEMENT SYSTEM");
			System.out.println("1.ADD CONTACTS");
			System.out.println("2.EDIT CONTACTS");
			System.out.println("3.DELETE CONTACTS");
			System.out.println("4.SEARCH CONTACTS");
			System.out.println("0.EXIT");
			System.out.println("Please enter your choice");
			
			choice = sc.nextInt();
		
			Contact contact = new Contact();
			switch (choice) {
			case 1:
				File file = new File("javaContactDetails.txt");
				FileWriter fw = new FileWriter(file, true);
				contact = contact.getDetails(contact);
				contact.addContact(contact, fw);
                                    System.out.println("ADDED SUCCESFULLLY");
                                 System.out.println("press enter to continue");
                              sc.nextLine();

				break;
			case 2:
				 contact.editContact();
				break;
			case 3:
				contact.DeleteContact();
				break;
			case 4:
				 contact.SearchContact();
				 break;
			case 0:
				 return;
			default:System.out.println("enter valid input");
				break;
				
			}

		}
	}
}
