import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UtilityClass {
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) throws IOException, InterruptedException {

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
				contact = getDetails(contact);
				addContact(contact, fw);

				break;
			case 2:
				UtilityClass.editContact();
				break;
			case 3:
				DeleteContact();
				break;
			case 4:
				SearchContact();
				break;
			case 0:
				return;
			default:
				System.out.println("enter valid input");
				break;

			}

		}
	}

	public static void addContact(Contact contact, FileWriter fw) throws IOException {

		PrintWriter pw = new PrintWriter(fw);
		pw.println(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getCompany() + ","
				+ contact.getHomeNumber() + "," + contact.getWorkNumber() + "," + contact.getHomeEmail() + ","
				+ contact.getWorkEmail() + "," + contact.getHomeAddress() + "," + contact.getWorkAddress() + ","
				+ contact.getDob());
		System.out.println("ADDED SUCCESFULLLY");
		pw.close();

	}

	public static void addContact(Contact contact, PrintWriter pw) {
		pw.println(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getCompany() + ","
				+ contact.getHomeNumber() + "," + contact.getWorkNumber() + "," + contact.getHomeEmail() + ","
				+ contact.getWorkEmail() + "," + contact.getHomeAddress() + "," + contact.getWorkAddress() + ","
				+ contact.getDob());
	}

	public static Contact setContactsAttributes(Contact contact, String values[]) {
		contact.setFirstName(values[0]);
		contact.setLastName(values[1]);
		contact.setCompany(values[2]);
		contact.setHomeNumber(values[3]);
		contact.setWorkNumber(values[4]);
		contact.setHomeEmail(values[5]);
		contact.setWorkEmail(values[6]);
		contact.setHomeAddress(values[7]);

		contact.setWorkAddress(values[8]);

		contact.setDob(values[9]);
		return contact;
	}

	public static void editContact() throws IOException {
		String fname;
		String lname;
		sc.nextLine();

		System.out.println("Enter fisrtname");
		fname = sc.nextLine();
		System.out.println("Enter last name");
		lname = sc.nextLine();
		int recordNum = getContacts(fname, lname);
		if (recordNum == -1) {
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

			UtilityClass.setContactsAttributes(contact, values);
			if (index != recordNum) {

				addContact(contact, pw);

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
					contact.setFirstName(newValue);
					break;
				case 2:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.setLastName(newValue);
					;
					break;
				case 3:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.setCompany(newValue);
					break;
				case 4:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.setHomeNumber(newValue);
					break;
				case 5:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.setWorkNumber(newValue);
					break;
				case 6:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.setHomeEmail(newValue);
					break;
				case 7:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.setWorkEmail(newValue);
					break;
				case 8:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.setHomeAddress(newValue);
					break;
				case 9:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.setWorkAddress(newValue);
					break;
				case 10:
					System.out.println("enter new value:");
					newValue = sc.nextLine();
					contact.setDob(newValue);
					break;
				case 0:
					return;
				}
				pw.println(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getCompany() + ","
						+ contact.getHomeNumber() + "," + contact.getWorkNumber() + "," + contact.getHomeEmail() + ","
						+ contact.getWorkEmail() + "," + contact.getHomeAddress() + "," + contact.getWorkAddress() + ","
						+ contact.getDob());

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

	public static int getContacts(String fname, String lname) throws IOException {
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

			UtilityClass.setContactsAttributes(contact, values);
			if (fname.equals(values[0]) && lname.equals(values[1])) {
				found++;
				returnValue = index;
				System.out.println("firstname:" + values[0]);
				System.out.println("lastname:" + values[1]);
				System.out.println("company name:" + values[2]);
				System.out.println("Home Number:" + values[3]);
				System.out.println("Work Number:" + values[4]);
				
				System.out.println("Home Email:" + values[5]);
				System.out.println("Work Email:" + values[6]);
                                System.out.println("Home Address:" + values[7]);
				System.out.println("Work Address:" + values[8]);
				System.out.println("DOB:" + values[9]);

				System.out.println("RECORD NUMBER: " + index);
				addContact(contact, pw1);

			} else {
				addContact(contact, pw1);

			}
		}
		pw1.close();
		fw1.close();
		br.close();
		fr.close();

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

	public static void SearchContact() throws IOException {
		File file = new File("javaContactDetails.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String value;
		System.out.println("enter value to be searched");
		sc.nextLine();
		value = sc.nextLine();
		String line;
		int found = 0;
		while ((line = br.readLine()) != null) {

			String values[] = line.split(",");
			Contact contact = new Contact();

			setContactsAttributes(contact, values);
			if (line.indexOf(value) != -1) {
				System.out.println("firstname:" + values[0]);
				System.out.println("lastname:" + values[1]);
				System.out.println("company name:" + values[2]);
				System.out.println("Home Number:" + values[3]);
				System.out.println("Work Number:" + values[4]);
                                 System.out.println("Home Email:" + values[5]);
				System.out.println("Work Email:" + values[6]);
				System.out.println("Home Address:" + values[7]);
				System.out.println("Work Address:" + values[8]);
				
				System.out.println("DOB:" + values[9]);
				found++;
			}

		}
		if (found == 0) {
			System.out.println("NO VALUES MATCHED");
			sc.nextLine();
			System.out.println("press enter to continue");

		} else {
			System.out.println("press enter to continue");
			sc.nextLine();
		}
		br.close();
		fr.close();

	}

	public static void DeleteContact() throws IOException {
		String fname;
		String lname;
		sc.nextLine();

		System.out.println("Enter fisrtname");
		fname = sc.nextLine();
		System.out.println("Enter last name");
		lname = sc.nextLine();

		int recordNum = getContacts(fname, lname);
		if (recordNum == -1) {
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

			setContactsAttributes(contact, values);
			if (index != recordNum) {

				addContact(contact, pw);
				System.out.println("ADDED SUCCESFULLLY in delete");

			}
		}
		pw.close();
		br1.close();
		fw.close();
		fr1.close();

	}

	public static Contact getDetails(Contact contact) {
		sc.nextLine();
		System.out.println("Enter fisrtname");
		contact.setFirstName(sc.nextLine());

		System.out.println("Enter last name");
		contact.setLastName(sc.nextLine());

		System.out.println("Enter company name");
		contact.setCompany(sc.nextLine());

		System.out.println("Enter home phone");
		contact.setHomeNumber(sc.nextLine());

		System.out.println("Enter work phone");
		contact.setWorkNumber(sc.nextLine());

		System.out.println("Enter home email");
		contact.setHomeEmail(sc.nextLine());

		System.out.println("Enter work email");
		contact.setWorkEmail(sc.nextLine());

		System.out.println("Enter home address");
		contact.setHomeAddress(sc.nextLine());

		System.out.println("Enter work address");
		contact.setWorkAddress(sc.nextLine());

		System.out.println("Enter dob");
		contact.setDob(sc.nextLine());

		return contact;
	}

}
