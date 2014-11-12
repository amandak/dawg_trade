package edu.uga.dawgtrades.model.impl;
import edu.uga.dawgtrades.model.RegisteredUser;
import edu.uga.dawgtrades.persist.impl.PersistableImpl;


public class RegisteredUserImpl extends PersistableImpl implements RegisteredUser {

	private String name;
	private String firstName;
	private String lastName;
	private String password;
	private boolean isAdmin;
	private String email;
	private String phone;
	private boolean canText;
	
	public RegisteredUserImpl(){}

	public RegisteredUserImpl(String name, String firstName, String lastName,
			String password, boolean isAdmin, String email, String phone,
			boolean canText) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.isAdmin = isAdmin;
		this.email = email;
		this.phone = phone;
		this.canText = canText;
	}
	
	public long getID() {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPersistent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean getIsAdmin() {
		return isAdmin;
	}

	@Override
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public boolean getCanText() {
		return canText;
	}

	@Override
	public void setCanText(boolean canText) {
		this.canText = canText;
	}

}
