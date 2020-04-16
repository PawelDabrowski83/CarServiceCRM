package pl.coderslab.person;

import org.junit.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class PersonEntityTest {

    @Test
    public void shouldGettersAndSettersWorkProperly() {

        // given
        PersonEntity personEntity = new PersonEntity();

        // when
        personEntity.setId(1);
        personEntity.setFirstName("firstName");
        personEntity.setLastName("lastName");
        personEntity.setAddress("address");
        personEntity.setPhone("123456");
        personEntity.setNotes("notes");
        personEntity.setBirthdate(LocalDate.of(1999, 1, 1));
        personEntity.setCreated(LocalDateTime.of(2020, 12, 31, 15, 35));
        personEntity.setUpdated(LocalDateTime.of(2020, 12, 31, 15, 35));
        personEntity.setActive(true);

        // then
        assertEquals(1, personEntity.getId());
        assertEquals("firstName", personEntity.getFirstName());
        assertEquals("lastName", personEntity.getLastName());
        assertEquals("address", personEntity.getAddress());
        assertEquals("123456", personEntity.getPhone());
        assertEquals("notes", personEntity.getNotes());
        assertEquals(LocalDate.of(1999, 1, 1), personEntity.getBirthdate());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), personEntity.getCreated());
        assertEquals(LocalDateTime.of(2020, 12, 31, 15, 35), personEntity.getUpdated());
        assertTrue(personEntity.isActive());
    }

    @Test
    public void shouldEqualsAndHashCodeWorkProperly() {

        // given
        PersonEntity personEntity1 = new PersonEntity(
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
        PersonEntity personEntity2 = new PersonEntity(
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
        PersonEntity personEntity3 = new PersonEntity(
                3,
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
        PersonEntity personEntity4 = new PersonEntity(
                4,
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
        assertEquals(personEntity1, personEntity2);
        assertEquals(personEntity1.hashCode(), personEntity2.hashCode());
        assertNotEquals(personEntity1, personEntity3);
        assertNotEquals(personEntity1.hashCode(), personEntity3.hashCode());
        assertNotEquals(personEntity1, personEntity4);
        assertNotEquals(personEntity1.hashCode(), personEntity4.hashCode());
        assertNotEquals(personEntity2, personEntity3);
        assertNotEquals(personEntity2.hashCode(), personEntity3.hashCode());
        assertNotEquals(personEntity2, personEntity4);
        assertNotEquals(personEntity2.hashCode(), personEntity4.hashCode());
        assertNotEquals(personEntity3, personEntity4);
        assertNotEquals(personEntity3.hashCode(), personEntity4.hashCode());
    }

    @Test
    public void shouldCompareToWorkProperly() {

        // given
        PersonEntity personEntity1 = new PersonEntity(
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
        PersonEntity personEntity2 = new PersonEntity(
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
        PersonEntity personEntity3 = new PersonEntity(
                3,
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
        PersonEntity personEntity4 = new PersonEntity(
                4,
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
        assertEquals(0, personEntity1.compareTo(personEntity2));
        assertEquals(5, personEntity1.compareTo(personEntity3));
        assertEquals(-1, personEntity1.compareTo(personEntity4));
        assertEquals(5, personEntity2.compareTo(personEntity3));
        assertEquals(-1, personEntity2.compareTo(personEntity4));
        assertEquals(-5, personEntity3.compareTo(personEntity4));
    }

    @Test
    public void shouldToStringWorkProperly() {

        // given
        PersonEntity personEntity = new PersonEntity(
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
        String actualToString = personEntity.toString();

        // then
        assertEquals("PersonEntity{id=1, firstName='firstName', lastName='lastName'," +
                " address='address', phone='123456', notes='notes', birthdate=1999-01-01," +
                " created=2020-12-31T15:35, updated=2020-12-31T15:35, active=true}",
                actualToString);
    }


}
