package pl.coderslab.labor;

import java.time.LocalDate;

public class LaborDto implements Comparable<LaborDto>{

    private int laborId;
    private LocalDate registrationDate;
    private LocalDate scheduledDate;
    private LocalDate startedDate;
    private LocalDate finishedDate;
    private int employeeId;
    private String employeeFullname;
    private String descriptionIssue;
    private String descriptionService;
    private String status;
    private int vehicleId;
    private String vehicleSignature;
    private double customerCost;
    private double materialCost;
    private int mhTotal;

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

    public String getEmployeeFullname() {
        return employeeFullname;
    }

    public void setEmployeeFullname(String employeeFullname) {
        this.employeeFullname = employeeFullname;
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
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleSignature() {
        return vehicleSignature;
    }

    public void setVehicleSignature(String vehicleSignature) {
        this.vehicleSignature = vehicleSignature;
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

    @Override
    public int compareTo(LaborDto o) {
        int result = this.registrationDate.compareTo(o.registrationDate);
        if (result == 0) {
            result = this.scheduledDate.compareTo(o.scheduledDate);
        }
        if (result == 0) {
            result = this.vehicleSignature.compareToIgnoreCase(o.vehicleSignature);
        }
        return result;
    }
}
