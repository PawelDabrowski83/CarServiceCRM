package pl.coderslab.car;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ServiceInterface;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    MapperInterface<CarDto, Car, CarEntity> carMapper = mock(CarMapper.class);
    GenericDao<CarEntity> carDao = mock(CarDaoImpl.class);
    ServiceInterface<CarDto> carService = new CarService(carDao, carMapper);
    CarDto carDto = mock(CarDto.class);
    Car car = mock(Car.class);
    CarEntity carEntity = mock(CarEntity.class);

    @Before
    public void setUp() {

        when(carMapper.mapDtoToService(carDto)).thenReturn(car);
        when(carMapper.mapServiceToDto(car)).thenReturn(carDto);
        when(carMapper.mapEntityToService(carEntity)).thenReturn(car);
        when(carMapper.mapServiceToEntity(car)).thenReturn(carEntity);
    }

    @Test
    public void shouldCarServiceCreateWork() {

        // when
        carService.create(carDto);

        // then
        verify(carDao, times(1)).create(any());
    }

    @Test
    public void shouldCarServiceReadWork() {

        // when
        carService.read(1);

        // then
        verify(carDao, times(1)).read(1);
    }

    @Test
    public void shouldCarServiceUpdateWork() {

        // work
        carService.update(carDto);

        // then
        verify(carDao, times(1)).update(carEntity);
    }

    @Test
    public void shouldCarServiceDeleteWork() {

        // when
        carService.delete(1);

        // then
        verify(carDao, times(1)).delete(1);
    }

    @Test
    public void shouldCarServiceFindAllWork() {

        // when
        carService.findAll();

        // then
        verify(carDao, times(1)).findAll();
    }
}
