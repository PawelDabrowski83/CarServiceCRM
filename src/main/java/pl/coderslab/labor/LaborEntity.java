package pl.coderslab.labor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LaborEntity {

    private int laborId;
    private LocalDate registrationDate;
    private LocalDate scheduledDate;
    private LocalDate startedDate;
    private LocalDate finishedDate;
    private int employeeId;
    private String descriptionIssue;
    private String descriptionService;
    private Status status;
    private enum Status {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
}
