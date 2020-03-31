package pl.coderslab.customer;

import pl.coderslab.person.*;
import pl.coderslab.commons.EntityDao;
import pl.coderslab.commons.MapperInterface;

public class CustomerMapper implements MapperInterface<CustomerDto, Customer, CustomerEntity> {

    private static final EntityDao<PersonEntity> PERSON_DAO = new PersonDaoImpl();
    private static final MapperInterface<PersonDto, Person, PersonEntity> PERSON_MAPPER = new PersonMapper();

    @Override
    public CustomerDto mapServiceToDto(Customer customer) {
        CustomerDto dto = new CustomerDto();
        dto.setCustomerId(customer.getCustomerId());
        dto.setPersonalId(customer.getPerson().getId());
        dto.setFullname(customer.getPerson().getFullname());
        return dto;
    }

    @Override
    public Customer mapDtoToService(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setCustomerId(dto.getCustomerId());
        customer.setPerson(PERSON_MAPPER.mapEntityToService(PERSON_DAO.read(dto.getPersonalId())));
        return customer;
    }

    @Override
    public CustomerEntity mapServiceToEntity(Customer customer) {
        CustomerEntity entity = new CustomerEntity();
        entity.setCustomerId(customer.getCustomerId());
        entity.setPersonalId(customer.getPerson().getId());
        return entity;
    }

    @Override
    public Customer mapEntityToService(CustomerEntity entity) {
        Customer customer = new Customer();
        customer.setCustomerId(entity.getCustomerId());
        customer.setPerson(PERSON_MAPPER.mapEntityToService(PERSON_DAO.read(entity.getPersonalId())));
        customer.setUpdated(entity.getUpdated());
        customer.setCreated(entity.getCreated());
        customer.setActive(entity.isActive());
        return customer;
    }
}
