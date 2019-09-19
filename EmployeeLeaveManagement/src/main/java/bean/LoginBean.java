package bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginBean {
	
	@Id
	private String Username;
	private String password;
	private String role;
	
	public String getUsername() {
		return Username;
	}
	
	public void setUsername(String username) {
		Username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "LoginBean [Username=" + Username + ", password=" + password + ", role=" + role + "]";
	}
}