package by.epam.chekun.domain.util.builder.user;

import by.epam.chekun.domain.entity.user.Address;
import by.epam.chekun.domain.entity.user.Contacts;

public interface ContactsBuilder {

    ContactsBuilder withEmail(String email);

    ContactsBuilder withPhoneNumber(long phoneNumber);

    ContactsBuilder withAddress(Address address);

    Contacts build();
}
