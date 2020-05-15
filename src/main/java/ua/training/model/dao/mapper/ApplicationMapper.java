package ua.training.model.dao.mapper;

import ua.training.model.entity.Application;
import ua.training.model.entity.EditionStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ApplicationMapper implements ObjectMapper<Application> {
    @Override
    public Application extractFromResultSet(ResultSet rs) throws SQLException {
        Application application = new Application();
        application.setId(rs.getInt("application.id"));
        application.setCost(rs.getLong("cost"));
        application.setEditionId(rs.getLong("id_edition"));
        return application;
    }

    @Override
    public Application makeUnique(Map<Integer, Application> cache,
                              Application application) {
        cache.putIfAbsent(application.getId(), application);
        return cache.get(application.getId());
    }
}
