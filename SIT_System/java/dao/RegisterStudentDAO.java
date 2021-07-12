  
/**************************************************************************************************
 ***  File Name      : ScheduleDAO.java
 ***  Version        : V1.3
 ***  Designer       : 永井海音
 ***  Date           : 2021.06.17
 ***  Purpose        : データベースに接続し、時間割のデータを更新、挿入、選択する。
 ***                   
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 永井海音,2021.06.17
 *** V1.1 : 永井海音,2021.06.20
 *** V1.2 : 永井海音,2021.06.25
 *** V1.3 : 永井海音,2021.06.28
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.StudentModel;

public class RegisterStudentDAO {

	String url = "jdbc:mysql://localhost:51601/STUDENT";//STUDENT DATABASE
	String usr = "master";
	String pass = "Pracb2021*";


	public boolean registerCheck(StudentModel student) {

		//確認処理
		//登録する内容がデータベースに重複していないか確認

		try {
			// ドライバクラスをロード
	    	Class.forName("com.mysql.cj.jdbc.Driver");

		    // データベースへ接続
	    	Connection con = DriverManager.getConnection(url,usr,pass);

	    	Statement stmt = con.createStatement();
	    	// 検索の実施と重複の確認
	        String sql_check = "SELECT * FROM STUDENT_INFO";
	        ResultSet rs = stmt.executeQuery(sql_check);

	    	while (rs.next()) {
	        	String sID = rs.getString("STUDENTID");
	        	if(student.getStudentID().equals(sID) == true) {
	        		// プリファードステートメントオブジェクトのクローズ
	        		stmt.close() ;
	    	        con.close();
	        		return false ;
	        	}

	        }

	        // プリファードステートメントオブジェクトのクローズ
	        stmt.close() ;
	        con.close();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return true;
	}

	public boolean registerStudentAccount(StudentModel student) {

		//登録処理
		//登録する内容をデータベースに登録

		try {
			// ドライバクラスをロード
	    	Class.forName("com.mysql.cj.jdbc.Driver");

		    // データベースへ接続
	    	Connection con = DriverManager.getConnection(url,usr,pass);


	        // プリファードステートメントオブジェクトの生成
	        String sql = "INSERT INTO STUDENT_INFO VALUES (?,?,?)";
	        PreparedStatement prestmt = con.prepareStatement(sql);
	        // プリファードステートメントオブジェクトの設定
	        prestmt.setString(1, student.getStudentID());
	        prestmt.setString(2, student.getStudentPass());
	        prestmt.setString(3, student.getStudentName());
	        // データベースの更新
	        prestmt.executeUpdate();
	        // プリファードステートメントオブジェクトのクローズ
	        prestmt.close();
	        con.close();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }

	    return true;
	}

	public boolean nameUpdate(StudentModel student) {

		//登録処理
		//登録する内容をデータベースに登録

		try {
			// ドライバクラスをロード
	    	Class.forName("com.mysql.cj.jdbc.Driver");

		    // データベースへ接続
	    	Connection con = DriverManager.getConnection(url,usr,pass);


	        // プリファードステートメントオブジェクトの生成
	        String sql = "UPDATE STUDENT_INFO SET STUDENTNAME = ?  WHERE STUDENTID = ?";
	        PreparedStatement prestmt = con.prepareStatement(sql);
	        // プリファードステートメントオブジェクトの設定
	        prestmt.setString(1, student.getStudentName());
	        prestmt.setString(2, student.getStudentID());
	        // データベースの更新
	        prestmt.executeUpdate();
	        // プリファードステートメントオブジェクトのクローズ
	        prestmt.close();
	        con.close();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }

	    return true;
	}

	public boolean passUpdate(StudentModel student) {

		//登録処理
		//登録する内容をデータベースに登録

		try {
			// ドライバクラスをロード
	    	Class.forName("com.mysql.cj.jdbc.Driver");

		    // データベースへ接続
	    	Connection con = DriverManager.getConnection(url,usr,pass);

	        // プリファードステートメントオブジェクトの生成
	        String sql = "UPDATE STUDENT_INFO SET PASSWORD = ?  WHERE STUDENTID = ?";
	        PreparedStatement prestmt = con.prepareStatement(sql);
	        // プリファードステートメントオブジェクトの設定
	        prestmt.setString(1, student.getStudentPass());
	        prestmt.setString(2, student.getStudentID());
	        // データベースの更新
	        prestmt.executeUpdate();
	        // プリファードステートメントオブジェクトのクローズ
	        prestmt.close();
	        con.close();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }

	    return true;
	}
}

