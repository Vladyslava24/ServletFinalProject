package ua.training.controller.Command;

import ua.training.model.entity.Edition;
import ua.training.model.entity.EditionStatus;
import ua.training.model.service.EditionService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class UpdateEditionCommand implements Command {
    private EditionService editionService;

    public UpdateEditionCommand(EditionService editionService) {
        this.editionService = editionService;
    }

        @Override
        public String execute(HttpServletRequest request) {
            String id = request.getParameter("id");
            request.setAttribute("id", id);

            String name = request.getParameter("name");
            String author = request.getParameter("author");
            //String price = request.getParameter("price");

            if (name == null || author.equals("")) {
                return "/WEB-INF/admin/update.jsp";
            }
//todo: check edition with DB
            Edition edition = new Edition.Builder()
                    .buildName(name)
                    .buildAuthor(author)
                    .buildPrice(20)
                    .buildAmountEdition(0)
                    .buildStatus(EditionStatus.IN_STOCK)
                    .buildAmountAvailable(300)
                    .build();
            try {
                editionService.updateEdition(edition);
            } catch (SQLException e) {
                e.printStackTrace();
                return "/WEB-INF/admin/update.jsp";
            }
            return "redirect:admin";
    }
}
