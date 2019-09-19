package restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import bean.Employee;
import bean.LoginBean;
import service.AdminDao;

@RestController
@RequestMapping("/adminresource")
public class AdminRestController {

	@Autowired
	AdminDao admindao;
	
	@RequestMapping(value = "/addemployee", method = RequestMethod.POST)
	public String addEmployee(@RequestBody Employee employee) {
		admindao.addemployee(employee);
		return "success";
	}

	@RequestMapping(value = "/deleteemployee", method = RequestMethod.POST)
	public String delete(@RequestBody LoginBean login) {
		String status=admindao.deleteuser(login);
		return status;
	}

	@RequestMapping(value = "/editemployee",method = RequestMethod.POST)
	public String editAddress( @RequestBody Employee employeebean) {
		String status=admindao.editEmployee(employeebean);
		return status;
	}	
}

