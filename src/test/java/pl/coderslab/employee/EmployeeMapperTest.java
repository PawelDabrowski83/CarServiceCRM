package pl.coderslab.employee;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.runners.*;
import pl.coderslab.commons.*;
import pl.coderslab.person.*;

import java.time.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeMapperTest {

    Person person;
    PersonEntity personEntity;
    Employee employee;
    EmployeeEntity employeeEntity;
    EmployeeDto employeeDto;
    final PersonDaoInterface<PersonEntity> personDao = mock(PersonDaoImpl.class);
    final MapperInterface<PersonDto, Person, PersonEntity> personMapper = mock(PersonMapper.class);
    final MapperInterface<EmployeeDto, Employee, EmployeeEntity> employeeMapper = new EmployeeMapper(personDao, personMapper);

    @Before
    public void setUp() {

        person = mock(Person.class);
    }

    @Test
    public void shouldMapServiceToDtoWork() {

        // given
        employee = new Employee(
                1,
                person,
                1.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        EmployeeDto employeeDtoExpected = new EmployeeDto(
                1,
                1,
                1.0,
                "fullname"
        );
        when(person.getFullname()).thenReturn("fullname");
        when(person.getId()).thenReturn(1);

        // when
        EmployeeDto employeeDtoActual = employeeMapper.mapServiceToDto(employee);

        // then
        assertEquals(employeeDtoExpected, employeeDtoActual);
        assertEquals(1, employeeDtoActual.getEmployeeId());
        assertEquals(1, employeeDtoActual.getPersonId());
        assertEquals(1.0, employeeDtoActual.getMhCost(), 0.1);
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenMappingNullInServiceToDto() {

        // given
        employee = null;

        // when
        employeeMapper.mapServiceToDto(employee);
    }

    @Test
    public void shouldMapDtoToServiceWork() {

        // given
        employeeDto = new EmployeeDto(
                1,
                1,
                1.0,
                null
        );
        Employee employeeExpected = new Employee(
                1,
                person,
                1.0,
                null,
                null,
                false
        );
        when(personDao.read(1)).thenReturn(personEntity);
        when(personMapper.mapEntityToService(personEntity)).thenReturn(person);
        Employee employee1 = new Employee();

        // when
        Employee employeeActual = employeeMapper.mapDtoToService(employeeDto);

        // then
        assertEquals(employeeExpected, employeeActual);
        assertEquals(1, employeeActual.getEmployeeId());
        assertEquals(1.0, employeeActual.getMhCost(), 0.1);
        assertNull(employeeActual.getCreated());
        assertNull(employeeActual.getUpdated());
        assertFalse(employeeActual.isActive());
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenMappingNullInDtoToService() {

        // given
        employeeDto = null;

        // when
        employeeMapper.mapDtoToService(employeeDto);
    }

    @Test
    public void shouldMapEntityToServiceWork() {

        // given
        employeeEntity = new EmployeeEntity(
                1,
                1,
                1.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Employee employeeExpected = new Employee(
                1,
                person,
                1.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        when(personDao.read(1)).thenReturn(personEntity);
        when(personMapper.mapEntityToService(personEntity)).thenReturn(person);

        // when
        Employee employeeActual = employeeMapper.mapEntityToService(employeeEntity);

        // then
        assertEquals(employeeExpected, employeeActual);
        assertEquals(1, employeeActual.getEmployeeId());
        assertEquals(1.0, employeeActual.getMhCost(), 0.1);
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), employeeActual.getCreated());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), employeeActual.getUpdated());
        assertTrue(employeeActual.isActive());
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenMappingNullInEntityToService() {

        // given
        employeeEntity = null;

        // when
        employeeMapper.mapEntityToService(employeeEntity);
    }

    @Test
    public void shouldMapServiceToEntityWork() {

        // given
        employee = new Employee(
                1,
                person,
                1.0,
                null,
                null,
                false
        );
        EmployeeEntity employeeEntityExpected = new EmployeeEntity(
                1,
                1,
                1.0,
                null,
                null,
                false
        );
        when(person.getId()).thenReturn(1);

        // when
        EmployeeEntity employeeEntityActual = employeeMapper.mapServiceToEntity(employee);

        // then
        assertEquals(employeeEntityExpected, employeeEntityActual);
        assertEquals(1, employeeEntityActual.getEmployeeId());
        assertEquals(1.0, employeeEntityActual.getMhCost(), 0.1);
        assertNull(employeeEntityActual.getCreated());
        assertNull(employeeEntityActual.getUpdated());
        assertFalse(employeeEntityActual.isActive());
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenMappingNullInServiceToEntity() {

        // given
        employee = null;

        // when
        employeeMapper.mapServiceToEntity(employee);
    }
}
