package sit.sns.system;
import java.sql.SQLException;
import java.util.List;


public class ScheduleLogic {
	public List<ScheduleModel> makeSchedule() throws SQLException{
		ScheduleDAO dao = new ScheduleDAO();
		List<ScheduleModel> scheduleList = dao.findTimeTable("AL19046");//test AL19046
		return scheduleList;


	}

}
