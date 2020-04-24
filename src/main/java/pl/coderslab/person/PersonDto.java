package pl.coderslab.person;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

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
    private String fullname;

    public PersonDto() {
    }

    protected PersonDto(String birthYear, String birthMonth, String birthDay) {
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }

    public PersonDto(int id, String firstName, String lastName, String address, String phone, String notes, String birthYear, String birthMonth, String birthDay, String fullname) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.notes = notes;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.fullname = fullname;
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
//        if (this.birthDay != null) {
            if (result == 0) {
                result = this.birthYear.compareToIgnoreCase(o.birthYear);
            }
            if (result == 0) {
                result = this.birthMonth.compareToIgnoreCase(o.birthMonth);
            }
            if (result == 0) {
                result = this.birthDay.compareToIgnoreCase(o.birthDay);
            }
//        }
        return result;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", notes='" + notes + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", birthMonth='" + birthMonth + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDto)) return false;
        PersonDto personDto = (PersonDto) o;
        return getFirstName().equals(personDto.getFirstName()) &&
                getLastName().equals(personDto.getLastName()) &&
                getBirthYear().equals(personDto.getBirthYear()) &&
                getBirthMonth().equals(personDto.getBirthMonth()) &&
                getBirthDay().equals(personDto.getBirthDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAddress(), getPhone(), getBirthYear(), getBirthMonth(), getBirthDay());
    }
}
