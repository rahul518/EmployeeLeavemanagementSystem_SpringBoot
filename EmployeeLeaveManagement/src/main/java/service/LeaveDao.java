package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import bean.Employee;
import bean.LeaveDetails;
import interfaces.Employeeinterface;
import interfaces.LeaveInterface;

@EnableAutoConfiguration
@Service
public class LeaveDao {
	
	@Autowired
	LeaveInterface leaverepo;

	@Autowired
	Employeeinterface employeerepo;

	@Autowired
	LeaveDao leavedao;

	public ArrayList<Employee> getManagers() {
		return (ArrayList<Employee>) employeerepo.getManagers();
	}

	public LeaveDetails getDays(LeaveDetails leave) {
		Employee employee = employeerepo.findById(leave.getEmployeename()).get();
		leave.setDays_left(employee.getDaysLeft());
		return leave;
	}

	public void applyLeave(LeaveDetails leave) {
		leaverepo.save(leave);
		Employee employee=employeerepo.findById(leave.getEmployeename()).get();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/mm/yyyy");
		LocalDate start = LocalDate.parse(leave.getStart());
		LocalDate end = LocalDate.parse(leave.getEnd());
		int daysbetween=(int) (ChronoUnit.DAYS.between(start,end )+1);
		int daysleft=employee.getDaysLeft()-daysbetween;
		employee.setDaysLeft(daysleft);
		employeerepo.save(employee);
	}

	public LeaveDetails getLOP(LeaveDetails leave) {
		Employee employee = employeerepo.findById(leave.getEmployeename()).get();
		leave.setLop(employee.getLOP());
		System.out.println(leave.getLop() );
		return leave;
	}

	public void applylopLeave(LeaveDetails leave) {
		leaverepo.save(leave);
		Employee employee=employeerepo.findById(leave.getEmployeename()).get();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/mm/yyyy");
		LocalDate start = LocalDate.parse(leave.getStart());
		LocalDate end = LocalDate.parse(leave.getEnd());
		int daysbetween=(int) (ChronoUnit.DAYS.between(start,end )+1);
		int lopsleft=employee.getLOP()-daysbetween;
		employee.setLOP(lopsleft);
		employeerepo.save(employee);
	}

	public ArrayList<LeaveDetails> getLeaves(LeaveDetails leave)
	{
		return (ArrayList<LeaveDetails>) employeerepo.getLeaves(leave.getEmployeename());
	}

	public ArrayList<LeaveDetails> getallleaves(int leaveid) {
		return new ArrayList<LeaveDetails> (leaverepo.getallleaves(leaveid));
	}

	public String cancelrequest(LeaveDetails leavedetails) {
		LeaveDetails Leavedetails1=leaverepo.findById(leavedetails.getLeaveid()).get();
		Employee employee=employeerepo.findById(leavedetails.getEmployeename()).get();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/mm/yyyy");
		LocalDate start = LocalDate.parse(Leavedetails1.getStart());
		LocalDate end = LocalDate.parse(Leavedetails1.getEnd());
		int leftovers=(int) (ChronoUnit.DAYS.between(start,end )+1);
		int daysleft=Leavedetails1.getDays_left()+leftovers;
		Leavedetails1.setDays_left(daysleft);
		Leavedetails1.setStatus("cancelled");
		leaverepo.save(Leavedetails1);
		employee.setDaysLeft(daysleft);
		employeerepo.save(employee);
		return "cancelled";
	}

	public String cancelloprequest(LeaveDetails leavedetails) {
		LeaveDetails Leavedetails1=leaverepo.findById(leavedetails.getLeaveid()).get();
		Employee employee=employeerepo.findById(leavedetails.getEmployeename()).get();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/mm/yyyy");
		LocalDate start = LocalDate.parse(Leavedetails1.getStart());
		LocalDate end = LocalDate.parse(Leavedetails1.getEnd());
		int lopapplied=(int) (ChronoUnit.DAYS.between(start,end )+1);
		int lopsleft=Leavedetails1.getLop()+lopapplied;
		Leavedetails1.setLop(lopsleft);
		Leavedetails1.setStatus("cancelled");
		leaverepo.save(Leavedetails1);
		employee.setLOP(lopsleft);
		employeerepo.save(employee);
		return "cancelled";
	}

	public ArrayList<Employee> getCeo() {
		return (ArrayList<Employee>) employeerepo.getCeo();
	}

	public ArrayList<LeaveDetails> acceptorreject(LeaveDetails leave)
	{
		return (ArrayList<LeaveDetails>) leaverepo.acceptorreject(leave.getApplyTo());
	}


	public String acceptrequest(LeaveDetails leavedetails) {
		LeaveDetails leaveReq=leaverepo.findById(leavedetails.getLeaveid()).get();
		leaveReq.setStatus("accepted");
		leaverepo.save(leaveReq);
		return "accepted";
	}

	public String rejectrequest(LeaveDetails leavedetails) {
		LeaveDetails Leavedetails1=leaverepo.findById(leavedetails.getLeaveid()).get();
		Employee employee=employeerepo.findById(leavedetails.getApplyTo()).get();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/mm/yyyy");
		LocalDate start = LocalDate.parse(Leavedetails1.getStart());
		LocalDate end = LocalDate.parse(Leavedetails1.getEnd());
		int daysbetween=(int) (ChronoUnit.DAYS.between(start,end )+1);
		int daysleft=Leavedetails1.getDays_left()+daysbetween;
		Leavedetails1.setDays_left(daysleft);
		Leavedetails1.setStatus("rejected");
		leaverepo.save(Leavedetails1);
		employee.setDaysLeft(daysleft);
		employeerepo.save(employee);
		return "rejected";
	}

	public String rejectlop(LeaveDetails leavedetails) {
		LeaveDetails Leavedetails1=leaverepo.findById(leavedetails.getLeaveid()).get();
		Employee employee=employeerepo.findById(leavedetails.getApplyTo()).get();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/mm/yyyy");
		LocalDate start = LocalDate.parse(Leavedetails1.getStart());
		LocalDate end = LocalDate.parse(Leavedetails1.getEnd());
		int lopapplied=(int) (ChronoUnit.DAYS.between(start,end )+1);
		int lopsleft=Leavedetails1.getDays_left()+lopapplied;
		Leavedetails1.setDays_left(lopsleft);
		Leavedetails1.setStatus("rejected");
		leaverepo.save(Leavedetails1);
		employee.setDaysLeft(lopsleft);
		employeerepo.save(employee);
		return "rejected";
	}
}