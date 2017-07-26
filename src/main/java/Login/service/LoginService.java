package Login.service;

/**
 * Created by tharindu on 7/25/17.
 */


        import Login.Model.User;
        import Login.dao.LoginDaoInterface;
        import org.springframework.beans.factory.annotation.Autowired;

public class LoginService implements LoginServiceInterface {

    @Autowired
    private LoginDaoInterface loginDaoInterface;

    public boolean authenticateUser(User user){
        return loginDaoInterface.authenticateUser(user);
    }
}
