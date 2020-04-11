package pl.coderslab.person;

import java.time.DateTimeException;
import java.time.LocalDate;

public class PersonDto implements Comparable<PersonDto> {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String notes;
    private String birthYear;
    private String birthMonth;
    private String birthDay;
    private String updated;
    private boolean active;
    private String fullname;

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

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDate getBirthdate() {
        try {
            return LocalDate.of(Integer.parseInt(birthYear), Integer.parseInt(birthMonth), Integer.parseInt(birthDay));
        } catch (DateTimeException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Invalid date format in: dd-mm-rrrr " + birthDay + "-" + birthMonth + "-" + birthYear);
            return LocalDate.of(1,1,1);
        }
    }

    @Override
    public int compareTo(PersonDto o) {
        int result = this.fullname.compareToIgnoreCase(o.fullname);
        if(result == 0) {
            result = this.birthYear.compareToIgnoreCase(o.birthYear);
        }
        if(result == 0) {
            result = this.birthMonth.compareToIgnoreCase(o.birthMonth);
        }
        if(result == 0) {
            result = this.birthDay.compareToIgnoreCase(o.birthDay);
        }
        return result;
    }
}
