package interfaces;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import bean.Employee;
import bean.LeaveDetails;

@Repository
public interface Employeeinterface extends JpaRepository<Employee, String> {

	@Query("select c from Employee c where c.employeetype='Manager'")
	ArrayList<Employee> getManagers();

	@Query("select c from LeaveDetails c where c.employeename=:employeeName")
	ArrayList<LeaveDetails> getLeaves(@Param("employeeName") String employeeName);

	@Query("select c from Employee c where c.employeetype='Ceo'")
	ArrayList<Employee> getCeo();
}