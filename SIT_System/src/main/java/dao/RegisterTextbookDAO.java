package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.RegisterListModel;
public class RegisterTextbookDAO {

	public boolean execute(RegisterListModel textbook) {

		//登録処理
		//登録する内容をデータベースに登録
		int count;
		try {
			// ドライバクラスをロード
		    Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースへ接続
		    Connection con =
		   	DriverManager.getConnection("jdbc:mysql://160.16.141.77:51601/TEXT","master","Pracb2021*");
		    
		    String sql = "SELECT TEXTID FROM REGISTER_LIST;";
		    PreparedStatement ps = con.prepareStatement(sql);
		    ResultSet rs = ps.executeQuery();
		    
		    count = 0;
		    while(rs.next()) {
		    	count++;
		    }

		    // プリファードステートメントオブジェクトの生成
		    String sql2 = "INSERT INTO REGISTER_LIST VALUES (?,?,?,?,?,?,?,?,?)";
		    PreparedStatement prestmt = con.prepareStatement(sql2);
		    // プリファードステートメントオブジェクトの設定
		    prestmt.setInt(1, count+1);
		    prestmt.setString(2, textbook.getStudentID());
		    prestmt.setString(3, textbook.getStudentName());
		    prestmt.setString(4, textbook.getDepartment());
		    prestmt.setString(5, textbook.getSubject());
		    prestmt.setString(6, textbook.getTextName());
		    prestmt.setString(7, textbook.getAuthor());
		    prestmt.setString(8, textbook.getPublish());
		    prestmt.setString(9, textbook.getCampus());

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


