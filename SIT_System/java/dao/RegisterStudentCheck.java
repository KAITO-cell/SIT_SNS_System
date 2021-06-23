package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.Student; 

public class RegisterStudentCheck {
	public boolean execute(Student user) {
		
		//確認処理
		//登録する内容がデータベースに重複していないか確認
		
		try {
			// ドライバクラスをロード
	    	Class.forName("com.mysql.cj.jdbc.Driver"); 

		    // データベースへ接続
	    	Connection con =
		   	          DriverManager.getConnection("jdbc:mysql://160.16.141.77:51601/STUDENT","master","Pracb2021*"); 
	    	
	    	Statement stmt = con.createStatement();
	    	// 検索の実施と重複の確認
	        String sql_check = "SELECT * FROM STUDENT_INFO";
	        ResultSet rs = stmt.executeQuery(sql_check);

	    	while (rs.next()) {
	        	String sID = rs.getString("STUDENTID");
	        	if(user.getId().equals(sID) == true) {
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
}
