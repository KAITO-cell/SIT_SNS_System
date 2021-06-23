package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import beans.StudentModel; 

public class RegisterStudentDAO {
	public boolean execute(StudentModel student) {
		
		//登録処理
		//登録する内容をデータベースに登録
		
		try {
			// ドライバクラスをロード
	    	Class.forName("com.mysql.cj.jdbc.Driver"); 

		    // データベースへ接続
	    	Connection con =
	   	          DriverManager.getConnection("jdbc:mysql://160.16.141.77:51601/STUDENT","master","Pracb2021*"); 
		     
		        
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
}
