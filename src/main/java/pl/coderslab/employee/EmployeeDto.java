package pl.coderslab.employee;

import java.time.LocalDateTime;

public class EmployeeDto {

    private int employeeId;
    private int personId;
    private double mhCost;
    private String updated;
    private boolean active = true;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public double getMhCost() {
        return mhCost;
    }

    public void setMhCost(double mhCost) {
        this.mhCost = mhCost;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
