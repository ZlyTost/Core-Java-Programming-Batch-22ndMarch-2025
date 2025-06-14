package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Contact Management System: 
Create classes for Contact, AddressBook, and User8. 
Implement methods for adding, removing, and searching contacts.
*/

// Class representing a Phone Number
class PhoneNumber {
    private String type; // e.g., "Mobile", "Home", "Work"
    private String number;

    public PhoneNumber(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return type + ": " + number;
    }
}

// Class representing an Email
class Email {
    private String emailAddress;

    public Email(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return emailAddress;
    }
}

// Class representing a Contact
class Contact {
    private String name;
    private List<PhoneNumber> phoneNumbers;
    private List<Email> emails;

    public Contact(String name) {
        this.name = name;
        this.phoneNumbers = new ArrayList<>();
        this.emails = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    public void addEmail(Email email) {
        emails.add(email);
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public List<Email> getEmails() {
        return emails;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", emails=" + emails +
                '}';
    }
}

// Class representing an Address Book
class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added: " + contact.getName());
    }

    public void removeContact(String name) {
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
        System.out.println("Contact removed: " + name);
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null; // Contact not found
    }

    public void displayContacts() {
        System.out.println("Contacts in Address Book:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}

// Class representing a User8
class User8 {
    private String User8name;
    private AddressBook addressBook;

    public User8(String User8name) {
        this.User8name = User8name;
        this.addressBook = new AddressBook();
    }

    public String getUser8name() {
        return User8name;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }
}

// Main class to run the Contact Management System
public class p3 {
    public static void main(String[] args) {
        // Create a User8
        User8 User8 = new User8("Alice");

        // Create contacts
        Contact contact1 = new Contact("Bob");
        contact1.addPhoneNumber(new PhoneNumber("Mobile", "123-456-7890"));
        contact1.addEmail(new Email("bob@example.com"));

        Contact contact2 = new Contact("Charlie");
        contact2.addPhoneNumber(new PhoneNumber("Home", "098-765-4321"));
        contact2.addEmail(new Email("charlie@example.com"));

        // Add contacts to the User8's address book
        User8.getAddressBook().addContact(contact1);
        User8.getAddressBook().addContact(contact2);

        // Display contacts
        User8.getAddressBook().displayContacts();

        // Search for a contact
        Contact foundContact = User8.getAddressBook().searchContact("Bob");
        if (foundContact != null) {
            System.out.println("Found Contact: " + foundContact);
        } else {
            System.out.println("Contact not found.");
        }

        // Remove a contact
        User8.getAddressBook().removeContact("Charlie");

        // Display contacts after removal
        User8.getAddressBook().displayContacts();
    }
}
