package interfaces;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import bean.LeaveDetails;

public interface LeaveInterface extends JpaRepository<LeaveDetails, Integer> {

	@Query("select m from LeaveDetails m where m.leaveid=:leaveid")
	public ArrayList<LeaveDetails> getallleaves(@Param("leaveid") int leaveid);
	
	@Query("select l from LeaveDetails l where l.applyTo=:apply_to and l.status='Pending'")
	public ArrayList<LeaveDetails> acceptorreject(@Param("apply_to") String apply_to);
}