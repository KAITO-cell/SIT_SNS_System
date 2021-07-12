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
package dao;
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

import beans.ScheduleModel;


public class ScheduleDAO {
	//List<ResultSet> timeTables = new ArrayList<ResultSet>();//store timetables from monday to saturday;

	Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps =null;
	String url = "jdbc:mysql://localhost:51601/STUDENT";//STUDENT DATABASE
	String user = "master";
	String pass = "Pracb2021*";
	String[] weekTableName = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
	int weekIndex=0;

	//時間割取得
	public List<ScheduleModel> findTimeTable(String stdid) {
		List<ScheduleModel> scheduleList= new ArrayList<ScheduleModel>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);

		for(weekIndex=0;weekIndex<6;weekIndex++) {
			String sql="SELECT * FROM "+ weekTableName[weekIndex]+" WHERE STUDENTID = ?;";
			ps = con.prepareStatement(sql);
			ps.setString(1, stdid);
			rs = ps.executeQuery();
			while(rs.next()) {
				ScheduleModel schedule = new ScheduleModel(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				scheduleList.add(schedule);
			}
		}


		}catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}finally {
				try {
					con.close();
					ps.close();
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return scheduleList;
	}

	//時間割確認
	public boolean exsistTimeTable(String stdid) {
		boolean result=true;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			Statement sm=null;
			for( weekIndex = 0 ; weekIndex < 6 ; weekIndex++ ) {
				String sql = "SELECT STUDENTID FROM " + weekTableName[weekIndex]+";";
				sm =con.createStatement();
				rs = sm.executeQuery(sql);
				//時間割が登録されているかの確認
				while(rs.next()) {
					if(rs.getString("STUDENTID").equals(stdid)) {
						result= true;
						break;
					}else {
						result= false;
					}
				}
				if (result) {
					break;
				}
			}
			sm.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}


	//時間割初期化 動作確認済 0627_10_29
	public void initTimeTable(String stdid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			for(weekIndex=0;weekIndex<6;weekIndex++) {
				String sql = "INSERT INTO "+weekTableName[weekIndex]+" VALUES (?,'0','0','0','0','0','0','0');";
				ps = con.prepareStatement(sql);
				ps.setString(1, stdid);
				System.out.println(weekTableName[weekIndex]+"  aaa");
				ps.executeUpdate();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}




	//時間割更新
	public void insertTimeTable(ScheduleModel table,String tableName,String week,String stdid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			String sql = "Update "+tableName+" SET "+
												week+"1=?,"+
												week+"2=?,"+
												week+"3=?,"+
												week+"4=?,"+
												week+"5=?,"+
												week+"6=?,"+
												week+"7=?"+
												"WHERE STUDENTID=?;";
			ps = con.prepareStatement(sql);
			ps.setString(1, table.getFirst());
			ps.setString(2, table.getSecond());
			ps.setString(3, table.getThird());
			ps.setString(4, table.getFourth());
			ps.setString(5, table.getFifth());
			ps.setString(6, table.getSixth());
			ps.setString(7, table.getSeventh());
			ps.setString(8, stdid);
			ps.executeUpdate();
			}catch (SQLException | ClassNotFoundException e){
				e.printStackTrace();
			}finally {
				try {
					con.close();
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
			}
		}
	}
}

