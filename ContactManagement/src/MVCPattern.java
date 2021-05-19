import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class MVCPattern {
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) throws IOException, InterruptedException, SQLException {

		int choice = -1;
		boolean condition = true;

		while (condition) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			// clrscr();
			System.out.println("CONTACT MANAGEMENT SYSTEM");
			System.out.println("1.ADD CONTACTS");
			System.out.println("2.EDIT CONTACTS");
			System.out.println("3.DELETE CONTACTS");
			System.out.println("4.SEARCH CONTACTS");
			System.out.println("0.EXIT");
			System.out.println("Please enter your choice");
			choice = sc.nextInt();
			String fname;
			String lname;

			switch (choice) {
			case 1:
				Contact contact = addContact();
				// Contact contact = new Contact();
				// contact.setFirstName("test");
				ContactView view = new ContactView();
				ContactController controller = new ContactController(contact, view);
				int cid1 = controller.addContact(contact);
				PhoneNumber p = new PhoneNumber();
				PhoneNumberView phoneNumberView = new PhoneNumberView();
				PhoneNumberController phoneNumberController = new PhoneNumberController(p, phoneNumberView);
				phoneNumberController.addPhone(cid1, contact);
				System.out.println("cid in mvc=" + cid1);
				EmailAddress e = new EmailAddress();
				EmailAddressView emailAddressView = new EmailAddressView();
				EmailAddressController emailAddressController = new EmailAddressController(e, emailAddressView);
				emailAddressController.addEmailAddress(cid1, contact);
				Address a = new Address();
				AddressView addressView = new AddressView();
				AddressController addressController = new AddressController(a, addressView);
				addressController.addAddress(cid1, contact);
				System.out.println("CONTACT ADDED SUCCESSFULLY");
				System.out.println("press enter to continue");
				sc.nextLine();
				break;

			case 2:
				sc.nextLine();
				System.out.println("enter firstname");
				fname = sc.nextLine();
				System.out.println("enter lastname");
				lname = sc.nextLine();
				Contact contact1 = new Contact();
				int choice1 = editContact();
				String field = "";
				if (choice1 >= 1 && choice1 <= 4) {
					if (choice1 == 1) {
						field = "firstname";
					} else if (choice1 == 2) {
						field = "lastname";
					} else if (choice1 == 3) {
						field = "company";
					} else if (choice1 == 4) {
						field = "dob";
					}
					ContactView view1 = new ContactView();
					ContactController controller1 = new ContactController(contact1, view1);
					controller1.editContact(contact1, fname, lname, field);
				} else if (choice1 == 5) {
					PhoneNumberView phoneNumberView1 = new PhoneNumberView();
					PhoneNumber p1 = new PhoneNumber();
					PhoneNumberController phoneNumberController1 = new PhoneNumberController(p1, phoneNumberView1);
					phoneNumberController1.editContact(contact1, fname, lname);
				} else if (choice1 == 6) {
					EmailAddress e1 = new EmailAddress();
					EmailAddressView emailAddressView1 = new EmailAddressView();
					EmailAddressController emailAddressController1 = new EmailAddressController(e1, emailAddressView1);
					emailAddressController1.editContact(contact1, fname, lname);

				} else if (choice1 == 7) {
					Address a1 = new Address();
					AddressView addressView1 = new AddressView();
					AddressController addressController1 = new AddressController(a1, addressView1);
					addressController1.editContact(contact1, fname, lname);

				}
				break;

			case 3:
				sc.nextLine();
				System.out.println("enter first name of the contact to delete");
				fname = sc.nextLine();
				System.out.println("enter last name of the contact to delete");
				lname = sc.nextLine();
				Contact contact2 = new Contact();
				ContactView view1 = new ContactView();
				ContactController controller1 = new ContactController(contact2, view1);
				int cid = controller1.getcid(fname, lname);
				PhoneNumber p2 = new PhoneNumber();
				PhoneNumberView phoneNumberView1 = new PhoneNumberView();
				PhoneNumberController phoneNumberController1 = new PhoneNumberController(p2, phoneNumberView1);
				int value = phoneNumberController1.deleteContact(cid);
				if (value == -1) {
					break;
				}
				EmailAddress e2 = new EmailAddress();
				EmailAddressView emailAddressView1 = new EmailAddressView();
				EmailAddressController emailAddressController1 = new EmailAddressController(e2, emailAddressView1);
				emailAddressController1.deleteContact(cid);
				Address a2 = new Address();
				AddressView addressView1 = new AddressView();
				AddressController addressController1 = new AddressController(a2, addressView1);
				addressController1.deleteContact(cid);
				controller1.deleteContact(cid);
				break;

			case 4: {
				sc.nextLine();
				System.out.println("enter firstname of the contact to be searched ");
				String fname1 = sc.nextLine();
				Contact contact3 = new Contact();
				ContactView view3 = new ContactView();
				ContactController controller3 = new ContactController(contact3, view3);
				ArrayList<Contact> li = controller3.searchContact(fname1);
				// System.out.println("li===mvc"+li);
				PhoneNumberView phoneNumberView3 = new PhoneNumberView();
				PhoneNumber p4 = new PhoneNumber();
				PhoneNumberController phoneNumberController3 = new PhoneNumberController(p4, phoneNumberView3);
				phoneNumberController3.SearchContact(li);
				EmailAddress e3 = new EmailAddress();
				EmailAddressView emailAddressView3 = new EmailAddressView();
				EmailAddressController emailAddressController3 = new EmailAddressController(e3, emailAddressView3);
				emailAddressController3.SearchContact(li);
				Address a3 = new Address();
				AddressView addressView3 = new AddressView();
				AddressController addressController3 = new AddressController(a3, addressView3);
				addressController3.SearchContact(li);

				for (Contact c : li) {
					controller3.display(c);
					phoneNumberController3.display(c.getPhoneNumber());
					emailAddressController3.display(c.getEmailAddress());
					addressController3.display(c.getAddress());
					System.out.println();
				}
				System.out.println("press enter to continue");
				sc.nextLine();

				break;
			}

			}

		}
	}

	private static Contact addContact() {
		int choice = -1;
		Contact contact = new Contact();
		sc.nextLine();
		System.out.println("Enter fisrtname");
		contact.setFirstName(sc.nextLine());

		System.out.println("Enter last name");
		contact.setLastName(sc.nextLine());

		System.out.println("Enter company name");
		contact.setCompany(sc.nextLine());

		System.out.println("Enter Phone  ");
		contact.setPhoneNumber(setPhoneValues(contact.getPhoneNumber()));
		System.out.println("Enter EMail");
		contact.setEmailAddress(setEmailValues(contact.getEmailAddress()));
		System.out.println("enter address");
		contact.setAddress(setAddressValues(contact.getAddress()));
		sc.nextLine();
		System.out.println("Enter dob");
		contact.setDob(sc.nextLine());
		return contact;
	}

	private static ArrayList setPhoneValues(ArrayList<PhoneNumber> map) {
		map = new ArrayList<>();
		int choice = -1;
		while (true) {
			System.out.println("to add Phonenumber press 1 ,to exit press 0");
			choice = sc.nextInt();

			String key = "", val = "";
			switch (choice) {

			case 1:
				sc.nextLine();
				System.out.println("enter type");

				key = sc.nextLine();
				System.out.println("enter value");
				val = sc.nextLine();
				PhoneNumber ph = new PhoneNumber(val, key);
				map.add(ph);

				break;

			case 0: {
				return map;
			}
			default:
				break;
			}

		}
		// return map;
	}

	private static ArrayList setEmailValues(ArrayList<EmailAddress> map) {
		map = new ArrayList<>();
		int choice = -1;
		while (true) {
			System.out.println("to add Email press 1 ,to exit press 0");
			choice = sc.nextInt();

			String key = "", val = "";
			switch (choice) {

			case 1:
				sc.nextLine();
				System.out.println("enter type");

				key = sc.nextLine();
				System.out.println("enter value");
				val = sc.nextLine();
				EmailAddress ph = new EmailAddress(val, key);
				map.add(ph);

				break;

			case 0: {
				return map;
			}
			default:
				break;
			}

		}
		// return map;
	}

	private static ArrayList setAddressValues(ArrayList<Address> map) {
		map = new ArrayList<>();
		int choice = -1;
		while (true) {
			System.out.println("to add Address press 1 ,to exit press 0");
			choice = sc.nextInt();

			String key = "", val = "";
			switch (choice) {

			case 1:

				sc.nextLine();
				System.out.println("enter type");

				key = sc.nextLine();
				System.out.println("enter value");
				val = sc.nextLine();
				Address ph = new Address(val, key);
				map.add(ph);

				break;

			case 0: {
				return map;
			}
			default:
				break;
			}

		}
		// return map;
	}

	public static int editContact() {
		int choice;

		System.out.println("1. Edit firstname");
		System.out.println("2. Edit lastname");
		System.out.println("3. Edit company");
		System.out.println("4. Edit dob");
		System.out.println("5. Edit Phone number");

		System.out.println("6. Edit  email");

		System.out.println("7. Edit  Address");

		// System.out.println("0. Exit");
		choice = sc.nextInt();

		return choice;
	}

}