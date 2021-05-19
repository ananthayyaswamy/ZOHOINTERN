import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactController {
	private Contact model;
	private ContactView view;
	public ContactController(Contact model, ContactView view)
    {
        this.model = model;
        this.view = view;
    }
	
	public int addContact(Contact contact) throws SQLException{
		
		Database d=new Database();
		int contactid=d.addContactIntoDatabase(contact);
		
		return contactid;
		
	}
	public void editContact(Contact contact,String fname,String lastname,String field ) throws SQLException{
		Scanner sc=new Scanner(System.in);
		//System.out.println("enter the field you want to edit");
		//String field=sc.nextLine();
		System.out.println("enter the new value");
		String value=sc.nextLine();
		Database d=new Database();
		int contactid=d.getContactId(fname, lastname);
		d.editContact(contactid, field, value,"contact");
		
		
		
	}
	public int getcid(String fname,String lname) throws SQLException{
		Database d=new Database();
		int contactid=d.getContactId(fname, lname);
		return contactid;
	}
	public void deleteContact(int contactid) throws SQLException{
		Database d=new Database();
		
		
		d.deleteContact(contactid, "contact");
		
		
	}
	public ArrayList<Contact> searchContact(String fname) throws SQLException{
		Database d=new Database();
		//int cid=d.getContactId(fname);
		//System.out.println("Search="+cid);
		return d.SearchContact(fname, "contact");
		
	}
	public void display(Contact c){
		
			view.show(c);
		
	}

}
