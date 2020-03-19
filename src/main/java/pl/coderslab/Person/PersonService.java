package pl.coderslab.Person;

import pl.coderslab.commons.EntityDao;

import java.util.*;
import java.util.stream.Collectors;

public class PersonService {

    public static final EntityDao<PersonEntity> PERSON_DAO = new PersonDaoImpl();
    public static final PersonMapper PERSON_MAPPER = new PersonMapper();

    public void createPerson (PersonDto dto) {
        PERSON_DAO.create(
                PERSON_MAPPER.mapServiceToEntity(
                        PERSON_MAPPER.mapDtoToService(
                                dto)));
    }

    public PersonDto readPerson (int personId) {
        Optional<PersonEntity> entityOptional = Optional.of(PERSON_DAO.read(personId));
        return PERSON_MAPPER.mapServiceToDto(
                PERSON_MAPPER.mapEntityToService(
                        entityOptional.orElseGet(
                                PersonEntity::new)));
    }

    public void updatePerson (PersonDto dto) {
        PERSON_DAO.update(
                PERSON_MAPPER.mapServiceToEntity(
                        PERSON_MAPPER.mapDtoToService(
                                dto)));
    }

    public void deletePerson (int personId) {
        PERSON_DAO.delete(personId);
    }

    public Set<PersonDto> findAll () {
        Set<PersonEntity> entities = PERSON_DAO.findAll();
        return entities.stream()
                .map(PERSON_MAPPER::mapEntityToService)
                .map(PERSON_MAPPER::mapServiceToDto)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
