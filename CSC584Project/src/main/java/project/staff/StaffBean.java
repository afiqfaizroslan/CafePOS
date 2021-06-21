package project.staff;
import java.io.Serializable;
public class StaffBean implements Serializable  
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID;
	private String Name;
	private String Phone;
	private String Password;
	private String outlet_ID;
	public boolean valid;
	
	
	
	public StaffBean() {

	}
	public StaffBean(String iD, String name, String phone, String password, String outlet_ID, boolean valid) {
		ID = iD;
		Name = name;
		Phone = phone;
		Password = password;
		this.outlet_ID = outlet_ID;
		this.valid = valid;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getOutlet_ID() {
		return outlet_ID;
	}
	public void setOutlet_ID(String outlet_ID) {
		this.outlet_ID = outlet_ID;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	
	
	
	
	
	
	
	
	
	

}
