package ua.training.model.dao.implement;

import ua.training.model.dao.ApplicationDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.EditionDao;
import ua.training.model.dao.UserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    /*@Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    private Connection getConnection(){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/authdb",
                    "root" ,
                    "root" );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    @Override
    public EditionDao createEditionDao() {
        return new JDBCEditionDao(getConnection());
    }

    @Override
    public ApplicationDao createApplicationDao() {
        return new JDBCApplicationDao(getConnection());
    }

    private Connection getConnection(){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
