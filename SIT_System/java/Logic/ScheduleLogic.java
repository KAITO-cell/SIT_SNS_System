package Logic;
import java.sql.SQLException;
import java.util.List;

import beans.ScheduleModel;
import dao.ScheduleDAO;


public class ScheduleLogic {
	public List<ScheduleModel> makeSchedule() throws SQLException{
		ScheduleDAO dao = new ScheduleDAO();
		List<ScheduleModel> scheduleList = dao.findTimeTable();
		return scheduleList;


	}

}
