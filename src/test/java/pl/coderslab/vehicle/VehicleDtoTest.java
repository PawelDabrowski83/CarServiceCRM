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
        vehicleDto.setNextInspection(LocalDate.of(1999, 1, 1));
        vehicleDto.setColor("color");
        vehicleDto.setNotes("notes");

        // then
        assertEquals(1, vehicleDto.getVehicleId());
        assertEquals(1, vehicleDto.getCarId());
        assertEquals("(1999) mark model", vehicleDto.getCarSignature());
        assertEquals(1, vehicleDto.getOwnerId());
        assertEquals("lastName firstName", vehicleDto.getOwnerFullname());
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
                "(1999) mark model"
        );
        VehicleDto vehicleDto3 = new VehicleDto(
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
        VehicleDto vehicleDto4 = new VehicleDto(
                1,
                2,
                1,
                "registryPlate",
                LocalDate.of(2000, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model"
        );
    }
}
