package pl.coderslab.labor;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class LaborEntityTest {

    @Test
    public void shouldGettersAndSettersWork() {

        // given
        LaborEntity laborEntity = new LaborEntity();

        // when
        laborEntity.setLaborId(1);
        laborEntity.setRegistrationDate(LocalDate.of(2020, 12, 31));
        laborEntity.setScheduledDate(LocalDate.of(2020, 12, 31));
        laborEntity.setStartedDate(LocalDate.of(2020, 12, 31));
        laborEntity.setFinishedDate(LocalDate.of(2020, 12, 31));
        laborEntity.setEmployeeId(1);
        laborEntity.setDescriptionIssue("issue");
        laborEntity.setDescriptionService("service");
        laborEntity.setStatus(LaborEntity.StatusEnum.BACKLOG);
        laborEntity.setVehicleId(1);
        laborEntity.setCustomerCost(1.0);
        laborEntity.setMaterialCost(11.0);
        laborEntity.setMhTotal(100);
        laborEntity.setCreated(LocalDateTime.of(2020, 12, 31, 15, 35));
        laborEntity.setUpdated(LocalDateTime.of(2020, 12, 31, 15, 35));
        laborEntity.setActive(true);

        // then
        assertEquals(1, laborEntity.getLaborId());
        assertEquals(LocalDate.of(2020, 12, 31), laborEntity.getRegistrationDate());
        assertEquals(LocalDate.of(2020, 12, 31), laborEntity.getScheduledDate());
        assertEquals(LocalDate.of(2020, 12, 31), laborEntity.getStartedDate());
        assertEquals(LocalDate.of(2020, 12, 31), laborEntity.getFinishedDate());
        assertEquals(1, laborEntity.getEmployeeId());
        assertEquals("issue", laborEntity.getDescriptionIssue());
        assertEquals("service", laborEntity.getDescriptionService());
        assertEquals(LaborEntity.StatusEnum.BACKLOG.toString(), laborEntity.getStatus());
        assertEquals(1, laborEntity.getVehicleId());
        assertEquals(1.0, laborEntity.getCustomerCost(), 0.1);
        assertEquals(11.0, laborEntity.getMaterialCost(), 0.1);
        assertEquals(100, laborEntity.getMhTotal());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), laborEntity.getCreated());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), laborEntity.getUpdated());
        assertTrue(laborEntity.isActive());
    }

    @Test
    public void shouldEqualsAndHashCodeWork(){

        // given
        LaborEntity laborEntity1 = new LaborEntity(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                1,
                "issue",
                "service",
                LaborEntity.StatusEnum.BACKLOG,
                1,
                5.0,
                5.0,
                50,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        LaborEntity laborEntity2 = new LaborEntity(
                2,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                2,
                "issue",
                "service",
                LaborEntity.StatusEnum.BACKLOG,
                1,
                5.0,
                5.0,
                50,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        LaborEntity laborEntity3 = new LaborEntity(
                3,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                2,
                "issue",
                "service",
                LaborEntity.StatusEnum.BACKLOG,
                1,
                5.0,
                5.0,
                50,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        LaborEntity laborEntity4 = new LaborEntity(
                4,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                1,
                "issue",
                "service",
                LaborEntity.StatusEnum.BACKLOG,
                1,
                15.0,
                5.0,
                50,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // then
        assertNotEquals(laborEntity1, laborEntity2);
        assertNotEquals(laborEntity1, laborEntity3);
        assertNotEquals(laborEntity1, laborEntity4);
        assertEquals(laborEntity2, laborEntity3);
        assertNotEquals(laborEntity2, laborEntity4);
        assertNotEquals(laborEntity3, laborEntity4);
        assertNotEquals(laborEntity1.hashCode(), laborEntity2.hashCode());
        assertNotEquals(laborEntity1.hashCode(), laborEntity3.hashCode());
        assertNotEquals(laborEntity1.hashCode(), laborEntity4.hashCode());
        assertEquals(laborEntity2.hashCode(), laborEntity3.hashCode());
        assertNotEquals(laborEntity2.hashCode(), laborEntity4.hashCode());
        assertNotEquals(laborEntity3.hashCode(), laborEntity4.hashCode());
    }

    @Test
    public void shouldToStringWork() {

        // given
        LaborEntity laborEntity = new LaborEntity(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                1,
                "issue",
                "service",
                LaborEntity.StatusEnum.BACKLOG,
                1,
                5.0,
                5.0,
                50,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        String actualToString = laborEntity.toString();

        // then
        assertEquals("LaborEntity{laborId=1, registrationDate=1999-01-01, scheduledDate=1999-01-02, startedDate=1999-01-03," +
                " finishedDate=1999-01-04, employeeId=1, descriptionIssue='issue', descriptionService='service', status=BACKLOG," +
                " vehicleId=1, customerCost=5.0, materialCost=5.0, mhTotal=50, created=2020-12-31T15:35, updated=2020-12-31T15:35," +
                " active=true}", actualToString);
        assertNotEquals("", actualToString);
    }
}
