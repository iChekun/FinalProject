package by.epam.chekun.domain.util.builder.user.impl;

import by.epam.chekun.domain.entity.user.Address;
import by.epam.chekun.domain.entity.user.Contacts;
import by.epam.chekun.domain.util.builder.user.ContactsBuilder;

public class ContactsBuilderImpl implements ContactsBuilder {

    private String contactsId;
    private String email;
    private long phoneNumber;
    private Address address;

    public ContactsBuilderImpl() {
        this.contactsId = "";
    }

    public ContactsBuilderImpl(String contactsId) {
        this.contactsId = contactsId;
    }

    @Override
    public ContactsBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public ContactsBuilder withPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public ContactsBuilder withAddress(Address address) {
        this.address = address;
        return this;
    }

    @Override
    public Contacts build() {
        Contacts contacts = new Contacts();
        contacts.setContactsId(contactsId);
        contacts.setAddress(address);
        contacts.setEmail(email);
        contacts.setPhoneNumber(phoneNumber);
        return contacts;
    }

    public String getContactsId() {
        return contactsId;
    }

    public String getEmail() {
        return email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }
}
