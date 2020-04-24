package pl.coderslab.vehicle;

import pl.coderslab.commons.DbUtil;
import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class VehicleDaoImpl implements GenericDao<VehicleEntity> {

    private static final String TABLE_NAME = "vehicles";
    private static final String CREATE_QUERY =
            "INSERT INTO " + TABLE_NAME + " (details_id, registration_plate, next_inspection, owner, color, notes, created, updated) VALUES (?, ?, ?, ?, ?, ?, NOW(), NOW())";
    private static final String READ_QUERY =
            "SELECT * FROM " + TABLE_NAME + " WHERE vehicle_id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE " + TABLE_NAME + " SET details_id = ?, registration_plate = ?, next_inspection = ?, owner = ?, color = ?, notes = ?, updated = NOW() WHERE vehicle_id = ?";
    private static final String DELETE_QUERY =
            "UPDATE " + TABLE_NAME + " SET active = 0, updated = NOW() WHERE vehicle_id = ?";
    private static final String FIND_ALL_QUERY =
            "SELECT * FROM " + TABLE_NAME + " WHERE active = 1";


    @Override
    public void create(VehicleEntity entity) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY);
            statement.setInt(1, entity.getCarId());
            statement.setString(2, entity.getRegistryPlate());
            statement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.of(entity.getNextInspection(), LocalTime.NOON)));
            statement.setInt(4, entity.getOwnerId());
            statement.setString(5, entity.getColor());
            statement.setString(6, entity.getNotes());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public VehicleEntity read(int id) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                VehicleEntity entity = new VehicleEntity();
                entity.setVehicleId(resultSet.getInt("vehicle_id"));
                entity.setCarId(resultSet.getInt("details_id"));
                entity.setRegistryPlate(resultSet.getString("registration_plate"));
                entity.setNextInspection(resultSet.getTimestamp("next_inspection").toLocalDateTime().toLocalDate());
                entity.setOwnerId(resultSet.getInt("owner"));
                entity.setColor(resultSet.getString("color"));
                entity.setNotes(resultSet.getString("notes"));
                entity.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                entity.setUpdated(resultSet.getTimestamp("updated").toLocalDateTime());
                entity.setActive(resultSet.getBoolean("active"));
                return entity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new VehicleEntity();
    }

    @Override
    public void update(VehicleEntity entity) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            statement.setInt(1, entity.getCarId());
            statement.setString(2, entity.getRegistryPlate());
            statement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.of(entity.getNextInspection(), LocalTime.NOON)));
            statement.setInt(4, entity.getOwnerId());
            statement.setString(5, entity.getColor());
            statement.setString(6, entity.getNotes());
            statement.setInt(7, entity.getVehicleId());
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
    public Set<VehicleEntity> findAll() {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            Set<VehicleEntity> vehicleEntities = new HashSet<>();
            while (resultSet.next()) {
                VehicleEntity entity = new VehicleEntity();
                entity.setVehicleId(resultSet.getInt("vehicle_id"));
                entity.setCarId(resultSet.getInt("details_id"));
                entity.setRegistryPlate(resultSet.getString("registration_plate"));
                entity.setOwnerId(resultSet.getInt("owner"));
                entity.setColor(resultSet.getString("color"));
                entity.setNotes(resultSet.getString("notes"));
                entity.setNextInspection(resultSet.getTimestamp("next_inspection").toLocalDateTime().toLocalDate());
                entity.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                entity.setUpdated(resultSet.getTimestamp("updated").toLocalDateTime());
                entity.setActive(resultSet.getBoolean("active"));
                vehicleEntities.add(entity);
            }
            return vehicleEntities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }
}
