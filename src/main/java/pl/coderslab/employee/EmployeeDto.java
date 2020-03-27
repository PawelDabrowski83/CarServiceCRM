package pl.coderslab.employee;


public class EmployeeDto implements Comparable<EmployeeDto>{

    private int employeeId;
    private int personId;
    private double mhCost;
    private String updated;
    private String fullname;

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
}
