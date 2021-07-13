/**************************************************************************************************
 ***  File Name      : Request.java
 ***  Version        : V2.0
 ***  Designer       : 奈良操樹
 ***  Date           : 2021.07.
 ***  Purpose        : 教科書リスト画面で選択された教科書の情報をセッションに登録する
 ***
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 奈良操樹,2021.06.28
 *** V1.1 : 奈良操樹,2021.07.02
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

