package bean;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Employee {

	@Id
	private String employeeName;
	private String employeeId;
	private String employeetype;
	private int daysLeft;
	private int LOP;
	private String email;
	private String address;
	private String phonenumber;
	private String password;
	
	public int getLOP() {
		return LOP;
	}

	public void setLOP(int lOP) {
		LOP = lOP;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public String getEmployeetype() {
		return employeetype;
	}

	public void setEmployeetype(String employeetype) {
		this.employeetype = employeetype;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeetype="
				+ employeetype + ", daysLeft=" + daysLeft + ", LOP=" + LOP + ", email=" + email + ", address=" + address
				+ ", phonenumber=" + phonenumber + ", password=" + password + "]";
	}
}