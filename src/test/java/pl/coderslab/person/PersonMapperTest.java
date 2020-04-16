package pl.coderslab.person;

import org.junit.Test;
import pl.coderslab.commons.MapperInterface;

import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.Assert.*;

public class PersonMapperTest {

    private static final MapperInterface<PersonDto, Person, PersonEntity> PERSON_MAPPER = new PersonMapper();

    @Test
    public void shouldMapEntityToServiceWorkProperly() {

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
        Person personExpected = new Person(
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
        Person personActual = PERSON_MAPPER.mapEntityToService(personEntity);

        // then
        assertEquals(personExpected, personActual);
        assertEquals(personExpected.getId(), personActual.getId());
        assertEquals(personExpected.getFullname(), personActual.getFullname());
        assertEquals(personExpected.getAddress(), personActual.getAddress());
        assertEquals(personExpected.getNotes(), personActual.getNotes());
        assertEquals(personExpected.getCreated(), personActual.getCreated());
        assertEquals(personExpected.getUpdated(), personActual.getUpdated());
        assertEquals(personExpected.isActive(), personActual.isActive());
    }

    @Test
    public void shouldServiceToEntityWorkProperly() {

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
        PersonEntity personEntityExpected = new PersonEntity(
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
        PersonEntity personEntityActual = PERSON_MAPPER.mapServiceToEntity(person);

        // then
        assertEquals(personEntityExpected, personEntityActual);
        assertEquals(personEntityExpected.getId(), personEntityActual.getId());
        assertEquals(personEntityExpected.getAddress(), personEntityActual.getAddress());
        assertEquals(personEntityExpected.getNotes(), personEntityActual.getNotes());
        assertEquals(personEntityExpected.getCreated(), personEntityActual.getCreated());
        assertEquals(personEntityExpected.getUpdated(), personEntityActual.getUpdated());
        assertEquals(personEntityExpected.isActive(), personEntityActual.isActive());
    }

    @Test
    public void shouldServiceToDtoWorkProperly() {

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
        PersonDto personDtoExpected = new PersonDto(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                "1",
                "1",
                "lastName firstName"
        );

        // when
        PersonDto personDtoActual = PERSON_MAPPER.mapServiceToDto(person);

        // then
        assertEquals(personDtoExpected, personDtoActual);
        assertEquals(personDtoExpected.getId(), personDtoActual.getId());
        assertEquals(personDtoExpected.getAddress(), personDtoActual.getAddress());
        assertEquals(personDtoExpected.getNotes(), personDtoActual.getNotes());
        assertEquals(personDtoExpected.getFullname(), personDtoActual.getFullname());
    }

    @Test
    public void shouldDtoToServiceWorkProperly() {

        // given
        PersonDto personDto = new PersonDto(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                "1999",
                "1",
                "1",
                "lastName firstName"
        );
        Person personExpected = new Person(
                1,
                "firstName",
                "lastName",
                "address",
                "123456",
                "notes",
                LocalDate.of(1999, 1, 1),
                null,
                null,
                false
        );

        // when
        Person personActual = PERSON_MAPPER.mapDtoToService(personDto);

        // then
        assertEquals(personExpected, personActual);
        assertEquals(personExpected.getId(), personActual.getId());
        assertEquals(personExpected.getAddress(), personActual.getAddress());
        assertEquals(personExpected.getNotes(), personActual.getNotes());
        assertEquals(personExpected.getFullname(), personActual.getFullname());
        assertNull(personActual.getCreated());
        assertNull(personActual.getUpdated());
        assertFalse(personActual.isActive());
    }
}
