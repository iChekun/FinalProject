package by.epam.chekun.domain.entity.user;

import java.io.Serializable;
import java.util.Objects;

public class Contacts implements Serializable {
    private static final long serialVersionUID = 1L;

    private String contactsId;
    private String email;
    private long phoneNumber;
    private Address address;

    public Contacts() {
    }

    public Contacts(String contactsId, Address address, String email, long phoneNumber) {
        this.contactsId = contactsId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Address getAddress() {
        return address;
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

    public void setContactsId(String contactsId) {
        this.contactsId = contactsId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts contacts = (Contacts) o;
        return phoneNumber == contacts.phoneNumber &&
                Objects.equals(contactsId, contacts.contactsId) &&
                Objects.equals(email, contacts.email) &&
                Objects.equals(address, contacts.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactsId, email, phoneNumber, address);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "contactsId='" + contactsId + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address=" + address +
                '}';
    }
}
