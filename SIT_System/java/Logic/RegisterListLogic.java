/**************************************************************************************************
 ***  File Name      : RegisterListLogic.java
 ***  Version        : V1.1
 ***  Designer       : 永井海音
 ***  Date           : 2021.07.02
 ***  Purpose        : RegisterListDAOによりデータベースから読みだした値に基づく、RegisterListModelインスタンスのListを生成する
 ***
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 永井海音,2021.06.28
 *** V1.1 : 永井海音,2021.07.02
 */
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

    public RegisterListModel makeTextidcode(String textid) {
    	RegisterListDAO dao = new RegisterListDAO();
    	RegisterListModel tempList = dao.getRegisterRecode(textid);
    	return tempList;
    }
}

