package pl.coderslab.employee;

import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ServiceInterface;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class EmployeeService implements ServiceInterface<EmployeeDto> {

    private final GenericDao<EmployeeEntity> EMPLOYEE_DAO;
    private final MapperInterface<EmployeeDto, Employee, EmployeeEntity> EMPLOYEE_MAPPER;


    public EmployeeService(GenericDao<EmployeeEntity> EMPLOYEE_DAO, MapperInterface<EmployeeDto, Employee, EmployeeEntity> EMPLOYEE_MAPPER) {
        this.EMPLOYEE_DAO = EMPLOYEE_DAO;
        this.EMPLOYEE_MAPPER = EMPLOYEE_MAPPER;
    }

    @Override
    public void create(EmployeeDto dto) {
        EMPLOYEE_DAO.create(
                EMPLOYEE_MAPPER.mapServiceToEntity(
                        EMPLOYEE_MAPPER.mapDtoToService(
                                dto)));
    }

    @Override
    public EmployeeDto read(int id) {
        Optional<EmployeeEntity> entityOptional = Optional.ofNullable(EMPLOYEE_DAO.read(id));
        EmployeeEntity entity = entityOptional.orElseGet(EmployeeEntity::new);
        return EMPLOYEE_MAPPER.mapServiceToDto(EMPLOYEE_MAPPER.mapEntityToService(entity));
    }

    @Override
    public void update(EmployeeDto dto) {
        EMPLOYEE_DAO.update(
                EMPLOYEE_MAPPER.mapServiceToEntity(
                        EMPLOYEE_MAPPER.mapDtoToService(
                                dto)));

    }

    @Override
    public void delete(int id) {
        EMPLOYEE_DAO.delete(id);
    }

    @Override
    public Set<EmployeeDto> findAll() {

        return EMPLOYEE_DAO.findAll().stream()
                .map(EMPLOYEE_MAPPER::mapEntityToService)
                .map(EMPLOYEE_MAPPER::mapServiceToDto)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
