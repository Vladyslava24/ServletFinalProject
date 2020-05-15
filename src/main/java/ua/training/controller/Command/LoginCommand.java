package ua.training.controller.Command;


import ua.training.model.entity.Role;
import ua.training.model.entity.User;
import ua.training.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class LoginCommand implements Command{
    private UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if (login == null || login.equals("") || pass == null || pass.equals("")) {
            //System.out.println("Not");
            return "/login.jsp";
        }
        System.out.println(login + " " + pass);
        //System.out.println("Yes!");
//todo: check login with DB
        Optional<User> user = userService.findByLogin(login);
        if (user.isPresent()) {
            if (CommandUtility.checkUserIsLogged(request, login)) {
                return "/WEB-INF/error.jsp";
            }

            if (user.get().getRole().equals(Role.USER)) {
                CommandUtility.setUserRole(request, Role.USER, login);
                //return "/WEB-INF/user/userbasis.jsp";
                return "redirect:user";
            } else if (user.get().getRole().equals(Role.ADMIN)) {
                CommandUtility.setUserRole(request, Role.ADMIN, login);
                //return "/WEB-INF/admin/admin.jsp";
                return "redirect:admin";
            } else {
                CommandUtility.setUserRole(request, Role.UNKNOWN, login);
                return "/login.jsp";
            }
        }
        return "/login.jsp";
    }
}