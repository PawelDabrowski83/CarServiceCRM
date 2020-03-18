package pl.coderslab.PersonDetails;

import pl.coderslab.commons.MapperInterface;

public class PersonDetailsMapper implements MapperInterface<PersonDetailsDto,PersonDetails,PersonDetailsEntity> {

    public PersonDetailsDto mapServiceToDto (PersonDetails personDetails) {
        PersonDetailsDto dto = new PersonDetailsDto();
        dto.setId(personDetails.getId());
        dto.setFirstName(personDetails.getFirstName());
        dto.setLastName(personDetails.getLastName());
        dto.setAddress(personDetails.getAddress());
        dto.setPhone(personDetails.getPhone());
        dto.setNotes(personDetails.getNotes());
        dto.setBirthYear(personDetails.getBirthYear());
        dto.setBirthMonth(personDetails.getBirthMonth());
        dto.setBirthDay(personDetails.getBirthDay());
        dto.setCreated(personDetails.getCreated());
        dto.setUpdated(personDetails.getUpdated());
        dto.setActive(personDetails.isActive());
        dto.setFullname(personDetails.getFullname());
        return dto;
    }

    public PersonDetails mapDtoToService (PersonDetailsDto dto) {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setId(dto.getId());
        personDetails.setFirstName(dto.getFirstName());
        personDetails.setLastName(dto.getLastName());
        personDetails.setAddress(dto.getAddress());
        personDetails.setPhone(dto.getPhone());
        personDetails.setNotes(dto.getNotes());
        personDetails.setBirthdate(dto.getBirthdate());
        personDetails.setCreated(dto.getCreated());
        personDetails.setUpdated(dto.getUpdated());
        personDetails.setActive(dto.isActive());
        return personDetails;
    }

    public PersonDetailsEntity mapServiceToEntity (PersonDetails personDetails) {
        PersonDetailsEntity entity = new PersonDetailsEntity();
        entity.setId(personDetails.getId());
        entity.setFirstName(personDetails.getFirstName());
        entity.setLastName(personDetails.getLastName());
        entity.setAddress(personDetails.getAddress());
        entity.setPhone(personDetails.getPhone());
        entity.setNotes(personDetails.getNotes());
        entity.setBirthdate(personDetails.getBirthdate());
        entity.setCreated(personDetails.getCreated());
        entity.setUpdated(personDetails.getUpdated());
        entity.setActive(personDetails.isActive());
        return entity;
    }

    public PersonDetails mapEntityToService (PersonDetailsEntity entity) {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setId(entity.getId());
        personDetails.setFirstName(entity.getFirstName());
        personDetails.setLastName(entity.getLastName());
        personDetails.setAddress(entity.getAddress());
        personDetails.setPhone(entity.getPhone());
        personDetails.setNotes(entity.getNotes());
        personDetails.setBirthdate(entity.getBirthdate());
        personDetails.setCreated(entity.getCreated());
        personDetails.setUpdated(entity.getUpdated());
        personDetails.setActive(entity.isActive());
        return personDetails;
    }
}
