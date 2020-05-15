package ua.training.model.dao.implement;

import ua.training.model.dao.EditionDao;
import ua.training.model.dao.mapper.EditionMapper;
import ua.training.model.entity.Edition;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCEditionDao implements EditionDao {
    private Connection connection;

    public JDBCEditionDao(Connection connection) {
        this.connection = connection;
    }

    /*@Override
    public Optional<Edition> findByLogin(String login) {
        Optional<User> result = Optional.empty();
        try(PreparedStatement ps = connection.prepareCall("SELECT * FROM user WHERE login = ?")){
            ps.setString( 1, login);
            ResultSet rs;
            rs = ps.executeQuery();
            UserMapper mapper = new UserMapper();
            if (rs.next()){
                result = Optional.of(mapper.extractFromResultSet(rs));
            }//TODO : ask question how avoid two users with the same name
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return result;
    }*/

    @Override
    public void create(Edition entity) {
        //Optional<User> result = Optional.empty();
        try(PreparedStatement ps = connection.prepareCall("INSERT INTO edition (name, author, price, amount_edition, status, amount_available) values (?, ?, ?, ?, ?, ?)")){
            ps.setString( 1, entity.getName());
            ps.setString( 2, entity.getAuthor());
            ps.setLong( 3, entity.getPrice());
            ps.setInt( 4, entity.getAmountEdition());
            ps.setString( 5, entity.getEditionStatus().name());
            ps.setInt( 6, entity.getAmountAvailable());
            ps.executeUpdate();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Edition findById(int id) {
        Edition edition = null;
        try(PreparedStatement ps = connection.prepareCall("SELECT * FROM edition WHERE id = ?")){
            ps.setInt( 1, id);
            ResultSet rs;
            rs = ps.executeQuery();
            EditionMapper mapper = new EditionMapper();
            if (rs.next()){
                edition = mapper.extractFromResultSet(rs);
            }//TODO : ask question how avoid two teachers with the same name
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return edition;
    }

    @Override
    public List<Edition> findAll() {
        List<Edition> resultList = new ArrayList<>();
        //Map<Integer,Driver> drivers = new HashMap<>();
        //Map<Integer,Car> cars = new HashMap<>();
        try (Statement ps = connection.createStatement()){
            ResultSet rs = ps.executeQuery(
                    "SELECT * FROM edition");
            EditionMapper editionMapper = new EditionMapper();
            while ( rs.next() ){
                Edition edition = editionMapper.extractFromResultSet(rs);
                //edition = editionMapper.makeUniqueEdition( editions, edition);
                resultList.add(edition);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }


    @Override
    public Optional<Edition> findAllById(int id) {
        Optional<Edition> result = Optional.empty();
        try(PreparedStatement ps = connection.prepareCall("SELECT * FROM edition WHERE id = ?")){
            ps.setInt( 1, id);
            ResultSet rs;
            rs = ps.executeQuery();
            EditionMapper mapper = new EditionMapper();
            if (rs.next()){
                result = Optional.of(mapper.extractFromResultSet(rs));
            }//TODO : ask question how avoid two teachers with the same name
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return result;
    }

    /*@Override
    public List<Edition> findAll() {
        Map<Integer, Edition> editions = new HashMap<>();

        final String query = "" +
                " select * from edition";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);

            EditionMapper editionMapper = new EditionMapper();

            while (rs.next()) {
                Edition edition = editionMapper
                        .extractFromResultSet(rs);
                edition = editionMapper
                        .makeUnique(editions, edition);
                edition.getEditions().add(edition);
            }
            return new ArrayList<>(editions.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }*/

    /*@Override
    public List<User> findAll() {
        Optional<User> result = Optional.empty();
        try(PreparedStatement ps = connection.prepareCall("SELECT * FROM user")){
            ResultSet rs= ps.executeQuery();
            UserMapper mapper = new UserMapper();
            if (rs.next()){
                result = Optional.of(mapper.extractFromResultSet(rs));
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return result;
    }*/

    @Override
    public void update(Edition entity) {
        try(PreparedStatement ps = connection.prepareCall( "UPDATE edition SET name=?, author=?, price=?, amount_edition=?, status=?, amount_available=? WHERE id=?")){
            ps.setString( 1, entity.getName());
            ps.setString( 2, entity.getAuthor());
            ps.setLong( 3, entity.getPrice());
            ps.setInt( 4, entity.getAmountEdition());
            ps.setString( 5, entity.getEditionStatus().name());
            ps.setInt( 6, entity.getAmountAvailable());
            ps.setLong( 7, entity.getId());
            ps.executeUpdate();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(int id) {
        try(PreparedStatement ps = connection.prepareCall("DELETE FROM edition WHERE id = ?")){
            ps.setInt(1,id);
            ps.execute();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void close()  {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
