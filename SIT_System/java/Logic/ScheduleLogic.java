/**************************************************************************************************
 ***  File Name      : Request.java
 ***  Version        : V2.0
 ***  Designer       : 奈良操樹
 ***  Date           : 2021.07.11
 ***  Purpose        : 教科書リスト画面で選択された教科書の情報をセッションに登録する
 ***
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 奈良操樹,2021.06.28
 *** V1.1 : 奈良操樹,2021.07.02
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
