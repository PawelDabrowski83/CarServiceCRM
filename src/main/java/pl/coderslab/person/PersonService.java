package pl.coderslab.person;

import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ServiceInterface;

import java.util.*;
import java.util.stream.Collectors;

public class PersonService implements ServiceInterface<PersonDto> {

    public static final GenericDao<PersonEntity> PERSON_DAO = new PersonDaoImpl();
    public static final MapperInterface<PersonDto, Person, PersonEntity> PERSON_MAPPER = new PersonMapper();

    public void create (PersonDto dto) {
        PERSON_DAO.create(
                PERSON_MAPPER.mapServiceToEntity(
                        PERSON_MAPPER.mapDtoToService(
                                dto)));
    }

    public PersonDto read (int personId) {
        Optional<PersonEntity> entityOptional = Optional.of(PERSON_DAO.read(personId));
        return PERSON_MAPPER.mapServiceToDto(
                PERSON_MAPPER.mapEntityToService(
                        entityOptional.orElseGet(
                                PersonEntity::new)));
    }

    public void update (PersonDto dto) {
        PERSON_DAO.update(
                PERSON_MAPPER.mapServiceToEntity(
                        PERSON_MAPPER.mapDtoToService(
                                dto)));
    }

    public void delete (int personId) {
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
