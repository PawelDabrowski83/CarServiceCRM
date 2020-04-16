package pl.coderslab.person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Person implements Comparable<Person>{

    protected static final String FIRSTNAME_PLACEHOLDER = "";
    protected static final String LASTNAME_PLACEHOLDER = "";

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

    public Person() {
    }

    protected Person(int id, String firstName, String lastName, String address, String phone, String notes, LocalDate birthdate, LocalDateTime created, LocalDateTime updated, boolean active) {
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

    protected Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getFullname () {
        StringBuilder builder = new StringBuilder();
        if (lastName == null || lastName.trim().isEmpty()) {
            builder.append(LASTNAME_PLACEHOLDER);
        } else {
            builder.append(lastName.trim());
        }
        builder.append(" ");
        if (firstName == null || firstName.trim().isEmpty()) {
            builder.append(FIRSTNAME_PLACEHOLDER);
        } else {
            builder.append(firstName.trim());
        }

        return builder.toString().trim();
    }

    public String getBirthYear() {
        if (birthdate == null) {
            return "";
        }
        return Integer.toString(this.birthdate.getYear());
    }

    public String getBirthMonth() {
        if (birthdate == null) {
            return "";
        }
        return Integer.toString(this.birthdate.getMonthValue());
    }

    public String getBirthDay() {
        if (birthdate == null) {
            return "";
        }
        return Integer.toString(this.birthdate.getDayOfMonth());
    }

    @Override
    public int compareTo(Person o) {
        int result = this.lastName.compareToIgnoreCase(o.lastName);
        if(result == 0) {
            result = this.firstName.compareToIgnoreCase(o.firstName);
        }
        if(result == 0) {
            result = this.birthdate.compareTo(o.birthdate);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getFirstName().equals(person.getFirstName()) &&
                getLastName().equals(person.getLastName()) &&
                Objects.equals(getAddress(), person.getAddress()) &&
                getPhone().equals(person.getPhone()) &&
                getBirthdate().equals(person.getBirthdate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAddress(), getPhone(), getBirthdate());
    }

    @Override
    public String toString() {
        return "Person{" +
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
}
