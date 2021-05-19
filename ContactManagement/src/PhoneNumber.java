
public class PhoneNumber {
private String phoneNumber;
public PhoneNumber(String phoneNumber, String type) {
	super();
	this.phoneNumber = phoneNumber;
	this.type = type;
}
public PhoneNumber() {
	// TODO Auto-generated constructor stub
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
private String type;

}
