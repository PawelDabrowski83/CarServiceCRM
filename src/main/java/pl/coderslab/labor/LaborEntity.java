package pl.coderslab.labor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class LaborEntity {

    private int laborId;
    private LocalDate registrationDate;
    private LocalDate scheduledDate;
    private LocalDate startedDate;
    private LocalDate finishedDate;
    private int employeeId;
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
    private int vehicleId;
    private double customerCost;
    private double materialCost;
    private int mhTotal;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active;

    public LaborEntity() {
    }

    protected LaborEntity(int laborId, LocalDate registrationDate, LocalDate scheduledDate, LocalDate startedDate, LocalDate finishedDate, int employeeId, String descriptionIssue, String descriptionService, StatusEnum status, int vehicleId, double customerCost, double materialCost, int mhTotal, LocalDateTime created, LocalDateTime updated, boolean active) {
        this.laborId = laborId;
        this.registrationDate = registrationDate;
        this.scheduledDate = scheduledDate;
        this.startedDate = startedDate;
        this.finishedDate = finishedDate;
        this.employeeId = employeeId;
        this.descriptionIssue = descriptionIssue;
        this.descriptionService = descriptionService;
        this.status = status;
        this.vehicleId = vehicleId;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LaborEntity)) return false;
        LaborEntity that = (LaborEntity) o;
        return getEmployeeId() == that.getEmployeeId() &&
                getVehicleId() == that.getVehicleId() &&
                Double.compare(that.getCustomerCost(), getCustomerCost()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getVehicleId(), getCustomerCost());
    }

    @Override
    public String toString() {
        return "LaborEntity{" +
                "laborId=" + laborId +
                ", registrationDate=" + registrationDate +
                ", scheduledDate=" + scheduledDate +
                ", startedDate=" + startedDate +
                ", finishedDate=" + finishedDate +
                ", employeeId=" + employeeId +
                ", descriptionIssue='" + descriptionIssue + '\'' +
                ", descriptionService='" + descriptionService + '\'' +
                ", status=" + status +
                ", vehicleId=" + vehicleId +
                ", customerCost=" + customerCost +
                ", materialCost=" + materialCost +
                ", mhTotal=" + mhTotal +
                ", created=" + created +
                ", updated=" + updated +
                ", active=" + active +
                '}';
    }
}
