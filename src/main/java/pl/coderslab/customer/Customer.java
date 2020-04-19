package pl.coderslab.customer;

import pl.coderslab.person.Person;

import java.time.LocalDateTime;
import java.util.Objects;

public class Customer implements Comparable<Customer>{

    private int customerId;
    private Person person;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active;

    public Customer() {
    }

    protected Customer(int customerId, Person person, LocalDateTime created, LocalDateTime updated, boolean active) {
        this.customerId = customerId;
        this.person = person;
        this.created = created;
        this.updated = updated;
        this.active = active;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
    public int compareTo(Customer o) {
        int result = 0;
        if (this.person != null && o.person != null) {
            result = this.person.compareTo(o.person);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", person=" + person +
                ", created=" + created +
                ", updated=" + updated +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getPerson().equals(customer.getPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPerson());
    }
}
