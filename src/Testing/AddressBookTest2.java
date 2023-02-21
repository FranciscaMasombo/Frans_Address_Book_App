package Testing;
import Main.AddressBook;
import Main.Person;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest2 {
    private static final String LS = System.lineSeparator();

    private static ArrayList<Person> address;
    private static final InputStream sysInBackup = System.in; // backup System.in to restore it later
    private static ByteArrayInputStream in; // to provide input to System.in

    @BeforeAll
    public static void init() {
        address = new ArrayList<Person>();
        Person fran = new Person("Fran","Davis","0983425629","Femail@gmail.com","2089,Marys Walk, Waterford ");
        address.add(fran);
        Person bob = new Person("Bob","Smith","0529020282","BobsEmail@gmail.com","506,Tramore Road, Dublin ");
        address.add(bob);
        Person harry = new Person("Harry","Potter","0483443249","HarryEmail@gmail.com","221,Bakers Street, London ");
        address.add(harry);
    }

    @AfterEach
    public void resetSystemIn() {
        System.setIn(sysInBackup);
    }

    @Test
    @DisplayName("Test if new person can be added")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testAddAddress() {
        ByteArrayInputStream inContent = new ByteArrayInputStream("Jane\nDoe\n0123456789\njane.doe@example.com\n123 Main St.".getBytes());
        System.setIn(inContent);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AddressBook.addAddress();
        String expectedOutput = "Currently Adding new person to Address Book:\n" +
                "First Name:\n" +
                "Last Name:\n" +
                "Phone Number:\n" +
                "Email:\n" +
                "Full Address:\n" +
                "New Person added successfully\n";
        assertEquals(expectedOutput, outContent.toString());         }
    @Test
    @DisplayName("Test if person can be deleted")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testDeleteAddress() {
        in = new ByteArrayInputStream("0529020282\n".getBytes());
        System.setIn(in);
        AddressBook.deleteAddress();
        Person deletedPerson = AddressBook.searchAddressBookByNumber("0529020282");
        assertNull(deletedPerson);
    }
    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    @DisplayName("Test search by phone number ")
    void testSearchAddressBookByNumber() {
        // Given
        AddressBook addressBook = new AddressBook();
        String phoneNumber = "0983425629";

        // When
        Person fran = AddressBook.searchAddressBookByNumber(phoneNumber);

        // Then
        assertNotNull(fran);
        Assertions.assertEquals("Fran", fran.getFirstName());
        Assertions.assertEquals("Davis", fran.getLastName());
        Assertions.assertEquals("0983425629", fran.getPhoneNumber());
        Assertions.assertEquals("Femail@gmail.com", fran.getEmail());
        Assertions.assertEquals("2089,Marys Walk, Waterford ", fran.getFulladdresss());
    }

}
