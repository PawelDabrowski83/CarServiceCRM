package pl.coderslab.employee;

import pl.coderslab.commons.DbUtil;
import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDaoImpl implements GenericDao<EmployeeEntity> {

    private static final MapperInterface<EmployeeDto,Employee,EmployeeEntity> EMPLOYEE_MAPPER = new EmployeeMapper();
    private static final String TABLE_NAME = "employees";
    private static final String CREATE_QUERY =
            "INSERT INTO " + TABLE_NAME + " (personal_id, mh_cost, created, updated) values (?, ?, NOW(), NOW())";
    private static final String READ_QUERY =
            "SELECT * FROM " + TABLE_NAME + " where employee_id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE " + TABLE_NAME + " SET personal_id = ?, mh_cost = ?, updated = NOW() where employee_id = ?";
    private static final String DELETE_QUERY =
            "UPDATE " + TABLE_NAME + " SET active = 0, updated = NOW() WHERE employee_id = ?";
    private static final String FIND_ALL_QUERY =
            "SELECT * FROM " + TABLE_NAME + " WHERE active = 1";

    @Override
    public void create(EmployeeEntity entity) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY);
            statement.setInt(1, entity.getPersonId());
            statement.setDouble(2, entity.getMhCost());
            System.out.println(">>" + statement.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public EmployeeEntity read(int id) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EmployeeEntity entity = new EmployeeEntity();
                entity.setEmployeeId(resultSet.getInt("employee_id"));
                entity.setPersonId(resultSet.getInt("personal_id"));
                entity.setMhCost(resultSet.getDouble("mh_cost"));
                entity.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                entity.setUpdated(resultSet.getTimestamp("updated").toLocalDateTime());
                entity.setActive(resultSet.getBoolean("active"));
                return entity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new EmployeeEntity();
    }

    @Override
    public void update(EmployeeEntity entity) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            statement.setInt(1, entity.getPersonId());
            statement.setDouble(2, entity.getMhCost());
            statement.setInt(3, entity.getEmployeeId());
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
    public Set<EmployeeEntity> findAll() {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            Set<EmployeeEntity> entitySet = new HashSet<>();
            while (resultSet.next()) {
                EmployeeEntity entity = new EmployeeEntity();
                entity.setEmployeeId(resultSet.getInt("employee_id"));
                entity.setPersonId(resultSet.getInt("personal_id"));
                entity.setMhCost(resultSet.getDouble("mh_cost"));
                entity.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                entity.setUpdated(resultSet.getTimestamp("updated").toLocalDateTime());
                entity.setActive(resultSet.getBoolean("active"));
                entitySet.add(entity);
            }
            return entitySet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }
}
