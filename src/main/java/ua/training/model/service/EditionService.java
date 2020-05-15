package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.EditionDao;
import ua.training.model.entity.Edition;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EditionService {
    public Optional findAllById(int id) {/*throws DatabaseException*/
        DaoFactory factory = DaoFactory.getInstance();
        EditionDao editionDao = factory.createEditionDao();
        Optional<Edition> edition = editionDao.findAllById(id);

        //dao.findByLogin(login); /*.orElseThrow(() -> new DatabaseException("User not found: " + login)); */
        if (edition.isPresent()) {
            return edition;
        } else {
            return Optional.empty();
        }
    }

    public void deleteEdition(int id) throws SQLException {
        //TODO try/catch
        DaoFactory factory = DaoFactory.getInstance();
        EditionDao editionDao = factory.createEditionDao();
        editionDao.delete(id);
    }

    public void saveEdition(Edition edition) throws SQLException {
        //TODO try/catch
        DaoFactory factory = DaoFactory.getInstance();
        EditionDao editionDao = factory.createEditionDao();
        editionDao.create(edition);
    }

    public void updateEdition(Edition edition) throws SQLException {
        //TODO try/catch
        DaoFactory factory = DaoFactory.getInstance();
        EditionDao editionDao = factory.createEditionDao();
        editionDao.update(edition);
    }

    public List<Edition> getAllEditions() throws Exception {
        DaoFactory factory = DaoFactory.getInstance();
        try (EditionDao dao = factory.createEditionDao()) {
            return dao.findAll();
        }
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
