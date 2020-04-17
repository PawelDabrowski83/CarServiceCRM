package pl.coderslab.customer;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CustomerDtoTest {

    @Test
    public void shouldGettersAndSettersWork() {

        // given
        CustomerDto customerDto = new CustomerDto();

        // when
        customerDto.setCustomerId(1);
        customerDto.setPersonalId(1);
        customerDto.setFullname("lastName firstName");

        // then
        assertEquals(1, customerDto.getCustomerId());
        assertEquals(1, customerDto.getPersonalId());
        assertEquals("lastName firstName", customerDto.getFullname());
    }

    @Test
    public void shouldEqualsAndHashCodeWork() {

        // given
        CustomerDto customerDto1 = new CustomerDto(
                1,
                1,
                "lastName firstName"
        );
        CustomerDto customerDto2 = new CustomerDto(
                1,
                1,
                "lastName firstName"
        );
        CustomerDto customerDto3 = new CustomerDto(
                1,
                1,
                "another lastName firstName"
        );
        CustomerDto customerDto4 = new CustomerDto(
                1,
                2,
                "lastName firstName"
        );

        // then
        assertEquals(customerDto1, customerDto2);
        assertNotEquals(customerDto1, customerDto3);
        assertNotEquals(customerDto1, customerDto4);
        assertNotEquals(customerDto2, customerDto3);
        assertNotEquals(customerDto2, customerDto4);
        assertNotEquals(customerDto3, customerDto4);
        assertEquals(customerDto1.hashCode(), customerDto2.hashCode());
        assertNotEquals(customerDto1.hashCode(), customerDto3.hashCode());
        assertNotEquals(customerDto1.hashCode(), customerDto4.hashCode());
        assertNotEquals(customerDto2.hashCode(), customerDto3.hashCode());
        assertNotEquals(customerDto2.hashCode(), customerDto4.hashCode());
        assertNotEquals(customerDto3.hashCode(), customerDto4.hashCode());

    }

    @Test
    public void shouldCompareToWork() {

        // given
        CustomerDto customerDto1 = new CustomerDto(
                1,
                1,
                "lastName firstName"
        );
        CustomerDto customerDto2 = new CustomerDto(
                1,
                1,
                "lastName firstName"
        );
        CustomerDto customerDto3 = new CustomerDto(
                1,
                1,
                "another lastName firstName"
        );
        CustomerDto customerDto4 = new CustomerDto(
                1,
                2,
                "lastName firstName"
        );

        // then
        assertEquals(0, customerDto1.compareTo(customerDto2));
        assertEquals(11, customerDto1.compareTo(customerDto3));
        assertEquals(-1, customerDto1.compareTo(customerDto4));
        assertEquals(11, customerDto2.compareTo(customerDto3));
        assertEquals(-1, customerDto2.compareTo(customerDto4));
        assertEquals(-11, customerDto3.compareTo(customerDto4));
    }

    @Test
    public void shouldToStringWork() {

        // given
        CustomerDto customerDto = new CustomerDto(
                1,
                1,
                "lastName firstName"
        );

        // when
        String actualToString = customerDto.toString();

        // then
        assertEquals("CustomerDto{customerId=1, personalId=1, fullname='lastName firstName'}", actualToString);
    }
}
