package pl.coderslab.employee;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmployeeEntityTest {

    @Test
    public void shouldGettersAndSettersWork() {

        // given
        EmployeeEntity employeeEntity = new EmployeeEntity();

        // when
        employeeEntity.setEmployeeId(1);
        employeeEntity.setPersonId(1);
        employeeEntity.setMhCost(1);
        employeeEntity.setCreated(LocalDateTime.of(2020, 12, 31, 15, 35));
        employeeEntity.setUpdated(LocalDateTime.of(2020, 12, 31, 15, 35));
        employeeEntity.setActive(true);

        // then
        assertEquals(1, employeeEntity.getEmployeeId());
        assertEquals(1, employeeEntity.getPersonId());
        assertEquals(1.0, employeeEntity.getMhCost(), 0.1);
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), employeeEntity.getCreated());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), employeeEntity.getUpdated());
        assertTrue(employeeEntity.isActive());
    }

    @Test
    public void shouldEqualsAndHashCodeWork() {

        // given
        EmployeeEntity employeeEntity1 = new EmployeeEntity(
                1,
                1,
                1.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        EmployeeEntity employeeEntity2 = new EmployeeEntity(
                2,
                1,
                14.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        EmployeeEntity employeeEntity3 = new EmployeeEntity(
                3,
                3,
                19.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        EmployeeEntity employeeEntity4 = new EmployeeEntity(
                4,
                3,
                21.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // then
        assertEquals(employeeEntity1, employeeEntity2);
        assertNotEquals(employeeEntity1, employeeEntity3);
        assertNotEquals(employeeEntity1, employeeEntity4);
        assertNotEquals(employeeEntity2, employeeEntity3);
        assertNotEquals(employeeEntity2, employeeEntity4);
        assertEquals(employeeEntity3, employeeEntity4);
        assertEquals(employeeEntity1.hashCode(), employeeEntity2.hashCode());
        assertNotEquals(employeeEntity1.hashCode(), employeeEntity3.hashCode());
        assertNotEquals(employeeEntity1.hashCode(), employeeEntity4.hashCode());
        assertNotEquals(employeeEntity2.hashCode(), employeeEntity3.hashCode());
        assertNotEquals(employeeEntity2.hashCode(), employeeEntity4.hashCode());
        assertEquals(employeeEntity3.hashCode(), employeeEntity4.hashCode());
    }

    @Test
    public void shouldToStringWork() {

        // given
        EmployeeEntity employeeEntity = new EmployeeEntity(
                1,
                1,
                1.0,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        String actualToString = employeeEntity.toString();

        // then
        assertEquals("EmployeeEntity{employeeId=1, personId=1, mhCost=1.0," +
                " created=2020-12-31T15:35, updated=2020-12-31T15:35, active=true}",
                actualToString);
    }
}
