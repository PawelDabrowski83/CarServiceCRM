package pl.coderslab.Person;

import pl.coderslab.commons.DbUtil;
import pl.coderslab.commons.EntityDao;

import java.sql.*;
import java.util.Set;

public class PersonDaoImpl extends EntityDao<PersonEntity> {

    private static final String TABLE_NAME = "personal_infos";
    private static final String CREATE_QUERY =
            "INSERT INTO " + TABLE_NAME + " (first_name, last_name, address, phone, notes, created, date_of_birth) values (?, ?, ?, ?, ?, ?, ?)";
    private static final String READ_QUERY =
            "SELECT * FROM " + TABLE_NAME + " where personal_id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE " + TABLE_NAME + " SET first_name = ?, last_name = ?, address = ?, phone = ?, notes = ?, created = ?, updated = NOW(), date_of_birth = ? where personal_id = ?";
    private static final String DELETE_QUERY =
            "DELETE FROM " + TABLE_NAME + " WHERE personal_id = ?";
    private static final String FIND_ALL_QUERY =
            "SELECT * FROM " + TABLE_NAME;

    public PersonDaoImpl(Class<PersonEntity> classType) {
        super(classType);
    }

    @Override
    public void create(PersonEntity entity) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY);
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getAddress());
            statement.setString(4, entity.getPhone());
            statement.setString(5, entity.getNotes());
            statement.setString(6, entity.getCreated().toString());
            statement.setString(7, entity.getBirthdate().toString());
            statement.executeUpdate();
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
                PersonEntity entity = new PersonEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("first_name"));
                entity.setLastName(resultSet.getString("last_name"));
                entity.setAddress(resultSet.getString("address"));
                entity.setPhone(resultSet.getString("phone"));
                entity.setNotes(resultSet.getString("notes"));
                entity.setBirthdate(resultSet.getTimestamp("birthdate").toLocalDateTime().toLocalDate());
                entity.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                entity.setUpdated(resultSet.getTimestamp("updated").toLocalDateTime());
                entity.setActive(resultSet.getBoolean("active"));
                return entity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new PersonEntity();
    }

    @Override
    public void update(PersonEntity entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Set<PersonEntity> findAll() {
        return null;
    }
}
