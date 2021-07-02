package dao ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.RegisterListModel;

public class MyTextListDAO {

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
    		System.out.println("DAO,"+studentID) ;
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
                System.out.println(tempList) ;
                String a = rs.getString("STUDENTID") ;
                System.out.println(a) ;
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
}
