package pl.coderslab.car;

import org.junit.Test;
import pl.coderslab.commons.MapperInterface;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static org.junit.Assert.*;

public class CarMapperTest {

    private static final MapperInterface<CarDto, Car, CarEntity> CAR_MAPPER = new CarMapper();

    @Test
    public void shouldMapEntityToServiceWork() {

        // given
        CarEntity carEntity = new CarEntity(
                1,
                "mark",
                "model",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Car carExpected = new Car(
                1,
                "mark",
                "model",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        Car carActual = CAR_MAPPER.mapEntityToService(carEntity);

        // then
        assertEquals(carExpected, carActual);
        assertEquals(carExpected.getCarId(), carActual.getCarId());
        assertEquals(carExpected.getCarSignature(), carActual.getCarSignature());
        assertEquals(carExpected.getCreated(), carActual.getCreated());
        assertEquals(carExpected.getUpdated(), carActual.getUpdated());
        assertEquals(carExpected.isActive(), carActual.isActive());
    }

    @Test
    public void shouldServiceToEntityWork() {

        // given
        CarEntity carEntityExpected = new CarEntity(
                1,
                "mark",
                "model",
                LocalDate.of(1999, 1, 1),
                null,
                null,
                false
        );
        Car car = new Car(
                1,
                "mark",
                "model",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        CarEntity carEntityActual = CAR_MAPPER.mapServiceToEntity(car);

        // then
        assertEquals(carEntityExpected, carEntityActual);
        assertEquals(carEntityExpected.getCarId(), carEntityActual.getCarId());
        assertNull(carEntityActual.getCreated());
        assertNull(carEntityActual.getUpdated());
        assertFalse(carEntityActual.isActive());
    }

    @Test
    public void shouldDtoToServiceWork() {

        // given
        CarDto carDto = new CarDto(
                1,
                "mark",
                "model",
                1999,
                "(1999) mark model"
        );
        Car carExpected = new Car(
                1,
                "mark",
                "model",
                LocalDate.of(1999, 1, 1),
                null,
                null,
                false
        );

        // when
        Car carActual = CAR_MAPPER.mapDtoToService(carDto);

        // then
        assertEquals(carExpected, carActual);
        assertEquals(carExpected.getCarId(), carActual.getCarId());
        assertEquals(carExpected.getCarSignature(), carActual.getCarSignature());
        assertNull(carActual.getCreated());
        assertNull(carActual.getUpdated());
        assertFalse(carActual.isActive());

    }

    @Test
    public void shouldServiceToDtoWork() {

        // given
        Car car = new Car(
                1,
                "mark",
                "model",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        CarDto carDtoExpected = new CarDto(
                1,
                "mark",
                "model",
                1999,
                "(1999) mark model"
        );

        // when
        CarDto carDtoActual = CAR_MAPPER.mapServiceToDto(car);

        // then
        assertEquals(carDtoExpected, carDtoActual);
        assertEquals(carDtoExpected.getCarId(), carDtoActual.getCarId());
        assertEquals(carDtoExpected.getCarSignature(), carDtoActual.getCarSignature());
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionWhenCarProductionDateIsNullWithMapServiceToDto() {

        // given
        Car car = new Car(
                1,
                "mark",
                "model",
                null,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        CarDto carDtoActual = CAR_MAPPER.mapServiceToDto(car);

        // then
        // NullPointerException

    }

    @Test
    public void shouldWorkPerfectlyWhenCarDtoProductionYearIsNegativeWithMapDtoToService() {

        // given
        CarDto carDto = new CarDto(
                1,
                "mark",
                "model",
                -17,
                "(1999) mark model"
        );

        // when
        Car carActual = CAR_MAPPER.mapDtoToService(carDto);

        // then
        // DateTimeParseException
        assertEquals(LocalDate.of(-17, 1, 1), carActual.getProductionYear());
    }


}
