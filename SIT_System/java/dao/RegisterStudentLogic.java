package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import beans.Student; 

public class RegisterStudentLogic {
	public boolean execute(Student user) {
		
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
	        prestmt.setString(1, user.getId());
	        prestmt.setString(2, user.getPass());
	        prestmt.setString(3, user.getName());
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
