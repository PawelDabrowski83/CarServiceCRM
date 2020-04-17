package pl.coderslab.vehicle;

import org.junit.Test;
import pl.coderslab.commons.MapperInterface;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class VehicleMapperTest {

    private static final VehicleTest VEHICLE_TEST = new VehicleTest();
    private static final MapperInterface<VehicleDto, Vehicle, VehicleEntity> VEHICLE_MAPPER = new VehicleMapper();

    @Test
    public void shouldMapServiceToDtoWorkProperly() {

        // given
        Vehicle vehicle = new Vehicle(
                1,
                VEHICLE_TEST.initializeCar(),
                VEHICLE_TEST.initializeCustomer(),
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        VehicleDto vehicleDtoExpected = new VehicleDto(
                1,
                1,
                1,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model registryPlate"
        );

        // when
        VehicleDto vehicleDtoActual = VEHICLE_MAPPER.mapServiceToDto(vehicle);

        // then
        assertEquals(vehicleDtoExpected, vehicleDtoActual);
        assertEquals(vehicleDtoExpected.getVehicleId(), vehicleDtoActual.getVehicleId());
        assertEquals(vehicleDtoExpected.getCarId(), vehicleDtoActual.getCarId());
        assertEquals(vehicleDtoExpected.getOwnerId(), vehicleDtoActual.getOwnerId());
        assertEquals(vehicleDtoExpected.getOwnerFullname(), vehicleDtoActual.getOwnerFullname());
        assertEquals(vehicleDtoExpected.getNextInspection(), vehicleDtoActual.getNextInspection());
        assertEquals(vehicleDtoExpected.getNotes(), vehicleDtoActual.getNotes());
        assertEquals(vehicleDtoExpected.getColor(), vehicleDtoActual.getColor());
    }

    @Test
    public void shouldMapDtoToServiceWorkProperly() {

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
                "(1999) mark model registryPlate"
        );
        Vehicle vehicleExpected = new Vehicle(
                1,
                VEHICLE_TEST.initializeCar(),
                VEHICLE_TEST.initializeCustomer(),
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                null,
                null,
                false
        );

        // when
        Vehicle vehicleActual = VEHICLE_MAPPER.mapDtoToService(vehicleDto);

        // then
        assertEquals(vehicleExpected, vehicleActual);
        assertEquals(vehicleExpected.getVehicleId(), vehicleActual.getVehicleId());
        assertEquals(vehicleExpected.getNotes(), vehicleActual.getNotes());
        assertNull(vehicleActual.getCreated());
        assertNull(vehicleActual.getUpdated());
        assertFalse(vehicleActual.isActive());
    }

    @Test
    public void shouldMapServiceToEntityWorkProperly() {

        // given
        Vehicle vehicle = new Vehicle(
                1,
                VEHICLE_TEST.initializeCar(),
                VEHICLE_TEST.initializeCustomer(),
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        VehicleEntity vehicleEntityExpected = new VehicleEntity(
                1,
                1,
                1,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                null,
                null,
                false
        );

        // when
        VehicleEntity vehicleEntityActual = VEHICLE_MAPPER.mapServiceToEntity(vehicle);

        // then
        assertEquals(vehicleEntityExpected, vehicleEntityActual);
        assertEquals(vehicleEntityExpected.getNotes(), vehicleEntityActual.getNotes());
        assertNull(vehicleEntityActual.getCreated());
        assertNull(vehicleEntityActual.getUpdated());
        assertFalse(vehicleEntityActual.isActive());
    }

    @Test
    public void shouldMapEntityToServiceWorkProperly() {

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
        Vehicle vehicleExpected = new Vehicle(
                1,
                VEHICLE_TEST.initializeCar(),
                VEHICLE_TEST.initializeCustomer(),
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        Vehicle vehicleActual = VEHICLE_MAPPER.mapEntityToService(vehicleEntity);

        // then
        assertEquals(vehicleExpected, vehicleActual);
        assertEquals(vehicleExpected.getVehicleId(), vehicleActual.getVehicleId());
        assertEquals(vehicleExpected.getNotes(), vehicleActual.getNotes());
        assertEquals(vehicleExpected.getCreated(), vehicleActual.getCreated());
        assertEquals(vehicleExpected.getUpdated(), vehicleActual.getUpdated());
        assertTrue(vehicleActual.isActive());
        assertNull(vehicleActual.getCarSignature());
    }
}
