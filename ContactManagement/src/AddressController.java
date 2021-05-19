import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressController {
	private ArrayList<Address> model;
	private AddressView view;
	public AddressController(ArrayList<Address> model, AddressView view) {
		super();
		this.model = model;
		this.view = view;
	}
	public void addAddress(int contactid,Contact contact) throws SQLException{
		Database db=new Database();
		db.addAddressIntoDatabase(contact, contactid);
	}
	public void editContact(Contact contact,String fname,String lastname ) throws SQLException{
		Scanner sc=new Scanner(System.in);
		Database d=new Database();
		int contactid=d.getContactId(fname, lastname);
		System.out.println("enter the type of Address you want to edit");
		String type=sc.nextLine();
		System.out.println("Enter the new value");
		String value=sc.nextLine();
		d.editTypeContact(contactid, "address", value, "address", type);
		
	}

	public void deleteContact(int contactid) throws SQLException{
		Database d=new Database();
		
		
		d.deleteContact(contactid, "address");
		
		
	}
	public ArrayList<Contact> SearchContact(ArrayList<Contact> li) throws SQLException{
		Database d=new Database();
		for( Contact contact:li){
			int contactid=d.getContactId(contact.getFirstName());
			contact=d.searchAddress(contact, contactid, "address");
		}
		return li;
	}
	
	public void display(ArrayList<Address> li){
		Scanner sc=new Scanner(System.in);
		view.displayAddress(li);
		
	}
}
