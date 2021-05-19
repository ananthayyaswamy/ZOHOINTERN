
public class Address {
	private String address;
	public Address(String address, String type) {
		super();
		this.address = address;
		this.type = type;
	}
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String type;

}
