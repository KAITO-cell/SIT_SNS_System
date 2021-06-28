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


}