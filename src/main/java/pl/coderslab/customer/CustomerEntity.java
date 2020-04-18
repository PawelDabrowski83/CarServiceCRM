package pl.coderslab.customer;

import java.time.LocalDateTime;
import java.util.Objects;

public class CustomerEntity {

    private int customerId;
    private int personalId;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active;

    public CustomerEntity() {
    }

    protected CustomerEntity(int customerId, int personalId, LocalDateTime created, LocalDateTime updated, boolean active) {
        this.customerId = customerId;
        this.personalId = personalId;
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

    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
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
        if (!(o instanceof CustomerEntity)) return false;
        CustomerEntity entity = (CustomerEntity) o;
        return getPersonalId() == entity.getPersonalId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonalId());
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "customerId=" + customerId +
                ", personalId=" + personalId +
                ", created=" + created +
                ", updated=" + updated +
                ", active=" + active +
                '}';
    }
}
