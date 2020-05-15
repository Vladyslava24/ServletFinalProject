package ua.training.controller.Command;


import ua.training.model.entity.Role;
import ua.training.model.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

class CommandUtility {
    static void setUserRole(HttpServletRequest request,
                            Role role, String login) {
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        context.setAttribute("login", login);
        session.setAttribute("role", role);
    }

    static boolean checkUserIsLogged(HttpServletRequest request, String login){
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

        if(loggedUsers.stream().anyMatch(login::equals)){
            return true;
        }
        loggedUsers.add(login);
        request.getSession().getServletContext()
                .setAttribute("loggedUsers", loggedUsers);
        return false;
    }

    static void removeUserFromSession(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        HashSet<String> loggedUsers = getLoggedUsers(request);
        if(user != null) {
            loggedUsers.remove(user.getLogin());
            //request.getSession().getServletContext()
              //      .setAttribute("loggedUsers", loggedUsers);
            request.getSession().removeAttribute("user");
            request.getSession().getServletContext().removeAttribute("user");
        }
    }

    private static HashSet<String> getLoggedUsers(HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        HashSet<String> loggedUsers =(HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");
        return  loggedUsers;
    }
}