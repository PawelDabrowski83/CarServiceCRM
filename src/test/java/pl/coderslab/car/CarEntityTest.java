package pl.coderslab.car;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class CarEntityTest {

    @Test
    public void shouldGettersAndSettersWorkProperly() {

        // given
        CarEntity carEntity = new CarEntity();

        // when
        carEntity.setCarId(1);
        carEntity.setMark("mark");
        carEntity.setModel("model");
        carEntity.setProductionYear(LocalDate.of(1999, 1, 1));
        carEntity.setCreated(LocalDateTime.of(2020, 12, 31, 15, 35));
        carEntity.setUpdated(LocalDateTime.of(2020, 12, 31, 15, 35));
        carEntity.setActive(true);

        // then
        assertEquals(1, carEntity.getCarId());
        assertEquals("mark", carEntity.getMark());
        assertEquals("model", carEntity.getModel());
        assertEquals(LocalDate.of(1999, 1, 1), carEntity.getProductionYear());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), carEntity.getCreated());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), carEntity.getUpdated());
        assertTrue(carEntity.isActive());
    }

    @Test
    public void shouldToStringWorkProperly() {

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

        // then
        assertEquals("CarEntity{carId=1, mark='mark', model='model', productionYear=1999, created=2020-12-31T15:35, updated=2020-12-31T15:35, active=true}", carEntity.toString());
    }

    @Test
    public void shouldEqualsAndHashCodeWorkProperly() {

        // given
        CarEntity carEntity1 = new CarEntity(
                1,
                "mark",
                "model",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        CarEntity carEntity2 = new CarEntity(
                100,
                "mark",
                "model",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                false
        );
        CarEntity carEntity3 = new CarEntity(
                1,
                "another mark",
                "model",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        CarEntity carEntity4 = new CarEntity(
                1,
                "mark",
                "model",
                LocalDate.of(2000, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // then
        assertEquals(carEntity1, carEntity2);
        assertEquals(carEntity1.hashCode(), carEntity2.hashCode());
        assertNotEquals(carEntity1, carEntity3);
        assertNotEquals(carEntity1.hashCode(), carEntity3.hashCode());
        assertNotEquals(carEntity1, carEntity4);
        assertNotEquals(carEntity1.hashCode(), carEntity4.hashCode());
        assertNotEquals(carEntity2, carEntity3);
        assertNotEquals(carEntity2.hashCode(), carEntity3.hashCode());
        assertNotEquals(carEntity2, carEntity4);
        assertNotEquals(carEntity2.hashCode(), carEntity4.hashCode());
        assertNotEquals(carEntity3, carEntity4);
        assertNotEquals(carEntity3.hashCode(), carEntity4.hashCode());
    }
}
