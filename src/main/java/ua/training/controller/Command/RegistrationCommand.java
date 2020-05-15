package ua.training.controller.Command;

import ua.training.model.entity.Role;
import ua.training.model.entity.User;
import ua.training.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Optional;

public class RegistrationCommand implements Command{
    private UserService userService;

    public RegistrationCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if (login == null || login.equals("") || pass == null || pass.equals("")) {
            //System.out.println("Not");
            return "/registration.jsp";
        }
        System.out.println(login + " " + pass);
        //System.out.println("Yes!");
//todo: check login with DB
        User user = new User.Builder()
                .buildFirstName(firstName)
                .buildLastName(lastName)
                .buildEmail(email)
                .buildLogin(login)
                .buildPassword(pass)
                .buildRole(Role.USER)
                .build();
        try {
            userService.saveUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return "/registration.jsp";
        }
        /*if (user.isPresent()) {
            if (CommandUtility.checkUserIsLogged(request, login)) {
                return "/WEB-INF/error.jsp";
            }

            if (user.get().getRole().equals(Role.USER)) {
                CommandUtility.setUserRole(request, Role.USER, login);
                return "/WEB-INF/user/userbasis.jsp";
            } else if (user.get().getRole().equals(Role.ADMIN)) {
                CommandUtility.setUserRole(request, Role.USER, login);
                return "/WEB-INF/admin/admin.jsp";
            } else {
                CommandUtility.setUserRole(request, Role.UNKNOWN, login);
                return "/login.jsp";
            }
        }*/
        return "redirect:login";
    }
}