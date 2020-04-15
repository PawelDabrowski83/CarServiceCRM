package pl.coderslab.car;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void shouldGettersAndSettersWorkProperly() {

        // given
        Car car = new Car();

        // when
        car.setCarId(1);
        car.setMark("mark");
        car.setModel("model");
        car.setProductionYear(LocalDate.of(1999,1,1));
        car.setActive(true);
        car.setCreated(LocalDateTime.of(2000, 12, 31, 15, 35));
        car.setUpdated(LocalDateTime.of(2000, 12, 31, 15, 35));

        // then
        assertEquals(1, car.getCarId());
        assertEquals("mark", car.getMark());
        assertEquals("model", car.getModel());
        assertEquals(LocalDate.of(1999,1,1), car.getProductionYear());
        assertTrue(car.isActive());
        assertEquals(LocalDateTime.of(2000, 12, 31, 15, 35), car.getCreated());
        assertEquals(LocalDateTime.of(2000, 12, 31, 15, 35), car.getUpdated());
    }

    @Test
    public void shouldGetCarSignatureIfFieldsAreSet() {

        // given
        Car car = new Car(
                "mark",
                "model",
                LocalDate.of(1999, 1, 1)
        );

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999) mark model", (result));
    }

    @Test
    public void shouldGetCarSignatureWithoutModelIfModelIsNull() {

        // given
        Car car = new Car(
                "mark",
                null,
                LocalDate.of(1999, 1, 1)
        );

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999) mark", result);
    }

    @Test
    public void shouldGetCarSignatureWithoutModelIfModelIsEmpty() {

        // given
        Car car = new Car(
                "mark",
                "",
                LocalDate.of(1999, 1, 1)
        );

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999) mark", result);
    }

    @Test
    public void shouldGetCarSignatureWithoutModelIfModelIsButSpaces() {

        // given
        Car car = new Car(
                "mark",
                "    ",
                LocalDate.of(1999, 1, 1)
        );

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999) mark", result);
    }

    @Test
    public void shouldGetCarSignatureWithoutMarkIfMarkIsNull(){

        // given
        Car car = new Car(
                null,
                "model",
                LocalDate.of(1999, 1, 1)
        );

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999) model", result);
    }

    @Test
    public void shouldGetCarSignatureWithoutMarkIfMarkIsEmpty(){

        // given
        Car car = new Car(
                "",
                "model",
                LocalDate.of(1999, 1, 1)
        );

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999) model", result);
    }

    @Test
    public void shouldGetCarSignatureWithoutMarkIfMarkIsButSpaces(){

        // given
        Car car = new Car(
                "     ",
                "model",
                LocalDate.of(1999, 1, 1)
        );

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999) model", result);
    }

    @Test
    public void shouldGetCarSignatureWhenMarkAndModelAreNull() {

        // given
        Car car = new Car(
                null,
                null,
                LocalDate.of(1999, 1, 1)
        );

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999)", result);
    }

    @Test
    public void shouldGetCarSignatureWhenMarkAndModelAreEmpty() {

        // given
        Car car = new Car(
                "",
                "",
                LocalDate.of(1999, 1, 1)
        );

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999)", result);
    }

    @Test
    public void shouldGetCarSignatureWhenMarkAndModelAreButSpaces() {

        // given
        Car car = new Car(
                "       ",
                "                  ",
                LocalDate.of(1999, 1, 1)
        );

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999)", result);
    }

    @Test
    public void shouldGetProperToString() {

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

        // when
        String result = car.toString();

        // then
        assertEquals("Car{carId=1, model='model', mark='mark', productionYear=1999, created=2020-12-31T15:35, updated=2020-12-31T15:35, active=true}", result);
    }

    @Test
    public void shouldGetProperEqualsAndHashCode() {

        // given
        Car car1 = new Car(
                1,
                "mark",
                "model",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Car car2 = new Car(
                2,
                "mark",
                "model",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                false
        );
        Car car3 = new Car(
                2,
                "mark",
                "another model definitely",
                LocalDate.of(1999, 1, 22),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );


        // then
        assertEquals(car1, car2);
        assertEquals(car1.hashCode(), car2.hashCode());
        assertNotEquals(car2, car3);
        assertNotEquals(car2.hashCode(), car3.hashCode());
        assertNotEquals(car1, car3);
        assertNotEquals(car1.hashCode(), car3.hashCode());
    }

    @Test
    public void shouldGetProperCompareTo() {

        // given
        Car car1 = new Car(
                1,
                "mark",
                "model",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Car car2 = new Car(
                2,
                "mark",
                "model",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                false
        );
        Car car3 = new Car(
                2,
                "mark",
                "another model definitely",
                LocalDate.of(1999, 1, 22),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Car car4 = new Car(
                2,
                "another mark",
                "another model definitely",
                LocalDate.of(1999, 1, 22),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // then
        assertEquals(0, car1.compareTo(car2));
        assertEquals(-21, car2.compareTo(car3));
        assertEquals(-21, car1.compareTo(car3));
        assertEquals(12, car3.compareTo(car4));
    }
}
