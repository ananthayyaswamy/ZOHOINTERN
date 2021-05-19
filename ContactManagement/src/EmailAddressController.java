import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmailAddressController {
	private ArrayList<EmailAddress> model;
	private EmailAddressView view;

	public EmailAddressController(ArrayList<EmailAddress> model, EmailAddressView view) {
		super();
		this.model = model;
		this.view = view;
	}

	public void addEmailAddress(int contactid, Contact contact) throws SQLException {
		Database db = new Database();
		db.addEmailIntoDatabase(contact, contactid);
	}

	public void editContact(Contact contact, String fname, String lastname) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Database d = new Database();
		int contactid = d.getContactId(fname, lastname);
		System.out.println("enter the type of Email you want to edit");
		String type = sc.nextLine();
		System.out.println("Enter the new value");
		String value = sc.nextLine();
		d.editTypeContact(contactid, "emailaddress", value, "email", type);

	}

	public void deleteContact(int contactid) throws SQLException {
		Database d = new Database();

		d.deleteContact(contactid, "email");

	}

	public ArrayList<Contact> SearchContact(ArrayList<Contact> li) throws SQLException {
		Database d = new Database();
		for (Contact contact : li) {
			int contactid = d.getContactId(contact.getFirstName());
			contact = d.searchEmail(contact, contactid, "email");
		}
		return li;
	}

	public void display(ArrayList<EmailAddress> li) {

		view.displayAddress(li);
	}
}
