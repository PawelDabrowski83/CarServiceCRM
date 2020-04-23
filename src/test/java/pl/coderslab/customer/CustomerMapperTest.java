package pl.coderslab.customer;

import org.junit.Before;
import org.junit.Test;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.person.*;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

public class CustomerMapperTest {

    CustomerDto customerDto;
    Customer customer;
    CustomerEntity customerEntity;

    Person person;
    PersonEntity personEntity;
    final PersonDaoInterface<PersonEntity> personDao = mock(PersonDaoImpl.class);
    final MapperInterface<PersonDto, Person, PersonEntity> personMapper = mock(PersonMapper.class);
    final MapperInterface<CustomerDto, Customer, CustomerEntity> customerMapper = new CustomerMapper(personDao, personMapper);

    @Before
    public void setUp() {
        person = mock(Person.class);
        when(person.getId()).thenReturn(1);

    }

    @Test
    public void shouldMapServiceToDtoWork() {

        // given
        customer = new Customer(
                1,
                person,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        CustomerDto customerDtoExpected = new CustomerDto(
                1,
                1,
                "fullname"
        );
        when(person.getId()).thenReturn(1);
        when(person.getFullname()).thenReturn("fullname");

        // when
        CustomerDto customerDtoActual = customerMapper.mapServiceToDto(customer);

        // then
        assertEquals(customerDtoExpected, customerDtoActual);
        assertEquals(customerDtoExpected.getCustomerId(), customerDtoActual.getCustomerId());
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenMappingNullInServiceToDto() {

        // given
        customer = null;

        // when
        customerMapper.mapServiceToDto(customer);

    }

    @Test
    public void shouldMapDtoToServiceWork() {

        // given
        customerDto = new CustomerDto(
                1,
                1,
                "fullname"
        );
        person.setId(1);
        Customer customerExpected = new Customer(
                1,
                person,
                null,
                null,
                false
        );
        when(personDao.read(1)).thenReturn(personEntity);
        when(personMapper.mapEntityToService(personEntity)).thenReturn(person);

        // when
        Customer customerActual = customerMapper.mapDtoToService(customerDto);

        // then
        assertEquals(customerExpected, customerActual);
        assertEquals(1, customerActual.getCustomerId());
        assertNull(customerActual.getCreated());
        assertNull(customerActual.getUpdated());
        assertFalse(customerActual.isActive());
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenMappingNullInDtoToService() {

        // given
        customerDto = null;

        // when
        customerMapper.mapDtoToService(customerDto);
    }

    @Test
    public void shouldMapServiceToEntityWork() {

        // given
        person.setId(1);
        customer = new Customer(
                1,
                person,
                null,
                null,
                false
        );
        CustomerEntity customerEntityExpected = new CustomerEntity(
                1,
                1,
                null,
                null,
                false
        );

        // when
        CustomerEntity customerEntityActual = customerMapper.mapServiceToEntity(customer);

        // then
        assertEquals(customerEntityExpected, customerEntityActual);
        assertEquals(1, customerEntityActual.getPersonalId());
        assertNull(customerEntityActual.getCreated());
        assertNull(customerEntityActual.getUpdated());
        assertFalse(customerEntityActual.isActive());
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenMappingNullInServiceToEntity() {

        // given
        customer = null;

        // when
        customerMapper.mapServiceToEntity(customer);
    }

    @Test
    public void shouldMapEntityToServiceWork() {

        // given
        customerEntity = new CustomerEntity(
                1,
                1,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Customer customerExpected = new Customer(
                1,
                person,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        when(personDao.read(1)).thenReturn(personEntity);
        when(personMapper.mapEntityToService(personEntity)).thenReturn(person);

        // when
        Customer customerActual = customerMapper.mapEntityToService(customerEntity);

        // then
        assertEquals(customerExpected, customerActual);
        assertEquals(1, customerActual.getCustomerId());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), customerActual.getCreated());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), customerActual.getUpdated());
        assertTrue(customerActual.isActive());
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenMappingNullInEntityToService() {

        // given
        customerEntity = null;

        // when
        customerMapper.mapEntityToService(customerEntity);
    }
}
