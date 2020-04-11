package pl.coderslab.vehicle;

import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ServiceInterface;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class VehicleService implements ServiceInterface<VehicleDto> {

    private static final GenericDao<VehicleEntity> VEHICLE_DAO = new VehicleDaoImpl();
    private static final MapperInterface<VehicleDto, Vehicle, VehicleEntity> VEHICLE_MAPPER = new VehicleMapper();

    @Override
    public void create(VehicleDto dto) {
        VEHICLE_DAO.create(
                VEHICLE_MAPPER.mapServiceToEntity(
                        VEHICLE_MAPPER.mapDtoToService(
                                dto)));
    }

    @Override
    public VehicleDto read(int id) {
        Optional<VehicleEntity> vehicleEntity = Optional.ofNullable(VEHICLE_DAO.read(id));
        VehicleEntity entity = vehicleEntity.orElseGet(VehicleEntity::new);
        return VEHICLE_MAPPER.mapServiceToDto(
                VEHICLE_MAPPER.mapEntityToService(
                        entity));
    }

    @Override
    public void update(VehicleDto dto) {
        VEHICLE_DAO.update(
                VEHICLE_MAPPER.mapServiceToEntity(
                        VEHICLE_MAPPER.mapDtoToService(
                                dto)));
    }

    @Override
    public void delete(int id) {
        VEHICLE_DAO.delete(id);
    }

    @Override
    public Set<VehicleDto> findAll() {
        return VEHICLE_DAO.findAll().stream()
                .map(VEHICLE_MAPPER::mapEntityToService)
                .map(VEHICLE_MAPPER::mapServiceToDto)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
