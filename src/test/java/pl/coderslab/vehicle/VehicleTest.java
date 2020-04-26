package pl.coderslab.vehicle;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.runners.*;
import pl.coderslab.car.Car;
import pl.coderslab.customer.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VehicleTest {

    Car car;
    Customer customer;
    Vehicle vehicle;

    @Before
    public void setUp() {

        car = mock(Car.class);
        customer = mock(Customer.class);
        when(car.getCarSignature()).thenReturn("(1999) mark model");
    }
    @Test
    public void shouldGettersAndSettersWorkProperly() {

        // given
        vehicle = new Vehicle();

        // when
        vehicle.setVehicleId(1);
        vehicle.setCar(car);
        vehicle.setRegistryPlate("registryPlate");
        vehicle.setOwner(customer);
        vehicle.setColor("color");
        vehicle.setNextInspection(LocalDate.of(1999, 1, 1));
        vehicle.setNotes("notes");
        vehicle.setCreated(LocalDateTime.of(2020, 12, 31, 15, 35));
        vehicle.setUpdated(LocalDateTime.of(2020, 12, 31, 15, 35));
        vehicle.setActive(true);

        // then
        assertEquals(1, vehicle.getVehicleId());
        assertEquals(car, vehicle.getCar());
        assertEquals("registryPlate", vehicle.getRegistryPlate());
        assertEquals(customer, vehicle.getOwner());
        assertEquals("color", vehicle.getColor());
        assertEquals("notes", vehicle.getNotes());
        assertEquals(LocalDate.of(1999, 1, 1), vehicle.getNextInspection());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), vehicle.getCreated());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), vehicle.getUpdated());
        assertTrue(vehicle.isActive());
    }

    @Test
    public void shouldEqualsAndHashCodeWorkProperly() {

        // given
        Vehicle vehicle1 = new Vehicle(
                1,
                car,
                customer,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        Vehicle vehicle2 = new Vehicle(
                2,
                car,
                customer,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Car car2 = mock(Car.class);
        when(car2.getModel()).thenReturn("another model");
        vehicle2.setCar(car2);
        when(car.getModel()).thenReturn("model");

        Vehicle vehicle3 = new Vehicle(
                3,
                car,
                customer,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        Vehicle vehicle4 = new Vehicle(
                4,
                car,
                customer,
                "registryPlate",
                LocalDate.of(2000, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // then
        assertNotEquals(vehicle1, vehicle2);
        assertNotEquals(vehicle1.hashCode(), vehicle2.hashCode());
        assertEquals(vehicle1, vehicle3);
        assertEquals(vehicle1.hashCode(), vehicle3.hashCode());
        assertNotEquals(vehicle1, vehicle4);
        assertNotEquals(vehicle1.hashCode(), vehicle4.hashCode());
        assertNotEquals(vehicle2, vehicle3);
        assertNotEquals(vehicle2.hashCode(), vehicle3.hashCode());
        assertNotEquals(vehicle2, vehicle4);
        assertNotEquals(vehicle2.hashCode(), vehicle4.hashCode());
        assertNotEquals(vehicle3, vehicle4);
        assertNotEquals(vehicle3.hashCode(), vehicle4.hashCode());
    }

    @Test
    public void shouldToStringWorkProperly() {

        // given
        Vehicle vehicle = new Vehicle(
                1,
                car,
                customer,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        when(car.toString()).thenReturn("CarMock");
        when(customer.toString()).thenReturn("CustomerMock");

        // when
        String actualToSting = vehicle.toString();

        // then
        assertEquals("Vehicle{vehicleId=1, car=CarMock, owner=CustomerMock, registryPlate='registryPlate', nextInspection=1999-01-01, color='color', notes='notes', created=2020-12-31T15:35, updated=2020-12-31T15:35, active=true}", actualToSting);
    }

    @Test
    public void shouldCompareToWorkProperly() {

        // given
        Vehicle vehicle1 = new Vehicle(
                1,
                car,
                customer,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        Car car2 = mock(Car.class);
        Vehicle vehicle2 = new Vehicle(
                2,
                car2,
                customer,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        Vehicle vehicle3 = new Vehicle(
                3,
                car,
                customer,
                "another registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        Vehicle vehicle4 = new Vehicle(
                4,
                car,
                customer,
                "registryPlate",
                LocalDate.of(2000, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        when(car.compareTo(car2)).thenReturn(1);

        // then
        assertEquals(1, vehicle1.compareTo(vehicle2));
        assertEquals(17, vehicle1.compareTo(vehicle3));
        assertEquals(-1, vehicle1.compareTo(vehicle4));
        assertEquals(1, vehicle2.compareTo(vehicle3));
        assertEquals(1, vehicle2.compareTo(vehicle4));
        assertEquals(-17, vehicle3.compareTo(vehicle4));
    }

    @Test
    public void shouldGetCarSignatureWhenRegistryPlateIsNull() {

        // given
        Vehicle vehicle = new Vehicle(
                car,
                null
        );


        // when
        String actual = vehicle.getCarSignature();

        // then
        assertEquals(("(1999) mark model" + " " + Vehicle.REGISTRYPLATE_PLACEHOLDER).trim(), actual);
    }

    @Test
    public void shouldGetCarSignatureWhenRegistryPlateIsEmpty() {

        // given
        Vehicle vehicle = new Vehicle(
                car,
                ""
        );

        // when
        String actual = vehicle.getCarSignature();

        // then
        assertEquals(("(1999) mark model" + " " + Vehicle.REGISTRYPLATE_PLACEHOLDER).trim(), actual);
    }

    @Test
    public void shouldGetCarSignatureWhenRegistryPlateIsButSpaces() {

        // given
        Vehicle vehicle = new Vehicle(
                car,
                "           "
        );

        // when
        String actual = vehicle.getCarSignature();

        // then
        assertEquals(("(1999) mark model" + " " + Vehicle.REGISTRYPLATE_PLACEHOLDER).trim(), actual);
    }

    @Test
    public void shouldGetCarSignatureWhenCarIsNull() {

        // given
        Vehicle vehicle = new Vehicle(
                null,
                "registryPlate"
        );

        // when
        String actual = vehicle.getCarSignature();

        // then
        assertEquals((Vehicle.CARSIGNATURE_PLACEHOLDER + " " + "registryPlate").trim(), actual);
    }

    @Test
    public void shouldGetCarSignatureWhenCarAndRegistryPlateAreNull() {

        // given
        Vehicle vehicle = new Vehicle(
                null,
                null
        );

        // when
        String actual = vehicle.getCarSignature();

        // then
        assertEquals((Vehicle.CARSIGNATURE_PLACEHOLDER + " " + Vehicle.REGISTRYPLATE_PLACEHOLDER).trim(), actual);
    }

    @Test
    public void shouldGetCarSignatureWhenCarIsNullAndRegistryPlateIsEmpty() {

        // given
        Vehicle vehicle = new Vehicle(
                null,
                ""
        );

        // when
        String actual = vehicle.getCarSignature();

        // then
        assertEquals((Vehicle.CARSIGNATURE_PLACEHOLDER + " " + Vehicle.REGISTRYPLATE_PLACEHOLDER).trim(), actual);
    }

}
