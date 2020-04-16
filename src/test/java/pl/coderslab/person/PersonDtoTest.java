package pl.coderslab.person;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PersonDtoTest {

    @Test
    public void shouldGettersAndSettersWorkProperly() {

        // given
        PersonDto personDto = new PersonDto();

        // when
        personDto.setId(1);
        personDto.setFirstName("firstName");
        personDto.setLastName("lastName");
        personDto.setFullname("lastName firstName");
        personDto.setAddress("address");
        personDto.setPhone("123456");
        personDto.setNotes("notes");
        personDto.setBirthYear("1999");
        personDto.setBirthMonth("01");
        personDto.setBirthDay("01");

        // then
        assertEquals(1, personDto.getId());
        assertEquals("firstName", personDto.getFirstName());
        assertEquals("lastName", personDto.getLastName());
        assertEquals("lastName firstName", personDto.getFullname());
        assertEquals("address", personDto.getAddress());
        assertEquals("123456", personDto.getPhone());
        assertEquals("notes", personDto.getNotes());
        assertEquals("1999", personDto.getBirthYear());
        assertEquals("01", personDto.getBirthMonth());
        assertEquals("01", personDto.getBirthDay());
        assertEquals(LocalDate.of(1999, 1, 1), personDto.getBirthdate());
    }

    @Test
    public void shouldGiveFakeDateWhenBirthYearIsNull() {

        // given
        PersonDto personDto = new PersonDto(
                null,
                "01",
                "01"
        );

        // when
        LocalDate actualBirthdate = personDto.getBirthdate();

        // then
        assertEquals(LocalDate.of(1, 1, 1), actualBirthdate);
    }

    @Test
    public void shouldGiveFakeDateWhenBirthYearIsEmpty() {

        // given
        PersonDto personDto = new PersonDto(
                "",
                "01",
                "01"
        );

        // when
        LocalDate actualBirthdate = personDto.getBirthdate();

        // then
        assertEquals(LocalDate.of(1, 1, 1), actualBirthdate);
    }

    @Test
    public void shouldGiveFakeDateWhenBirthYearIsIncorrect() {

        // given
        PersonDto personDto = new PersonDto(
                "year",
                "01",
                "01"
        );

        // when
        LocalDate actualBirthdate = personDto.getBirthdate();

        // then
        assertEquals(LocalDate.of(1, 1, 1), actualBirthdate);
    }

    @Test
    public void shouldGiveFakeDateWhenBirthMonthIsNull() {

        // given
        PersonDto personDto = new PersonDto(
                "1999",
                null,
                "01"
        );

        // when
        LocalDate actualBirthdate = personDto.getBirthdate();

        // then
        assertEquals(LocalDate.of(1, 1, 1), actualBirthdate);
    }

    @Test
    public void shouldGiveFakeDateWhenBirthMonthIsEmpty() {

        // given
        PersonDto personDto = new PersonDto(
                "1999",
                "",
                "01"
        );

        // when
        LocalDate actualBirthdate = personDto.getBirthdate();

        // then
        assertEquals(LocalDate.of(1, 1, 1), actualBirthdate);
    }

    @Test
    public void shouldGiveFakeDateWhenBirthMonthIsIncorrect() {

        // given
        PersonDto personDto = new PersonDto(
                "1999",
                "month",
                "01"
        );

        // when
        LocalDate actualBirthdate = personDto.getBirthdate();

        // then
        assertEquals(LocalDate.of(1, 1, 1), actualBirthdate);
    }

    @Test
    public void shouldGiveFakeDateWhenBirthDayIsNull() {

        // given
        PersonDto personDto = new PersonDto(
                "1999",
                "01",
                null
        );

        // when
        LocalDate actualBirthdate = personDto.getBirthdate();

        // then
        assertEquals(LocalDate.of(1, 1, 1), actualBirthdate);
    }

    @Test
    public void shouldGiveFakeDateWhenBirthDayIsEmpty() {

        // given
        PersonDto personDto = new PersonDto(
                "1999",
                "01",
                ""
        );

        // when
        LocalDate actualBirthdate = personDto.getBirthdate();

        // then
        assertEquals(LocalDate.of(1, 1, 1), actualBirthdate);
    }

    @Test
    public void shouldGiveFakeDateWhenBirthDayIsIncorrect() {

        // given
        PersonDto personDto = new PersonDto(
                "1999",
                "01",
                "day"
        );

        // when
        LocalDate actualBirthdate = personDto.getBirthdate();

        // then
        assertEquals(LocalDate.of(1, 1, 1), actualBirthdate);
    }

    @Test
    public void shouldEqualsAndHashcodeWorkProperly() {

        // given
        PersonDto personDto1 = new PersonDto(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                "01",
                "01",
                "lastName firstName"
        );
        PersonDto personDto2 = new PersonDto(
                2,
                "another firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                "01",
                "01",
                "another lastName firstName"
        );
        PersonDto personDto3 = new PersonDto(
                3,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                "01",
                "01",
                "lastName firstName"
        );

        PersonDto personDto4 = new PersonDto(
                4,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "2000",
                "01",
                "01",
                "lastName firstName"
        );

        // then
        assertNotEquals(personDto1, personDto2);
        assertNotEquals(personDto1.hashCode(), personDto2.hashCode());
        assertEquals(personDto1, personDto3);
        assertEquals(personDto1.hashCode(), personDto3.hashCode());
        assertNotEquals(personDto1, personDto4);
        assertNotEquals(personDto1.hashCode(), personDto4.hashCode());
        assertNotEquals(personDto2, personDto3);
        assertNotEquals(personDto2.hashCode(), personDto3.hashCode());
        assertNotEquals(personDto2, personDto4);
        assertNotEquals(personDto2.hashCode(), personDto4.hashCode());
        assertNotEquals(personDto3, personDto4);
        assertNotEquals(personDto3.hashCode(), personDto4.hashCode());
    }

    @Test
    public void shouldCompareToWorkProperly() {

        // given
        PersonDto personDto1 = new PersonDto(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                "01",
                "01",
                "lastName firstName"
        );
        PersonDto personDto2 = new PersonDto(
                2,
                "another firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                "01",
                "01",
                "another lastName firstName"
        );
        PersonDto personDto3 = new PersonDto(
                3,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                "01",
                "01",
                "lastName firstName"
        );

        PersonDto personDto4 = new PersonDto(
                4,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "2000",
                "01",
                "01",
                "lastName firstName"
        );

        // then
        assertEquals(11, personDto1.compareTo(personDto2));
        assertEquals(0, personDto1.compareTo(personDto3));
        assertEquals(-1, personDto1.compareTo(personDto4));
        assertEquals(-11, personDto2.compareTo(personDto3));
        assertEquals(-11, personDto2.compareTo(personDto4));
        assertEquals(-1, personDto3.compareTo(personDto4));
    }

    @Test
    public void shouldToStringWorkProperly() {

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
                "01",
                "lastName firstName"
        );

        // when
        String actualToString = personDto.toString();

        // then
        assertEquals("PersonDto{id=1, firstName='firstName', lastName='lastName'," +
                " address='address', phone='123456', notes='notes', birthYear='1999'," +
                " birthMonth='01', birthDay='01', fullname='lastName firstName'}", actualToString);
    }

}
