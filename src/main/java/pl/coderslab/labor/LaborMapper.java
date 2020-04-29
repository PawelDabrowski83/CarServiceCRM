package pl.coderslab.labor;

import pl.coderslab.car.*;
import pl.coderslab.commons.GenericDao;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ServiceInterface;
import pl.coderslab.employee.Employee;
import pl.coderslab.employee.EmployeeDto;
import pl.coderslab.employee.EmployeeEntity;
import pl.coderslab.employee.EmployeeService;
import pl.coderslab.vehicle.Vehicle;
import pl.coderslab.vehicle.VehicleDto;
import pl.coderslab.vehicle.VehicleEntity;
import pl.coderslab.vehicle.VehicleService;

public class LaborMapper implements MapperInterface<LaborDto, Labor, LaborEntity> {

    private MapperInterface<EmployeeDto, Employee, EmployeeEntity> EMPLOYEE_MAPPER;
    private GenericDao<EmployeeEntity> EMPLOYEE_DAO;
    private final ServiceInterface<EmployeeDto> EMPLOYEE_SERVICE = new EmployeeService(EMPLOYEE_DAO, EMPLOYEE_MAPPER);
    private GenericDao<VehicleEntity> VEHICLE_DAO;
    private MapperInterface<VehicleDto, Vehicle, VehicleEntity> VEHICLE_MAPPER;
    private final ServiceInterface<VehicleDto> VEHICLE_SERVICE = new VehicleService(VEHICLE_DAO, VEHICLE_MAPPER);

    public LaborMapper(GenericDao<EmployeeEntity> EMPLOYEE_DAO, MapperInterface<EmployeeDto, Employee, EmployeeEntity> EMPLOYEE_MAPPER, GenericDao<VehicleEntity> VEHICLE_DAO, MapperInterface<VehicleDto, Vehicle, VehicleEntity> VEHICLE_MAPPER) {
        this.EMPLOYEE_MAPPER = EMPLOYEE_MAPPER;
        this.EMPLOYEE_DAO = EMPLOYEE_DAO;
        this.VEHICLE_DAO = VEHICLE_DAO;
        this.VEHICLE_MAPPER = VEHICLE_MAPPER;
    }

    @Override
    public LaborDto mapServiceToDto(Labor labor) {
        LaborDto dto = new LaborDto();
        dto.setLaborId(labor.getLaborId());
        dto.setRegistrationDate(labor.getRegistrationDate());
        dto.setScheduledDate(labor.getScheduledDate());
        dto.setStartedDate(labor.getStartedDate());
        dto.setFinishedDate(labor.getFinishedDate());
        dto.setEmployeeId(labor.getEmployee().getEmployeeId());
        dto.setEmployeeFullname(labor.getEmployeeFullname());
        dto.setDescriptionIssue(labor.getDescriptionIssue());
        dto.setDescriptionService(labor.getDescriptionService());
        dto.setStatus(String.valueOf(labor.getStatus()));
        dto.setVehicleId(labor.getVehicle().getVehicleId());
        dto.setVehicleSignature(labor.getVehicleSignature());
        dto.setCustomerCost(labor.getCustomerCost());
        dto.setMaterialCost(labor.getMaterialCost());
        dto.setMhTotal(labor.getMhTotal());
        dto.setCustomerFullname(labor.getCustomerFullname());
        return dto;
    }

    @Override
    public Labor mapDtoToService(LaborDto dto) {
        Labor labor = new Labor();
        labor.setLaborId(dto.getLaborId());
        labor.setRegistrationDate(dto.getRegistrationDate());
        labor.setScheduledDate(dto.getScheduledDate());
        labor.setStartedDate(dto.getStartedDate());
        labor.setFinishedDate(dto.getFinishedDate());
        labor.setEmployee(EMPLOYEE_MAPPER.mapDtoToService(EMPLOYEE_SERVICE.read(dto.getEmployeeId())));
        labor.setDescriptionIssue(dto.getDescriptionIssue());
        labor.setDescriptionService(dto.getDescriptionService());
        labor.setStatus(Labor.StatusEnum.valueOf(dto.getStatus()));
        labor.setVehicle(VEHICLE_MAPPER.mapDtoToService(VEHICLE_SERVICE.read(dto.getVehicleId())));
        labor.setCustomerCost(dto.getCustomerCost());
        labor.setMaterialCost(dto.getMaterialCost());
        labor.setMhTotal(dto.getMhTotal());
        return labor;
    }

    @Override
    public LaborEntity mapServiceToEntity(Labor labor) {
        LaborEntity entity = new LaborEntity();
        entity.setLaborId(labor.getLaborId());
        entity.setRegistrationDate(labor.getRegistrationDate());
        entity.setScheduledDate(labor.getScheduledDate());
        entity.setStartedDate(labor.getStartedDate());
        entity.setFinishedDate(labor.getFinishedDate());
        entity.setEmployeeId(labor.getEmployee().getEmployeeId());
        entity.setDescriptionIssue(labor.getDescriptionIssue());
        entity.setDescriptionService(labor.getDescriptionService());
        entity.setStatus(LaborEntity.StatusEnum.valueOf(labor.getStatus()));
        entity.setVehicleId(labor.getVehicle().getVehicleId());
        entity.setCustomerCost(labor.getCustomerCost());
        entity.setMaterialCost(labor.getMaterialCost());
        entity.setMhTotal(labor.getMhTotal());
        return entity;
    }

    @Override
    public Labor mapEntityToService(LaborEntity entity) {
        Labor labor = new Labor();
        labor.setLaborId(entity.getLaborId());
        labor.setRegistrationDate(entity.getRegistrationDate());
        labor.setScheduledDate(entity.getScheduledDate());
        labor.setStartedDate(entity.getStartedDate());
        labor.setFinishedDate(entity.getFinishedDate());
        labor.setEmployee(EMPLOYEE_MAPPER.mapDtoToService(EMPLOYEE_SERVICE.read(entity.getEmployeeId())));
        labor.setDescriptionIssue(entity.getDescriptionIssue());
        labor.setDescriptionService(entity.getDescriptionService());
        labor.setStatus(Labor.StatusEnum.valueOf(entity.getStatus()));
        labor.setVehicle(VEHICLE_MAPPER.mapDtoToService(VEHICLE_SERVICE.read(entity.getVehicleId())));
        labor.setCustomerCost(entity.getCustomerCost());
        labor.setMaterialCost(entity.getMaterialCost());
        labor.setMhTotal(entity.getMhTotal());
        return labor;
    }
}
