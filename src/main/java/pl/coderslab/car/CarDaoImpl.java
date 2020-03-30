package pl.coderslab.car;

import pl.coderslab.commons.DbUtil;
import pl.coderslab.commons.EntityDao;
import pl.coderslab.commons.MapperInterface;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class CarDaoImpl extends EntityDao<CarEntity> {

    private static final MapperInterface<CarDto, Car, CarEntity> CAR_MAPPER = new CarMapper();
    private static final String TABLE_NAME = "vehicle_details";
    private static final String CREATE_QUERY =
            "INSERT INTO " + TABLE_NAME + " (model, mark, production_year, created, updated) VALUES (?, ?, ?, NOW(), NOW())";
    private static final String READ_QUERY =
            "SELECT * FROM " + TABLE_NAME + " WHERE vehicle_details_id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE " + TABLE_NAME + " SET model = ?, mark = ?, production_year = ?, updated = NOW() WHERE vehicle_details_id = ?";
    private static final String DELETE_QUERY =
            "UPDATE " + TABLE_NAME + " SET active = 0, updated = NOW() WHERE vehicle_details_id = ?";
    private static final String FIND_ALL_QUERY =
            "SELECT * FROM " + TABLE_NAME + " WHERE active = 1";


    @Override
    public void create(CarEntity entity) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY);
            statement.setString(1, entity.getModel());
            statement.setString(2, entity.getMark());
            statement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.of(entity.getProductionYear(), LocalTime.NOON)));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CarEntity read(int id) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                CarEntity entity = new CarEntity();
                entity.setCarId(resultSet.getInt("vehicle_details_id"));
                entity.setModel(resultSet.getString("model"));
                entity.setMark(resultSet.getString("mark"));
                entity.setProductionYear(resultSet.getTimestamp("production_year").toLocalDateTime().toLocalDate());
                entity.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                entity.setUpdated(resultSet.getTimestamp("updated").toLocalDateTime());
                entity.setActive(resultSet.getBoolean("active"));
                return entity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new CarEntity();
    }

    @Override
    public void update(CarEntity entity) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            statement.setString(1, entity.getModel());
            statement.setString(2, entity.getMark());
            statement.setString(3, entity.getProductionYear().toString());
            statement.setInt(4, entity.getCarId());
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
    public Set<CarEntity> findAll() {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            Set<CarEntity> entities = new HashSet<>();
            while (resultSet.next()) {
                CarEntity entity = new CarEntity();
                entity.setCarId(resultSet.getInt("vehicle_details_id"));
                entity.setModel(resultSet.getString("model"));
                entity.setMark(resultSet.getString("mark"));
                entity.setProductionYear(resultSet.getTimestamp("production_year").toLocalDateTime().toLocalDate());
                entity.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                entity.setUpdated(resultSet.getTimestamp("updated").toLocalDateTime());
                entity.setActive(resultSet.getBoolean("active"));
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }
}
