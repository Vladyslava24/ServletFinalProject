package ua.training.model.dao.implement;

import ua.training.model.dao.UserDao;
import ua.training.model.dao.mapper.UserMapper;
import ua.training.model.entity.Role;
import ua.training.model.entity.User;

import java.sql.*;
import java.util.*;

public class JDBCUserDao implements UserDao {
  /*
    @Override
    public Optional<User> findByLogin(String login) {
        User user = null;
        try (PreparedStatement ps = connection.prepareStatement("select * from user where login=?")) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = extractFromResultSet(rs);
            }
        } catch (Exception ignored) {
        }
        return Optional.ofNullable(user);
    }*/
  private Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<User> findByLogin(String login) {
        Optional<User> result = Optional.empty();
        try(PreparedStatement ps = connection.prepareCall("SELECT * FROM user WHERE login = ?")){
            ps.setString( 1, login);
            ResultSet rs;
            rs = ps.executeQuery();
            UserMapper mapper = new UserMapper();
            if (rs.next()){
                result = Optional.of(mapper.extractFromResultSet(rs));
            }//TODO : ask question how avoid two users with the same name
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return result;
    }

    @Override
    public void create(User entity) {
        //Optional<User> result = Optional.empty();
        try(PreparedStatement ps = connection.prepareCall("INSERT INTO user (first_name, last_name, email, login, password, role) values (?, ?, ?, ?, ?, ?)")){
            ps.setString( 1, entity.getFirstName());
            ps.setString( 2, entity.getLastName());
            ps.setString( 3, entity.getEmail());
            ps.setString( 4, entity.getLogin());
            ps.setString( 5, entity.getPassword());
            ps.setString( 6, entity.getRole().name());
            ps.executeUpdate();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    /*@Override
    public List<User> findAll() {
        Optional<User> result = Optional.empty();
        try(PreparedStatement ps = connection.prepareCall("SELECT * FROM user")){
            ResultSet rs= ps.executeQuery();
            UserMapper mapper = new UserMapper();
            if (rs.next()){
                result = Optional.of(mapper.extractFromResultSet(rs));
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return result;
    }*/

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close()  {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}