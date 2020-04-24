package pl.coderslab.employee;

import java.time.LocalDateTime;
import java.util.Objects;

public class EmployeeEntity {

    private int employeeId;
    private int personId;
    private double mhCost; // man-hour
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active;

    public EmployeeEntity() {
    }

    protected EmployeeEntity(int employeeId, int personId, double mhCost, LocalDateTime created, LocalDateTime updated, boolean active) {
        this.employeeId = employeeId;
        this.personId = personId;
        this.mhCost = mhCost;
        this.created = created;
        this.updated = updated;
        this.active = active;
    }

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
        if (!(o instanceof EmployeeEntity)) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return getPersonId() == that.getPersonId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonId());
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "employeeId=" + employeeId +
                ", personId=" + personId +
                ", mhCost=" + mhCost +
                ", created=" + created +
                ", updated=" + updated +
                ", active=" + active +
                '}';
    }
}
