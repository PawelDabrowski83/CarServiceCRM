package pl.coderslab.labor;

import pl.coderslab.employee.Employee;
import pl.coderslab.vehicle.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class Labor implements Comparable<Labor>{

    // messages for getVehicleSignature
    protected static final String VEHICLE_PLACEHOLDER = "";
    protected static final String VEHICLE_REGISTRY_PLATE_PLACEHOLDER = "";

    // messages for getCustomerFullname
    protected static final String PERSON_FULLNAME_PLACEHOLDER = "";

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

    public Labor() {
    }

    protected Labor(int laborId, LocalDate registrationDate, LocalDate scheduledDate, LocalDate startedDate, LocalDate finishedDate, Employee employee, String descriptionIssue, String descriptionService, StatusEnum status, Vehicle vehicle, double customerCost, double materialCost, int mhTotal, LocalDateTime created, LocalDateTime updated, boolean active) {
        this.laborId = laborId;
        this.registrationDate = registrationDate;
        this.scheduledDate = scheduledDate;
        this.startedDate = startedDate;
        this.finishedDate = finishedDate;
        this.employee = employee;
        this.descriptionIssue = descriptionIssue;
        this.descriptionService = descriptionService;
        this.status = status;
        this.vehicle = vehicle;
        this.customerCost = customerCost;
        this.materialCost = materialCost;
        this.mhTotal = mhTotal;
        this.created = created;
        this.updated = updated;
        this.active = active;
    }

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
        StringBuilder builder = new StringBuilder();
        if (employee != null && employee.getPerson() != null && employee.getPerson().getFullname() != null) {
            builder.append(employee.getPerson().getFullname());
        } else {
            builder.append(PERSON_FULLNAME_PLACEHOLDER);
        }
        return builder.toString().trim();
    }

    public String getCustomerFullname() {
        StringBuilder builder = new StringBuilder();
        if (vehicle != null && vehicle.getOwner() != null && vehicle.getOwner().getPerson() != null && vehicle.getOwner().getPerson().getFullname() != null) {
            builder.append(vehicle.getOwner().getPerson().getFullname());
        } else {
            builder.append(PERSON_FULLNAME_PLACEHOLDER);
        }
        return builder.toString().trim();
    }

    public String getVehicleSignature() {
        StringBuilder builder = new StringBuilder();
        if (vehicle != null && vehicle.getCar() != null) {
            builder.append(vehicle.getCar().getCarSignature());
        } else {
            builder.append(VEHICLE_PLACEHOLDER);
        }
        builder.append(" ");
        if (vehicle != null && vehicle.getRegistryPlate() != null) {
            builder.append(vehicle.getRegistryPlate());
        } else {
            builder.append(VEHICLE_REGISTRY_PLATE_PLACEHOLDER);
        }

        return builder.toString().trim();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Labor)) return false;
        Labor labor = (Labor) o;
        return getRegistrationDate().equals(labor.getRegistrationDate()) &&
                getScheduledDate().equals(labor.getScheduledDate()) &&
                getEmployee().equals(labor.getEmployee()) &&
                getVehicle().equals(labor.getVehicle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegistrationDate(), getScheduledDate(), getEmployee(), getVehicle());
    }

    @Override
    public int compareTo(Labor o) {
        int result = 0;
        if (this.getRegistrationDate() != null && o.getRegistrationDate() != null) {
            result = this.getRegistrationDate().compareTo(o.getRegistrationDate());
        }
        if (result == 0 && this.getScheduledDate() != null && o.getScheduledDate() != null) {
            result = this.getScheduledDate().compareTo(o.getScheduledDate());
        }
        if (result == 0 && this.employee != null && o.employee != null) {
            result = this.employee.compareTo(o.employee);
        }
        if (result == 0 && this.vehicle != null &&) {

        }
        return result;
    }

    @Override
    public String toString() {
        return "Labor{" +
                "laborId=" + laborId +
                ", registrationDate=" + registrationDate +
                ", scheduledDate=" + scheduledDate +
                ", startedDate=" + startedDate +
                ", finishedDate=" + finishedDate +
                ", employee=" + employee +
                ", descriptionIssue='" + descriptionIssue + '\'' +
                ", descriptionService='" + descriptionService + '\'' +
                ", status=" + status +
                ", vehicle=" + vehicle +
                ", customerCost=" + customerCost +
                ", materialCost=" + materialCost +
                ", mhTotal=" + mhTotal +
                ", created=" + created +
                ", updated=" + updated +
                ", active=" + active +
                '}';
    }
}
