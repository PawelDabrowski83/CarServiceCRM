package pl.coderslab.vehicle;

import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ServiceInterface;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class VehicleService implements ServiceInterface<VehicleDto> {

    private final GenericDao<VehicleEntity> vehicleDao;
    private final MapperInterface<VehicleDto, Vehicle, VehicleEntity> vehicleMapper;

    public VehicleService(GenericDao<VehicleEntity> vehicleDao, MapperInterface<VehicleDto, Vehicle, VehicleEntity> vehicleMapper) {
        this.vehicleDao = vehicleDao;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public void create(VehicleDto dto) {
        vehicleDao.create(
                vehicleMapper.mapServiceToEntity(
                        vehicleMapper.mapDtoToService(
                                dto)));
    }

    @Override
    public VehicleDto read(int id) {
        Optional<VehicleEntity> vehicleEntity = Optional.ofNullable(vehicleDao.read(id));
        VehicleEntity entity = vehicleEntity.orElseGet(VehicleEntity::new);
        return vehicleMapper.mapServiceToDto(
                vehicleMapper.mapEntityToService(
                        entity));
    }

    @Override
    public void update(VehicleDto dto) {
        vehicleDao.update(
                vehicleMapper.mapServiceToEntity(
                        vehicleMapper.mapDtoToService(
                                dto)));
    }

    @Override
    public void delete(int id) {
        vehicleDao.delete(id);
    }

    @Override
    public Set<VehicleDto> findAll() {
        return vehicleDao.findAll().stream()
                .map(vehicleMapper::mapEntityToService)
                .map(vehicleMapper::mapServiceToDto)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
