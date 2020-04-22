package pl.coderslab.employee;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EmployeeDtoTest {

    @Test
    public void shouldGettersAndSettersWork() {

        // given
        EmployeeDto employeeDto = new EmployeeDto();

        // when
        employeeDto.setEmployeeId(1);
        employeeDto.setPersonId(1);
        employeeDto.setMhCost(1);
        employeeDto.setFullname("lastName firstName");

        // then
        assertEquals(1, employeeDto.getEmployeeId());
        assertEquals(1, employeeDto.getPersonId());
        assertEquals(1, employeeDto.getMhCost(), 0.1);
        assertEquals("lastName firstName", employeeDto.getFullname());
    }

    @Test
    public void shouldEqualsAndHashCodeWork() {

        // given
        EmployeeDto employeeDto1 = new EmployeeDto(
                1,
                1,
                10,
                "lastName firstName"
        );
        EmployeeDto employeeDto2 = new EmployeeDto(
                2,
                1,
                10,
                "lastName firstName"
        );
        EmployeeDto employeeDto3 = new EmployeeDto(
                3,
                1,
                10,
                "another lastName firstName"
        );
        EmployeeDto employeeDto4 = new EmployeeDto(
                1,
                1,
                10,
                "another lastName firstName"
        );

        // then
        assertEquals(employeeDto1, employeeDto2);
        assertNotEquals(employeeDto1, employeeDto3);
        assertNotEquals(employeeDto1, employeeDto4);
        assertNotEquals(employeeDto2, employeeDto3);
        assertNotEquals(employeeDto2, employeeDto4);
        assertEquals(employeeDto3, employeeDto4);
        assertEquals(employeeDto1.hashCode(), employeeDto2.hashCode());
        assertNotEquals(employeeDto1.hashCode(), employeeDto3.hashCode());
        assertNotEquals(employeeDto1.hashCode(), employeeDto4.hashCode());
        assertNotEquals(employeeDto2.hashCode(), employeeDto3.hashCode());
        assertNotEquals(employeeDto2.hashCode(), employeeDto4.hashCode());
        assertEquals(employeeDto3.hashCode(), employeeDto4.hashCode());
    }

    @Test
    public void shouldCompareToWork() {

        // given
        EmployeeDto employeeDto1 = new EmployeeDto(
                1,
                1,
                10,
                "lastName firstName"
        );
        EmployeeDto employeeDto2 = new EmployeeDto(
                2,
                1,
                10,
                "lastName firstName"
        );
        EmployeeDto employeeDto3 = new EmployeeDto(
                3,
                1,
                10,
                "another lastName firstName"
        );
        EmployeeDto employeeDto4 = new EmployeeDto(
                1,
                2,
                15,
                "another lastName firstName"
        );

        assertEquals(0, employeeDto1.compareTo(employeeDto2));
        assertEquals(11, employeeDto1.compareTo(employeeDto3));
        assertEquals(11, employeeDto1.compareTo(employeeDto4));
        assertEquals(11, employeeDto2.compareTo(employeeDto3));
        assertEquals(11, employeeDto2.compareTo(employeeDto4));
        assertEquals(0, employeeDto3.compareTo(employeeDto4));
    }

    @Test
    public void shouldToStringWork() {

        // given
        EmployeeDto employeeDto = new EmployeeDto(
                1,
                1,
                10,
                "lastName firstName"
        );

        // when
        String actualToString = employeeDto.toString();

        // then
        assertEquals("EmployeeDto{employeeId=1, personId=1, mhCost=10.0," +
                " fullname='lastName firstName'}", actualToString);
    }
}
