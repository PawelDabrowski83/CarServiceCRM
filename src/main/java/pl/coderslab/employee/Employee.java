package pl.coderslab.employee;

import pl.coderslab.person.Person;

import java.time.LocalDateTime;
import java.util.Objects;

public class Employee implements Comparable<Employee> {

    private int employeeId;
    private Person person;
    private double mhCost;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active;

    public Employee() {
    }

    protected Employee(int employeeId, Person person, double mhCost, LocalDateTime created, LocalDateTime updated, boolean active) {
        this.employeeId = employeeId;
        this.person = person;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
    public int compareTo(Employee o) {
        return this.person.compareTo(o.person);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getPerson().equals(employee.getPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPerson());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", person=" + person +
                ", mhCost=" + mhCost +
                ", created=" + created +
                ", updated=" + updated +
                ", active=" + active +
                '}';
    }
}
