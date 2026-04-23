import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // Valid contact creation
    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("1234567890", "Sydney", "Brown", "2055551234", "123 Main St Birmingham");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Sydney", contact.getFirstName());
        assertEquals("Brown", contact.getLastName());
        assertEquals("2055551234", contact.getPhone());
        assertEquals("123 Main St Birmingham", contact.getAddress());
    }

    // Contact ID cannot be null
    @Test
    public void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(null, "Sydney", "Brown", "2055551234", "123 Main St Birmingham"));
    }

    // Contact ID cannot be longer than 10 characters
    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345678901", "Sydney", "Brown", "2055551234", "123 Main St Birmingham"));
    }

    // Contact ID cannot be updated (final field - verified via no setter)
    @Test
    public void testContactIdNotUpdatable() {
        Contact contact = new Contact("ABC123", "Sydney", "Brown", "2055551234", "123 Main St Birmingham");
        assertEquals("ABC123", contact.getContactId());
    }

    // First name cannot be null
    @Test
    public void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ABC123", null, "Brown", "2055551234", "123 Main St Birmingham"));
    }

    // First name cannot be longer than 10 characters
    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ABC123", "Abcdefghijk", "Brown", "2055551234", "123 Main St Birmingham"));
    }

    // Last name cannot be null
    @Test
    public void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ABC123", "Sydney", null, "2055551234", "123 Main St Birmingham"));
    }

    // Last name cannot be longer than 10 characters
    @Test
    public void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ABC123", "Sydney", "Abcdefghijk", "2055551234", "123 Main St Birmingham"));
    }

    // Phone cannot be null
    @Test
    public void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ABC123", "Sydney", "Brown", null, "123 Main St Birmingham"));
    }

    // Phone must be exactly 10 digits
    @Test
    public void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ABC123", "Sydney", "Brown", "205555", "123 Main St Birmingham"));
    }

    @Test
    public void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ABC123", "Sydney", "Brown", "20555512345", "123 Main St Birmingham"));
    }

    // Address cannot be null
    @Test
    public void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ABC123", "Sydney", "Brown", "2055551234", null));
    }

    // Address cannot be longer than 30 characters
    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ABC123", "Sydney", "Brown", "2055551234", "1234 Very Long Address Street Name Here"));
    }

    // Setters work correctly
    @Test
    public void testSetFirstName() {
        Contact contact = new Contact("ABC123", "Sydney", "Brown", "2055551234", "123 Main St Birmingham");
        contact.setFirstName("Sara");
        assertEquals("Sara", contact.getFirstName());
    }

    @Test
    public void testSetLastName() {
        Contact contact = new Contact("ABC123", "Sydney", "Brown", "2055551234", "123 Main St Birmingham");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testSetPhone() {
        Contact contact = new Contact("ABC123", "Sydney", "Brown", "2055551234", "123 Main St Birmingham");
        contact.setPhone("9995554321");
        assertEquals("9995554321", contact.getPhone());
    }

    @Test
    public void testSetAddress() {
        Contact contact = new Contact("ABC123", "Sydney", "Brown", "2055551234", "123 Main St Birmingham");
        contact.setAddress("456 New Ave");
        assertEquals("456 New Ave", contact.getAddress());
    }
}
