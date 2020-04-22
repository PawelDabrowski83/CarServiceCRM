package pl.coderslab.employee;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ServiceInterface;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    EmployeeEntity employeeEntity = mock(EmployeeEntity.class);
    Employee employee = mock(Employee.class);
    EmployeeDto employeeDto = mock(EmployeeDto.class);
    GenericDao<EmployeeEntity> employeeDao = mock(EmployeeDaoImpl.class);
    MapperInterface<EmployeeDto, Employee, EmployeeEntity> employeeMapper = mock(EmployeeMapper.class);
    ServiceInterface<EmployeeDto> employeeService = new EmployeeService(employeeDao, employeeMapper);

    @Before
    public void setUp() {

        when(employeeMapper.mapEntityToService(employeeEntity)).thenReturn(employee);
        when(employeeMapper.mapServiceToEntity(employee)).thenReturn(employeeEntity);
        when(employeeMapper.mapDtoToService(employeeDto)).thenReturn(employee);
        when(employeeMapper.mapServiceToDto(employee)).thenReturn(employeeDto);
    }
    @Test
    public void shouldEmployeeServiceCreateWork() {

        // when
        employeeService.create(employeeDto);

        // then
        verify(employeeDao, times(1)).create(employeeEntity);
    }

    @Test
    public void shouldEmployeeServiceReadWork() {

        // when
        employeeService.read(1);

        // then
        verify(employeeDao, times(1)).read(1);
    }

    @Test
    public void shouldEmployeeServiceUpdateWork() {

        // when
        employeeService.update(employeeDto);

        // then
        verify(employeeDao, times(1)).update(employeeEntity);
    }

    @Test
    public void shouldEmployeeServiceDeleteWork() {

        // when
        employeeService.delete(1);

        // then
        verify(employeeDao, times(1)).delete(1);
    }

    @Test
    public void shouldEmployeeServiceFindAllWork() {

        // when
        employeeService.findAll();

        // then
        verify(employeeDao, times(1)).findAll();
    }
}
