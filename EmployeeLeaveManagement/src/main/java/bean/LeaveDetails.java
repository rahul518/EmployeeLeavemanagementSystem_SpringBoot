package bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LeaveDetails{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int leaveid;
	String employeename;
	String applyTo;
	String reason;
	String status;
	String start;
	String end;	
	int days_left;
	int lop;
	
	public int getLop() {
		return lop;
	}

	public void setLop(int lop) {
		this.lop = lop;
	}

	public String getEmployeename() {
		return employeename;
	}
	
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	
	public String getApplyTo() {
		return applyTo;
	}
	
	public void setApplyTo(String applyTo) {
		this.applyTo = applyTo;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStart() {
		return start;
	}
	
	public void setStart(String start) {
		this.start = start;
	}
	
	public String getEnd() {
		return end;
	}
	
	public void setEnd(String end) {
		this.end = end;
	}
	
	public int getLeaveid() {
		return leaveid;
	}
	
	public void setLeaveid(int leaveid) {
		this.leaveid = leaveid;
	}
	
	public int getDays_left() {
		return days_left;
	}
	
	public void setDays_left(int days_left) {
		this.days_left = days_left;
	}
	
	@Override
	public String toString() {
		return "LeaveDetails [ employeename=" + employeename + ", applyTo=" + applyTo + ", reason="
				+ reason + ", status=" + status + ", start=" + start + ", end=" + end + ", leaveid=" + leaveid
				+ ", days_left=" + days_left + "]";
	}
}