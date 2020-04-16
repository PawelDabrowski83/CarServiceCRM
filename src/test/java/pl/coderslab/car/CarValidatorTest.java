package pl.coderslab.car;
import org.junit.Test;
import pl.coderslab.commons.ValidatorInterface;

import static org.junit.Assert.*;

public class CarValidatorTest {

    private static final ValidatorInterface<CarDto> CAR_VALIDATOR = new CarValidator();

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerIfCarDtoIsNull() {

        // given
        CarDto carDto = null;

        // when
        String validateResult = CAR_VALIDATOR.validate(carDto);

        // then
        // NullPointerException

    }

    @Test
    public void shouldGetMessageIfCarDtoMarkIsNull() {

        // given
        CarDto carDto = new CarDto();
        carDto.setModel("model");
        carDto.setProductionYear(1990);

        // when
        String validateResult = CAR_VALIDATOR.validate(carDto);

        // then
        assertEquals(CarValidator.INVALID_MARK, validateResult);
    }

    @Test
    public void shouldGetMessageIfCarDtoMarkIsEmpty() {

        // given
        CarDto carDto = new CarDto();
        carDto.setMark("");
        carDto.setModel("model");
        carDto.setProductionYear(1999);

        // when
        String validateResult = CAR_VALIDATOR.validate(carDto);

        // then
        assertEquals(CarValidator.INVALID_MARK, validateResult);
    }

    @Test
    public void shouldGetMessageIfCarDtoIsButSpaces() {

        // given
        CarDto carDto = new CarDto();
        carDto.setMark("   ");
        carDto.setModel("model");
        carDto.setProductionYear(1999);

        // when
        String validateResult = CAR_VALIDATOR.validate(carDto);

        // then
        assertEquals(CarValidator.INVALID_MARK, validateResult);
    }

    @Test
    public void shouldGetMessageIfCarDtoModelIsNull() {

        // given
        CarDto carDto = new CarDto();
        carDto.setMark("mark");
        carDto.setModel(null);
        carDto.setProductionYear(1999);

        // when
        String validateResult = CAR_VALIDATOR.validate(carDto);

        // then
        assertEquals(CarValidator.INVALID_MODEL, validateResult);
    }

    @Test
    public void shouldGetMessageIfCarDtoModelIsEmpty() {
        // given
        CarDto carDto = new CarDto();
        carDto.setMark("mark");
        carDto.setModel("");
        carDto.setProductionYear(1999);

        // when
        String validateResult = CAR_VALIDATOR.validate(carDto);

        // then
        assertEquals(CarValidator.INVALID_MODEL, validateResult);
    }


    @Test
    public void shouldGetMessageIfCarDtoModelIsButSpaces() {
        // given
        CarDto carDto = new CarDto();
        carDto.setMark("mark");
        carDto.setModel("   ");
        carDto.setProductionYear(1999);

        // when
        String validateResult = CAR_VALIDATOR.validate(carDto);

        // then
        assertEquals(CarValidator.INVALID_MODEL, validateResult);
    }

    @Test
    public void shouldGetMessageIfCarDtoProductionYearIsZero() {

        // given
        CarDto carDto = new CarDto();
        carDto.setMark("mark");
        carDto.setModel("model");
        carDto.setProductionYear(0);

        // when
        String validateResult = CAR_VALIDATOR.validate(carDto);

        // then
        assertEquals(CarValidator.INVALID_PRODYEAR, validateResult);
    }

    @Test
    public void shouldGetMessageIfCarDtoProductionYearIs444() {

        // given
        CarDto carDto = new CarDto();
        carDto.setMark("mark");
        carDto.setModel("model");
        carDto.setProductionYear(444);

        // when
        String validateResult = CAR_VALIDATOR.validate(carDto);

        // then
        assertEquals(CarValidator.INVALID_PRODYEAR, validateResult);
    }

    @Test
    public void shouldGetMessageIfCarDtoProductionYearIsIntegerMax() {

        // given
        CarDto carDto = new CarDto();
        carDto.setMark("mark");
        carDto.setModel("model");
        carDto.setProductionYear(Integer.MAX_VALUE);

        // when
        String validateResult = CAR_VALIDATOR.validate(carDto);

        // then
        assertEquals(CarValidator.INVALID_PRODYEAR, validateResult);
    }
}
