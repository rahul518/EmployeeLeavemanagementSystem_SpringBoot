package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import bean.Employee;
import bean.LeaveDetails;

@Controller
public class EmployeeController {

	LeaveDetails leave = new LeaveDetails();
	Employee employee = new Employee();

	/**
	 * 
	 * @return modelview(managers)
	 */
	//This method is used to display list of managers in apply.jsp.
	@RequestMapping( value="/getManagers",method = RequestMethod.GET)
	public ModelAndView getManagers()
	{
		RestTemplate rest = new RestTemplate();
		ModelAndView modelview = new ModelAndView();
		ResponseEntity<List<Employee>> responseEntity = rest.exchange(
				"http://localhost:8282/employeeresource/getmanagers", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		modelview.addObject("managers", responseEntity.getBody());
		modelview.setViewName("apply.jsp");
		return modelview;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return status
	 * @throws ServletException
	 * @throws IOException
	 */
	//This method is used to apply leave.
	@RequestMapping( value="/apply",method = RequestMethod.POST)
	public String apply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true);

		leave.setStart(request.getParameter("start"));
		leave.setEnd(request.getParameter("end"));
		leave.setReason(request.getParameter("reason"));
		leave.setEmployeename((String)session.getAttribute("name"));
		leave.setDays_left(employee.getDaysLeft());
		leave.setApplyTo(request.getParameter("Manager"));
		leave.setStatus("Pending");
		leave.setLop(employee.getLOP());

		String url="http://localhost:8282/employeeresource/getDaysLeft";
		RestTemplate resttemplate=new RestTemplate();
		LeaveDetails leavedetails=resttemplate.postForObject(url,leave,LeaveDetails.class);
		System.out.println(leavedetails);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/mm/yyyy");
		LocalDate start = LocalDate.parse(request.getParameter("start"));
		LocalDate end = LocalDate.parse(request.getParameter("end"));
		if(ChronoUnit.DAYS.between(start, end)+1 < 5)
		{
			if(ChronoUnit.DAYS.between(start, end)+1 <= leavedetails.getDays_left() )
			{
				leavedetails.setDays_left(leavedetails.getDays_left() - (int) ((ChronoUnit.DAYS.between(start, end)+1)));
				String url1="http://localhost:8282/employeeresource/applyleave";
				RestTemplate resttemplate1=new RestTemplate();
				String status1=resttemplate1.postForObject(url1,leavedetails,String.class);
				if(status1.equals("applied"))
					return "redirect:EmployeeFunctionalities.jsp";
			}
		}
		else if(leavedetails.getDays_left()==0)
		{
			return "redirect:Error.jsp";
		}
		return "applied";
	}

	/**
	 * 
	 * @return modelview(managers)
	 */
	//This method is used to get list of managers in applyforLOP.jsp. 
	@RequestMapping( value="/getManagersforLOP",method = RequestMethod.GET)
	public ModelAndView getManagersLOP()
	{
		RestTemplate rest = new RestTemplate();
		ModelAndView modelview = new ModelAndView();
		ResponseEntity<List<Employee>> responseEntity = rest.exchange(
				"http://localhost:8282/employeeresource/getmanagersforlop", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		modelview.addObject("managers", responseEntity.getBody());
		modelview.setViewName("applyforLOP.jsp");
		return modelview;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return status
	 * @throws ServletException
	 * @throws IOException
	 */
	//This method is used to applylop.
	@RequestMapping( value="/applyLOP",method = RequestMethod.POST)
	public String applyLOP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true);

		leave.setStart(request.getParameter("start"));
		leave.setEnd(request.getParameter("end"));
		leave.setReason(request.getParameter("reason"));
		leave.setEmployeename((String)session.getAttribute("name"));
		leave.setDays_left(employee.getDaysLeft());
		leave.setApplyTo(request.getParameter("Manager"));
		leave.setStatus("Pending");

		String url="http://localhost:8282/employeeresource/getLOPleft";
		RestTemplate resttemplate=new RestTemplate();
		LeaveDetails leavedetails=resttemplate.postForObject(url,leave,LeaveDetails.class);
		System.out.println(leavedetails);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/mm/yyyy");
		LocalDate start = LocalDate.parse(request.getParameter("start"));
		LocalDate end = LocalDate.parse(request.getParameter("end"));
		if(ChronoUnit.DAYS.between(start, end)+1 < 2)
		{
			if(ChronoUnit.DAYS.between(start, end)+1 <= leavedetails.getLop() )
			{
				leavedetails.setLop(leavedetails.getLop() - (int) ((ChronoUnit.DAYS.between(start, end)+1)));
				String url1="http://localhost:8282/employeeresource/applyleaveLOP";
				RestTemplate resttemplate1=new RestTemplate();
				String status1=resttemplate1.postForObject(url1,leavedetails,String.class);
				if(status1.equals("applied"))
					return "redirect:EmployeeFunctionalities.jsp";
			}
		}
		else if(leavedetails.getLop()==0)
		{
			return "redirect:Error.jsp";
		}
		return "applied";
	}

