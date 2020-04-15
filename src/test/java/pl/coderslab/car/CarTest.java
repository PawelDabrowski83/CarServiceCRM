package pl.coderslab.car;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void shouldGetIdIfCarIdIsSet() {

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
    public void shouldGetCarSignatureIfFielsAreSet() {

        // given
        Car car = new Car();
        car.setMark("mark");
        car.setModel("model");
        car.setProductionYear(LocalDate.of(1999,1,1));

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999) mark model", (result));
    }

    @Test
    public void shouldGetCarSignatureWithoutModelIfModelIsNull() {

        // given
        Car car = new Car();
        car.setMark("mark");
        car.setModel(null);
        car.setProductionYear(LocalDate.of(1999,1,1));

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999) mark", result);
    }

    @Test
    public void shouldGetCarSignatureWithoutModelIfModelIsEmpty() {

        // given
        Car car = new Car();
        car.setMark("mark");
        car.setModel("");
        car.setProductionYear(LocalDate.of(1999,1,1));

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999) mark", result);
    }

    @Test
    public void shouldGetCarSignatureWithoutModelIfModelIsButSpaces() {

        // given
        Car car = new Car();
        car.setMark("mark");
        car.setModel("    ");
        car.setProductionYear(LocalDate.of(1999,1,1));

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999) mark", result);
    }

    @Test
    public void shouldGetCarSignatureWithoutMarkIfMarkIsNull(){

        // given
        Car car = new Car();
        car.setMark(null);
        car.setModel("model");
        car.setProductionYear(LocalDate.of(1999,1,1));

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999) model", result);
    }

    @Test
    public void shouldGetCarSignatureWithoutMarkIfMarkIsEmpty(){

        // given
        Car car = new Car();
        car.setMark("");
        car.setModel("model");
        car.setProductionYear(LocalDate.of(1999,1,1));

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999) model", result);
    }

    @Test
    public void shouldGetCarSignatureWithoutMarkIfMarkIsButSpaces(){

        // given
        Car car = new Car();
        car.setMark("  ");
        car.setModel("model");
        car.setProductionYear(LocalDate.of(1999,1,1));

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999) model", result);
    }

    @Test
    public void shouldGetCarSignatureWhenMarkAndModelAreNull() {

        // given
        Car car = new Car();
        car.setMark(null);
        car.setModel(null);
        car.setProductionYear(LocalDate.of(1999,1,1));

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999)", result);
    }

    @Test
    public void shouldGetCarSignatureWhenMarkAndModelAreEmpty() {

        // given
        Car car = new Car();
        car.setMark("");
        car.setModel("");
        car.setProductionYear(LocalDate.of(1999,1,1));

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999)", result);
    }

    @Test
    public void shouldGetCarSignatureWhenMarkAndModelAreButSpaces() {

        // given
        Car car = new Car();
        car.setMark("    ");
        car.setModel("       ");
        car.setProductionYear(LocalDate.of(1999,1,1));

        // when
        String result = car.getCarSignature();

        // then
        assertEquals("(1999)", result);
    }
}
