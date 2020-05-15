package ua.training.model.dao.implement;

import ua.training.model.dao.ApplicationDao;
import ua.training.model.dao.mapper.ApplicationMapper;
import ua.training.model.dao.mapper.EditionMapper;
import ua.training.model.entity.Application;
import ua.training.model.entity.Edition;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCApplicationDao implements ApplicationDao {
    private Connection connection;

    public JDBCApplicationDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(Application entity) {
        try(PreparedStatement ps = connection.prepareCall("INSERT INTO application (cost, id_edition values (?, ?)")){
            ps.setLong( 1, entity.getCost());
            ps.setLong(2, entity.getEditionId());
            ps.executeUpdate();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Application findById(int id) {
        Application application = null;
        try(PreparedStatement ps = connection.prepareCall("SELECT * FROM application WHERE id = ?")){
            ps.setInt( 1, id);
            ResultSet rs;
            rs = ps.executeQuery();
            ApplicationMapper mapper = new ApplicationMapper();
            if (rs.next()){
                application = mapper.extractFromResultSet(rs);
            }//TODO : ask question how avoid two teachers with the same name
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return application;
    }

    @Override
    public List<Application> findAll() {
        Map<Integer,Application> applications = new HashMap<>();
        Map<Integer,Edition> editions = new HashMap<>();

        final String query = "" +
                " SELECT * FROM application" +
                " LEFT JOIN application_has_edition USING (application.id)" +
                " LEFT JOIN edition USING (edition.id)";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);

            ApplicationMapper applicationMapper = new ApplicationMapper();
            EditionMapper editionMapper = new EditionMapper();

            while (rs.next()) {
                Application application = applicationMapper
                        .extractFromResultSet(rs);
                Edition edition = editionMapper
                        .extractFromResultSet(rs);
                application = applicationMapper
                        .makeUnique(applications, application);
                edition = editionMapper
                        .makeUnique(editions, edition);
                application.getEditions().add(edition);
            }
            return new ArrayList<>(applications.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Application entity) {
        try(PreparedStatement ps = connection.prepareCall( "UPDATE application SET cost=? WHERE id=?")){
            ps.setLong( 1, entity.getCost());
            ps.setLong( 2, entity.getId());
            ps.executeUpdate();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws Exception {

    }
}
