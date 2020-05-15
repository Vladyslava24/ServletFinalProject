package ua.training.model.dao.mapper;

import ua.training.model.entity.Edition;
import ua.training.model.entity.EditionStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class EditionMapper implements ObjectMapper<Edition> {
    @Override
    public Edition extractFromResultSet(ResultSet rs) throws SQLException {
        Edition edition = new Edition();
        edition.setId(rs.getInt("id"));
        edition.setName(rs.getString("name"));
        edition.setAuthor(rs.getString("author"));
        edition.setPrice(rs.getLong("price"));
        edition.setAmountEdition(rs.getInt("amount_edition"));
        edition.setEditionStatus(EditionStatus.valueOf(rs.getString("status")));
        edition.setAmountAvailable(rs.getInt("amount_available"));
        return edition;
    }

    @Override
    public Edition makeUnique(Map<Integer, Edition> cache,
                              Edition edition) {
        cache.putIfAbsent(edition.getId(), edition);
        return cache.get(edition.getId());
    }
}
