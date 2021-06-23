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
			    
			try {
		        // JDBCドライバのロード
				Class.forName("com.mysql.cj.jdbc.Driver");
		            
		        // データベース接続
		        con = DriverManager.getConnection("jdbc:mysql://160.16.141.77:51601/STUDENT","master","Pracb2021*");
		        System.out.println("接続中");
		            
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
		            
			} catch (ClassNotFoundException e) {
		        System.out.println("JDBCドライバのロードでエラーが発生しました");
		    } catch (SQLException e) {
		        System.out.println("データベースへのアクセスでエラーが発生しました。");
		    } finally {
		        try {
		            if (con != null) {
		            	stmt.close() ;
		    	        con.close();
		            }
		        } catch (SQLException e) {
		            System.out.println("データベースへのアクセスでエラーが発生しました。2");
		        }
		    }
			return false;
	}
}	
	

