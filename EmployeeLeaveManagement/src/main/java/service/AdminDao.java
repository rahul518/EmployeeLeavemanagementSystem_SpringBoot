package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import bean.Employee;
import bean.LoginBean;
import interfaces.Employeeinterface;
import interfaces.LoginInterface;

@EnableAutoConfiguration
@Service
public class AdminDao {

	LoginBean loginbean= new LoginBean();
	
	@Autowired
	LoginInterface logininterface;
	@Autowired
	Employeeinterface employeeinterface;
	
	public String addemployee(Employee employee) {
		LoginBean loginbean= new LoginBean();
		loginbean.setUsername(employee.getEmployeeName());
		loginbean.setPassword(employee.getPassword());
		loginbean.setRole(employee.getEmployeetype());
		logininterface.save(loginbean);
		employee.setDaysLeft(10);
		employee.setLOP(3);
		employeeinterface.save(employee);
		return "success";
	}
	
	public String deleteuser(LoginBean login) {
        LoginBean loginbean=new LoginBean();
        String username = login.getUsername();
		loginbean=logininterface.findById(username).get();
		logininterface.delete(loginbean);
		Employee employee = employeeinterface.findById(username).get();
		employeeinterface.delete(employee);
		return "success";
	}
	
	public String editEmployee(Employee employeebean) {
		Employee employee = employeeinterface.findById(employeebean.getEmployeeName()).get();
		employee.setAddress(employeebean.getAddress());
		employee.setEmail(employeebean.getEmail());
		employee.setPhonenumber(employeebean.getPhonenumber());
		employeeinterface.save(employee);
		return "success";
	}
}