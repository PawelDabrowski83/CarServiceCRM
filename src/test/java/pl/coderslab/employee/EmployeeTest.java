package pl.coderslab.employee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.person.Person;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeTest {

    Person person = mock(Person.class);
    Person anotherPerson = mock(Person.class);

    @Test
    public void shouldGettersAndSettersWork() {

        // given
        Employee employee = new Employee();

        // when
        employee.setEmployeeId(1);
        employee.setPerson(person);
        employee.setMhCost(1.0);
        employee.setCreated(LocalDateTime.of(2020, 12, 31, 15, 35));
        employee.setUpdated(LocalDateTime.of(2020, 12, 31, 15, 35));
        employee.setActive(true);

        // then
        assertEquals(1, employee.getEmployeeId());
        assertEquals(person, employee.getPerson());
        assertEquals(1.0, employee.getMhCost(), 0.1);
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), employee.getCreated());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), employee.getUpdated());
        assertTrue(employee.isActive());
    }

    @Test
    public void shouldEqualsAndHashCodeWork() {

        // given
        Employee employee1 = new Employee(
                1,
                person,
                1.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Employee employee2 = new Employee(
                2,
                person,
                1.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Employee employee3 = new Employee(
                3,
                anotherPerson,
                21.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Employee employee4 = new Employee(
                4,
                anotherPerson,
                31.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // then
        assertEquals(employee1, employee2);
        assertNotEquals(employee1, employee3);
        assertNotEquals(employee1, employee4);
        assertNotEquals(employee2, employee3);
        assertNotEquals(employee2, employee4);
        assertEquals(employee3, employee4);
        assertEquals(employee1.hashCode(), employee2.hashCode());
        assertNotEquals(employee1.hashCode(), employee3.hashCode());
        assertNotEquals(employee1.hashCode(), employee4.hashCode());
        assertNotEquals(employee2.hashCode(), employee3.hashCode());
        assertNotEquals(employee2.hashCode(), employee4.hashCode());
        assertEquals(employee3.hashCode(), employee4.hashCode());
    }

    @Test
    public void shouldCompareToWork() {

        // given
        Employee employee1 = new Employee(
                1,
                person,
                1.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Employee employee2 = new Employee(
                2,
                person,
                1.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Employee employee3 = new Employee(
                3,
                anotherPerson,
                21.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Employee employee4 = new Employee(
                4,
                anotherPerson,
                31.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // then
        assertEquals(0, employee1.compareTo(employee2));
        assertNotEquals(16, employee1.compareTo(employee3));
        assertNotEquals(16, employee1.compareTo(employee4));
        assertNotEquals(16, employee2.compareTo(employee3));
        assertNotEquals(16, employee2.compareTo(employee4));
        assertEquals(0, employee3.compareTo(employee4));
    }

    @Test
    public void shouldToStringWork() {

        // given
        Employee employee = new Employee(
                1,
                person,
                1.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        when(employee.getPerson().toString()).thenReturn("MockPerson");

        // when
        String actualToString = employee.toString();

        // then
        assertEquals("Employee{employeeId=1, person=MockPerson, mhCost=1.0," +
                " created=2020-12-31T15:35, updated=2020-12-31T15:35," +
                " active=true}", actualToString);
    }
}
