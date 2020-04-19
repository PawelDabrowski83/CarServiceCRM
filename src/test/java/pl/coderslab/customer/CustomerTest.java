package pl.coderslab.customer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.person.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CustomerTest {

    @Mock
    Person person = new Person();
    Person anotherPerson = new Person();

    @Before
    public void setUp() {
        Mockito.when(person.toString()).thenReturn("PersonMock");
        Mockito.when(person.compareTo(anotherPerson)).thenReturn(111);

        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setPhone("123456");
        person.setBirthdate(LocalDate.of(1999, 1, 1));

        anotherPerson.setFirstName("another firstName");
        anotherPerson.setLastName("another lastName");
        anotherPerson.setPhone("123456789");
        anotherPerson.setBirthdate(LocalDate.of(1900, 1, 1));
    }

    @Test
    public void shouldGettersAndSettersWork() {

        // given
        Customer customer = new Customer();

        // when
        customer.setCustomerId(1);
        customer.setPerson(person);
        customer.setCreated(LocalDateTime.of(2020, 12, 31, 15, 35));
        customer.setUpdated(LocalDateTime.of(2020, 12, 31, 15, 35));
        customer.setActive(true);

        // then
        assertEquals(1, customer.getCustomerId());
        assertEquals(person, customer.getPerson());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), customer.getCreated());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), customer.getUpdated());
        assertTrue(customer.isActive());
    }

    @Test
    public void shouldEqualsAndHashCodeWork() {

        // given
        Customer customer1 = new Customer(
                1,
                person,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Customer customer2 = new Customer(
                2,
                person,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Customer customer3 = new Customer(
                3,
                anotherPerson,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // then
        assertEquals(customer1, customer2);
        assertNotEquals(customer1, customer3);
        assertNotEquals(customer2, customer3);
        assertEquals(customer1.hashCode(), customer2.hashCode());
        assertNotEquals(customer1.hashCode(), customer3.hashCode());
        assertNotEquals(customer2.hashCode(), customer3.hashCode());
    }

    @Test
    public void shouldCompareToWork() {

        // given
        Customer customer1 = new Customer(
                1,
                person,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Customer customer2 = new Customer(
                2,
                person,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Customer customer3 = new Customer(
                3,
                anotherPerson,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // then
        assertEquals(0, customer1.compareTo(customer2));
        assertEquals(111, customer1.compareTo(customer3));
        assertEquals(111, customer2.compareTo(customer3));
    }


    @Test
    public void shouldToStringWork() {

        // given
        Customer customer = new Customer(
                1,
                person,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        String actualToString = customer.toString();

        // then
        assertEquals("Customer{customerId=1, person=PersonMock, created=2020-12-31T15:35, updated=2020-12-31T15:35, active=true}", actualToString);
    }

}
