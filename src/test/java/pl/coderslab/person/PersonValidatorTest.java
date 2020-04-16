package pl.coderslab.person;

import org.junit.Test;
import pl.coderslab.commons.ValidatorInterface;
import static org.junit.Assert.*;

public class PersonValidatorTest {

    private static final ValidatorInterface<PersonDto> PERSON_VALIDATOR = new PersonValidator();

    @Test
    public void shouldGetMessageWhenFirstNameIsNull() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                null,
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                "01",
                "01",
                "lastName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_FIRSTNAME, result);
    }

    @Test
    public void shouldGetMessageWhenFirstNameIsEmpty() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "",
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                "01",
                "01",
                "lastName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_FIRSTNAME, result);
    }

    @Test
    public void shouldGetMessageWhenFirstNameIsButSpaces() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "        ",
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                "01",
                "01",
                "lastName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_FIRSTNAME, result);
    }

    @Test
    public void shouldGetMessageWhenLastNameIsNull() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "firstName",
                null,
                "address",
                "123456",
                "notes",
                "1999",
                "01",
                "01",
                "firstName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_LASTNAME, result);
    }

    @Test
    public void shouldGetMessageWhenLastNameIsEmpty() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "firstName",
                "",
                "address",
                "123456",
                "notes",
                "1999",
                "01",
                "01",
                "firstName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_LASTNAME, result);
    }

    @Test
    public void shouldGetMessageWhenLastNameIsButSpaces() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "firstName",
                "                  ",
                "address",
                "123456",
                "notes",
                "1999",
                "01",
                "01",
                "firstName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_LASTNAME, result);
    }

    @Test
    public void shouldGetMessageWhenPhoneIsNull() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "firstName",
                "lastName",
                "address",
                null,
                "notes",
                "1999",
                "01",
                "01",
                "lastName firstName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_PHONE, result);
    }

    @Test
    public void shouldGetMessageWhenPhoneIsEmpty() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "firstName",
                "lastName",
                "address",
                "",
                "notes",
                "1999",
                "01",
                "01",
                "lastName firstName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_PHONE, result);
    }

    @Test
    public void shouldGetMessageWhenPhoneIsButSpaces() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "firstName",
                "lastName",
                "address",
                "       ",
                "notes",
                "1999",
                "01",
                "01",
                "lastName firstName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_PHONE, result);
    }

    @Test
    public void shouldGetMessageWhenYearIsNull() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                null,
                "01",
                "01",
                "lastName firstName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_YEAR, result);
    }

    @Test
    public void shouldGetMessageWhenYearIsEmpty() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "",
                "01",
                "01",
                "lastName firstName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_YEAR + PersonValidator.INVALID_DATE, result);
    }

    @Test
    public void shouldGetMessageWhenYearIsButSpaces() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "          ",
                "01",
                "01",
                "lastName firstName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_YEAR + PersonValidator.INVALID_DATE, result);
    }

    @Test
    public void shouldGetMessageWhenMonthIsNull() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                null,
                "01",
                "lastName firstName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_MONTH, result);
    }

    @Test
    public void shouldGetMessageWhenMonthIsEmpty() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                "",
                "01",
                "lastName firstName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_MONTH + PersonValidator.INVALID_DATE, result);
    }

    @Test
    public void shouldGetMessageWhenMonthIsButSpaces() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                "     ",
                "01",
                "lastName firstName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_MONTH + PersonValidator.INVALID_DATE, result);
    }

    @Test
    public void shouldGetMessageWhenDayIsNull() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                "01",
                null,
                "lastName firstName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_DAY, result);
    }

    @Test
    public void shouldGetMessageWhenDayIsEmpty() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                "01",
                "",
                "lastName firstName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_DAY + PersonValidator.INVALID_DATE, result);
    }

    @Test
    public void shouldGetMessageWhenDayIsButSpaces() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                "01",
                "                    ",
                "lastName firstName"
        );

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(PersonValidator.INVALID_DAY + PersonValidator.INVALID_DATE, result);
    }

    @Test
    public void shouldGetMessageWhenPersonDtoIsNull() {

        // given
        PersonDto personDto = new PersonDto();

        // when
        String result = PERSON_VALIDATOR.validate(personDto);

        // then
        assertEquals(
                PersonValidator.INVALID_FIRSTNAME + PersonValidator.INVALID_LASTNAME +
                PersonValidator.INVALID_PHONE + PersonValidator.INVALID_YEAR +
                PersonValidator.INVALID_MONTH + PersonValidator.INVALID_DAY, result);
    }
}
