package pl.coderslab.person;

import pl.coderslab.commons.MapperInterface;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class PersonMapper implements MapperInterface<PersonDto, Person, PersonEntity> {

    public PersonDto mapServiceToDto (Person person) {
        PersonDto dto = new PersonDto();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAddress());
        dto.setPhone(person.getPhone());
        dto.setNotes(person.getNotes());
        dto.setBirthYear(person.getBirthYear());
        dto.setBirthMonth(person.getBirthMonth());
        dto.setBirthDay(person.getBirthDay());
        dto.setUpdated(person.getUpdated().toString());
        dto.setActive(person.isActive());
        dto.setFullname(person.getFullname());
        return dto;
    }

    public Person mapDtoToService (PersonDto dto) {
        Person person = new Person();
        person.setId(dto.getId());
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setAddress(dto.getAddress());
        person.setPhone(dto.getPhone());
        person.setNotes(dto.getNotes());
        person.setBirthdate(dto.getBirthdate());
        try {
            person.setUpdated(LocalDateTime.parse(dto.getUpdated()));
        } catch (DateTimeException | NumberFormatException | NullPointerException e) {
            e.printStackTrace();
            person.setUpdated(null);
        }
        person.setActive(dto.isActive());
        return person;
    }

    public PersonEntity mapServiceToEntity (Person person) {
        PersonEntity entity = new PersonEntity();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setPhone(person.getPhone());
        entity.setNotes(person.getNotes());
        entity.setBirthdate(person.getBirthdate());
        entity.setCreated(person.getCreated());
        entity.setUpdated(person.getUpdated());
        entity.setActive(person.isActive());
        return entity;
    }

    public Person mapEntityToService (PersonEntity entity) {
        Person person = new Person();
        person.setId(entity.getId());
        person.setFirstName(entity.getFirstName());
        person.setLastName(entity.getLastName());
        person.setAddress(entity.getAddress());
        person.setPhone(entity.getPhone());
        person.setNotes(entity.getNotes());
        person.setBirthdate(entity.getBirthdate());
        person.setCreated(entity.getCreated());
        person.setUpdated(entity.getUpdated());
        person.setActive(entity.isActive());
        return person;
    }

}
