package pl.coderslab.labor;

import pl.coderslab.commons.DbUtil;
import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ParameterReaderService;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class LaborDaoImpl implements GenericDao<LaborEntity> {

    private static final MapperInterface<LaborDto, Labor, LaborEntity> LABOR_MAPPER = new LaborMapper();
    private static final String TABLE_NAME = "labors";
    private static final String CREATE_QUERY =
            "INSERT INTO " + TABLE_NAME + " (registry_date, scheduled_date, started_date, finished_date, assigned, issue_description, service_log, status, vehicle, labor_cost, material_cost, mh_ammount, created, updated) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";
    private static final String READ_QUERY =
            "SELECT * FROM " + TABLE_NAME + " WHERE labor_id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE " + TABLE_NAME + " SET registry_date = ?, scheduled_date = ?, started_date = ?, finished_date = ?, assigned = ?, issue_description = ?, service_log = ?, status = ?, vehicle = ?, labor_cost = ?, material_cost = ?, mh_ammount = ?, updated = NOW() WHERE labor_id = ?";
    private static final String DELETE_QUERY =
            "UPDATE " + TABLE_NAME + " SET active = 0, updated = NOW() WHERE labor_id = ?";
    private static final String FIND_ALL_QUERY =
            "SELECT * FROM " + TABLE_NAME + " WHERE active = 1";
    @Override
    public void create(LaborEntity entity) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY);
            pushEntityIntoStatement(statement, entity);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LaborEntity read(int id) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getLaborEntityFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new LaborEntity();
    }

    @Override
    public void update(LaborEntity entity) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            pushEntityIntoStatement(statement, entity);
            statement.setInt(13, entity.getLaborId());
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
    public Set<LaborEntity> findAll() {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            Set<LaborEntity> entities = new HashSet<>();
            while(resultSet.next()) {
                entities.add(getLaborEntityFromResultSet(resultSet));
            }
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }

    private LaborEntity getLaborEntityFromResultSet (ResultSet resultSet) throws SQLException {
        LaborEntity entity = new LaborEntity();
        entity.setLaborId(resultSet.getInt("labor_id"));
        entity.setRegistrationDate(resultSet.getTimestamp("registry_date").toLocalDateTime().toLocalDate());
        entity.setScheduledDate(resultSet.getTimestamp("scheduled_date").toLocalDateTime().toLocalDate());
        entity.setStartedDate(resultSet.getTimestamp("started_date").toLocalDateTime().toLocalDate());
        entity.setFinishedDate(resultSet.getTimestamp("finished_date").toLocalDateTime().toLocalDate());
        entity.setEmployeeId(resultSet.getInt("assigned"));
        entity.setDescriptionIssue(resultSet.getString("issue_description"));
        entity.setDescriptionService(resultSet.getString("service_log"));
        entity.setStatus(LaborEntity.StatusEnum.valueOf(resultSet.getString("status")));
        entity.setVehicleId(resultSet.getInt("vehicle"));
        entity.setCustomerCost(resultSet.getDouble("labor_cost"));
        entity.setMaterialCost(resultSet.getDouble("material_cost"));
        entity.setMhTotal(resultSet.getInt("mh_ammount"));
        entity.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
        entity.setUpdated(resultSet.getTimestamp("updated").toLocalDateTime());
        entity.setActive(resultSet.getBoolean("active"));
        return entity;
    }

    private void pushEntityIntoStatement (PreparedStatement statement, LaborEntity entity) throws SQLException{
        statement.setTimestamp(1, ParameterReaderService.convertLocalDateToTimestamp(entity.getRegistrationDate()));
        statement.setTimestamp(2, ParameterReaderService.convertLocalDateToTimestamp(entity.getScheduledDate()));
        statement.setTimestamp(3, ParameterReaderService.convertLocalDateToTimestamp(entity.getStartedDate()));
        statement.setTimestamp(4, ParameterReaderService.convertLocalDateToTimestamp(entity.getFinishedDate()));
        statement.setInt(5, entity.getEmployeeId());
        statement.setString(6, entity.getDescriptionIssue());
        statement.setString(7, entity.getDescriptionService());
        statement.setString(8, entity.getStatus());
        statement.setInt(9, entity.getVehicleId());
        statement.setDouble(10, entity.getCustomerCost());
        statement.setDouble(11, entity.getMaterialCost());
        statement.setInt(12, entity.getMhTotal());
    }
}
