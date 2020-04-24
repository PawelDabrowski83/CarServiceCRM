package pl.coderslab.employee;

import pl.coderslab.commons.GenericDao;
import pl.coderslab.person.*;
import pl.coderslab.commons.MapperInterface;

public class EmployeeMapper implements MapperInterface<EmployeeDto,Employee,EmployeeEntity> {

    private final GenericDao<PersonEntity> PERSON_DAO;
    private final MapperInterface<PersonDto, Person, PersonEntity> PERSON_MAPPER;

    public EmployeeMapper(GenericDao<PersonEntity> PERSON_DAO, MapperInterface<PersonDto, Person, PersonEntity> PERSON_MAPPER) {
        this.PERSON_DAO = PERSON_DAO;
        this.PERSON_MAPPER = PERSON_MAPPER;
    }

    @Override
    public EmployeeDto mapServiceToDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setEmployeeId(employee.getEmployeeId());
        dto.setPersonId(employee.getPerson().getId());
        dto.setMhCost(employee.getMhCost());
        dto.setFullname(employee.getPerson().getFullname());
        return dto;
    }

    @Override
    public Employee mapDtoToService(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setEmployeeId(dto.getEmployeeId());
        employee.setPerson(PERSON_MAPPER.mapEntityToService(PERSON_DAO.read(dto.getPersonId())));
        employee.setMhCost(dto.getMhCost());
        return employee;
    }

    @Override
    public EmployeeEntity mapServiceToEntity(Employee employee) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setEmployeeId(employee.getEmployeeId());
        entity.setPersonId(employee.getPerson().getId());
        entity.setMhCost(employee.getMhCost());
        return entity;
    }

    @Override
    public Employee mapEntityToService(EmployeeEntity entity) {
        Employee employee = new Employee();
        employee.setEmployeeId(entity.getEmployeeId());
        employee.setPerson(PERSON_MAPPER.mapEntityToService(PERSON_DAO.read(entity.getPersonId())));
        employee.setMhCost(entity.getMhCost());
        employee.setCreated(entity.getCreated());
        employee.setUpdated(entity.getUpdated());
        employee.setActive(entity.isActive());
        return employee;
    }
}
