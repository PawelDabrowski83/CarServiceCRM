package pl.coderslab.vehicle;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class VehicleEntityTest {

    @Test
    public void shouldGettersAndSettersWorkProperly() {

        // given
        VehicleEntity vehicleEntity = new VehicleEntity();

        // when
        vehicleEntity.setVehicleId(1);
        vehicleEntity.setCarId(1);
        vehicleEntity.setOwnerId(1);
        vehicleEntity.setRegistryPlate("registryPlate");
        vehicleEntity.setColor("color");
        vehicleEntity.setNotes("notes");
        vehicleEntity.setNextInspection(LocalDate.of(1999, 1, 1));
        vehicleEntity.setCreated(LocalDateTime.of(2020, 12, 31, 15, 35));
        vehicleEntity.setUpdated(LocalDateTime.of(2020, 12, 31, 15, 35));
        vehicleEntity.setActive(true);

        // then
        assertEquals(1, vehicleEntity.getVehicleId());
        assertEquals(1, vehicleEntity.getCarId());
        assertEquals(1, vehicleEntity.getOwnerId());
        assertEquals("registryPlate", vehicleEntity.getRegistryPlate());
        assertEquals("color", vehicleEntity.getColor());
        assertEquals("notes", vehicleEntity.getNotes());
        assertEquals(LocalDate.of(1999, 1, 1), vehicleEntity.getNextInspection());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), vehicleEntity.getCreated());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), vehicleEntity.getUpdated());
        assertTrue(vehicleEntity.isActive());
    }

    @Test
    public void shouldEqualsAndHashCodeWorkProperly() {

        // given
        VehicleEntity vehicleEntity1 = new VehicleEntity(
                1,
                1,
                1,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        VehicleEntity vehicleEntity2 = new VehicleEntity(
                2,
                1,
                1,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        VehicleEntity vehicleEntity3 = new VehicleEntity(
                3,
                2,
                2,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        VehicleEntity vehicleEntity4 = new VehicleEntity(
                4,
                2,
                2,
                "registryPlate",
                LocalDate.of(2000, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // then
        assertEquals(vehicleEntity1, vehicleEntity2);
        assertNotEquals(vehicleEntity1, vehicleEntity3);
        assertNotEquals(vehicleEntity1, vehicleEntity4);
        assertNotEquals(vehicleEntity2, vehicleEntity3);
        assertNotEquals(vehicleEntity2, vehicleEntity4);
        assertNotEquals(vehicleEntity3, vehicleEntity4);
        assertEquals(vehicleEntity1.hashCode(), vehicleEntity2.hashCode());
        assertNotEquals(vehicleEntity1.hashCode(), vehicleEntity3.hashCode());
        assertNotEquals(vehicleEntity1.hashCode(), vehicleEntity4.hashCode());
        assertNotEquals(vehicleEntity2.hashCode(), vehicleEntity3.hashCode());
        assertNotEquals(vehicleEntity2.hashCode(), vehicleEntity4.hashCode());
        assertNotEquals(vehicleEntity3.hashCode(), vehicleEntity4.hashCode());
    }

    @Test
    public void shouldToStringWorkProperly() {

        // given
        VehicleEntity vehicleEntity = new VehicleEntity(
                1,
                1,
                1,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        String actualToString = vehicleEntity.toString();

        // then
        assertEquals("VehicleEntity{vehicleId=1, carId=1, ownerId=1, " +
                "registryPlate='registryPlate', nextInspection=1999-01-01, color='color'," +
                " notes='notes', created=2020-12-31T15:35, updated=2020-12-31T15:35," +
                " active=true}", actualToString);
    }

}
