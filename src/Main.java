import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in); // what number did the user inter from the menu
    private static final AddressBook aD = new AddressBook();

    public static void AddressBookMenu(){
        System.out.println("""

                    ~ Menu ~\s
                    [1] Add\s
                    [2] View all Contacts In Address Book\s
                    [3] Remove
                    [4] Update Contact Info
                    [5] Sort By Last Name
                    [6] Sort By First Name
                    [7] Sort By Alphabetical Order
                    [8] Exit App
                    Enter Your Choice ie. 1,2 or 3:"""
        );
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");

        while (true){
            //method to be executed  to display options
            AddressBookMenu();

            // has a correct option been picked or else try again
            try{
                int menuChoice;
                menuChoice = scanner.nextInt();

                switch (menuChoice){
                    case 1:
                        System.out.println("First Name:");
                        String firstName = scanner.next();

                        System.out.println("Last Name:");
                        String lastName = scanner.next();

                        System.out.println("Phone Number:");
                        String phoneNumber = scanner.next();

                        System.out.println("Email:");
                        String email = scanner.next();

                        System.out.println("Full Addresss:");
                        String fulladresss = scanner.next();

                        Person person = new Person(firstName,lastName,phoneNumber,email,fulladresss);
                        AddressBook.addAddress(person);
                        System.out.println("New Person added successfully");

                        break;
                    case 2:
                        AddressBook.AllAdsress();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    default:
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }



}