package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Logic {
	
	public boolean execute(String id,String pass) {
		
		//DBの変数
			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
				
			//SQL
			String sql = "SELECT * FROM stu_info";
			    
			try {
		        // JDBCドライバのロード
				Class.forName("com.mysql.cj.jdbc.Driver");
		            
		        // データベース接続
		        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
		        System.out.println("接続中");
		            
		        // SQL実行準備
		        stmt = con.prepareStatement(sql);
		            
		        rs = stmt.executeQuery();
		      // データがなくなるまで(rs.next()がfalseになるまで)繰り返す
		        while (rs.next()) {
		            String ID = rs.getString("id");
		            String password = rs.getString("password");
		            if(ID.equals(id) && password.equals(pass)) {
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
		                con.close();
		            }
		        } catch (SQLException e) {
		            System.out.println("データベースへのアクセスでエラーが発生しました。2");
		        }
		    }
			return false;
	}
}	
	

