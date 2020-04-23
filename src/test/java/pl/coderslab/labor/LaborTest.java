package pl.coderslab.labor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.car.Car;
import pl.coderslab.employee.Employee;
import pl.coderslab.person.Person;
import pl.coderslab.vehicle.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LaborTest {

    Employee employee = mock(Employee.class);
    Employee anotherEmployee = mock(Employee.class);
    Person person = mock(Person.class);
    Person anotherPerson = mock(Person.class);
    Vehicle vehicle = mock(Vehicle.class);

    @Before
    public void setUp() {
        employee = mock(Employee.class);
        anotherEmployee = mock(Employee.class);
        person = mock(Person.class);
        anotherPerson = mock(Person.class);
        vehicle = mock(Vehicle.class);

        when(employee.compareTo(anotherEmployee)).thenReturn(-1);
        when(employee.getPerson()).thenReturn(person);
//        when(anotherEmployee.getPerson()).thenReturn(anotherPerson);
        when(employee.toString()).thenReturn("EmployeeMock");
        when(vehicle.toString()).thenReturn("VehicleMock");
    }

    @Test
    public void shouldGettersAndSettersWork() {

        // given
        Labor labor = new Labor();

        // when
        labor.setLaborId(1);
        labor.setRegistrationDate(LocalDate.of(1999, 1, 1));
        labor.setScheduledDate(LocalDate.of(1999, 1, 2));
        labor.setStartedDate(LocalDate.of(1999, 1, 3));
        labor.setFinishedDate(LocalDate.of(1999, 1, 4));
        labor.setEmployee(employee);
        labor.setDescriptionIssue("issue");
        labor.setDescriptionService("service");
        labor.setStatus(Labor.StatusEnum.BACKLOG);
        labor.setVehicle(vehicle);
        labor.setCustomerCost(1.0);
        labor.setMaterialCost(1.0);
        labor.setMhTotal(100);
        labor.setCreated(LocalDateTime.of(2020, 12, 31, 15, 35));
        labor.setUpdated(LocalDateTime.of(2020, 12, 31, 15, 35));
        labor.setActive(true);

        // then
        assertEquals(1, labor.getLaborId());
        assertEquals(LocalDate.of(1999, 1, 1), labor.getRegistrationDate());
        assertEquals(LocalDate.of(1999, 1, 2), labor.getScheduledDate());
        assertEquals(LocalDate.of(1999, 1, 3), labor.getStartedDate());
        assertEquals(LocalDate.of(1999, 1, 4), labor.getFinishedDate());
        assertEquals(employee, labor.getEmployee());
        assertEquals("issue", labor.getDescriptionIssue());
        assertEquals("service", labor.getDescriptionService());
        assertEquals(Labor.StatusEnum.BACKLOG.toString(), labor.getStatus());
        assertEquals(vehicle, labor.getVehicle());
        assertEquals(1.0, labor.getCustomerCost(), 0.1);
        assertEquals(1.0, labor.getMaterialCost(), 0.1);
        assertEquals(100, labor.getMhTotal());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), labor.getCreated());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), labor.getUpdated());
        assertTrue(labor.isActive());
    }

    @Test
    public void shouldEqualsAndHashCodeWork() {

        // given
        Labor labor1 = new Labor(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                employee,
                "issue",
                "service",
                Labor.StatusEnum.COST_ESTIMATION_ACCEPTED,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Labor labor2 = new Labor(
                2,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                employee,
                "issue",
                "service",
                Labor.StatusEnum.CANCELLED,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Labor labor3 = new Labor(
                3,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                anotherEmployee,
                "issue",
                "service",
                Labor.StatusEnum.IN_PROGRESS,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Labor labor4 = new Labor(
                4,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                anotherEmployee,
                "issue",
                "service",
                Labor.StatusEnum.READY_FOR_COLLECTION,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // then
        assertEquals(labor1, labor2);
        assertNotEquals(labor1, labor3);
        assertNotEquals(labor1, labor4);
        assertNotEquals(labor2, labor3);
        assertNotEquals(labor2, labor4);
        assertEquals(labor3, labor4);
        assertEquals(labor1.hashCode(), labor2.hashCode());
        assertNotEquals(labor1.hashCode(), labor3.hashCode());
        assertNotEquals(labor1.hashCode(), labor4.hashCode());
        assertNotEquals(labor2.hashCode(), labor3.hashCode());
        assertNotEquals(labor2.hashCode(), labor4.hashCode());
        assertEquals(labor3.hashCode(), labor4.hashCode());
    }

    @Test
    public void shouldCompareToWork() {

        // given
        Labor labor1 = new Labor(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                employee,
                "issue",
                "service",
                Labor.StatusEnum.COST_ESTIMATION_ACCEPTED,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Labor labor2 = new Labor(
                2,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                employee,
                "issue",
                "service",
                Labor.StatusEnum.CANCELLED,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Labor labor3 = new Labor(
                3,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                anotherEmployee,
                "issue",
                "service",
                Labor.StatusEnum.IN_PROGRESS,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Labor labor4 = new Labor(
                4,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                anotherEmployee,
                "issue",
                "service",
                Labor.StatusEnum.READY_FOR_COLLECTION,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // then
        assertEquals(0, labor1.compareTo(labor2));
        assertEquals(-1, labor1.compareTo(labor3));
        assertEquals(-1, labor1.compareTo(labor4));
        assertEquals(-1, labor2.compareTo(labor3));
        assertEquals(-1, labor2.compareTo(labor4));
        assertEquals(0, labor3.compareTo(labor4));
    }

    @Test
    public void shouldToStringWork() {

        // given
        Labor labor = new Labor(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                employee,
                "issue",
                "service",
                Labor.StatusEnum.COST_ESTIMATION_ACCEPTED,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        String actualToString = labor.toString();

        // then
        assertEquals("Labor{laborId=1, registrationDate=1999-01-01, scheduledDate=1999-01-02, startedDate=1999-01-03," +
                " finishedDate=1999-01-04, employee=EmployeeMock, descriptionIssue='issue', descriptionService='service'," +
                " status=COST_ESTIMATION_ACCEPTED, vehicle=VehicleMock, customerCost=1.0, materialCost=1.0, mhTotal=100," +
                " created=2020-12-31T15:35, updated=2020-12-31T15:35, active=true}", actualToString);
        assertNotEquals("", actualToString);
    }

    @Test
    public void shouldGetPlaceholderMessageWhenEmployeeIsNullOnEmployeeFullname() {

        // given
        employee = null;
        Labor labor = new Labor(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                employee,
                "issue",
                "service",
                Labor.StatusEnum.COST_ESTIMATION_ACCEPTED,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        String expected = Labor.PERSON_FULLNAME_PLACEHOLDER.trim();
        String actual = labor.getEmployeeFullname();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPlaceholderMessageWhenEmployeePersonIsNullOnEmployeeFullname() {

        // given
        employee.setPerson(null);
        Labor labor = new Labor(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                employee,
                "issue",
                "service",
                Labor.StatusEnum.COST_ESTIMATION_ACCEPTED,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        String expected = Labor.PERSON_FULLNAME_PLACEHOLDER.trim();
        String actual = labor.getEmployeeFullname();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPlaceholderMessageWhenVehicleIsNullOnVehicleSignature() {

        // given
        vehicle = null;
        Labor labor = new Labor(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                employee,
                "issue",
                "service",
                Labor.StatusEnum.COST_ESTIMATION_ACCEPTED,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        String expected = (Labor.VEHICLE_PLACEHOLDER + " " + Labor.VEHICLE_REGISTRY_PLATE_PLACEHOLDER).trim();
        String actual = labor.getVehicleSignature();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPlaceholderMessageWhenVehicleCarIsNullOnVehicleSignature() {

        // given
        vehicle.setCar(null);
        Labor labor = new Labor(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                employee,
                "issue",
                "service",
                Labor.StatusEnum.COST_ESTIMATION_ACCEPTED,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        when(vehicle.getRegistryPlate()).thenReturn("registryPlate");

        // when
        String expected = (Labor.VEHICLE_PLACEHOLDER + " " + vehicle.getRegistryPlate()).trim();
        String actual = labor.getVehicleSignature();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPlaceholderMessageWhenVehicleRegistryPlateIsNullOnVehicleSignature() {

        // given
        vehicle.setRegistryPlate(null);
        Labor labor = new Labor(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                employee,
                "issue",
                "service",
                Labor.StatusEnum.COST_ESTIMATION_ACCEPTED,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Car car = mock(Car.class);
        when(vehicle.getCar()).thenReturn(car);
        when(car.getCarSignature()).thenReturn("CarSignature");

        // when
        String expected = (vehicle.getCar().getCarSignature() + " " + Labor.VEHICLE_REGISTRY_PLATE_PLACEHOLDER).trim();
        String actual = labor.getVehicleSignature();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPlaceholderMessageWhenVehicleCarAndRegistryPlateAreNullOnVehicleSignature() {

        // given
        vehicle.setRegistryPlate(null);
        vehicle.setCar(null);
        Labor labor = new Labor(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                employee,
                "issue",
                "service",
                Labor.StatusEnum.COST_ESTIMATION_ACCEPTED,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        String expected = (Labor.VEHICLE_PLACEHOLDER + " " + Labor.VEHICLE_REGISTRY_PLATE_PLACEHOLDER).trim();
        String actual = labor.getVehicleSignature();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPlaceholderWhenVehicleIsNullOnCustomerFullname() {

        // given
        vehicle = null;
        Labor labor = new Labor(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                employee,
                "issue",
                "service",
                Labor.StatusEnum.COST_ESTIMATION_ACCEPTED,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        String expected = Labor.PERSON_FULLNAME_PLACEHOLDER.trim();
        String actual = labor.getCustomerFullname();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPlaceholderWhenVehicleOwnerIsNullOnCustomerFullname() {

        // given
        vehicle.setOwner(null);
        Labor labor = new Labor(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                employee,
                "issue",
                "service",
                Labor.StatusEnum.COST_ESTIMATION_ACCEPTED,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        String expected = Labor.PERSON_FULLNAME_PLACEHOLDER.trim();
        String actual = labor.getCustomerFullname();

        // then
        assertEquals(expected, actual);
    }

}
