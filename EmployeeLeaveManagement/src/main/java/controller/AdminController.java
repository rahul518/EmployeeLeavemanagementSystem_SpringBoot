package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import bean.Employee;
import bean.LoginBean;

@Controller
public class AdminController {

	/**
	 * 
	 * @param request
	 * @param response
	 * @return status
	 * @throws ServletException
	 * @throws IOException
	 */
	//This method is used to add an employee.
	@RequestMapping( value="/add",method = RequestMethod.POST)
	public String addemployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Employee employee = new Employee();
		employee.setEmployeeId(request.getParameter("EmployeeId"));
		employee.setPassword(request.getParameter("password"));
		employee.setEmployeeName(request.getParameter("name"));
		employee.setAddress(request.getParameter("address"));
		employee.setEmail(request.getParameter("Email"));
		employee.setPhonenumber(request.getParameter("phonenumber"));	
		employee.setEmployeetype(request.getParameter("employeetype"));

		String url="http://localhost:8282/adminresource/addemployee";
		RestTemplate resttemplate=new RestTemplate();
		String status=resttemplate.postForObject(url,employee,String.class);
		if(status.equals("success"))
			return "AdminFunctionalities.jsp";
		else
			return "Error.jsp";
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return status
	 * @throws ServletException
	 * @throws IOException
	 */
	//This method is used to edit details of an employee.
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String Editdetails(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{

		Employee employeebean = new Employee();
		employeebean.setEmployeeName(request.getParameter("employeeName"));
		employeebean.setPhonenumber(request.getParameter("contact"));
		employeebean.setAddress(request.getParameter("address"));
		employeebean.setEmail(request.getParameter("email"));
		String url="http://localhost:8282/adminresource/editemployee";
		RestTemplate resttemplate=new RestTemplate();
		String status=resttemplate.postForObject(url,employeebean,String.class);
		if(status.equals("success"))
			return "AdminFunctionalities.jsp";
		return "Error.jsp";

	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return status
	 * @throws ServletException
	 * @throws IOException
	 */
	//This method is used to delete the details of an employee. 
	@RequestMapping( value="/delete",method = RequestMethod.POST)
	public String deleteuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		LoginBean loginbean= new LoginBean();
		loginbean.setUsername(request.getParameter("name"));
		String url="http://localhost:8282/adminresource/deleteemployee";
		RestTemplate resttemplate=new RestTemplate();
		String status=resttemplate.postForObject(url, loginbean, String.class);
		if(status.equals("success"))
			return "AdminFunctionalities.jsp";
		else
			return "Error.jsp";
	}
}