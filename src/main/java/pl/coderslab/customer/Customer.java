package pl.coderslab.customer;

import pl.coderslab.person.Person;

import java.time.LocalDateTime;

public class Customer implements Comparable<Customer>{

    private int customerId;
    private Person person;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active;

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
        return this.person.compareTo(o.person);
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
}
