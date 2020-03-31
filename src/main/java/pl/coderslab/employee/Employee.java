package pl.coderslab.employee;

import pl.coderslab.person.Person;

import java.time.LocalDateTime;

public class Employee implements Comparable<Employee> {

    private int employeeId;
    private Person person;
    private double mhCost;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active = true;

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
}
