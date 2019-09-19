package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bean.LoginBean;
import interfaces.LoginInterface;

@Service
public class LoginDao {
	@Autowired
	LoginInterface loginrepo;

	//This method checks employee type of logging in employee and returns the status.
	public String LoginRepository(LoginBean loginbean) {	
		if(loginrepo.findById(loginbean.getUsername()).isPresent())
		{
			LoginBean login = loginrepo.findById(loginbean.getUsername()).get();
			if(login.getPassword().equals(loginbean.getPassword()))
			{
				return login.getRole();
			}
			return "no role";
		}
		return "redirect:Error.jsp";
	}
}