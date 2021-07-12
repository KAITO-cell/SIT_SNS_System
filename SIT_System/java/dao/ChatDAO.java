/**************************************************************************************************
 ***  File Name      : Request.java
 ***  Version        : V2.0
 ***  Designer       : 奈良操樹
 ***  Date           : 2021.07.11
 ***  Purpose        : 教科書リスト画面で選択された教科書の情報をセッションに登録する
 ***
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 奈良操樹,2021.06.28
 *** V1.1 : 奈良操樹,2021.07.02
 */
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
import beans.TextChatModel;

public class ChatDAO {

	//sql用の変数宣言
	 Connection con = null;
	 PreparedStatement stmt = null;
	 ResultSet rs = null;
	 String url_CHAT = "jdbc:mysql://localhost:51601/CHAT";
	 //String url_TEXT = "jdbc:mysql://localhost:51601/CHAT";
	 String usr = "master";
	 String pass = "Pracb2021*";
	 public List<ChatModel> RequestChat(String roomid) {
	    // SQL文の作成
	        String sql = "SELECT * FROM CHATROOM WHERE ROOMID = ? ORDER BY time";

	        List<ChatModel> chatList= new ArrayList<ChatModel>();

	        try {

	            // JDBCドライバのロード
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            // データベース接続
	            con = DriverManager.getConnection(url_CHAT,usr,pass);
	            // SQL実行準備
	            stmt = con.prepareStatement(sql);

	            stmt.setString(1, roomid);

	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	String roomID = rs.getString("ROOMID");
	                String studentid = rs.getString("STUDENTID");
	                String text = rs.getString("TEXT");
	                String time = rs.getTimestamp("TIME").toString();
	                ChatModel chatmodel = new ChatModel(roomID,studentid,text,time);
					chatList.add(chatmodel);
	            }

	        } catch (ClassNotFoundException |SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                con.close();
	                rs.close();
	            } catch (SQLException e) {
	            	e.printStackTrace();
	            }
	        }
	        return chatList;
	    }

	public void InsertChat(String roomid,String studentid , String text) {

 // SQL文の作成
     String sql = "INSERT INTO CHATROOM VALUES(?,?,?,?)";

     try {
         // JDBCドライバのロード
         Class.forName("com.mysql.cj.jdbc.Driver");

         // データベース接続
         con = DriverManager.getConnection(url_CHAT,usr,pass);

         // SQL実行準備
         stmt = con.prepareStatement(sql);

         //データの書き込み
         stmt.setString(1, roomid);
         stmt.setString(2, studentid);
         stmt.setString(3, text);
         stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
         stmt.executeUpdate();

     } catch (ClassNotFoundException|SQLException e) {
         e.printStackTrace();
     } finally {
         try {
             con.close();
             stmt.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
	}

	public List<TextChatModel> textRequestChat(String textid) {

	    // SQL文の作成
	        String sql = "SELECT * FROM CONTENTS WHERE textid = ? ORDER BY time";

	        List<TextChatModel> chatList= new ArrayList<TextChatModel>();
	        try {

	            // JDBCドライバのロード
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            // データベース接続
	            con = DriverManager.getConnection(url_CHAT,usr,pass);
	            // SQL実行準備
	            stmt = con.prepareStatement(sql);

	            stmt.setString(1, textid);

	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	String txtid = rs.getString("textid");
	                String studentid = rs.getString("studentid");
	                String text = rs.getString("text");
	                String time = rs.getTimestamp("time").toString();
	                TextChatModel chatmodel = new TextChatModel(txtid,studentid,text,time);
					chatList.add(chatmodel);
	            }

	        } catch (ClassNotFoundException |SQLException e) {
	        	e.printStackTrace();
	        } finally {
	            try {
	                con.close();
	                rs.close();
	            }catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return chatList;
	    }

	public void textInsertChat(String textid,String studentid , String text) {

    // SQL文の作成
        String sql = "INSERT INTO CONTENTS VALUES(?,?,?,?)";
        try {
            // JDBCドライバのロード
            Class.forName("com.mysql.cj.jdbc.Driver");

            // データベース接続
            con = DriverManager.getConnection(url_CHAT,usr,pass);

            // SQL実行準備
            stmt = con.prepareStatement(sql);

            //データの書き込み
            stmt.setString(1, textid);
            stmt.setString(2, studentid);
            stmt.setString(3, text);
            stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
            	stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

}
