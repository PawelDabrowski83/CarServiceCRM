package pl.coderslab.person;

import pl.coderslab.commons.ValidatorInterface;

import java.util.regex.Pattern;

public class PersonValidator implements ValidatorInterface<PersonDto> {

    protected static final Pattern DATE_FORMAT_PATTERN = Pattern.compile("^([1]9\\d{2}|[2][0|1]\\d{2})-(0[1-9]|1[0-2])-(0[1-9]|1\\d|2\\d|3[0-1])$");
    protected static final String INVALID_FIRSTNAME = "First name cannot be empty.<br/>" + System.lineSeparator();
    protected static final String INVALID_LASTNAME = "Last name cannot be empty.<br/>" + System.lineSeparator();
    protected static final String INVALID_PHONE = "Phone cannot be empty.<br/>" + System.lineSeparator();
    protected static final String INVALID_YEAR = "Year cannot be empty.<br/>" + System.lineSeparator();
    protected static final String INVALID_MONTH = "Month cannot be empty.<br/>" + System.lineSeparator();
    protected static final String INVALID_DAY = "Day cannot be empty.<br/>" + System.lineSeparator();
    protected static final String INVALID_DATE = "Wrong data format. Required is YYYY-MM-DD.<br/>" + System.lineSeparator();

    @Override
    public String validate(PersonDto personDto) {
        StringBuilder builder = new StringBuilder();

        if (personDto.getFirstName() == null || personDto.getFirstName().trim().isEmpty()) {
            builder.append(INVALID_FIRSTNAME);
        }
        if (personDto.getLastName() == null || personDto.getLastName().trim().isEmpty()) {
            builder.append(INVALID_LASTNAME);
        }
        if (personDto.getPhone() == null || personDto.getPhone().trim().isEmpty()) {
            builder.append(INVALID_PHONE);
        }
        if (personDto.getBirthYear() == null || personDto.getBirthYear().trim().isEmpty()) {
            builder.append(INVALID_YEAR);
        }
        if (personDto.getBirthMonth() == null || personDto.getBirthMonth().trim().isEmpty()) {
            builder.append(INVALID_MONTH);
        }
        if (personDto.getBirthDay() == null || personDto.getBirthDay().trim().isEmpty()) {
            builder.append(INVALID_DAY);
        }
        if (personDto.getBirthYear() != null && personDto.getBirthMonth() != null && personDto.getBirthDay() != null) {
            String fullDate = String.join("-", personDto.getBirthYear().trim(), personDto.getBirthMonth().trim(), personDto.getBirthDay().trim());
            if (!DATE_FORMAT_PATTERN.matcher(fullDate).find()) {
                builder.append(INVALID_DATE);
            }
        }

        return builder.toString();
    }
}
