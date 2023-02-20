package Main;

import java.util.Scanner;

public class MainAddressBook {

    public static void AddressBookMenu() {
        System.out.println("""
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
                Enter Your Choice ie. 1,2 or 3:"""
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {
            //method to be executed  to display options
            AddressBookMenu();

            // has a correct option been picked or else try again
            try {
                int menuChoice = scanner.nextInt();

                switch (menuChoice) {
                    case 1:
                        AddressBook.addAddress();
                        break;
                    case 2:
                        // display all the contacts
                        AddressBook.AllAddress();
                        break;
                    case 3:
                        /**
                         * delete contact
                         * by need to find the contact by looking for the phone number
                         */

                        AddressBook.deleteAddress();
                        break;
                    case 4:
                        //Update Contact Info
                        AddressBook.UpdatePhoneNumber();
                       break;
                    case 5:
                        AddressBook.SearchByFname();
                        break;
                    case 6:
                        AddressBook.sortByFirstName();
                        break;
                    case 7:
                        AddressBook.SearchByLname();
                        break;
                    case 8:
                        AddressBook.sortByLastName();
                        break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}