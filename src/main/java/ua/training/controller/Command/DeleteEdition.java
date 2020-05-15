package ua.training.controller.Command;

import ua.training.model.entity.Edition;
import ua.training.model.service.EditionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteEdition implements Command {
    private EditionService editionService;

    public DeleteEdition(EditionService editionService) {
        this.editionService = editionService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        try {
            List<Edition> editions = editionService.getAllEditions();
            request.setAttribute("editions" , editions);
            String id = request.getParameter("id");
            request.setAttribute("id", id);
            editionService.deleteEdition(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:admin";
    }
}
