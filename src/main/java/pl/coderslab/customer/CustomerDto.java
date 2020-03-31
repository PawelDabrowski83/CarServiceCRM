package pl.coderslab.customer;

public class CustomerDto implements Comparable<CustomerDto> {

    private int customerId;
    private int personalId;
    private String fullname;

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
        return this.fullname.compareToIgnoreCase(o.fullname);
    }
}
