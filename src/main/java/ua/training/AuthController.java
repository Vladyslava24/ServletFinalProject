/*package ua.training;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.relation.Role;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.*;
import java.io.IOException;
import java.sql.*;

public class AuthController extends HttpServlet {
    private static String URL = "jdbc:mysql://localhost:3306/authdb";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";
    private static final String SELECT = "SELECT * FROM authdb.user WHERE login = ?";

    private void doPost(HttpRequest req, HttpResponse resp) throws
            ServletException , IOException {

        String login = req.getParameter("login");
        String password = req.getParemeter("password");

        User user = new User();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        req.getSession.setAttribute("user", user);
        if(login.equals(user.getLogin()) && password.equals(user.getPassword()
        && "ADMIN".equals(String.valueOf(user.getRole()))){
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
        }else if(login.equals(user.getLogin())&& password.equals(user.getPassword())){
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
        }else {
            req.setAttribute("errorMessage", "Login or password is incorrect");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }


    }


}
*/