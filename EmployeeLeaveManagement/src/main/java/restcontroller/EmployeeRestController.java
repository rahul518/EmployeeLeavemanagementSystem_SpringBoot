package restcontroller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import bean.Employee;
import bean.LeaveDetails;
import service.LeaveDao;

@RestController
@RequestMapping("/employeeresource")
public class EmployeeRestController {

	@Autowired
	LeaveDao leavedao;

	@RequestMapping(value = "/getmanagers", method = RequestMethod.GET)
	public ArrayList<Employee> GetManagers() {
		return (ArrayList<Employee>)leavedao.getManagers();
	}

	@RequestMapping(value = "/getDaysLeft", method = RequestMethod.POST)
	public LeaveDetails GetDays(@RequestBody LeaveDetails leave) {	
		return leavedao.getDays(leave);
	}

	//This method returns applied when an employee/manager successfully applies leave.
	@RequestMapping(value = "/applyleave", method = RequestMethod.POST)
	public String ApplyLeave(@RequestBody LeaveDetails leave) {
		leavedao.applyLeave(leave);
		return "applied";
	}

	@RequestMapping(value = "/getmanagersforlop", method = RequestMethod.GET)
	public ArrayList<Employee> GetManagersLop() {
		return (ArrayList<Employee>)leavedao.getManagers();
	}

	@RequestMapping(value = "/getLOPleft", method = RequestMethod.POST)
	public LeaveDetails GetLOP(@RequestBody LeaveDetails leave) {
		return leavedao.getLOP(leave);
	}

	@RequestMapping(value = "/applyleaveLOP", method = RequestMethod.POST)
	public String applyleaveLOP(@RequestBody LeaveDetails leave) {
		leavedao.applylopLeave(leave);
		return "applied";
	}

	@RequestMapping(value="/getLeaves",method=RequestMethod.POST)
	public ArrayList<LeaveDetails> getLeaves(@RequestBody LeaveDetails leave)
	{
		return (ArrayList<LeaveDetails>)leavedao.getLeaves(leave);
	}

	@RequestMapping(value = "/cancelview/{leaveid}", method = RequestMethod.GET)
	public ArrayList<LeaveDetails> cancelview(@PathVariable("leaveid")int leaveid)
	{
		return leavedao.getallleaves(leaveid);
	}

	@RequestMapping(value = "/cancelleave", method = RequestMethod.POST)
	public String cancelrequest(@RequestBody LeaveDetails leavedetails) {
		String status=leavedao.cancelrequest(leavedetails);
		return status;
	}

	@RequestMapping(value = "/cancellopview/{leaveid}", method = RequestMethod.GET)
	public ArrayList<LeaveDetails> cancellopview(@PathVariable("leaveid")int leaveid)
	{
		return leavedao.getallleaves(leaveid);
	}

	@RequestMapping(value = "/cancelleavelop", method = RequestMethod.POST)
	public String cancelloprequest(@RequestBody LeaveDetails leavedetails) {
		String status=leavedao.cancelloprequest(leavedetails);
		return status;
	}

	@RequestMapping(value = "/getceo", method = RequestMethod.GET)
	public ArrayList<Employee> GetCeo() {
		return (ArrayList<Employee>)leavedao.getCeo();
	}

	@RequestMapping(value="/viewrequests",method=RequestMethod.POST)
	public ArrayList<LeaveDetails> viewrequests(@RequestBody LeaveDetails leave)
	{
		return (ArrayList<LeaveDetails>)leavedao.acceptorreject(leave);
	}

	@RequestMapping(value = "/acceptrequest", method = RequestMethod.POST)
	public String acceptrequest(@RequestBody LeaveDetails leavedetails) {
		String status=leavedao.acceptrequest(leavedetails);
		return status;
	}

	//This method returns status when a leave is rejected.
	@RequestMapping(value = "/rejectrequest", method = RequestMethod.POST)
	public String rejectrequest(@RequestBody LeaveDetails leavedetails) {
		String status=leavedao.rejectrequest(leavedetails);
		return status;
	}

	@RequestMapping(value = "/rejectrlopequest", method = RequestMethod.POST)
	public String rejectloprequest(@RequestBody LeaveDetails leavedetails) {
		String status=leavedao.rejectlop(leavedetails);
		return status;
	}
}












