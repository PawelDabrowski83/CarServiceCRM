package pl.coderslab.labor;

import org.junit.Before;
import org.junit.Test;
import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ServiceInterface;
import pl.coderslab.employee.Employee;
import pl.coderslab.employee.EmployeeDaoImpl;
import pl.coderslab.employee.EmployeeDto;
import pl.coderslab.employee.EmployeeEntity;
import pl.coderslab.employee.EmployeeMapper;
import pl.coderslab.employee.EmployeeService;
import pl.coderslab.vehicle.Vehicle;
import pl.coderslab.vehicle.VehicleDaoImpl;
import pl.coderslab.vehicle.VehicleDto;
import pl.coderslab.vehicle.VehicleEntity;
import pl.coderslab.vehicle.VehicleMapper;
import pl.coderslab.vehicle.VehicleService;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class LaborMapperTest {

    LaborEntity laborEntity;
    Labor labor;
    LaborDto laborDto;
    Vehicle vehicle;
    VehicleDto vehicleDto;
    Employee employee;
    EmployeeDto employeeDto;
    final GenericDao<EmployeeEntity> employeeDao = mock(EmployeeDaoImpl.class);
    final ServiceInterface<EmployeeDto> employeeService = mock(EmployeeService.class);
    final MapperInterface<EmployeeDto, Employee, EmployeeEntity> employeeMapper = mock(EmployeeMapper.class);
    final GenericDao<VehicleEntity> vehicleDao = mock(VehicleDaoImpl.class);
    final ServiceInterface<VehicleDto> vehicleService = mock(VehicleService.class);
    final MapperInterface<VehicleDto, Vehicle, VehicleEntity> vehicleMapper = mock(VehicleMapper.class);
    final MapperInterface<LaborDto, Labor, LaborEntity> laborMapper = new LaborMapper(employeeDao, employeeMapper, vehicleDao, vehicleMapper);

    @Before
    public void setUp() {
        vehicle = mock(Vehicle.class);
        employee = mock(Employee.class);
    }

    @Test
    public void shouldMapServiceToDtoWork() {

        // given
        labor = new Labor(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                employee,
                "issue",
                "service",
                Labor.StatusEnum.QUEUE,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        LaborDto laborDtoExpected = new LaborDto(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                1,
                "employeeFullname",
                "issue",
                "service",
                "QUEUE",
                1,
                "(1999) mark model registryPlate",
                1.0,
                1.0,
                100,
                "customerFullname"
        );

        // when
        LaborDto laborDtoActual = laborMapper.mapServiceToDto(labor);

        // then
        assertEquals(laborDtoExpected, laborDtoActual);
        assertEquals(laborDtoExpected.getStartedDate(), laborDtoActual.getStartedDate());
        assertEquals(laborDtoExpected.getFinishedDate(), laborDtoActual.getFinishedDate());
        assertEquals(laborDtoExpected.getEmployeeId(), laborDtoActual.getEmployeeId());
        assertEquals(laborDtoExpected.getEmployeeFullname(), laborDtoActual.getEmployeeFullname());
        assertEquals(laborDtoExpected.getDescriptionIssue(), laborDtoActual.getDescriptionIssue());
        assertEquals(laborDtoExpected.getDescriptionService(), laborDtoActual.getDescriptionService());
        assertEquals(laborDtoExpected.getStatus(), laborDtoActual.getStatus());
        assertEquals(laborDtoExpected.getVehicleId(), laborDtoActual.getVehicleId());
        assertEquals(laborDtoExpected.getCustomerCost(), laborDtoActual.getCustomerCost(), 0.1);
        assertEquals(laborDtoExpected.getMaterialCost(), laborDtoActual.getMaterialCost(), 0.1);
        assertEquals(laborDtoExpected.getMhTotal(), laborDtoActual.getMhTotal());
        assertEquals(laborDtoExpected.getCustomerFullname(), laborDtoActual.getCustomerFullname());
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenMappingNullInServiceToDto() {

        // given
        labor = null;

        // when
        laborMapper.mapServiceToDto(labor);
    }

    @Test
    public void shouldMapDtoToServiceWork() {

        // given
        laborDto = new LaborDto(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                1,
                "employeeFullname",
                "issue",
                "service",
                "QUEUE",
                1,
                "(1999) mark model registryPlace",
                1.0,
                1.0,
                100,
                "customerFullname"
        );
        Labor laborExpected = new Labor(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                employee,
                "issue",
                "service",
                Labor.StatusEnum.QUEUE,
                vehicle,
                1.0,
                1.0,
                100,
                null,
                null,
                false
        );
        when(employeeService.read(1)).thenReturn(employeeDto);
        when(employeeMapper.mapDtoToService(employeeDto)).thenReturn(employee);
        when(vehicleService.read(1)).thenReturn(vehicleDto);
        when(vehicleMapper.mapDtoToService(vehicleDto)).thenReturn(vehicle);

        // when
        Labor laborActual = laborMapper.mapDtoToService(laborDto);

        // then
        assertEquals(laborExpected, laborActual);
        assertEquals(laborExpected.getStartedDate(), laborActual.getStartedDate());
        assertEquals(laborExpected.getFinishedDate(), laborActual.getFinishedDate());
        assertEquals(laborExpected.getDescriptionIssue(), laborActual.getDescriptionIssue());
        assertEquals(laborExpected.getDescriptionService(), laborActual.getDescriptionService());
        assertEquals(laborExpected.getStatus(), laborActual.getStatus());
        assertEquals(laborExpected.getCustomerCost(), laborActual.getCustomerCost(), 0.1);
        assertEquals(laborExpected.getMaterialCost(), laborActual.getMaterialCost(), 0.1);
        assertEquals(laborExpected.getMhTotal(), laborActual.getMhTotal());
        assertNull(laborActual.getCreated());
        assertNull(laborActual.getUpdated());
        assertFalse(laborActual.isActive());
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenMappingNullInDtoToService() {

        // given
        laborDto = null;

        // when
        laborMapper.mapDtoToService(laborDto);
    }

    @Test
    public void shouldMapServiceToEntityWork() {

        // given
        labor = new Labor(
                1,
                LocalDate.of(1999, 1, 1),
                LocalDate.of(1999, 1, 2),
                LocalDate.of(1999, 1, 3),
                LocalDate.of(1999, 1, 4),
                employee,
                "issue",
                "service",
                Labor.StatusEnum.QUEUE,
                vehicle,
                1.0,
                1.0,
                100,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

    }
}
