package pl.coderslab.customer;

import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ServiceInterface;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CustomerService implements ServiceInterface<CustomerDto> {

    private final GenericDao<CustomerEntity> customerDao;
    private final MapperInterface<CustomerDto, Customer, CustomerEntity> customerMapper;

    public CustomerService(GenericDao<CustomerEntity> customerDao, MapperInterface<CustomerDto, Customer, CustomerEntity> customerMapper) {
        this.customerDao = customerDao;
        this.customerMapper = customerMapper;
    }

    @Override
    public void create(CustomerDto dto) {
        customerDao.create(
                customerMapper.mapServiceToEntity(
                        customerMapper.mapDtoToService(
                                dto)));
    }

    @Override
    public CustomerDto read(int id) {
        Optional<CustomerEntity> entityOptional = Optional.ofNullable(customerDao.read(id));
        CustomerEntity entity = entityOptional.orElseGet(CustomerEntity::new);
        return customerMapper.mapServiceToDto(
                customerMapper.mapEntityToService(
                        entity));
    }

    @Override
    public void update(CustomerDto dto) {
        customerDao.update(
                customerMapper.mapServiceToEntity(
                        customerMapper.mapDtoToService(
                                dto)));
    }

    @Override
    public void delete(int id) {
        customerDao.delete(id);
    }

    @Override
    public Set<CustomerDto> findAll() {
        return customerDao.findAll().stream()
                .map(customerMapper::mapEntityToService)
                .map(customerMapper::mapServiceToDto)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
