package pl.coderslab.employee;

import org.junit.runner.*;
import org.mockito.runners.*;
import pl.coderslab.commons.*;
import pl.coderslab.person.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeMapperTest {

    Person person;
    Employee employee;
    EmployeeEntity employeeEntity;
    PersonDaoInterface<PersonEntity> personDao = mock(PersonDaoImpl.class);
    MapperInterface<PersonDto, Person, PersonEntity> personMapper = mock(PersonMapper.class);
}
