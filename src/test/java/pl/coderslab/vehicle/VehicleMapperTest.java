package pl.coderslab.vehicle;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.runners.*;
import pl.coderslab.car.*;
import pl.coderslab.commons.*;
import pl.coderslab.customer.*;
import pl.coderslab.person.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VehicleMapperTest {

    final MapperInterface<CarDto, Car, CarEntity> carMapper = mock(CarMapper.class);
    final MapperInterface<CustomerDto, Customer, CustomerEntity> customerMapper = mock(CustomerMapper.class);
    final ServiceInterface<CarDto> carService = mock(CarService.class);
    final ServiceInterface<CustomerDto> customerService = mock(CustomerService.class);
    final MapperInterface<VehicleDto, Vehicle, VehicleEntity> vehicleMapper = new VehicleMapper(carMapper, customerMapper, carService, customerService);
    Car car;
    CarDto carDto;
    Customer customer;
    CustomerDto customerDto;
    Person person;
    Vehicle vehicle;
    VehicleDto vehicleDto;
    VehicleEntity vehicleEntity;

    @Before
    public void setUp() {

        car = mock(Car.class);
        customer = mock(Customer.class);
        person = mock(Person.class);
        when(car.getCarId()).thenReturn(1);
        when(customer.getCustomerId()).thenReturn(1);
        when(carService.read(1)).thenReturn(carDto);
        when(customerService.read(1)).thenReturn(customerDto);
        when(carMapper.mapDtoToService(carDto)).thenReturn(car);
        when(customerMapper.mapDtoToService(customerDto)).thenReturn(customer);
    }

    @Test
    public void shouldMapServiceToDtoWork() {

        // given
        vehicle = new Vehicle(
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
        VehicleDto vehicleDtoExpected = new VehicleDto(
                1,
                1,
                1,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model registryPlate"
        );
        when(customer.getPerson()).thenReturn(person);
        when(person.getFullname()).thenReturn("lastName firstName");
        when(car.getCarSignature()).thenReturn("(1999) mark model");

        // when
        VehicleDto vehicleDtoActual = vehicleMapper.mapServiceToDto(vehicle);

        // then
        assertEquals(vehicleDtoExpected, vehicleDtoActual);
        assertEquals(vehicleDtoExpected.getVehicleId(), vehicleDtoActual.getVehicleId());
        assertEquals(vehicleDtoExpected.getCarId(), vehicleDtoActual.getCarId());
        assertEquals(vehicleDtoExpected.getOwnerId(), vehicleDtoActual.getOwnerId());
        assertEquals(vehicleDtoExpected.getOwnerFullname(), vehicleDtoActual.getOwnerFullname());
        assertEquals(vehicleDtoExpected.getNextInspection(), vehicleDtoActual.getNextInspection());
        assertEquals(vehicleDtoExpected.getNotes(), vehicleDtoActual.getNotes());
        assertEquals(vehicleDtoExpected.getColor(), vehicleDtoActual.getColor());
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenMappingNullInServiceToDto() {

        // given
        vehicle = null;

        // when
        vehicleMapper.mapServiceToDto(vehicle);
    }

    @Test
    public void shouldMapDtoToServiceWork() {

        // given
        VehicleDto vehicleDto = new VehicleDto(
                1,
                1,
                1,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                "lastName firstName",
                "(1999) mark model registryPlate"
        );
        Vehicle vehicleExpected = new Vehicle(
                1,
                car,
                customer,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                null,
                null,
                false
        );

        // when
        Vehicle vehicleActual = vehicleMapper.mapDtoToService(vehicleDto);

        // then
        assertEquals(vehicleExpected, vehicleActual);
        assertEquals(vehicleExpected.getVehicleId(), vehicleActual.getVehicleId());
        assertEquals(vehicleExpected.getNotes(), vehicleActual.getNotes());
        assertNull(vehicleActual.getCreated());
        assertNull(vehicleActual.getUpdated());
        assertFalse(vehicleActual.isActive());
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenMappingNullInDtoToService() {

        // given
        vehicleDto = null;

        // when
        vehicleMapper.mapDtoToService(vehicleDto);
    }

    @Test
    public void shouldMapServiceToEntityWork() {

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
        VehicleEntity vehicleEntityExpected = new VehicleEntity(
                1,
                1,
                1,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                null,
                null,
                false
        );

        // when
        VehicleEntity vehicleEntityActual = vehicleMapper.mapServiceToEntity(vehicle);

        // then
        assertEquals(vehicleEntityExpected, vehicleEntityActual);
        assertEquals(vehicleEntityExpected.getNotes(), vehicleEntityActual.getNotes());
        assertNull(vehicleEntityActual.getCreated());
        assertNull(vehicleEntityActual.getUpdated());
        assertFalse(vehicleEntityActual.isActive());
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenMappingNullInServiceToEntity() {

        // given
        vehicle = null;

        // when
        vehicleMapper.mapServiceToEntity(vehicle);
    }

    @Test
    public void shouldMapEntityToServiceWork() {

        // given
        VehicleEntity vehicleEntity = new VehicleEntity(
                1,
                1,
                1,
                "registryPlate",
                LocalDate.of(1999, 1, 1),
                "color",
                "notes",
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Vehicle vehicleExpected = new Vehicle(
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
        when(car.getCarSignature()).thenReturn("carSignatureMock");
        when(customer.getPerson()).thenReturn(person);
        when(person.getFullname()).thenReturn("lastName firstName");

        // when
        Vehicle vehicleActual = vehicleMapper.mapEntityToService(vehicleEntity);
        String carSignatureExpected = String.join(" ", vehicleExpected.getCar().getCarSignature(), vehicleExpected.getRegistryPlate()).trim();

        // then
        assertEquals(vehicleExpected, vehicleActual);
        assertEquals(vehicleExpected.getVehicleId(), vehicleActual.getVehicleId());
        assertEquals(vehicleExpected.getNotes(), vehicleActual.getNotes());
        assertEquals(vehicleExpected.getCreated(), vehicleActual.getCreated());
        assertEquals(vehicleExpected.getUpdated(), vehicleActual.getUpdated());
        assertTrue(vehicleActual.isActive());
        assertEquals(carSignatureExpected, vehicleActual.getCarSignature());
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenMappingNullInEntityToService() {

        // given
        vehicleEntity = null;

        // when
        vehicleMapper.mapEntityToService(vehicleEntity);
    }
}
