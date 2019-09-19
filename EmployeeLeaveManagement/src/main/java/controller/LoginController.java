package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import bean.LoginBean;

@Controller
public class LoginController {

	/**
	 * 
	 * @return Login.jsp;
	 */
	@RequestMapping(value="/")
	public String login()
	{
		return "Login.jsp";
	}

	/**
	 * 
	 * @param loginbean
	 * @param request
	 * @return status and redirect to respective jsp pages
	 */
	//This method gets the status from logindao and redirects to respective jsp.
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String logincontrol(LoginBean loginbean,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.setAttribute("name", loginbean.getUsername());
		String url="http://localhost:8282/loginresource/validate";
		RestTemplate resttemplate=new RestTemplate();
		String status=resttemplate.postForObject(url, loginbean, String.class);
		if(status.equals("admin"))
			return "AdminFunctionalities.jsp";
		if(status.equals("Employee"))
			return "EmployeeFunctionalities.jsp";
		if(status.equals("manager"))
			return "ManagerFunctionalities.jsp";
		if(status.equals("ceo"))
			return "Ceo.jsp";
		else
			return "Error.jsp";
	}
}