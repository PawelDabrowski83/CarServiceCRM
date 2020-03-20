package pl.coderslab.Person;

import pl.coderslab.commons.DbUtil;
import pl.coderslab.commons.EntityDao;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class PersonDaoImpl extends EntityDao<PersonEntity> {

    private static final PersonMapper PERSON_MAPPER = new PersonMapper();
    private static final String TABLE_NAME = "personal_infos";
    private static final String CREATE_QUERY =
            "INSERT INTO " + TABLE_NAME + " (first_name, last_name, address, phone, notes, created, updated, date_of_birth) values (?, ?, ?, ?, ?, NOW(), NOW(), ?)";
    private static final String READ_QUERY =
            "SELECT * FROM " + TABLE_NAME + " where personal_id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE " + TABLE_NAME + " SET first_name = ?, last_name = ?, address = ?, phone = ?, notes = ?, updated = NOW(), date_of_birth = ? where personal_id = ?";
    private static final String DELETE_QUERY =
            "DELETE FROM " + TABLE_NAME + " WHERE personal_id = ?";
    private static final String FIND_ALL_QUERY =
            "SELECT * FROM " + TABLE_NAME;

//    public PersonDaoImpl(Class<PersonEntity> classType) {
//        super(classType);
//    }

    @Override
    public void create(PersonEntity entity) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY);
            pushPreparedStatementOnEntity(statement, entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PersonEntity read(int id) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getEntityFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new PersonEntity();
    }

    @Override
    public void update(PersonEntity entity) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            pushPreparedStatementOnEntity(statement, entity);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<PersonEntity> findAll() {
        try (Connection conn = DbUtil.getConnection()) {
            List<PersonEntity> entities = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
//            System.out.println("ostatni: " + resultSet.last());
//            System.out.println("columnCount: " + resultSet.getMetaData().getColumnCount());
//            System.out.println(resultSet.getString(1));
//            System.out.println(resultSet.getString(2));
            while (resultSet.next()) {
                entities.add(getEntityFromResultSet(resultSet));
            }
            return entities.stream()
                    .map(PERSON_MAPPER::mapEntityToService)
                    .sorted(Comparator.naturalOrder())
                    .map(PERSON_MAPPER::mapServiceToEntity)
                    .collect(Collectors.toCollection(TreeSet::new));
        } catch (SQLException e) {
            e.printStackTrace();
            return new HashSet<>(0);
        }
    }

    private PersonEntity getEntityFromResultSet (ResultSet resultSet) throws SQLException{
        PersonEntity entity = new PersonEntity();
        entity.setId(resultSet.getInt("personal_id"));
        entity.setFirstName(resultSet.getString("first_name"));
        entity.setLastName(resultSet.getString("last_name"));
        entity.setAddress(resultSet.getString("address"));
        entity.setPhone(resultSet.getString("phone"));
        entity.setNotes(resultSet.getString("notes"));
        entity.setBirthdate(resultSet.getTimestamp("date_of_birth").toLocalDateTime().toLocalDate());
//        entity.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
        entity.setUpdated(resultSet.getTimestamp("updated").toLocalDateTime());
        entity.setActive(resultSet.getBoolean("active"));
        System.out.println(entity);
        return entity;
    }

    private void pushPreparedStatementOnEntity (PreparedStatement statement, PersonEntity entity) throws SQLException {
        statement.setString(1, entity.getFirstName());
        statement.setString(2, entity.getLastName());
        statement.setString(3, entity.getAddress());
        statement.setString(4, entity.getPhone());
        statement.setString(5, entity.getNotes());
//        statement.setString(6, entity.getCreated().toString());
//        statement.setString(7, entity.getUpdated().toString());
        statement.setString(6, entity.getBirthdate().toString());
        statement.executeUpdate();
    }
}
