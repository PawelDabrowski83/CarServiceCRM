package pl.coderslab.customer;

import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ServiceInterface;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CustomerService implements ServiceInterface<CustomerDto> {

    private static final MapperInterface<CustomerDto, Customer, CustomerEntity> CUSTOMER_MAPPER = new CustomerMapper();
    private static final GenericDao<CustomerEntity> CUSTOMER_DAO = new CustomerDaoImpl();

    @Override
    public void create(CustomerDto dto) {
        CUSTOMER_DAO.create(
                CUSTOMER_MAPPER.mapServiceToEntity(
                        CUSTOMER_MAPPER.mapDtoToService(
                                dto)));
    }

    @Override
    public CustomerDto read(int id) {
        Optional<CustomerEntity> entityOptional = Optional.ofNullable(CUSTOMER_DAO.read(id));
        CustomerEntity entity = entityOptional.orElseGet(CustomerEntity::new);
        return CUSTOMER_MAPPER.mapServiceToDto(
                CUSTOMER_MAPPER.mapEntityToService(
                        entity));
    }

    @Override
    public void update(CustomerDto dto) {
        CUSTOMER_DAO.update(
                CUSTOMER_MAPPER.mapServiceToEntity(
                        CUSTOMER_MAPPER.mapDtoToService(
                                dto)));
    }

    @Override
    public void delete(int id) {
        CUSTOMER_DAO.delete(id);
    }

    @Override
    public Set<CustomerDto> findAll() {
        return CUSTOMER_DAO.findAll().stream()
                .map(CUSTOMER_MAPPER::mapEntityToService)
                .map(CUSTOMER_MAPPER::mapServiceToDto)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Set<CustomerDto> findUnmatched() {
        return CUSTOMER_DAO_PLUS.findUnmatched().stream()
                .map(CUSTOMER_MAPPER::mapEntityToService)
                .map(CUSTOMER_MAPPER::mapServiceToDto)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
