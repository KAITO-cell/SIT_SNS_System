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



}
