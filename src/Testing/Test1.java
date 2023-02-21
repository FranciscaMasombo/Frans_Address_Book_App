package Testing;

import Main.AddressBook;
import Main.Person;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class Test1 {

    private final ArrayList<Person> address = new ArrayList<>();
        @BeforeEach
        public void setUp() {
            // bootstrap default contacts in the address book
            Person fran = new Person("Fran", "Davis", "0983425629", "Femail@gmail.com", "2089,Marys Walk, Waterford ");
            address.add(fran);

            Person bob = new Person("Bob", "Smith", "0529020282", "BobsEmail@gmail.com", "506,Tramore Road, Dublin ");
            address.add(bob);

            Person harry = new Person("Harry", "Potter", "0483443249", "HarryEmail@gmail.com", "221,Bakers Street, London ");
            address.add(harry);

        }
        @Test
        @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
        @DisplayName("Test if a person's phone number can be updated")
         void testUpdatePhoneNumber() {
            String phoneNumber = "0529020282";
            String newPhoneNumber = "0123456789";

            String input = phoneNumber + "\n3\n" + newPhoneNumber;
            System.setIn(new ByteArrayInputStream(input.getBytes()));
        }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Test if display all ")
     void testAllAddress() {
        String savedOutput = System.out.toString();
        AddressBook addressBook = new AddressBook();
        addressBook.AllAddress();
        System.setOut(System.out.printf(savedOutput));
        }


    }