package by.epam.chekun.domain.util.builder.user;

import by.epam.chekun.domain.entity.user.Address;

public interface AddressBuilder {

    AddressBuilder withCountry(String country);

    AddressBuilder withCity(String city);

    AddressBuilder withStreet(String street);

    AddressBuilder withHouseNumber(int houseNumber);

    AddressBuilder withApartmentNumber(int apartmentNumber);

    Address build();
}
