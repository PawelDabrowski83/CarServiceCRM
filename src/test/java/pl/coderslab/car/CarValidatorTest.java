package pl.coderslab.car;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
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
        assertEquals("Mark cannot be empty. <br/>" + System.lineSeparator(), validateResult);
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
        assertEquals("Mark cannot be empty. <br/>" + System.lineSeparator(), validateResult);
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
        assertEquals("Mark cannot be empty. <br/>" + System.lineSeparator(), validateResult);

    }



}
