package Login.dao;

/**
 * Created by tharindu on 7/25/17.
 */

        import javax.sql.DataSource;

        import Login.Model.User;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.jdbc.core.JdbcTemplate;

        import java.util.List;


public class Logindao implements LoginDaoInterface {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @SuppressWarnings("deprecation")
    public boolean authenticateUser(User userBean){
        boolean userExists = false;
        List list=jdbcTemplate.queryForList("select * from login " +
                        " where uname = ? and password = ?",
                userBean.getUserId(),userBean.getPassword());
        if(list.size()==1){
            userExists = true;
        }
        return userExists;
    }
}
