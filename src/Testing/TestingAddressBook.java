package Testing;
import Main.MainAddressBook;
import Main.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Main.AddressBook;

import static org.junit.jupiter.api.Assertions.*;

 class MainAddressBookTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
     private AddressBook addressBook;
     private MainAddressBook mainAddressBook;
     @BeforeEach
     void setUp() {
         addressBook = new AddressBook();
         mainAddressBook = new MainAddressBook();
     }


     @BeforeEach
     void setUpStreams() {
         System.setOut(new PrintStream(outContent));
         System.setErr(new PrintStream(errContent));
     }

     @AfterEach
     void restoreStreams() {
         System.setOut(originalOut);
         System.setErr(originalErr);
     }

     @Test
     void testAddressBookMenu() {
         String expectedOutput = """
                ~ Menu ~
                [1] Add
                [2] View all Contacts In Address Book
                [3] Delete Contact info
                [4] Update Info
                [5] Search By First Name
                [6] Sort By First Name
                [7] Search By Last Name
                [8] Sort By Last Name
                [9] Exit App
                Enter Your Choice ie. 1,2 or 3:
                 """;
         MainAddressBook.AddressBookMenu();
         assertEquals(expectedOutput, outContent.toString());
     }
     @Test
     public void testAddAddress() {
         InputStream in = new ByteArrayInputStream("test\nuser\n123\nuser@example.com\n123 Main St".getBytes());
         System.setIn(in);
         AddressBook.addAddress();
         Person person = addressBook.searchAddressBookByNumber("123");
         assertNotNull(person);
         assertEquals("test", person.getFirstName());
         assertEquals("user", person.getLastName());
         assertEquals("123", person.getPhoneNumber());
         assertEquals("user@example.com", person.getEmail());
         assertEquals("123 Main St", person.getFulladresss());
     }
     @Test
     public void testDeleteAddress() {
         InputStream in = new ByteArrayInputStream("0983425629\n".getBytes());
         System.setIn(in);
         AddressBook.deleteAddress();
         Person person = addressBook.searchAddressBookByNumber("0983425629");
         assertNull(person);
     }
     @Test
     void testUpdateAddress() {
         // update a person
         String input = "4\n" +
                 "555-555-5555\n" +
                 "777-777-7777\n" +
                 "exit";
         InputStream in = new ByteArrayInputStream(input.getBytes());
         System.setIn(in);

         MainAddressBook.main(null);

         // verify that the person's phone number was updated
         Person person = AddressBook.searchAddressBookByNumber("777-777-7777");
         assertNotNull(person);
         assertEquals("John", person.getFirstName());
         assertEquals("Doe", person.getLastName());
         assertEquals("johndoe@example.com", person.getEmail());
         assertEquals("123 Main St", person.getFulladresss());
     }
     @Test
     public void testSearchAddressBookByNumber() {
         // Create an address book with some people
         List<Person> addressBook = new ArrayList<>();
         addressBook.add(new Person("John", "Doe", "123-456-7890", "john.doe@example.com", "uuhuhhu"));
         addressBook.add(new Person("Jane", "Doe", "234-567-8901", "jane.doe@example.com", "yhggv"));
         addressBook.add(new Person("Bob", "Smith", "345-678-9012", "bob.smith@example.com", "jjjjj"));

         // Test searching for a phone number that exists in the address book
         Person result1 = AddressBook.searchAddressBookByNumber("234-567-8901");
         assertEquals("Jane", result1.getFirstName());
         assertEquals("Doe", result1.getLastName());

         // Test searching for a phone number that does not exist in the address book
         Person result2 = AddressBook.searchAddressBookByNumber("999-999-9999");
         assertNull(result2);
     }


 }