package pl.coderslab.person;

import pl.coderslab.commons.ValidatorInterface;

import java.util.regex.Pattern;

public class PersonValidator implements ValidatorInterface<PersonDto> {

    private static final Pattern DATE_FORMAT_PATTERN = Pattern.compile("^([1]9\\d{2}|[2][0|1]\\d{2})-(0[1-9]|1[0-2])-(0[1-9]|1\\d|2\\d|3[0-1])$");

    @Override
    public String validate(PersonDto personDto) {
        StringBuilder builder = new StringBuilder();

        if (personDto.getFirstName() == null || personDto.getFirstName().isEmpty()) {
            builder.append("First name cannot be empty." + System.lineSeparator());
        }
        if (personDto.getLastName() == null || personDto.getLastName().isEmpty()) {
            builder.append("Last name cannot be empty." + System.lineSeparator());
        }
        if (personDto.getPhone() == null || personDto.getPhone().isEmpty()) {
            builder.append("Phone cannot be empty." + System.lineSeparator());
        }
        if (personDto.getBirthYear() == null || personDto.getBirthYear().isEmpty()) {
            builder.append("Year cannot be empty." + System.lineSeparator());
        }
        if (personDto.getBirthMonth() == null || personDto.getBirthMonth().isEmpty()) {
            builder.append("Month cannot be empty." + System.lineSeparator());
        }
        if (personDto.getBirthDay() == null || personDto.getBirthDay().isEmpty()) {
            builder.append("Day cannot be empty." + System.lineSeparator());
        }
        String fullDate = String.join("-", personDto.getBirthYear(), personDto.getBirthMonth(), personDto.getBirthDay());
        System.out.println("fulldate: " + fullDate);
        System.out.println("regex.find ==> " + DATE_FORMAT_PATTERN.matcher(fullDate).find());
        if (!DATE_FORMAT_PATTERN.matcher(fullDate).find()) {
            builder.append("Wrong data format. Required is YYYY-MM-DD." + System.lineSeparator());
        };

        return builder.toString();
    }
}
