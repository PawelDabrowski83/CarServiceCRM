package pl.coderslab.labor;

import org.junit.Test;
import java.time.LocalDate;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;

public class LaborDtoTest {

    @Test
    public void shouldGettersAndSettersWork() {

        // given
        LaborDto laborDto = new LaborDto();

        // when
        laborDto.setLaborId(1);
        laborDto.setRegistrationDate(LocalDate.of(1999, 1, 1));
        laborDto.setScheduledDate(LocalDate.of(1999, 1, 2));
        laborDto.setStartedDate(LocalDate.of(1999, 1, 3));
        laborDto.setFinishedDate(LocalDate.of(1999, 1, 4));
        laborDto.setEmployeeId(1);
        laborDto.setEmployeeFullname("lastName firstName");
        laborDto.setDescriptionIssue("issue");
        laborDto.setDescriptionService("service");
        laborDto.setStatus("BACKLOG");
        laborDto.setVehicleId(1);
        laborDto.setVehicleSignature("(1999) mark model registryPlate");
        laborDto.setCustomerCost(1.0);
        laborDto.setMaterialCost(1.0);
        laborDto.setMhTotal(100);
        laborDto.setCustomerFullname("customerFullname");

        // then
        assertEquals(1, laborDto.getLaborId());
        assertEquals(LocalDate.of(1999, 1, 1), laborDto.getRegistrationDate());
        assertEquals(LocalDate.of(1999, 1, 2), laborDto.getScheduledDate());
        assertEquals(LocalDate.of(1999, 1, 3), laborDto.getStartedDate());
        assertEquals(LocalDate.of(1999, 1, 4), laborDto.getFinishedDate());
        assertEquals(1, laborDto.getEmployeeId());
        assertEquals("lastName firstName", laborDto.getEmployeeFullname());
        assertEquals("issue", laborDto.getDescriptionIssue());
        assertEquals("service", laborDto.getDescriptionService());
        assertEquals("BACKLOG", laborDto.getStatus());
        assertEquals(1, laborDto.getVehicleId());
        assertEquals("(1999) mark model registryPlate", laborDto.getVehicleSignature());
        assertEquals(1.0, laborDto.getCustomerCost(), 0.1);
        assertEquals(1.0, laborDto.getMaterialCost(), 0.1);
        assertEquals(100, laborDto.getMhTotal());
        assertEquals("customerFullname", laborDto.getCustomerFullname());
    }

    @Test
    public void shouldEqualsAndHashCodeWork() {

        // given
        LaborDto laborDto1 = new LaborDto(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                1,
                "lastName firstName",
                "issue",
                "service",
                "BACKLOG",
                1,
                "(1999) mark model registryPlate",
                1.0,
                1.0,
                100,
                "customerFullName"
        );
        LaborDto laborDto2 = new LaborDto(
                2,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                1,
                "lastName firstName",
                "issue",
                "service",
                "BACKLOG",
                1,
                "(1999) mark model registryPlate",
                1.0,
                1.0,
                100,
                "customerFullName"
        );
        LaborDto laborDto3 = new LaborDto(
                3,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 5),
                LocalDate.of(1999, 1, 5),
                LocalDate.of(1999, 1, 6),
                1,
                "lastName firstName",
                "issue",
                "service",
                "BACKLOG",
                1,
                "(1999) mark model registryPlate",
                1.0,
                1.0,
                100,
                "customerFullName"
        );
        LaborDto laborDto4 = new LaborDto(
                4,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                1,
                "lastName firstName",
                "issue",
                "service",
                "BACKLOG",
                1,
                "(2000) mark model registryPlate",
                1.0,
                1.0,
                100,
                "customerFullName"
        );

        // then
        assertEquals(laborDto1, laborDto2);
        assertNotEquals(laborDto1, laborDto3);
        assertNotEquals(laborDto1, laborDto4);
        assertNotEquals(laborDto2, laborDto3);
        assertNotEquals(laborDto2, laborDto4);
        assertNotEquals(laborDto3, laborDto4);
        assertEquals(laborDto1.hashCode(), laborDto2.hashCode());
        assertNotEquals(laborDto1.hashCode(), laborDto3.hashCode());
        assertNotEquals(laborDto1.hashCode(), laborDto4.hashCode());
        assertNotEquals(laborDto2.hashCode(), laborDto3.hashCode());
        assertNotEquals(laborDto2.hashCode(), laborDto4.hashCode());
        assertNotEquals(laborDto3.hashCode(), laborDto4.hashCode());
    }

    @Test
    public void shouldCompareToWork() {

        LaborDto laborDto1 = new LaborDto(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                1,
                "lastName firstName",
                "issue",
                "service",
                "BACKLOG",
                1,
                "(1999) mark model registryPlate",
                1.0,
                1.0,
                100,
                "customerFullName"
        );
        LaborDto laborDto2 = new LaborDto(
                2,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                1,
                "lastName firstName",
                "issue",
                "service",
                "BACKLOG",
                1,
                "(1999) mark model registryPlate",
                1.0,
                1.0,
                100,
                "customerFullName"
        );
        LaborDto laborDto3 = new LaborDto(
                3,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 5),
                LocalDate.of(1999, 1, 5),
                LocalDate.of(1999, 1, 6),
                1,
                "lastName firstName",
                "issue",
                "service",
                "BACKLOG",
                1,
                "(1999) mark model registryPlate",
                1.0,
                1.0,
                100,
                "customerFullName"
        );
        LaborDto laborDto4 = new LaborDto(
                4,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                1,
                "lastName firstName",
                "issue",
                "service",
                "BACKLOG",
                1,
                "(2000) mark model registryPlate",
                1.0,
                1.0,
                100,
                "customerFullName"
        );

        // then
        assertEquals(0, laborDto1.compareTo(laborDto2));
        assertEquals(-3, laborDto1.compareTo(laborDto3));
        assertEquals(-1, laborDto1.compareTo(laborDto4));
        assertEquals(-3, laborDto2.compareTo(laborDto3));
        assertEquals(-1, laborDto2.compareTo(laborDto4));
        assertEquals(3, laborDto3.compareTo(laborDto4));
    }

    @Test
    public void shouldToStringWork() {

        // given
        LaborDto laborDto = new LaborDto(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                1,
                "lastName firstName",
                "issue",
                "service",
                "BACKLOG",
                1,
                "(1999) mark model registryPlate",
                1.0,
                1.0,
                100,
                "customerFullname"
        );

        // when
        String actualToString = laborDto.toString();

        // then
        assertEquals("LaborDto{laborId=1, registrationDate=1999-01-01, scheduledDate=1999-01-02, startedDate=1999-01-03," +
                " finishedDate=1999-01-04, employeeId=1, employeeFullname='lastName firstName', descriptionIssue='issue'," +
                " descriptionService='service', status='BACKLOG', vehicleId=1," +
                " vehicleSignature='(1999) mark model registryPlate', customerCost=1.0, materialCost=1.0," +
                " mhTotal=100, customerFullname='customerFullname'}", actualToString);
        assertNotEquals("", actualToString);
    }
}
