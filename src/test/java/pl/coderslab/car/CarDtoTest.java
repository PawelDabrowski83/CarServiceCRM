package pl.coderslab.car;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarDtoTest {

    @Test
    public void shouldGettersAndSettersWorkProperly() {

        // given
        CarDto carDto = new CarDto();

        // when
        carDto.setCarId(1);
        carDto.setMark("mark");
        carDto.setModel("model");
        carDto.setProductionYear(1999);
        carDto.setCarSignature("(1999) mark model");

        // then
        assertEquals(1, carDto.getCarId());
        assertEquals("mark", carDto.getMark());
        assertEquals("model", carDto.getModel());
        assertEquals(1999, carDto.getProductionYear());
        assertEquals("(1999) mark model", carDto.getCarSignature());

    }

    @Test
    public void shouldEqualsAndHashCodeWorkProperly() {

        // given
        CarDto carDto1 = new CarDto(
          1,
          "mark",
          "model",
          1999,
          "(1999) mark model"
        );
        CarDto carDto2 = new CarDto(
                9999,
                "mark",
                "model",
                1999,
                "(1999) mark model"
        );
        CarDto carDto3 = new CarDto(
                1,
                "another mark",
                "model",
                1999,
                "(1999) another mark model"
        );
        CarDto carDto4 = new CarDto(
                1,
                "another mark",
                "model",
                1999,
                "(1999) another mark model"
        );

        // then
        assertEquals(carDto1, carDto2);
        assertEquals(carDto1.hashCode(), carDto2.hashCode());
        assertNotEquals(carDto1, carDto3);
        assertNotEquals(carDto1.hashCode(), carDto3.hashCode());
        assertNotEquals(carDto1, carDto4);
        assertNotEquals(carDto1.hashCode(), carDto4.hashCode());
        assertNotEquals(carDto2, carDto3);
        assertNotEquals(carDto2.hashCode(), carDto3.hashCode());
        assertNotEquals(carDto2, carDto4);
        assertNotEquals(carDto2.hashCode(), carDto4.hashCode());
        assertEquals(carDto3, carDto4);
        assertEquals(carDto3.hashCode(), carDto4.hashCode());
    }

    @Test
    public void shouldCompareToWorkProperly() {

        // given
        CarDto carDto1 = new CarDto(
                1,
                "mark",
                "model",
                1999,
                "(1999) mark model"
        );
        CarDto carDto2 = new CarDto(
                9999,
                "mark",
                "model",
                1999,
                "(1999) mark model"
        );
        CarDto carDto3 = new CarDto(
                1,
                "another mark",
                "model",
                1999,
                "(1999) another mark model"
        );
        CarDto carDto4 = new CarDto(
                1,
                "another mark",
                "model",
                1999,
                "(1999) another mark model"
        );

        // then
        assertEquals(0, carDto1.compareTo(carDto2));
        assertEquals(12, carDto1.compareTo(carDto3));
        assertEquals(12, carDto1.compareTo(carDto4));
        assertEquals(12, carDto2.compareTo(carDto3));
        assertEquals(12, carDto2.compareTo(carDto4));
        assertEquals(0, carDto3.compareTo(carDto4));
        assertEquals(-12, carDto4.compareTo(carDto2));
    }

    @Test
    public void shouldToStringWorksProperly() {

        // given
        CarDto carDto = new CarDto(
                1,
                "mark",
                "model",
                1999,
                "(1999) mark model"
        );

        // then
        assertEquals("CarDto{carId=1, mark='mark', model='model', productionYear=1999, carSignature='(1999) mark model'}", carDto.toString());
    }
}
