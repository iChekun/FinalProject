package by.epam.chekun.domain.util.builder.user.impl;

import by.epam.chekun.domain.entity.user.Address;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddressBuilderImplTest {

    private AddressBuilderImpl builder = new AddressBuilderImpl();
    private AddressBuilderImpl readyBuilder = new AddressBuilderImpl();


    @Test
    public void init() {
        readyBuilder.withCountry("country")
                .withStreet("street")
                .withCity("city")
                .withApartmentNumber(191)
                .withHouseNumber(52);
    }

    @Test
    public void testWithCountry() {
        builder.withCountry("country");

        assertEquals(builder.getCountry(), readyBuilder.getCountry());
    }

    @Test
    public void testWithCity() {
        builder.withCity("city");

        assertEquals(builder.getCity(), readyBuilder.getCity());
    }

    @Test
    public void testWithStreet() {
        builder.withStreet("street");

        assertEquals(builder.getStreet(), readyBuilder.getStreet());
    }

    @Test
    public void testWithHouseNumber() {
        builder.withHouseNumber(52);

        assertEquals(builder.getHouseNumber(), readyBuilder.getHouseNumber());
    }

    @Test
    public void testWithApartmentNumber() {
        builder.withApartmentNumber(191);

        assertEquals(builder.getApartmentNumber(), readyBuilder.getApartmentNumber());
    }

    @Test
    public void testBuild() {
        Address address = new Address();
        address.setCountry("country");
        address.setCity("city");
        address.setStreet("street");
        address.setApartmentNumber(191);
        address.setHouseNumber(52);

        Address result = readyBuilder.build();

        assertEquals(result, address);
    }
}