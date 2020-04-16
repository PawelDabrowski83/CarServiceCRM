package pl.coderslab.vehicle;

import org.junit.Test;
import pl.coderslab.car.Car;
import pl.coderslab.customer.Customer;
import pl.coderslab.person.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class VehicleTest {

    public Car initializeCar() {
        Car car = new Car();
        car.setCarId(1);
        car.setMark("mark");
        car.setModel("model");
        car.setProductionYear(LocalDate.of(1999, 1, 1));
        car.setCreated(LocalDateTime.of(2020, 12, 31, 15, 35));
        car.setUpdated(LocalDateTime.of(2020, 12, 31, 15, 35));
        car.setActive(true);
        return car;
    }

    public Customer initializeCustomer(){
        Person person = new Person();
        person.setId(1);
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setPhone("123456");
        person.setNotes("notes");
        person.setBirthdate(LocalDate.of(1999, 1, 1));
        person.setCreated(LocalDateTime.of(2020, 12, 31, 15, 35));
        person.setUpdated(LocalDateTime.of(2020, 12, 31, 15, 35));
        person.setActive(true);

        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setPerson(person);
        customer.setCreated(LocalDateTime.of(2020, 12, 31, 15, 35));
        customer.setUpdated(LocalDateTime.of(2020, 12, 31, 15, 35));
        customer.setActive(true);

        return customer;
    }

    @Test
    public void shouldGettersAndSettersWorkProperly() {

        // given
        Vehicle vehicle = new Vehicle();
        Car car = initializeCar();
        Customer customer = initializeCustomer();

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
        Car car = initializeCar();
        Customer customer = initializeCustomer();
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
        Car car2 = initializeCar();
        car2.setModel("another model");
        vehicle2.setCar(car2);

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
        Car car = initializeCar();
        Customer customer = initializeCustomer();
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

        // when
        String actualToSting = vehicle.toString();

        // then
        assertEquals("Vehicle{vehicleId=1, " +
                "car=Car{carId=1, model='model', mark='mark'," +
                " productionYear=1999, created=2020-12-31T15:35, updated=2020-12-31T15:35," +
                " active=true}," +
                " owner=Customer{customerId=1, " +
                "person=Person{id=1, firstName='firstName', lastName='lastName'," +
                " address='address', phone='123456', notes='notes', birthdate=1999-01-01," +
                " created=2020-12-31T15:35, updated=2020-12-31T15:35, active=true}," +
                " created=2020-12-31T15:35, updated=2020-12-31T15:35, active=true}, " +
                "registryPlate='registryPlate', nextInspection=1999-01-01, color='color'," +
                " notes='notes', created=2020-12-31T15:35, updated=2020-12-31T15:35," +
                " active=true}", actualToSting);
    }

    @Test
    public void shouldCompareToWorkProperly() {

        // given
        Car car = initializeCar();
        Customer customer = initializeCustomer();
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
        Car car2 = initializeCar();
        car2.setModel("another model");
        vehicle2.setCar(car2);

        car = initializeCar();
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
        assertEquals(12, vehicle1.compareTo(vehicle2));
        assertEquals(0, vehicle1.compareTo(vehicle3));
        assertEquals(0, vehicle1.compareTo(vehicle4));
        assertEquals(-12, vehicle2.compareTo(vehicle3));
        assertEquals(-12, vehicle2.compareTo(vehicle4));
        assertEquals(0, vehicle3.compareTo(vehicle4));
    }

    @Test
    public void shouldGetCarSignatureWhenRegistryPlateIsNull() {

        // given
        Car car = initializeCar();
        Customer customer = initializeCustomer();
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
        Car car = initializeCar();
        Customer customer = initializeCustomer();
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
        Car car = initializeCar();
        Customer customer = initializeCustomer();
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
        Car car = initializeCar();
        Customer customer = initializeCustomer();
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
        Car car = initializeCar();
        Customer customer = initializeCustomer();
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
        Car car = initializeCar();
        Customer customer = initializeCustomer();
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
