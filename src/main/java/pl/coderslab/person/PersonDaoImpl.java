package pl.coderslab.person;

import pl.coderslab.commons.DbUtil;
import java.sql.*;
import java.util.*;

public class PersonDaoImpl implements PersonDaoInterface<PersonEntity> {

    private static final String TABLE_NAME = "personal_infos";
    private static final String CREATE_QUERY =
            "INSERT INTO " + TABLE_NAME + " (first_name, last_name, address, phone, notes, created, updated, date_of_birth) values (?, ?, ?, ?, ?, NOW(), NOW(), ?)";
    private static final String READ_QUERY =
            "SELECT * FROM " + TABLE_NAME + " where personal_id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE " + TABLE_NAME + " SET first_name = ?, last_name = ?, address = ?, phone = ?, notes = ?, updated = NOW(), date_of_birth = ? where personal_id = ?";
    private static final String DELETE_QUERY =
            "UPDATE " + TABLE_NAME + " SET active = 0, updated = NOW() WHERE personal_id = ?";
    private static final String FIND_ALL_QUERY =
            "SELECT * FROM " + TABLE_NAME + " WHERE active = 1";
    private static final String FIND_UNMATCHED_CUSTOMERS =
            "SELECT * FROM " + TABLE_NAME + " WHERE " + TABLE_NAME + ".personal_id NOT IN (SELECT customers.personal_id FROM customers WHERE customers.personal_id=" + TABLE_NAME + ".personal_id AND active = 1);";
    private static final String FIND_UNMATCHED_EMPLOYEES =
            "SELECT * FROM " + TABLE_NAME + " WHERE " + TABLE_NAME + ".personal_id NOT IN (SELECT employees.personal_id FROM employees WHERE employees.personal_id=" + TABLE_NAME + ".personal_id AND active = 1);";

    @Override
    public void create(PersonEntity entity) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY);
            pushPreparedStatementOnEntity(statement, entity);
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
            statement.setInt(7, entity.getId());
            statement.executeUpdate();
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
            Set<PersonEntity> entities = new HashSet<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                entities.add(getEntityFromResultSet(resultSet));
            }
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
            return new HashSet<>(0);
        }
    }


    @Override
    public Set<PersonEntity> findUnmatchedCustomers() {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_UNMATCHED_CUSTOMERS);
            ResultSet resultSet = statement.executeQuery();
            Set<PersonEntity> entities = new HashSet<>();
            while (resultSet.next()) {
                entities.add(getEntityFromResultSet(resultSet));
            }
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new HashSet<>(0);
    }

    @Override
    public Set<PersonEntity> findUnmatchedEmployees() {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_UNMATCHED_EMPLOYEES);
            ResultSet resultSet = statement.executeQuery();
            Set<PersonEntity> entities = new HashSet<>();
            while (resultSet.next()) {
                entities.add(getEntityFromResultSet(resultSet));
            }
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new HashSet<>(0);
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
        entity.setUpdated(resultSet.getTimestamp("updated").toLocalDateTime());
        entity.setActive(resultSet.getBoolean("active"));
        return entity;
    }

    private void pushPreparedStatementOnEntity (PreparedStatement statement, PersonEntity entity) throws SQLException {
        statement.setString(1, entity.getFirstName());
        statement.setString(2, entity.getLastName());
        statement.setString(3, entity.getAddress());
        statement.setString(4, entity.getPhone());
        statement.setString(5, entity.getNotes());
        statement.setString(6, entity.getBirthdate().toString());

    }


}
