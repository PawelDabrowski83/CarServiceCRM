package pl.coderslab.customer;

import java.util.Objects;

public class CustomerDto implements Comparable<CustomerDto> {

    private int customerId;
    private int personalId;
    private String fullname;

    public CustomerDto() {
    }

    protected CustomerDto(int customerId, int personalId, String fullname) {
        this.customerId = customerId;
        this.personalId = personalId;
        this.fullname = fullname;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public int compareTo(CustomerDto o) {
        int result = 0;
        if (this.fullname != null && o.fullname != null) {
            result = this.fullname.compareToIgnoreCase(o.fullname);
        }
        if (result == 0 && this.personalId > 0 && o.personalId > 0) {
            result = Integer.compare(this.personalId, o.personalId);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerDto)) return false;
        CustomerDto that = (CustomerDto) o;
        return getPersonalId() == that.getPersonalId() &&
                Objects.equals(getFullname(), that.getFullname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonalId(), getFullname());
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId=" + customerId +
                ", personalId=" + personalId +
                ", fullname='" + fullname + '\'' +
                '}';
    }
}
