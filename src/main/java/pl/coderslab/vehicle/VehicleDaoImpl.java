package pl.coderslab.vehicle;

import pl.coderslab.commons.EntityDao;
import pl.coderslab.commons.MapperInterface;

import java.util.Set;

public class VehicleDaoImpl extends EntityDao<VehicleEntity> {

    private static final MapperInterface<VehicleDto, Vehicle, VehicleEntity> VEHICLE_MAPPER = new VehicleMapper();
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

    }

    @Override
    public VehicleEntity read(int id) {
        return null;
    }

    @Override
    public void update(VehicleEntity entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Set<VehicleEntity> findAll() {
        return null;
    }
}
