package pl.coderslab.employee;

import pl.coderslab.Person.*;
import pl.coderslab.commons.EntityDao;
import pl.coderslab.commons.MapperInterface;

public class EmployeeMapper implements MapperInterface<EmployeeDto,Employee,EmployeeEntity> {

    private static final PersonMapper PERSON_MAPPER = new PersonMapper();
    private static final EntityDao<PersonEntity> PERSON_DAO = new PersonDaoImpl();

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
        return employee;
    }
}
