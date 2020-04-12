package pl.coderslab.labor;

import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ServiceInterface;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LaborService implements ServiceInterface<LaborDto> {

    private static final GenericDao<LaborEntity> LABOR_DAO = new LaborDaoImpl();
    private static final MapperInterface<LaborDto, Labor, LaborEntity> LABOR_MAPPER = new LaborMapper();

    @Override
    public void create(LaborDto dto) {
        LABOR_DAO.create(
                LABOR_MAPPER.mapServiceToEntity(
                        LABOR_MAPPER.mapDtoToService(
                                dto)));
    }

    @Override
    public LaborDto read(int id) {
        Optional<LaborEntity> laborEntity = Optional.ofNullable(LABOR_DAO.read(id));
        LaborEntity entity = laborEntity.orElseGet(LaborEntity::new);
        return LABOR_MAPPER.mapServiceToDto(
                LABOR_MAPPER.mapEntityToService(
                        entity));
    }

    @Override
    public void update(LaborDto dto) {
        LABOR_DAO.update(
                LABOR_MAPPER.mapServiceToEntity(
                        LABOR_MAPPER.mapDtoToService(
                                dto)));

    }

    @Override
    public void delete(int id) {
        LABOR_DAO.delete(id);
    }

    @Override
    public Set<LaborDto> findAll() {
        return LABOR_DAO.findAll().stream().map(LABOR_MAPPER::mapEntityToService).map(LABOR_MAPPER::mapServiceToDto).collect(Collectors.toCollection(TreeSet::new));
    }
}
