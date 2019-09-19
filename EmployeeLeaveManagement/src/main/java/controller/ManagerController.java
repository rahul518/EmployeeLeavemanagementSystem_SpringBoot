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
public class ManagerController {
	LeaveDetails leave = new LeaveDetails();

	/**
	 * 
	 * @return modelview(ceo)
	 */
	//This method is used to get all ceo's and display in managerapply.jsp.
	@RequestMapping( value="/getCeo",method = RequestMethod.GET)
	public ModelAndView getCeo()
	{
		RestTemplate rest = new RestTemplate();
		ModelAndView modelview = new ModelAndView();
		ResponseEntity<List<Employee>> responseEntity = rest.exchange(
				"http://localhost:8282/employeeresource/getceo", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		modelview.addObject("ceo", responseEntity.getBody());
		modelview.setViewName("managerapply.jsp");
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
	//This method is used to apply leave of a manager.
	@RequestMapping( value="/managerapply",method = RequestMethod.POST)
	public String apply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true);
		leave.setStart(request.getParameter("start"));
		leave.setEnd(request.getParameter("end"));
		leave.setReason(request.getParameter("reason"));
		leave.setEmployeename((String)session.getAttribute("name"));
		leave.setApplyTo(request.getParameter("Ceo"));
		leave.setStatus("Pending");

		String url="http://localhost:8282/employeeresource/getDaysLeft";
		RestTemplate resttemplate=new RestTemplate();
		LeaveDetails leavedetails=resttemplate.postForObject(url,leave,LeaveDetails.class);
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
					return "redirect:ManagerFunctionalities.jsp";
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
	 * @return modelview(ceo)
	 */
	//This method is used to get all ceo's and display in managerapplylop.jsp.
	@RequestMapping( value="/getlopCeo",method = RequestMethod.GET)
	public ModelAndView getlopCeo()
	{
		RestTemplate rest = new RestTemplate();
		ModelAndView modelview = new ModelAndView();
		ResponseEntity<List<Employee>> responseEntity = rest.exchange(
				"http://localhost:8282/employeeresource/getceo", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		modelview.addObject("ceo", responseEntity.getBody());
		modelview.setViewName("managerapplylop.jsp");
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
	//This method is used to applylop of a manager.
	@RequestMapping( value="/managerapplylop",method = RequestMethod.POST)
	public String applyLOP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true);

		leave.setStart(request.getParameter("start"));
		leave.setEnd(request.getParameter("end"));
		leave.setReason(request.getParameter("reason"));
		leave.setEmployeename((String)session.getAttribute("name"));
		leave.setApplyTo(request.getParameter("Ceo"));
		leave.setStatus("Pending");

		String url="http://localhost:8282/employeeresource/getLOPleft";
		RestTemplate resttemplate=new RestTemplate();
		LeaveDetails leavedetails=resttemplate.postForObject(url,leave,LeaveDetails.class);
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
					return "redirect:ManagerFunctionalities.jsp";
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
	//This method is used to view the leaves applied to the manager.
	@RequestMapping( value="/AcceptReject",method = RequestMethod.GET)
	public ModelAndView viewRequests(HttpServletRequest request)
	{
		HttpHeaders requestHeaders = new HttpHeaders();
		HttpSession session = request.getSession();

		leave.setApplyTo((String) session.getAttribute("name"));

		HttpEntity<LeaveDetails> requestEntity1 = new HttpEntity<>(leave, requestHeaders);
		RestTemplate rest = new RestTemplate();
		ModelAndView modelview = new ModelAndView();
		ResponseEntity<List<LeaveDetails>> responseEntity = rest.exchange(
				"http://localhost:8282/employeeresource/viewrequests", HttpMethod.POST, requestEntity1,
				new ParameterizedTypeReference<List<LeaveDetails>>() {
				});
		modelview.addObject("list", responseEntity.getBody());
		modelview.setViewName("AcceptorReject.jsp");
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
	//This method is used to accept the leaves applied by an employee to the manager.
	@RequestMapping( value="/acceptrequest",method = RequestMethod.POST)
	public String acceptrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		leave.setLeaveid(Integer.parseInt(request.getParameter("leaveid")));
		String url="http://localhost:8282/employeeresource/acceptrequest";
		RestTemplate resttemplate=new RestTemplate();
		String status=resttemplate.postForObject(url,leave, String.class);
		if(status.equals("accepted"))
			return "redirect:ManagerFunctionalities.jsp";
		else
			return "redirect:Error.jsp";
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return status
	 * @throws ServletException
	 * @throws IOException
	 */
	//This method is used to reject the leaves applied by an employee to the manager.
	@RequestMapping( value="/rejectrequest",method = RequestMethod.POST)
	public String rejectrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		leave.setLeaveid(Integer.parseInt(request.getParameter("leaveid")));
		System.out.println(leave.getLeaveid());
		String url="http://localhost:8282/employeeresource/rejectrequest";
		RestTemplate resttemplate=new RestTemplate();
		String status=resttemplate.postForObject(url, leave, String.class);
		if(status.equals("rejected"))
			return "redirect:ManagerFunctionalities.jsp";
		else
			return "redirect:Error.jsp";
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return status
	 * @throws ServletException
	 * @throws IOException
	 */
	//This method is used to reject the lop applied by an employee to the manager. 
	@RequestMapping( value="/rejectloprequest",method = RequestMethod.POST)
	public String rejectloprequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		leave.setLeaveid(Integer.parseInt(request.getParameter("leaveid")));
		System.out.println(leave.getLeaveid());
		String url="http://localhost:8282/employeeresource/rejectloprequest";
		RestTemplate resttemplate=new RestTemplate();
		String status=resttemplate.postForObject(url, leave, String.class);
		if(status.equals("rejected"))
			return "redirect:ManagerFunctionalities.jsp";
		else
			return "redirect:Error.jsp";
	}
}