/**************************************************************************************************
 ***  File Name      : ScheduleLodic.java
 ***  Version        : V1.0
 ***  Designer       : 寺岡克起
 ***  Date           : 2021.06.17
 ***  Purpose        : ScheduleDAOによりデータベースから読みだした値に基づく、ScheduleModelインスタンスのListを生成する
 ***                   
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 寺岡克起,2021.06.17
 */
package Logic;
import java.sql.SQLException;
import java.util.List;

import beans.ScheduleModel;
import dao.ScheduleDAO;;


public class ScheduleLogic {
	public List<ScheduleModel> makeSchedule(String stdid) throws SQLException{
		ScheduleDAO dao = new ScheduleDAO();
		List<ScheduleModel> scheduleList = dao.findTimeTable(stdid);
		return scheduleList;


	}

}
