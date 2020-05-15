package ua.training.controller.Command;


import ua.training.model.entity.Edition;
import ua.training.model.service.EditionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EditionCommand implements Command {
    private EditionService editionService;

    public EditionCommand(EditionService editionService) {
        this.editionService = editionService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        try {
            List<Edition> editions = editionService.getAllEditions();
            request.setAttribute("editions" , editions);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "/WEB-INF/catalog.jsp";
    }
}
