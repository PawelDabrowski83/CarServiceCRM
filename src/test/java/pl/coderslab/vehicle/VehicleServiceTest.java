package pl.coderslab.vehicle;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ServiceInterface;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceTest {

    GenericDao<VehicleEntity> vehicleDao = mock(GenericDao.class);
    MapperInterface<VehicleDto, Vehicle, VehicleEntity> vehicleMapper = mock(MapperInterface.class);
    ServiceInterface<VehicleDto> vehicleService = new VehicleService(vehicleDao, vehicleMapper);
    VehicleDto vehicleDto = mock(VehicleDto.class);
    Vehicle vehicle = mock(Vehicle.class);
    VehicleEntity vehicleEntity = mock(VehicleEntity.class);

    @Before
    public void setUp() {

        when(vehicleMapper.mapDtoToService(vehicleDto)).thenReturn(vehicle);
        when(vehicleMapper.mapServiceToDto(vehicle)).thenReturn(vehicleDto);
        when(vehicleMapper.mapEntityToService(vehicleEntity)).thenReturn(vehicle);
        when(vehicleMapper.mapServiceToEntity(vehicle)).thenReturn(vehicleEntity);
    }



    @Test
    public void shouldVehicleServiceCreateWork() {

        // when
        vehicleService.create(vehicleDto);

        // then
        verify(vehicleDao, times(1)).create(vehicleEntity);
    }

    @Test
    public void shouldVehicleServiceReadWork() {

        // when
        vehicleService.read(1);

        // then
        verify(vehicleDao, times(1)).read(1);
    }

    @Test
    public void shouldVehicleServiceUpdateWork() {

        // when
        vehicleService.update(vehicleDto);

        // then
        verify(vehicleDao, times(1)).update(vehicleEntity);
    }

    @Test
    public void shouldVehicleServiceDeleteWork() {

        // when
        vehicleService.delete(1);

        // then
        verify(vehicleDao, times(1)).delete(1);
    }

    @Test
    public void shouldVehicleServiceFindAllWork() {

        // when
        vehicleService.findAll();

        // then
        verify(vehicleDao, times(1)).findAll();
    }
}
