package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import beans.ChatModel;

public class ChatDAO {
	
	//sql用の変数宣言
	 Connection con = null;
	 PreparedStatement stmt = null;
	 ResultSet rs = null;

	public List<ChatModel> requestChat(String textid) {

	        String contents ="";

	    // SQL文の作成
	        String sql = "SELECT * FROM CONTENTS WHERE textid = ? ORDER BY time DESC";
	        
	        List<ChatModel> chatList= new ArrayList<ChatModel>();

	        try {
	        	
	            // JDBCドライバのロード
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            // データベース接続
	            con = DriverManager.getConnection("jdbc:mysql://160.16.141.77:51601/CHAT", "master", "Pracb2021*");
	            System.out.println("接続中");
	            // SQL実行準備
	            stmt = con.prepareStatement(sql);
	            
	            stmt.setString(1, textid);
	            
	            rs = stmt.executeQuery();
	            
	            while (rs.next()) {
	            	String txtid = rs.getString("textid");
	                String studentid = rs.getString("studentid");
	                String text = rs.getString("text");
	                String time = rs.getTimestamp("time").toString();
	                //chatlist.add( time + " ( " + studentid + " ) " + text + "\n");
	                ChatModel chatmodel = new ChatModel(txtid,studentid,text,time);
					chatList.add(chatmodel);
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
	        return chatList;
	    }
	
	public void insertChat(String textid,String studentid , String text) {

    // SQL文の作成
        String sql = "INSERT INTO CONTENTS VALUES(?,?,?,?)";
        
        //contents {textid, studentid , text}

        try {
            // JDBCドライバのロード
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // データベース接続
            con = DriverManager.getConnection("jdbc:mysql://160.16.141.77:51601/CHAT", "master", "Pracb2021*");
            
            // SQL実行準備
            stmt = con.prepareStatement(sql);
            
            //データの書き込み
            stmt.setString(1, textid);
            stmt.setString(2, studentid);
            stmt.setString(3, text);
            stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            
            stmt.executeUpdate();
           
            stmt.close();
            
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
	}

}
