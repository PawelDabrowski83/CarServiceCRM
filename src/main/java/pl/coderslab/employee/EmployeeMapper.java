package pl.coderslab.employee;

import pl.coderslab.Person.PersonDaoImpl;
import pl.coderslab.Person.PersonEntity;
import pl.coderslab.Person.PersonMapper;
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
        dto.setUpdated(employee.getUpdated().toString());
        dto.setActive(employee.isActive());
        return dto;
    }

    @Override
    public Employee mapDtoToService(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setEmployeeId(dto.getEmployeeId());
        employee.setPerson(PERSON_MAPPER.mapEntityToService(PERSON_DAO.read(dto.getPersonId())));
        return null;
    }

    @Override
    public EmployeeEntity mapServiceToEntity(Employee employee) {
        return null;
    }

    @Override
    public Employee mapEntityToService(EmployeeEntity entity) {
        return null;
    }
}
