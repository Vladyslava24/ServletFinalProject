package ua.training.controller;

import ua.training.controller.Command.*;

import ua.training.model.service.EditionService;
import ua.training.model.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    public void init(ServletConfig servletConfig){

        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());

        commands.put("editions",
                new EditionCommand(new EditionService()));
        commands.put("delete_edition",
                new DeleteEdition(new EditionService()));
        commands.put("logout",
                new LogOutCommand());
        commands.put("login",
                new LoginCommand(new UserService()));
        commands.put("registration",
                new RegistrationCommand(new UserService()));
        commands.put("user",
                new UserCommand());
        commands.put("make_application",
                new UserCommand());
        commands.put("application_list",
                new UserCommand());
        commands.put("admin",
                new AdminCommand(new EditionService()));
        commands.put("add_edition",
                new AddEdition(new EditionService()));
        commands.put("update_edition",
                new UpdateEditionCommand(new EditionService()));
        commands.put("exception" , new ExceptionCommand());
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
        //response.getWriter().print("Hello from servlet");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        path = path.replaceAll(".*/" , "");
        Command command = commands.getOrDefault(path ,
                (r)->"/index.jsp");
        System.out.println(command.getClass().getName());
        String page = command.execute(request);
        //request.getRequestDispatcher(page).forward(request,response);
        if (page.contains("redirect:")) {
            response.sendRedirect(page.replace("redirect:", "/"));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
