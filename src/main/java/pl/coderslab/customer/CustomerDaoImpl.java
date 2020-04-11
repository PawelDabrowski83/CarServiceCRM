package pl.coderslab.customer;

import pl.coderslab.commons.DbUtil;
import pl.coderslab.commons.EntityDao;
import pl.coderslab.commons.MapperInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CustomerDaoImpl extends EntityDao<CustomerEntity> implements CustomerDaoInterface<CustomerEntity>{

    private static final MapperInterface<CustomerDto, Customer, CustomerEntity> CUSTOMER_MAPPER = new CustomerMapper();
    private static final String TABLE_NAME = "customers";
    private static final String CREATE_QUERY =
            "INSERT INTO " + TABLE_NAME + " (personal_id, created, updated) VALUES (?, NOW(), NOW())";
    private static final String READ_QUERY =
            "SELECT * FROM " + TABLE_NAME + " WHERE customer_id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE " + TABLE_NAME + " SET personal_id = ?, updated = NOW() WHERE customer_id = ?";
    private static final String DELETE_QUERY =
            "UPDATE " + TABLE_NAME + " SET active = 0, updated = NOW() WHERE customer_id = ?";
    private static final String FIND_ALL_QUERY =
            "SELECT * FROM " + TABLE_NAME + " WHERE active = 1";
    private static final String FIND_UNMATCHED_PERSON =
            "SELECT * FROM personal_infos\n" +
                    "WHERE personal_infos.personal_id\n" +
                    "    NOT IN (SELECT customers.personal_id\n" +
                    "    FROM customers\n" +
                    "    WHERE customers.personal_id=personal_infos.personal_id);";

    @Override
    public void create(CustomerEntity entity) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY);
            statement.setInt(1, entity.getPersonalId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CustomerEntity read(int id) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                CustomerEntity entity = new CustomerEntity();
                entity.setCustomerId(resultSet.getInt("customer_id"));
                entity.setPersonalId(resultSet.getInt("personal_id"));
                entity.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                entity.setUpdated(resultSet.getTimestamp("updated").toLocalDateTime());
                entity.setActive(resultSet.getBoolean("active"));
                return entity;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new CustomerEntity();
    }

    @Override
    public void update(CustomerEntity entity) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            statement.setInt(1, entity.getPersonalId());
            statement.setInt(2, entity.getCustomerId());
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
            System.out.println(statement.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Set<CustomerEntity> findAll() {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            Set<CustomerEntity> entities = new HashSet<>();
            while (resultSet.next()) {
//                CustomerEntity entity = new CustomerEntity();
//                entity.setCustomerId(resultSet.getInt("customer_id"));
//                entity.setPersonalId(resultSet.getInt("personal_id"));
//                entity.setUpdated(resultSet.getTimestamp("updated").toLocalDateTime());
//                entity.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
//                entity.setActive(resultSet.getBoolean("active"));
                entities.add(getEntityFromResultSet(resultSet));
            }
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }

    public Set<CustomerEntity> findUnmatched() {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_UNMATCHED_PERSON);
            ResultSet resultSet = statement.executeQuery();
            Set<CustomerEntity> entities = new HashSet<>();
            while (resultSet.next()) {
                entities.add(getEntityFromResultSet(resultSet));
            }
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }

    protected CustomerEntity getEntityFromResultSet (ResultSet resultSet) throws SQLException {
        CustomerEntity entity = new CustomerEntity();
        entity.setCustomerId(resultSet.getInt("customer_i"));
        entity.setPersonalId(resultSet.getInt("personal_id"));
        entity.setUpdated(resultSet.getTimestamp("updated").toLocalDateTime());
        entity.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
        entity.setActive(resultSet.getBoolean("active"));
        return entity;
    }
}
