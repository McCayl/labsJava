package humanity;

import java.time.LocalDate;

public class Person {
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private Address address;

    public Person(String lastName, String firstName, LocalDate birthDate, Address address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + ", дата рождения: " + birthDate + ", адрес: " + address;
    }
}
