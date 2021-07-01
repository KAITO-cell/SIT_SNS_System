package Logic;
import java.util.List;

import beans.RegisterListModel;
import dao.RegisterListDAO;


public class RegisterListLogic {


    //RegisterListDAOを元にListを作るメソッド定義
    public List<RegisterListModel> makeRegisterList (String sub){


    	RegisterListDAO dao = new RegisterListDAO();
        List<RegisterListModel> registerList = dao.getRegisterList(sub);
        return registerList;


    }

//    public static void main(String[] args) {
//    	String sub ="情報工学科";
//    	RegisterListLogic logic = new RegisterListLogic();
//    	List<RegisterListModel> registerList = logic.makeRegisterList(sub);
//		for(int i =0;i<registerList.size();i++) {
//			System.out.println(registerList.get(i).getTextName());
//		}
//    }
}

