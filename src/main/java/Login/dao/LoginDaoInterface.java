package Login.dao;

/**
 * Created by tharindu on 7/25/17.
 */


        import Login.Model.User;

        import javax.sql.DataSource;

public interface LoginDaoInterface {
    public abstract void setDataSource(DataSource dataSource);
    public abstract boolean authenticateUser(User userBean);
}
