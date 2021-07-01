package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.RegisterListModel;



public class RegisterListDAO {

    Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps =null;
    String url = "jdbc:mysql://160.16.141.77:51601/TEXT";
    String usr = "master";
    String pass = "Pracb2021*";



    // データベースのREGISTER_LISTからレコードを取得し、インスタンス化したリストを作る
    public List<RegisterListModel> getRegisterList(String subject){

        List<RegisterListModel> registerList = new ArrayList<RegisterListModel>();

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,usr,pass);

        String sql= "SELECT * FROM REGISTER_LIST WHERE SUBJECT=?;";
        ps = con.prepareStatement(sql);
        ps.setString(1,subject);
        rs = ps.executeQuery();

        while(rs.next()){
            RegisterListModel tempList = new RegisterListModel(rs.getString("TEXTID"),
                                                               rs.getString("STUDENTID"),
                                                               rs.getString("STUDENTNAME"),
                                                               rs.getString("DEPARTMENT"),
                                                               rs.getString("SUBJECT"),
                                                               rs.getString("TEXTNAME"),
                                                               rs.getString("AUTHOR"),
                                                               rs.getString("PUBLISHER"),
                                                               rs.getString("CAMPUS")
                                                                );
            registerList.add(tempList);
        }




        } catch(ClassNotFoundException |SQLException e){
            e.printStackTrace();
        } finally {
            try{
                con.close();
                rs.close();
                ps.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return registerList;
    }
    
    public boolean execute(RegisterListModel textbook) {

		//登録処理
		//登録する内容をデータベースに登録
		int count;
		try {
			// ドライバクラスをロード
		    Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースへ接続
		    Connection con =
		   	DriverManager.getConnection(url,usr,pass);
		    
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