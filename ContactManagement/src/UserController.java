
public class UserController {
private User model;
private UserView view;
public UserController(User model, UserView view) {
	super();
	this.model = model;
	this.view = view;
}
public int UserExits(String username){
	return model.userExists(username);
}
public int addUser(String username,String password){
	return model.addUser(username, password);
}
public int getUserId(String username,String password){
	return model.getUserId(username,password);
}

}
