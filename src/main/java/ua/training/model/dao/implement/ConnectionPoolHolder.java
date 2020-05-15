package ua.training.model.dao.implement;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.DriverManager;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;
    public static DataSource getDataSource(){

        if (dataSource == null){
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    ds.setUrl("jdbc:mysql://localhost:3306/authdb");
                    ds.setUsername("root");
                    ds.setPassword("root");
                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);
                    dataSource = ds;
                }
            }
        }
        return dataSource;

    }


}