	/**
	 * 
	 * @param request
	 * @return modelview
	 */
	//This method is used to view the leaves applied and cancel in CancelRequest.jsp.
	@RequestMapping( value="/cancelview",method = RequestMethod.GET)
	public ModelAndView viewRequests(HttpServletRequest request)
	{
		HttpHeaders requestHeaders = new HttpHeaders();
		HttpSession session = request.getSession();

		leave.setEmployeename((String) session.getAttribute("name"));
		HttpEntity<LeaveDetails> requestEntity1 = new HttpEntity<>(leave, requestHeaders);
		RestTemplate rest = new RestTemplate();
		ModelAndView modelview = new ModelAndView();
		ResponseEntity<List<LeaveDetails>> responseEntity = rest.exchange(
				"http://localhost:8282/employeeresource/getLeaves", HttpMethod.POST, requestEntity1,
				new ParameterizedTypeReference<List<LeaveDetails>>() {
				});
		modelview.addObject("leaves", responseEntity.getBody());
		modelview.setViewName("CancelRequest.jsp");
		return modelview;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return status
	 * @throws ServletException
	 * @throws IOException
	 */
	//This method is used to cancel the leave applied.
	@RequestMapping( value="/cancelleave",method = RequestMethod.POST)
	public String cancelrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		leave.setLeaveid(Integer.parseInt(request.getParameter("leaveid")));
		String url="http://localhost:8282/employeeresource/cancelleave";
		RestTemplate resttemplate=new RestTemplate();
		String status=resttemplate.postForObject(url,leave, String.class);
		if(status.equals("cancelled"))
			return "redirect:EmployeeFunctionalities.jsp";
		else
			return "redirect:Error.jsp";
	}

	/**
	 * 
	 * @param request
	 * @return modelview
	 */
	//This method is used to view and cancel the lop leaves applied in cancellop.jsp.  
	@RequestMapping( value="/cancellopview",method = RequestMethod.GET)
	public ModelAndView lopRequests(HttpServletRequest request)
	{
		HttpHeaders requestHeaders = new HttpHeaders();
		HttpSession session = request.getSession();

		leave.setEmployeename((String) session.getAttribute("name"));
		HttpEntity<LeaveDetails> requestEntity1 = new HttpEntity<>(leave, requestHeaders);
		RestTemplate rest = new RestTemplate();
		ModelAndView modelview = new ModelAndView();
		ResponseEntity<List<LeaveDetails>> responseEntity = rest.exchange(
				"http://localhost:8282/employeeresource/getLeaves", HttpMethod.POST, requestEntity1,
				new ParameterizedTypeReference<List<LeaveDetails>>() {
				});
		modelview.addObject("leaves", responseEntity.getBody());
		modelview.setViewName("cancellop.jsp");
		return modelview;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return status
	 * @throws ServletException
	 * @throws IOException
	 */
	//This method is used to cancel lop applied by an employee.
	@RequestMapping( value="/cancelleavelop",method = RequestMethod.POST)
	public String cancelloprequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		leave.setLeaveid(Integer.parseInt(request.getParameter("leaveid")));
		String url="http://localhost:8282/employeeresource/cancelleavelop";
		RestTemplate resttemplate=new RestTemplate();
		String status=resttemplate.postForObject(url,leave, String.class);
		if(status.equals("cancelled"))
			return "redirect:EmployeeFunctionalities.jsp";
		else
			return "redirect:Error.jsp";
	}
}