package pl.coderslab.labor;

import java.time.LocalDate;
import java.util.Objects;

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
    private String customerFullname;

    public LaborDto() {
    }

    protected LaborDto(int laborId, LocalDate registrationDate, LocalDate scheduledDate, LocalDate startedDate, LocalDate finishedDate, int employeeId, String employeeFullname, String descriptionIssue, String descriptionService, String status, int vehicleId, String vehicleSignature, double customerCost, double materialCost, int mhTotal, String customerFullname) {
        this.laborId = laborId;
        this.registrationDate = registrationDate;
        this.scheduledDate = scheduledDate;
        this.startedDate = startedDate;
        this.finishedDate = finishedDate;
        this.employeeId = employeeId;
        this.employeeFullname = employeeFullname;
        this.descriptionIssue = descriptionIssue;
        this.descriptionService = descriptionService;
        this.status = status;
        this.vehicleId = vehicleId;
        this.vehicleSignature = vehicleSignature;
        this.customerCost = customerCost;
        this.materialCost = materialCost;
        this.mhTotal = mhTotal;
        this.customerFullname = customerFullname;
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

    public String getCustomerFullname() {
        return customerFullname;
    }

    public void setCustomerFullname(String customerFullname) {
        this.customerFullname = customerFullname;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LaborDto)) return false;
        LaborDto laborDto = (LaborDto) o;
        return getRegistrationDate().equals(laborDto.getRegistrationDate()) &&
                getScheduledDate().equals(laborDto.getScheduledDate()) &&
                getVehicleSignature().equals(laborDto.getVehicleSignature());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegistrationDate(), getScheduledDate(), getVehicleSignature());
    }

    @Override
    public String toString() {
        return "LaborDto{" +
                "laborId=" + laborId +
                ", registrationDate=" + registrationDate +
                ", scheduledDate=" + scheduledDate +
                ", startedDate=" + startedDate +
                ", finishedDate=" + finishedDate +
                ", employeeId=" + employeeId +
                ", employeeFullname='" + employeeFullname + '\'' +
                ", descriptionIssue='" + descriptionIssue + '\'' +
                ", descriptionService='" + descriptionService + '\'' +
                ", status='" + status + '\'' +
                ", vehicleId=" + vehicleId +
                ", vehicleSignature='" + vehicleSignature + '\'' +
                ", customerCost=" + customerCost +
                ", materialCost=" + materialCost +
                ", mhTotal=" + mhTotal +
                ", customerFullname='" + customerFullname + '\'' +
                '}';
    }
}
