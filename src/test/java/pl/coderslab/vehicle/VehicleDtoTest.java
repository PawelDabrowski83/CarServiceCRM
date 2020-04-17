package pl.coderslab.vehicle;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class VehicleDtoTest {

    @Test
    public void shouldGettersAndSettersWorkProperly() {

        // given
        VehicleDto vehicleDto = new VehicleDto();

        // when
        vehicleDto.setVehicleId(1);
        vehicleDto.setCarId(1);
        vehicleDto.setCarSignature("(1999) mark model");
        vehicleDto.setOwnerId(1);
        vehicleDto.setOwnerFullname("lastName firstName");
        vehicleDto.setRegistryPlate("registryPlate");
        vehicleDto.setNextInspection(LocalDate.of(1999, 1, 1));
        vehicleDto.setColor("color");
        vehicleDto.setNotes("notes");

        // then
        assertEquals(1, vehicleDto.getVehicleId());
        assertEquals(1, vehicleDto.getCarId());
        assertEquals("(1999) mark model", vehicleDto.getCarSignature());
        assertEquals(1, vehicleDto.getOwnerId());
        assertEquals("lastName firstName", vehicleDto.getOwnerFullname());
        assertEquals("registryPlate", vehicleDto.getRegistryPlate());
        assertEquals(LocalDate.of(1999, 1, 1), vehicleDto.getNextInspection());
        assertEquals("color", vehicleDto.getColor());
        assertEquals("notes", vehicleDto.getNotes());
    }

    @Test
    public void shouldEqualsAndHashCodeWorkProperly() {

        // given
        VehicleDto vehicleDto1 = new VehicleDto(
                1,
                1,
                1,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model"
        );
        VehicleDto vehicleDto2 = new VehicleDto(
                1,
                2,
                1,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) another mark model"
        );
        VehicleDto vehicleDto3 = new VehicleDto(
                1,
                1,
                1,
                "another registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model"
        );
        VehicleDto vehicleDto4 = new VehicleDto(
                1,
                2,
                1,
                "registryPlate",
                LocalDate.of(2000, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) another mark model"
        );

        // then
        assertNotEquals(vehicleDto1, vehicleDto2);
        assertNotEquals(vehicleDto1, vehicleDto3);
        assertNotEquals(vehicleDto1, vehicleDto4);
        assertNotEquals(vehicleDto2, vehicleDto3);
        assertEquals(vehicleDto2, vehicleDto4);
        assertNotEquals(vehicleDto3, vehicleDto4);
        assertNotEquals(vehicleDto1.hashCode(), vehicleDto2.hashCode());
        assertNotEquals(vehicleDto1.hashCode(), vehicleDto3.hashCode());
        assertNotEquals(vehicleDto1.hashCode(), vehicleDto4.hashCode());
        assertNotEquals(vehicleDto2.hashCode(), vehicleDto3.hashCode());
        assertEquals(vehicleDto2.hashCode(), vehicleDto4.hashCode());
        assertNotEquals(vehicleDto3.hashCode(), vehicleDto4.hashCode());
    }

    @Test
    public void shouldCompareToWorkProperly() {

        // given
        VehicleDto vehicleDto1 = new VehicleDto(
                1,
                1,
                1,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model"
        );
        VehicleDto vehicleDto2 = new VehicleDto(
                1,
                2,
                1,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) another mark model"
        );
        VehicleDto vehicleDto3 = new VehicleDto(
                1,
                1,
                1,
                "another registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model"
        );
        VehicleDto vehicleDto4 = new VehicleDto(
                1,
                2,
                1,
                "registryPlate",
                LocalDate.of(2000, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) another mark model"
        );

        // then
        assertEquals(12, vehicleDto1.compareTo(vehicleDto2));
        assertEquals(17, vehicleDto1.compareTo(vehicleDto3));
        assertEquals(12, vehicleDto1.compareTo(vehicleDto4));
        assertEquals(-12, vehicleDto2.compareTo(vehicleDto3));
        assertEquals(0, vehicleDto2.compareTo(vehicleDto4));
        assertEquals(12, vehicleDto3.compareTo(vehicleDto4));
    }

    @Test
    public void shouldToStringWorkProperly() {

        // given
        VehicleDto vehicleDto = new VehicleDto(
                1,
                1,
                1,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model"
        );

        // when
        String actualToString = vehicleDto.toString();

        // then
        assertEquals("VehicleDto{vehicleId=1, carId=1, ownerId=1, registryPlate='registryPlate', nextInspection=1999-01-01," +
                " color='color', notes='notes', ownerFullname='lastName firstName', carSignature='(1999) mark model'}",
                actualToString);
    }
}
