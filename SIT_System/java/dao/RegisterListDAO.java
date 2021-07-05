package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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


    //データベースのREGISTER_LISTから指定されたtextidのレコードを
    public RegisterListModel getRegisterRecode(String textid) {


    	RegisterListModel tempList = null;

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,usr,pass);

        String sql= "SELECT * FROM REGISTER_LIST WHERE TEXTID=?;";
        ps = con.prepareStatement(sql);
        ps.setString(1,textid);
        rs = ps.executeQuery();

        rs.next();

        tempList = new RegisterListModel(rs.getString("TEXTID"),
                                                             rs.getString("STUDENTID"),
                                                             rs.getString("STUDENTNAME"),
                                                             rs.getString("DEPARTMENT"),
                                                             rs.getString("SUBJECT"),
                                                             rs.getString("TEXTNAME"),
                                                             rs.getString("AUTHOR"),
                                                             rs.getString("PUBLISHER"),
                                                             rs.getString("CAMPUS")
                                                            );

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

		return tempList;
    }

    //データベースのREGISTER_LISTから教科書を削除
    public void deleteText(String textid) {



		try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				String url = "jdbc:mysql://160.16.141.77:51601/TEXT";
				con = DriverManager.getConnection(url,usr,pass);

				String sql = "DELETE FROM REGISTER_LIST WHERE TEXTID=?";
				ps = con.prepareStatement(sql);
				ps.setString(1,textid);
				ps.executeUpdate();


		} catch(ClassNotFoundException |SQLException e){
	           e.printStackTrace();
	     } finally {
	          try{
	            con.close();
	            ps.close();
	          }catch(SQLException e){
	             e.printStackTrace();
	          }
	    }
    }
    
    //自分の教科書を登録する
    public boolean registerMyTextList(RegisterListModel textbook) {

		//登録処理
		//登録する内容をデータベースに登録
		int max = 0 ;
		int num = 0 ;
		
		try {
			// ドライバクラスをロード
		    Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースへ接続
		    Connection con =
		   	DriverManager.getConnection(url,usr,pass);

		    String sql = "SELECT TEXTID FROM REGISTER_LIST;";
		    PreparedStatement ps = con.prepareStatement(sql);
		    ResultSet rs = ps.executeQuery();

		    while(rs.next()) {
		    	num = Integer.parseInt(rs.getString("TEXTID")) ;
		    	if(max < num)
		    		max = num ;
		    }

		    // プリファードステートメントオブジェクトの生成
		    String sql2 = "INSERT INTO REGISTER_LIST VALUES (?,?,?,?,?,?,?,?,?)";
		    PreparedStatement prestmt = con.prepareStatement(sql2);
		    // プリファードステートメントオブジェクトの設定
		    prestmt.setInt(1, max+1);
		    prestmt.setString(2, textbook.getStudentID());
		    prestmt.setString(3, textbook.getStudentName());
		    prestmt.setString(4, textbook.getDepartMent());
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
    
    //自分が登録した教科書を教科書リストに出力する
    public List<RegisterListModel> getMyTextList(String studentID) {

		RegisterListModel tempList = null ;
    	//確認処理
    	//登録する内容がデータベースに重複していないか確認

		 List<RegisterListModel> registerList = new ArrayList<RegisterListModel>();

    	try {
    		// ドライバクラスをロード
    		Class.forName("com.mysql.cj.jdbc.Driver");

    		// データベースへ接続
    		Connection con =
    		          DriverManager.getConnection("jdbc:mysql://160.16.141.77:51601/TEXT","master","Pracb2021*");


    		// 検索の実施と重複の確認
    		String sql= "SELECT * FROM REGISTER_LIST WHERE STUDENTID = ?;";
    		PreparedStatement prestmt = con.prepareStatement(sql);
    		prestmt.setString(1,studentID);
    		ResultSet rs = prestmt.executeQuery();

    		while(rs.next()){
                tempList = new RegisterListModel(rs.getString("TEXTID"),
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

    		// プリファードステートメントオブジェクトのクローズ
    		prestmt.close() ;
    		con.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    return registerList ;
   }
	
	public List<String> selectText() {
		List<String> list = new ArrayList<String>();
		try {
			// ドライバクラスをロード
			Class.forName("com.mysql.cj.jdbc.Driver");
			// データベースへ接続
			Connection con = DriverManager.getConnection(url,usr,pass);
			Statement stmt = con.createStatement();
			String sql = "SELECT TEXTNAME FROM TEXTLIST;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
		        String tName = rs.getString("TEXTNAME");
		       	list.add(tName);
		    }
		    stmt.close();
		    con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
