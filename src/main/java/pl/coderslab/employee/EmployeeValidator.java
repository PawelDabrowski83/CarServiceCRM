package pl.coderslab.employee;

import pl.coderslab.commons.ValidatorInterface;

public class EmployeeValidator implements ValidatorInterface<EmployeeDto> {

    @Override
    public String validate(EmployeeDto employeeDto) {

        StringBuilder builder = new StringBuilder();
        if (employeeDto.getPersonId() < 1) {
            builder.append("PersonId cannot be empty or lower than 1.<br/>");
        }
        if (employeeDto.getMhCost() < 1) {
            builder.append("MHCost cannot be empty or lower than 1.<br/>");
        }
        return builder.toString();
    }
}
