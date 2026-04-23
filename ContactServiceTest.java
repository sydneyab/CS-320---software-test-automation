import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    // Add a valid contact
    @Test
    public void testAddContact() {
        Contact contact = new Contact("ABC123", "Sydney", "Brown", "2055551234", "123 Main St Birmingham");
        service.addContact(contact);
        assertEquals("Sydney", service.getContact("ABC123").getFirstName());
    }

    // Cannot add duplicate contact ID
    @Test
    public void testAddDuplicateContact() {
        Contact contact1 = new Contact("ABC123", "Sydney", "Brown", "2055551234", "123 Main St Birmingham");
        Contact contact2 = new Contact("ABC123", "Sara", "Smith", "9995554321", "456 New Ave");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    // Cannot add null contact
    @Test
    public void testAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    // Delete a contact
    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("ABC123", "Sydney", "Brown", "2055551234", "123 Main St Birmingham");
        service.addContact(contact);
        service.deleteContact("ABC123");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("ABC123"));
    }

    // Cannot delete contact that does not exist
    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("NOTREAL"));
    }

    // Update first name
    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("ABC123", "Sydney", "Brown", "2055551234", "123 Main St Birmingham");
        service.addContact(contact);
        service.updateFirstName("ABC123", "Sara");
        assertEquals("Sara", service.getContact("ABC123").getFirstName());
    }

    // Update last name
    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("ABC123", "Sydney", "Brown", "2055551234", "123 Main St Birmingham");
        service.addContact(contact);
        service.updateLastName("ABC123", "Smith");
        assertEquals("Smith", service.getContact("ABC123").getLastName());
    }

    // Update phone
    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("ABC123", "Sydney", "Brown", "2055551234", "123 Main St Birmingham");
        service.addContact(contact);
        service.updatePhone("ABC123", "9995554321");
        assertEquals("9995554321", service.getContact("ABC123").getPhone());
    }

    // Update address
    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("ABC123", "Sydney", "Brown", "2055551234", "123 Main St Birmingham");
        service.addContact(contact);
        service.updateAddress("ABC123", "456 New Ave");
        assertEquals("456 New Ave", service.getContact("ABC123").getAddress());
    }

    // Cannot update contact that does not exist
    @Test
    public void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("NOTREAL", "Sara"));
    }

    // Cannot update first name to null
    @Test
    public void testUpdateFirstNameNull() {
        Contact contact = new Contact("ABC123", "Sydney", "Brown", "2055551234", "123 Main St Birmingham");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("ABC123", null));
    }

    // Cannot update phone to invalid length
    @Test
    public void testUpdatePhoneInvalid() {
        Contact contact = new Contact("ABC123", "Sydney", "Brown", "2055551234", "123 Main St Birmingham");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("ABC123", "123"));
    }
}
