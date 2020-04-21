package pl.coderslab.person;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.commons.MapperInterface;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    PersonEntity personEntity = mock(PersonEntity.class);
    Person person = mock(Person.class);
    PersonDto personDto = mock(PersonDto.class);
    PersonDaoInterface<PersonEntity> personDao = mock(PersonDaoInterface.class);
    MapperInterface<PersonDto, Person, PersonEntity> personMapper = mock(MapperInterface.class);
    PersonServiceInterface<PersonDto> personService = new PersonService(personDao, personMapper);

    @Before
    public void setUp() {

        when(personMapper.mapServiceToEntity(person)).thenReturn(personEntity);
        when(personMapper.mapEntityToService(personEntity)).thenReturn(person);
        when(personMapper.mapServiceToDto(person)).thenReturn(personDto);
        when(personMapper.mapDtoToService(personDto)).thenReturn(person);

    }

    @Test
    public void shouldPersonServiceCreateWork() {

        // when
        personService.create(personDto);

        // then
        verify(personDao, times(1)).create(personEntity);

    }

    @Test
    public void shouldPersonServiceReadWork() {

        // when
        personService.read(1);

        // then
        verify(personDao, times(1)).read(1);
    }

    @Test
    public void shouldPersonServiceUpdateWork() {

        // when
        personService.update(personDto);

        // then
        verify(personDao, times(1)).update(personEntity);
    }

    @Test
    public void shouldPersonServiceDeleteWork() {

        // when
        personService.delete(1);

        // then
        verify(personDao, times(1)).delete(1);
    }

    @Test
    public void shouldPersonServiceFindAllWork() {

        // when
        personService.findAll();

        // then
        verify(personDao, times(1)).findAll();
    }

    @Test
    public void shouldPersonServiceFindUnmatchedCustomersWork() {

        // when
        personService.findUnmatchedCustomers();

        // then
        verify(personDao, times(1)).findUnmatchedCustomers();
    }

    @Test
    public void shouldPersonServiceFindUnmatchedEmployeesWork() {

        // when
        personService.findUnmatchedEmployees();

        // then
        verify(personDao, times(1)).findUnmatchedEmployees();
    }
}
