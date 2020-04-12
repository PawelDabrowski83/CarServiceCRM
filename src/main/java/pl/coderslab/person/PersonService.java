package pl.coderslab.person;

import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;

import java.util.*;
import java.util.stream.Collectors;

public class PersonService implements PersonServiceInterface<PersonDto> {

    public static final PersonDaoInterface<PersonEntity> PERSON_DAO = new PersonDaoImpl();
    public static final MapperInterface<PersonDto, Person, PersonEntity> PERSON_MAPPER = new PersonMapper();

    public void create (PersonDto dto) {
        PERSON_DAO.create(
                PERSON_MAPPER.mapServiceToEntity(
                        PERSON_MAPPER.mapDtoToService(
                                dto)));
    }

    public PersonDto read (int personId) {
        Optional<PersonEntity> entityOptional = Optional.ofNullable(PERSON_DAO.read(personId));
        System.out.println("ENT: " + entityOptional);
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
