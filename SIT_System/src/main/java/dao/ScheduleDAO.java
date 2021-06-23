package sit.sns.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	private ResultSet rs = null;
	private Statement stmt= null;
	private PreparedStatement pstmt = null;
	String url = "jdbc:mysql://160.16.141.77:51601/STUDENT";//STUDENT DATABASE
	String user = "master";
	String pass = "Pracb2021*";
	String[] weekID=new String[5];//store MONID,TUEID,WEDID...
//	String[] weekColumnName = ;//{"MONID","TUEID","WEDID","THUID","FRIID","SATID"};
	String[] weekTableName = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
	int weekIndex=0;


	public List<ScheduleModel> findTimeTable() throws SQLException {
		List<ScheduleModel> scheduleList= new ArrayList<ScheduleModel>();

		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pass);
		stmt = con.createStatement();
		//String sql = "SELECT * FROM SCHEDULE WHERE STUDENTID = 'AL19046'";
		//ResultSet weekID = stmt.executeQuery(sql);

//		while(weekID.next()) {
//			int i = 0;
//			while(i<weekColumnName.length){
//				weekID[i++] = weekID.getString(weekColumnName);
//			}
//		}

//		weekID.close();
//		rs = stmt.executeQuery("SELECT * FROM MONDAY");
		while(weekIndex<6) {//for(int j=0;j<weekID.length){
			//int j=0;
			rs = stmt.executeQuery("SELECT * FROM "+ weekTableName[weekIndex++]);//WHERE weekColumnName=weekID[j]
			while(rs.next()) {

				ScheduleModel schedule = new ScheduleModel(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				scheduleList.add(schedule);

				for(int i=1;i<9;i++) {System.out.println("TAG:dayTable "+rs.getString(i));}
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

	public boolean insertTimeTable() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pass);
		String sql = "insert into"
		pstmt = con.prepareStatement();
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
		return true;
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
