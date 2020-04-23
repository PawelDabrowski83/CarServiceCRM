package pl.coderslab.employee;


import java.util.Objects;

public class EmployeeDto implements Comparable<EmployeeDto>{

    private int employeeId;
    private int personId;
    private double mhCost;
    private String fullname;

    public EmployeeDto() {
    }

    protected EmployeeDto(int employeeId, int personId, double mhCost, String fullname) {
        this.employeeId = employeeId;
        this.personId = personId;
        this.mhCost = mhCost;
        this.fullname = fullname;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public int compareTo(EmployeeDto o) {
        return this.fullname.compareToIgnoreCase(o.fullname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDto)) return false;
        EmployeeDto that = (EmployeeDto) o;
        return getFullname().equals(that.getFullname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullname());
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "employeeId=" + employeeId +
                ", personId=" + personId +
                ", mhCost=" + mhCost +
                ", fullname='" + fullname + '\'' +
                '}';
    }
}
