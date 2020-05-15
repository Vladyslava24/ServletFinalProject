package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.User;

import java.sql.SQLException;
import java.util.Optional;

public class UserService {
    public Optional findByLogin(String login) {/*throws DatabaseException*/
        DaoFactory factory = DaoFactory.getInstance();
        UserDao userDao = factory.createUserDao();
        Optional<User> user = userDao.findByLogin(login);

        //dao.findByLogin(login); /*.orElseThrow(() -> new DatabaseException("User not found: " + login)); */
        if (user.isPresent()) {
            return user;
        } else {
            return Optional.empty();
        }
    }

    public void saveUser(User user) throws SQLException {
        //TODO try/catch
            DaoFactory factory = DaoFactory.getInstance();
            UserDao userDao = factory.createUserDao();
            userDao.create(user);
    }
       /* DaoFactory daoFactory = DaoFactory.getInstance();
        public Optional<User> login(String login){
            Optional<User> result; //= Optional.empty();
            try(UserDao userDao = daoFactory.createUserDao()){
                result = userDao.findByLogin(login);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }*/
}
