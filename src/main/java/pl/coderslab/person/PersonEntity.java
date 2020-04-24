package pl.coderslab.person;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class PersonEntity implements Comparable<PersonEntity> {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String notes;
    private LocalDate birthdate;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active;

    public PersonEntity() {
    }

    protected PersonEntity(int id, String firstName, String lastName, String address, String phone, String notes, LocalDate birthdate, LocalDateTime created, LocalDateTime updated, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.notes = notes;
        this.birthdate = birthdate;
        this.created = created;
        this.updated = updated;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
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
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", notes='" + notes + '\'' +
                ", birthdate=" + birthdate +
                ", created=" + created +
                ", updated=" + updated +
                ", active=" + active +
                '}';
    }

    @Override
    public int compareTo(PersonEntity o) {
        int result = this.lastName.compareToIgnoreCase(o.lastName);
        if (result == 0) {
            result = this.firstName.compareToIgnoreCase(o.firstName);
        }
        if (result == 0) {
            result = this.birthdate.compareTo(o.birthdate);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonEntity)) return false;
        PersonEntity that = (PersonEntity) o;
        return getFirstName().equals(that.getFirstName()) &&
                getLastName().equals(that.getLastName()) &&
                getBirthdate().equals(that.getBirthdate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getBirthdate());
    }
}
