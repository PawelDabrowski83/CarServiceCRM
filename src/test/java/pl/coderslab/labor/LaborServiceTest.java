package pl.coderslab.labor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ServiceInterface;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class LaborServiceTest {

    LaborEntity laborEntity;
    Labor labor;
    LaborDto laborDto;
    final GenericDao<LaborEntity> laborDao = mock(LaborDaoImpl.class);
    final MapperInterface<LaborDto, Labor, LaborEntity> laborMapper = mock(LaborMapper.class);
    final ServiceInterface<LaborDto> laborService = new LaborService(laborDao, laborMapper);

    @Before
    public void setUp() {

        laborEntity = mock(LaborEntity.class);
        labor = mock(Labor.class);
        laborDto = mock(LaborDto.class);
        when(laborMapper.mapDtoToService(laborDto)).thenReturn(labor);
        when(laborMapper.mapServiceToDto(labor)).thenReturn(laborDto);
        when(laborMapper.mapEntityToService(laborEntity)).thenReturn(labor);
        when(laborMapper.mapServiceToEntity(labor)).thenReturn(laborEntity);
    }

    @Test
    public void shouldCreateWork() {

        // when
        laborService.create(laborDto);

        // then
        verify(laborDao, times(1)).create(laborEntity);
    }

    @Test
    public void shouldReadWork() {

        // when
        laborService.read(1);

        // then
        verify(laborDao, times(1)).read(1);
    }

    @Test
    public void shouldUpdateWork() {

        // when
        laborService.update(laborDto);

        // then
        verify(laborDao, times(1)).update(laborEntity);
    }

    @Test
    public void shouldDeleteWork() {

        // when
        laborService.delete(1);

        // then
        verify(laborDao, times(1)).delete(1);
    }

    @Test
    public void shouldFindAllWork() {

        // when
        laborService.findAll();

        // then
        verify(laborDao, times(1)).findAll();
    }
}
