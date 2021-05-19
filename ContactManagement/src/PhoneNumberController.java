import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneNumberController {
	private ArrayList<PhoneNumber>model;
	private PhoneNumberView phoneNumberView;
	public PhoneNumberController(ArrayList<PhoneNumber> model, PhoneNumberView phoneNumberView) {
		super();
		this.model = model;
		this.phoneNumberView = phoneNumberView;
	}
	
	public void addPhone(int contactid,Contact contact) throws SQLException{
		Database db=new Database();
		db.addPhoneNumberIntoDatabase(contact, contactid);
	}
public void editContact(Contact contact,String fname,String lastname ) throws SQLException{
		Scanner sc=new Scanner(System.in);
		Database d=new Database();
		int contactid=d.getContactId(fname, lastname);
		System.out.println("enter the type of mobile number you want to edit");
		String type=sc.nextLine();
		System.out.println("Enter the new value");
		String value=sc.nextLine();
		d.editTypeContact(contactid, "mobilenumber", value, "mobilenumber", type);
		
	}

public int deleteContact(int contactid) throws SQLException{
	Database d=new Database();
	
	
	return d.deleteContact(contactid, "mobilenumber");
	
	
}
public ArrayList<Contact> SearchContact(ArrayList<Contact> li) throws SQLException{
	
	Database d=new Database();
	for( Contact contact:li){
		//System.out.println("in phone controller"+contact.getDob());
		int contactid=d.getContactId(contact.getFirstName());
		//System.out.println("contact id="+contactid);
	contact=	d.searchMobile(contact, contactid, "mobilenumber");
		
	}
	return li;
}
public void display(ArrayList<PhoneNumber> li){
	
	phoneNumberView.displayAddress(li);
}
}
