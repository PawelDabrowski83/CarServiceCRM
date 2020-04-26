package pl.coderslab.customer;

import org.junit.Test;
import pl.coderslab.commons.ValidatorInterface;

import static org.junit.Assert.assertEquals;

public class CustomerValidatorTest {

    private static final ValidatorInterface<CustomerDto> CUSTOMER_VALIDATOR = new CustomerValidator();


    @Test
    public void shouldGetMessageWhenPersonIdIsLowerThanOne() {

        // given
        CustomerDto customerDto = new CustomerDto();
        customerDto.setPersonalId(-1);

        // when
        String actual = CUSTOMER_VALIDATOR.validate(customerDto);

        // then
        assertEquals(CustomerValidator.INVALID_PERSON, actual);
    }
}
