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



	 //check if CHATROOM is exist

//	 public boolean existChatRoom(String roomid) {
//		 boolean result= true;
//		 String sql= "SELECT * FROM CHATROOM WHERE ROOMID = ?;";
//
//		 try {
//			 Class.forName("com.mysql.cj.jdbc.Driver");
//			 con = DriverManager.getConnection("jdbc:mysql://160.16.141.77:51601/CHAT", "master", "Pracb2021*");
//			 stmt=con.prepareStatement(sql);
//			 stmt.setString(1,roomid);
//			 rs = stmt.executeQuery();
//			 while(rs.next()) {
//
//				 if(rs.getString("ROOMID") !=null ) {
//					 System.out.println("成功！");
//					 result=true;
//				 }else {
//					 System.out.println("失敗！");
//					 result=false;
//				 }
//			 }
//
//		 } catch (ClassNotFoundException | SQLException e) {
//	            System.out.println("JDBCドライバのロードでエラーが発生しました");
//		 }finally {
//			try {
//
//	            	con.close();
//
//	            } catch (SQLException e) {
//	                System.out.println("データベースへのアクセスでエラーが発生しました。2");
//	            }
//		 }
//
//		 return result;
//
//	 }
//
//	 //Initialize CHATROOM
//	 public void initChatRoom(String roomid) {
//
//
//		 String sql = "INSERT INTO CHATROOM values(?,?,?,?); ";
//		 try {
//
//	            // JDBCドライバのロード
//	            Class.forName("com.mysql.cj.jdbc.Driver");
//	            // データベース接続
//	            con = DriverManager.getConnection("jdbc:mysql://160.16.141.77:51601/CHAT", "master", "Pracb2021*");
//	            System.out.println("接続中");
//	            // SQL実行準備
//	            stmt = con.prepareStatement(sql);
//	            stmt.setString(1, roomid);
//	            stmt.setString(2, "CHATBOT");
//	            stmt.setString(3, "メッセージを送りましょう!");
//	            stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
//
//
//	        } catch (ClassNotFoundException e) {
//	            System.out.println("JDBCドライバのロードでエラーが発生しました");
//	        } catch (SQLException e) {
//	            System.out.println("データベースへのアクセスでエラーが発生しました。");
//	        } finally {
//	            try {
//	                if (con != null) {
//	                    con.close();
//	                }
//	            } catch (SQLException e) {
//	                System.out.println("データベースへのアクセスでエラーが発生しました。2");
//	            }
//	        }
//
//
//
//	 }


	 public List<ChatModel> RequestChat(String roomid) {
	    // SQL文の作成
	        String sql = "SELECT * FROM CHATROOM WHERE ROOMID = ? ORDER BY time DESC";

	        List<ChatModel> chatList= new ArrayList<ChatModel>();

	        try {

	            // JDBCドライバのロード
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            // データベース接続
	            con = DriverManager.getConnection("jdbc:mysql://160.16.141.77:51601/CHAT", "master", "Pracb2021*");
	            System.out.println("接続中");
	            // SQL実行準備
	            stmt = con.prepareStatement(sql);

	            stmt.setString(1, roomid);

	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	String roomID = rs.getString("ROOMID");
	                String studentid = rs.getString("STUDENTID");
	                String text = rs.getString("TEXT");
	                String time = rs.getTimestamp("TIME").toString();
	                //chatlist.add( time + " ( " + studentid + " ) " + text + "\n");
	                ChatModel chatmodel = new ChatModel(roomID,studentid,text,time);
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

	public void InsertChat(String roomid,String studentid , String text) {

 // SQL文の作成
     String sql = "INSERT INTO CHATROOM VALUES(?,?,?,?)";

     //contents {textid, studentid , text}

     try {
         // JDBCドライバのロード
         Class.forName("com.mysql.cj.jdbc.Driver");

         // データベース接続
         con = DriverManager.getConnection("jdbc:mysql://160.16.141.77:51601/CHAT", "master", "Pracb2021*");

         // SQL実行準備
         stmt = con.prepareStatement(sql);

         //データの書き込み
         stmt.setString(1, roomid);
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













	public List<TextChatModel> textRequestChat(String textid) {

	    // SQL文の作成
	        String sql = "SELECT * FROM CONTENTS WHERE textid = ? ORDER BY time DESC";

	        List<TextChatModel> chatList= new ArrayList<TextChatModel>();

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
	                TextChatModel chatmodel = new TextChatModel(txtid,studentid,text,time);
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

	public void textInsertChat(String textid,String studentid , String text) {

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
