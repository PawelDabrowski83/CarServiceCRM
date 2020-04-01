package pl.coderslab.labor;

import pl.coderslab.employee.Employee;
import pl.coderslab.vehicle.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Labor {

    private int laborId;
    private LocalDate registrationDate;
    private LocalDate scheduledDate;
    private LocalDate startedDate;
    private LocalDate finishedDate;
    private Employee employee;
    private String descriptionIssue;
    private String descriptionService;
    private StatusEnum status;
    protected enum StatusEnum {
        BACKLOG,
        COST_ESTIMATION_ACCEPTED,
        QUEUE,
        IN_PROGRESS,
        READY_FOR_COLLECTION,
        CANCELLED
    };
    private Vehicle vehicle;
    private double customerCost;
    private double materialCost;
    private int mhTotal;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active;

    public int getLaborId() {
        return laborId;
    }

    public void setLaborId(int laborId) {
        this.laborId = laborId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public LocalDate getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(LocalDate startedDate) {
        this.startedDate = startedDate;
    }

    public LocalDate getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(LocalDate finishedDate) {
        this.finishedDate = finishedDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDescriptionIssue() {
        return descriptionIssue;
    }

    public void setDescriptionIssue(String descriptionIssue) {
        this.descriptionIssue = descriptionIssue;
    }

    public String getDescriptionService() {
        return descriptionService;
    }

    public void setDescriptionService(String descriptionService) {
        this.descriptionService = descriptionService;
    }

    public String getStatus() {
        return status.toString();
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getCustomerCost() {
        return customerCost;
    }

    public void setCustomerCost(double customerCost) {
        this.customerCost = customerCost;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    public int getMhTotal() {
        return mhTotal;
    }

    public void setMhTotal(int mhTotal) {
        this.mhTotal = mhTotal;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmployeeFullname() {
        return employee.getPerson().getFullname();
    }

    public String getVehicleSignature() {
        return vehicle.getCar().getCarSignature() + " " + vehicle.getRegistryPlate();
    }
}
