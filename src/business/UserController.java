package business;

import entity.User;
import dao.UserDao;
import core.Helper;

public class UserController {
    private final UserDao userDao = new UserDao();

    public User findByLogin(String mail, String password){
        if (!Helper.isEmailValid(mail)) return null;
        return this.userDao.findByLogin(mail, password);
    }
}
