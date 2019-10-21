package by.epam.chekun.domain.util.builder.user.impl;

import by.epam.chekun.domain.entity.user.Address;
import by.epam.chekun.domain.util.builder.user.AddressBuilder;

public class AddressBuilderImpl implements AddressBuilder {

    private String country;
    private String city;
    private String street;
    private int houseNumber;
    private int apartmentNumber;

    public AddressBuilderImpl() {
    }

    @Override
    public AddressBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    @Override
    public AddressBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    @Override
    public AddressBuilder withStreet(String street) {
        this.street = street;
        return this;
    }

    @Override
    public AddressBuilder withHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    @Override
    public AddressBuilder withApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
        return this;
    }

    @Override
    public Address build() {
        Address address = new Address(country, city, street, houseNumber, apartmentNumber);
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }
}
