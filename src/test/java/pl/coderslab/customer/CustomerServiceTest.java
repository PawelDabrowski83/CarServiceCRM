package pl.coderslab.customer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ServiceInterface;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    GenericDao<CustomerEntity> customerDao = mock(CustomerDaoImpl.class);
    MapperInterface<CustomerDto, Customer, CustomerEntity> customerMapper = mock(CustomerMapper.class);
    Customer customer = mock(Customer.class);
    CustomerEntity customerEntity = mock(CustomerEntity.class);
    CustomerDto customerDto = mock(CustomerDto.class);
    ServiceInterface<CustomerDto> customerService = new CustomerService(customerMapper, customerDao);

//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        when(customerMapper.mapServiceToDto(customer)).thenReturn(customerDto);
        when(customerMapper.mapDtoToService(customerDto)).thenReturn(customer);
        when(customerMapper.mapEntityToService(customerEntity)).thenReturn(customer);
        when(customerMapper.mapServiceToEntity(customer)).thenReturn(customerEntity);

    }

    @Test
    public void shouldCustomerServiceCreateWork() {

        // given

        // when
        customerService.create(customerDto);

        // then
        verify(customerMapper, times(1)).mapDtoToService(customerDto);
        verify(customerMapper, times(1)).mapServiceToEntity(any());
        verify(customerDao, times(1)).create(any());
        assertEquals(customerDto, customerMapper.mapServiceToDto(customer));
    }

    @Test
    public void shouldCustomerServiceReadWork() {

        // given
        int customerId = 1;
        CustomerDto customerDtoExpected = mock(CustomerDto.class);
        when(customerDtoExpected.getPersonalId()).thenReturn(8);
        when(customerEntity.getPersonalId()).thenReturn(8);
        when(customerDao.read(1)).thenReturn(customerEntity);
        when(customerDto.getPersonalId()).thenReturn(8);


        // when
        CustomerDto customerDtoActual = customerService.read(customerId);
        verify(customerDao, times(1)).read(anyInt());

        // then
        assertEquals(customerDtoExpected.getPersonalId(), customerDtoActual.getPersonalId());
        assertEquals(customerDtoExpected, customerDtoActual);
    }
}
