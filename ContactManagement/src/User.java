
public class User {
	private String User;
	private String password;
	private int userid;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int userExists(String username){
		Database d=new Database();
		return d.UserExists(username);
	}
public int addUser(String username,String password){
	Database d=new Database();
	return d.addUser(username, password);
}
public int getUserId(String username,String password){
	Database d=new Database();
	return d.getUserId(username,password);
}

}
