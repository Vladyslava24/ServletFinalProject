package ua.training.controller.Command;


import ua.training.model.entity.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        // ToDo delete current user (context & session)
        CommandUtility.removeUserFromSession(request);
        final HttpSession session = request.getSession();
        session.invalidate();
        CommandUtility.setUserRole(request, Role.UNKNOWN, "Guest");
        return "redirect:login";
    }
}