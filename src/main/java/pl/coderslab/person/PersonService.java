package pl.coderslab.person;

import pl.coderslab.commons.MapperInterface;

import java.util.*;
import java.util.stream.Collectors;

public class PersonService implements PersonServiceInterface<PersonDto> {

    public final PersonDaoInterface<PersonEntity> PERSON_DAO;
    public final MapperInterface<PersonDto, Person, PersonEntity> PERSON_MAPPER;

    public PersonService(PersonDaoInterface<PersonEntity> PERSON_DAO, MapperInterface<PersonDto, Person, PersonEntity> PERSON_MAPPER) {
        this.PERSON_DAO = PERSON_DAO;
        this.PERSON_MAPPER = PERSON_MAPPER;
    }

    public void create (PersonDto dto) {
        PERSON_DAO.create(
                PERSON_MAPPER.mapServiceToEntity(
                        PERSON_MAPPER.mapDtoToService(
                                dto)));
    }

    public PersonDto read (int personId) {
        Optional<PersonEntity> entityOptional = Optional.ofNullable(PERSON_DAO.read(personId));
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

    @Override
    public Set<PersonDto> findUnmatchedCustomers() {
        Set<PersonEntity> entities = PERSON_DAO.findUnmatchedCustomers();
        return entities.stream()
                .map(PERSON_MAPPER::mapEntityToService)
                .map(PERSON_MAPPER::mapServiceToDto)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public Set<PersonDto> findUnmatchedEmployees() {
        Set<PersonEntity> entities = PERSON_DAO.findUnmatchedEmployees();
        return entities.stream()
                .map(PERSON_MAPPER::mapEntityToService)
                .map(PERSON_MAPPER::mapServiceToDto)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
