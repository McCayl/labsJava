package humanity;

public class Address {
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String city;

    public Address(String street, String houseNumber, String apartmentNumber, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return street + ", " + houseNumber + ", кв. " + apartmentNumber + ", " + city;
    }
}
