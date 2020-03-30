package pl.coderslab.person;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person implements Comparable<Person>{

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
        return lastName + " " + firstName;
    }

    public String getBirthYear() {
        return Integer.toString(this.birthdate.getYear());
    }

    public String getBirthMonth() {
        return Integer.toString(this.birthdate.getMonthValue());
    }

    public String getBirthDay() {
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
}
