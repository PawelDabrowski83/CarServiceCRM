package pl.coderslab.vehicle;

import org.junit.Test;
import pl.coderslab.commons.ValidatorInterface;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class VehicleValidatorTest {

    private static final ValidatorInterface<VehicleDto> VEHICLE_VALIDATOR = new VehicleValidator();

    @Test (expected = NullPointerException.class)
    public void shouldGetNullPointerWhenDtoIsNull() {

        // given
        VehicleDto vehicleDto = null;

        // when
        String actual = VEHICLE_VALIDATOR.validate(vehicleDto);

        //then
        // NullPointer
    }

    @Test
    public void shouldGetEmptyWhenDtoVehicleIdIsZero() {

        // given
        VehicleDto vehicleDto = new VehicleDto(
                0,
                1,
                1,
                "registryPlate",
                LocalDate.of(2021, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model"
        );

        // when
        String actual = VEHICLE_VALIDATOR.validate(vehicleDto);

        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    public void shouldGetMessageWhenDtoCarIdIsZero() {

        // given
        VehicleDto vehicleDto = new VehicleDto(
                1,
                0,
                1,
                "registryPlate",
                LocalDate.of(2021, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model"
        );

        // when
        String actual = VEHICLE_VALIDATOR.validate(vehicleDto);

        // then
        assertEquals(VehicleValidator.INVALID_CAR_ID, actual);
    }

    @Test
    public void shouldGetMessageWhenDtoOwnerIdIsZero() {

        // given
        VehicleDto vehicleDto = new VehicleDto(
                1,
                1,
                0,
                "registryPlate",
                LocalDate.of(2021, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model"
        );

        // when
        String actual = VEHICLE_VALIDATOR.validate(vehicleDto);

        // then
        assertEquals(VehicleValidator.INVALID_OWNER_ID, actual);
    }

    @Test
    public void shouldGetMessageWhenDtoNextInspectionIsNull() {

        // given
        VehicleDto vehicleDto = new VehicleDto(
                1,
                1,
                1,
                "registryPlate",
                null,
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model"
        );

        // when
        String actual = VEHICLE_VALIDATOR.validate(vehicleDto);

        // then
        assertEquals(VehicleValidator.INVALID_NEXT_INSPECTION, actual);
    }

    @Test
    public void shouldGetMessageWhenDtoNextInspectionIsPast() {

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
        String actual = VEHICLE_VALIDATOR.validate(vehicleDto);

        // then
        assertEquals(VehicleValidator.INVALID_NEXT_INSPECTION, actual);
    }

    @Test
    public void shouldGetMessageWhenDtoRegistryPlateIsNull() {

        // given
        VehicleDto vehicleDto = new VehicleDto(
                1,
                1,
                1,
                null,
                LocalDate.of(2021, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model"
        );

        // when
        String actual = VEHICLE_VALIDATOR.validate(vehicleDto);

        // then
        assertEquals(VehicleValidator.INVALID_REGISTRY_PLATE, actual);
    }

    @Test
    public void shouldGetMessageWhenDtoRegistryPlateIsEmpty() {

        // given
        VehicleDto vehicleDto = new VehicleDto(
                1,
                1,
                1,
                "",
                LocalDate.of(2021, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model"
        );

        // when
        String actual = VEHICLE_VALIDATOR.validate(vehicleDto);

        // then
        assertEquals(VehicleValidator.INVALID_REGISTRY_PLATE, actual);
    }

    @Test
    public void shouldGetMessageWhenDtoRegistryPlateIsButSpaces() {

        // given
        VehicleDto vehicleDto = new VehicleDto(
                1,
                1,
                1,
                "      ",
                LocalDate.of(2021, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model"
        );

        // when
        String actual = VEHICLE_VALIDATOR.validate(vehicleDto);

        // then
        assertEquals(VehicleValidator.INVALID_REGISTRY_PLATE, actual);
    }

    @Test
    public void shouldGetMessageWhenDtoEssentialsAreWrong() {

        // given
        VehicleDto vehicleDto = new VehicleDto(
                1,
                0,
                0,
                null,
                null,
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model"
        );

        // when
        String actual = VEHICLE_VALIDATOR.validate(vehicleDto);

        // then
        assertEquals(VehicleValidator.INVALID_CAR_ID + VehicleValidator.INVALID_REGISTRY_PLATE +
                VehicleValidator.INVALID_OWNER_ID + VehicleValidator.INVALID_NEXT_INSPECTION, actual);
    }
}
