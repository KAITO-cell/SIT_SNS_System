package sit.sns.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * controller for database of schedule and week ,home.jsp
 *
 *
 */
import java.util.ArrayList;
import java.util.List;


public class ScheduleDAO {
	//List<ResultSet> timeTables = new ArrayList<ResultSet>();//store tmetables from monday to saturday;
	private Connection con = null;
	ResultSet rs = null;
	private Statement stmt= null;
	String url = "jdbc:mysql://160.16.141.77:51601/STUDENT";//STUDENT DATABASE
	String user = "master";
	String pass = "Pracb2021*";
	String[] weekIDColumn = {"MONID","TUEID","WEDID","THUID","FRIID","SATID"};
	String[] weekTableName = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
	int weekIndex=0;

	public List<ScheduleModel> findTimeTable() throws SQLException {
		List<ScheduleModel> scheduleList= new ArrayList<ScheduleModel>();

		try {
		Class.forName("com.mysql.cj.jdbc.Driver");


		con = DriverManager.getConnection(url, user, pass);

		stmt = con.createStatement();
		String sql = "SELECT * FROM SCHEDULE WHERE STUDENTID = 'AL19046'";
		ResultSet weekID = stmt.executeQuery(sql);
		List<String> s = new ArrayList<String>();

		while(weekID.next()) {
			for(int i=2;i<7;i++) {
				s.add(weekID.getString(i));
				//System.out.println(s.get(i-2));
			}
			System.out.println(weekID.getString(1));
			//count++;
		}
		weekID.close();

		//rs = stmt.executeQuery("SELECT * FROM MONDAY");
		while(weekIndex<6) {

			//List<String> dayTable = new ArrayList<String>();
			rs = stmt.executeQuery("SELECT * FROM "+ weekTableName[weekIndex++]);
			int i=1;
			//int columnIndex=1;
			//int weekIndex=0;
			//rs = stmt.executeQuery("SELECT * FROM "+ weekTableName[weekIndex]);

			//make day schedule
			//System.out.println(weekID.getInt(1));
			while(rs.next()) {
			ScheduleModel schedule = new ScheduleModel(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
			scheduleList.add(schedule);
			//dayTable.add(rs.getString(i));
			while(i<9) {
				System.out.println("TAG:dayTable "+rs.getString(i));
				i++;
			}

			//timeTables.add(test);
			}
			rs.close();

		}

		}catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			if (con !=null) {
				con.close();
			}
			if (stmt!=null) {
				stmt.close();
			}
			if (rs !=null) {
				rs.close();
			}
		}
		return scheduleList;
	}

//	public static void main(String[] args) {
//		ScheduleLogic sclo = new ScheduleLogic();

//		try {
//			ScheduleDAO dao = new ScheduleDAO();
//			List<ScheduleModel> scheduleList = dao.findTimeTable();
//			System.out.println(scheduleList.get(1).getThird());
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//	}
}
