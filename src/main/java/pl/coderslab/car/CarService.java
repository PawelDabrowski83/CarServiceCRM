package pl.coderslab.car;

import pl.coderslab.commons.EntityDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ServiceInterface;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CarService implements ServiceInterface<CarDto> {

    private static final EntityDao<CarEntity> CAR_DAO = new CarDaoImpl();
    private static final MapperInterface<CarDto, Car, CarEntity> CAR_MAPPER = new CarMapper();

    @Override
    public void create(CarDto dto) {
        CAR_DAO.create(
                CAR_MAPPER.mapServiceToEntity(
                        CAR_MAPPER.mapDtoToService(
                                dto)));
    }

    @Override
    public CarDto read(int id) {
        Optional<CarEntity> entityOptional = Optional.of(CAR_DAO.read(id));
        CarEntity entity = entityOptional.orElseGet(CarEntity::new);
        return CAR_MAPPER.mapServiceToDto(
                CAR_MAPPER.mapEntityToService(
                        entity));
    }

    @Override
    public void update(CarDto dto) {
        CAR_DAO.update(
                CAR_MAPPER.mapServiceToEntity(
                        CAR_MAPPER.mapDtoToService(
                                dto)));
    }

    @Override
    public void delete(int id) {
        CAR_DAO.delete(id);
    }

    @Override
    public Set<CarDto> findAll() {
        return CAR_DAO.findAll().stream()
                .map(CAR_MAPPER::mapEntityToService)
                .map(CAR_MAPPER::mapServiceToDto)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
