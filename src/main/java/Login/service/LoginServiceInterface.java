package Login.service;

import Login.Model.User;

/**
 * Created by tharindu on 7/25/17.
 */

public interface LoginServiceInterface {
    public abstract boolean authenticateUser(User userBean);
}