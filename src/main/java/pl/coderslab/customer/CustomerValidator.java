package pl.coderslab.customer;

import pl.coderslab.commons.ValidatorInterface;

public class CustomerValidator implements ValidatorInterface<CustomerDto> {

    protected static final String INVALID_PERSON = "PersonId cannot be below one";

    @Override
    public String validate(CustomerDto customerDto) {

        StringBuilder builder = new StringBuilder();
        if (customerDto.getPersonalId() < 1) {
            builder.append(INVALID_PERSON);
        }

        return builder.toString();
    }
}
