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

import beans.StudentModel;


public class LoginDAO {

	public boolean execute(StudentModel student) {

		//DBの変数
			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

			//SQL
			String sql = "SELECT * FROM STUDENT_INFO";
			String url = "jdbc:mysql://localhost:51601/STUDENT";
			String usr = "master";
			String pass = "Pracb2021*";
			try {
		        // JDBCドライバのロード
				Class.forName("com.mysql.cj.jdbc.Driver");
		        // データベース接続
		        con = DriverManager.getConnection(url,usr,pass);
		        // SQL実行準備
		        stmt = con.prepareStatement(sql);

		        rs = stmt.executeQuery();
		      // データがなくなるまで(rs.next()がfalseになるまで)繰り返す
		        while (rs.next()) {
		            String ID = rs.getString("STUDENTID");
		            String password = rs.getString("PASSWORD");
		            if(ID.equals(student.getStudentID()) && password.equals(student.getStudentPass())) {
		            	stmt.close() ;
		    	        con.close();
		                return true;
		            }
		        }

			} catch (ClassNotFoundException |SQLException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		        		rs.close();
		            	stmt.close() ;
		            	con.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
			return false;
	}
}


