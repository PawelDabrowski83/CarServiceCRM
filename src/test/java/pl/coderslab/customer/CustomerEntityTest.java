package pl.coderslab.customer;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class CustomerEntityTest {

    @Test
    public void shouldGettersAndSettersWork() {

        // given
        CustomerEntity customerEntity = new CustomerEntity();

        // when
        customerEntity.setCustomerId(1);
        customerEntity.setPersonalId(1);
        customerEntity.setCreated(LocalDateTime.of(2020, 12, 31, 15, 35));
        customerEntity.setUpdated(LocalDateTime.of(2020, 12, 31, 15, 35));
        customerEntity.setActive(true);

        // then
        assertEquals(1, customerEntity.getCustomerId());
        assertEquals(1, customerEntity.getPersonalId());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), customerEntity.getCreated());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), customerEntity.getUpdated());
        assertTrue(customerEntity.isActive());
    }

    @Test
    public void shouldEqualsAndHashCodeWork() {

        // given
        CustomerEntity customerEntity1 = new CustomerEntity(
                1,
                1,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        CustomerEntity customerEntity2 = new CustomerEntity(
                2,
                1,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        CustomerEntity customerEntity3 = new CustomerEntity(
                3,
                2,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                false
        );
        CustomerEntity customerEntity4 = new CustomerEntity(
                4,
                1,
                LocalDateTime.of(1999, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // then
        assertEquals(customerEntity1, customerEntity2);
        assertNotEquals(customerEntity1, customerEntity3);
        assertEquals(customerEntity1, customerEntity4);
        assertNotEquals(customerEntity2, customerEntity3);
        assertEquals(customerEntity2, customerEntity4);
        assertNotEquals(customerEntity3, customerEntity4);
        assertEquals(customerEntity1.hashCode(), customerEntity2.hashCode());
        assertNotEquals(customerEntity1.hashCode(), customerEntity3.hashCode());
        assertEquals(customerEntity1.hashCode(), customerEntity4.hashCode());
        assertNotEquals(customerEntity2.hashCode(), customerEntity3.hashCode());
        assertEquals(customerEntity2.hashCode(), customerEntity4.hashCode());
        assertNotEquals(customerEntity3.hashCode(), customerEntity4.hashCode());
    }

    @Test
    public void shouldToStringWork() {

        // given
        CustomerEntity customerEntity = new CustomerEntity(
                1,
                1,
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        String actualToString = customerEntity.toString();

        // then
        assertEquals("CustomerEntity{customerId=1, personalId=1, created=2020-12-31T15:35," +
                " updated=2020-12-31T15:35, active=true}", actualToString);
    }

}
