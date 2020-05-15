package ua.training.controller.Command;

import ua.training.model.entity.Edition;
import ua.training.model.service.EditionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class AdminCommand implements Command {

    private EditionService editionService;

    public AdminCommand(EditionService editionService) {
        this.editionService = editionService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        try {
            List<Edition> editions = editionService.getAllEditions();
            request.setAttribute("editions", editions);
            String id = request.getParameter("id");
            Optional<Edition> edit = editionService.findAllById(Integer.parseInt(id));
            request.setAttribute("id", edit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/WEB-INF/admin/admin.jsp";
    }
}
