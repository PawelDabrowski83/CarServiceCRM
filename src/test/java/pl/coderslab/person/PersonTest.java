package pl.coderslab.person;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void shouldWorkWithGettersAndSetters() {

        // given
        Person person = new Person();

        // when
        person.setId(1);
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setPhone("123456");
        person.setNotes("notes");
        person.setBirthdate(LocalDate.of(1999, 1, 1));
        person.setCreated(LocalDateTime.of(2020, 12, 31, 15, 35));
        person.setUpdated(LocalDateTime.of(2020, 12, 31, 15, 35));
        person.setActive(true);

        // then
        assertEquals(1, person.getId());
        assertEquals("firstName", person.getFirstName());
        assertEquals("lastName", person.getLastName());
        assertEquals("lastName firstName", person.getFullname());
        assertEquals("address", person.getAddress());
        assertEquals("123456", person.getPhone());
        assertEquals("notes", person.getNotes());
        assertEquals(LocalDate.of(1999, 1, 1), person.getBirthdate());
        assertEquals("1999", person.getBirthYear());
        assertEquals("1", person.getBirthMonth());
        assertEquals("1", person.getBirthDay());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), person.getCreated());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), person.getUpdated());
        assertTrue(person.isActive());
    }

    @Test
    public void shouldGetFullnameWithoutFirstNameWhenFirstNameIsNull() {

        // given
        Person person = new Person(
                null,
                "lastName"
        );

        // when
        String result = person.getFullname();

        // then
        assertEquals(("lastName" + " " + Person.FIRSTNAME_PLACEHOLDER).trim(), result);
    }

    @Test
    public void shouldGetFullnameWithoutFirstNameWhenFirstNameIsEmpty() {

        // given
        Person person = new Person(
                "",
                "lastName"
        );

        // when
        String result = person.getFullname();

        // then
        assertEquals(("lastName" + " " + Person.FIRSTNAME_PLACEHOLDER).trim(), result);
    }

    @Test
    public void shouldGetFullnameWithoutFirstNameWhenFirstNameIsButSpaces() {

        // given
        Person person = new Person(
                "     ",
                "lastName"
        );

        // when
        String result = person.getFullname();

        // then
        assertEquals(("lastName" + " " + Person.FIRSTNAME_PLACEHOLDER).trim(), result);
    }

    @Test
    public void shouldGetFullnameWithoutLastNameWhenLastNameIsNull() {

        // given
        Person person = new Person(
                "firstName",
                null
        );

        // when
        String result = person.getFullname();

        // then
        assertEquals((Person.LASTNAME_PLACEHOLDER + " " + "firstName").trim(), result);
    }

    @Test
    public void shouldGetFullnameWithoutLastNameWhenLastNameIsEmpty() {

        // given
        Person person = new Person(
                "firstName",
                ""
        );

        // when
        String result = person.getFullname();

        // then
        assertEquals((Person.LASTNAME_PLACEHOLDER + " " + "firstName").trim(), result);
    }

    @Test
    public void shouldGetFullnameWithoutLastNameWhenLastNameIsButSpaces() {

        // given
        Person person = new Person(
                "firstName",
                "               "
        );

        // when
        String result = person.getFullname();

        // then
        assertEquals((Person.LASTNAME_PLACEHOLDER + " " + "firstName").trim(), result);
    }

    @Test
    public void shouldGetFullnamePlaceholdersWhenBothFirstNameAndLastNameAreNull() {
        // given
        Person person = new Person(
                null,
                null
        );

        // when
        String result = person.getFullname();

        // then
        assertEquals((Person.LASTNAME_PLACEHOLDER + " " + Person.FIRSTNAME_PLACEHOLDER).trim(), result);
    }

    @Test
    public void shouldGetFullnamePlaceholdersWhenBothFirstNameAndLastNameAreEmpty() {
        // given
        Person person = new Person(
                "",
                ""
        );

        // when
        String result = person.getFullname();

        // then
        assertEquals((Person.LASTNAME_PLACEHOLDER + " " + Person.FIRSTNAME_PLACEHOLDER).trim(), result);
    }

    @Test
    public void shouldGetFullnamePlaceholdersWhenBothFirstNameAndLastNameAreButSpaces() {
        // given
        Person person = new Person(
                "                 ",
                "             "
        );

        // when
        String result = person.getFullname();

        // then
        assertEquals((Person.LASTNAME_PLACEHOLDER + " " + Person.FIRSTNAME_PLACEHOLDER).trim(), result);
    }

    @Test
    public void shouldBirthYearEmptyWhenPersonBirthDateIsNull() {

        // given
        Person person = new Person();
        person.setBirthdate(null);

        // when
        String result = person.getBirthYear();

        // then
        assertEquals("", result);
    }

    @Test
    public void shouldBirthMonthEmptyWhenPersonBirthDateIsNull() {

        // given
        Person person = new Person();
        person.setBirthdate(null);

        // when
        String result = person.getBirthMonth();

        // then
        assertEquals("", result);
    }

    @Test
    public void shouldBirthDayEmptyWhenPersonBirthDateIsNull() {

        // given
        Person person = new Person();
        person.setBirthdate(null);

        // when
        String result = person.getBirthDay();

        // then
        assertEquals("", result);
    }

    @Test
    public void shouldEqualsAndHashCodeWorkProperly() {

        // given
        Person person1 = new Person(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Person person2 = new Person(
                2,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Person person3 = new Person(
                1,
                "another firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Person person4 = new Person(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                LocalDate.of(2000, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // then
        assertEquals(person1, person2);
        assertEquals(person1.hashCode(), person2.hashCode());
        assertNotEquals(person1, person3);
        assertNotEquals(person1.hashCode(), person3.hashCode());
        assertNotEquals(person1, person4);
        assertNotEquals(person1.hashCode(), person4.hashCode());
        assertNotEquals(person2, person3);
        assertNotEquals(person2.hashCode(), person3.hashCode());
        assertNotEquals(person2, person4);
        assertNotEquals(person2.hashCode(), person4.hashCode());
        assertNotEquals(person3, person4);
        assertNotEquals(person3.hashCode(), person4.hashCode());
    }

    @Test
    public void shouldCompareToWorkProperly() {

        // given
        Person person1 = new Person(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Person person2 = new Person(
                2,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Person person3 = new Person(
                1,
                "another firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );
        Person person4 = new Person(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                LocalDate.of(2000, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // then
        assertEquals(0, person1.compareTo(person2));
        assertEquals(5, person1.compareTo(person3));
        assertEquals(-1, person1.compareTo(person4));
        assertEquals(5, person2.compareTo(person3));
        assertEquals(-1, person2.compareTo(person4));
        assertEquals(-5, person3.compareTo(person4));
    }

    @Test
    public void shouldToStringWork() {

        // given
        Person person = new Person(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                LocalDate.of(1999, 1, 1),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                LocalDateTime.of(2020, 12, 31, 15, 35),
                true
        );

        // when
        String actual = person.toString();

        // then
        assertEquals("Person{id=1, firstName='firstName', lastName='lastName', address='address', phone='123456', notes='notes', birthdate=1999-01-01, created=2020-12-31T15:35, updated=2020-12-31T15:35, active=true}", actual);
    }
}
