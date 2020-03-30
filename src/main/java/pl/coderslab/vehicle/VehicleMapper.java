package pl.coderslab.vehicle;

import pl.coderslab.car.*;
import pl.coderslab.commons.EntityDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.customer.*;

public class VehicleMapper implements MapperInterface<VehicleDto, Vehicle, VehicleEntity> {

    private static final EntityDao<CarEntity> CAR_DAO = new CarDaoImpl();
    private static final MapperInterface<CarDto, Car, CarEntity> CAR_MAPPER = new CarMapper();
    private static final EntityDao<CustomerEntity> CUSTOMER_DAO = new CustomerDaoImpl();
    private static final MapperInterface<CustomerDto, Customer, CustomerEntity> CUSTOMER_MAPPER = new CustomerMapper();

    @Override
    public VehicleDto mapServiceToDto(Vehicle vehicle) {

        return null;
    }

    @Override
    public Vehicle mapDtoToService(VehicleDto dto) {
        return null;
    }

    @Override
    public VehicleEntity mapServiceToEntity(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle mapEntityToService(VehicleEntity entity) {
        return null;
    }
}
