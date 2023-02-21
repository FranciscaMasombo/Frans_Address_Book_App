package Main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private static ArrayList<Person> address = new ArrayList<Person>();;
    public static  Scanner scanner = new Scanner(System.in);
    public AddressBook(){
        address = new ArrayList<Person>();
        /**
         * bootstrap default contacts in the address book
         * 3 users/ contacts
         * fran, bob, harry
         */
        Person fran = new Person("Fran","Davis","0983425629","Femail@gmail.com","2089,Marys Walk, Waterford ");
        address.add(fran);

        Person bob = new Person("Bob","Smith","0529020282","BobsEmail@gmail.com","506,Tramore Road, Dublin ");
        address.add(bob);

        Person harry = new Person("Harry","Potter","0483443249","HarryEmail@gmail.com","221,Bakers Street, London ");
        address.add(harry);

    }

    /**
     * Method addAddress is going to a new person to the address book
     */
    public static void addAddress() {
        System.out.println("Currently Adding new person to Address Book:");
        System.out.println("First Name:");
        String firstName = scanner.next();

        System.out.println("Last Name:");
        String lastName = scanner.next();

        System.out.println("Phone Number:");
        String phoneNumber = scanner.next();

        System.out.println("Email:");
        String email = scanner.next();

        System.out.println("Full Address:");
        String fulladresss = scanner.next();

        Person newPerson;
        newPerson = new Person(firstName, lastName, phoneNumber, email, fulladresss);

        //add new person
        address.add(newPerson);
        Person testNewPerson = AddressBook.searchAddressBookByNumber(phoneNumber);

        // check if the person was added
        if (testNewPerson != null){
            System.out.println("New Person added successfully");
        }else {
            System.out.println("No new Person added ");
        }

    }

    /**
     * Method AllAddress is going to list all current people in Address Book
     * There are always users in the Address book
     * They are printed to the user
     */

    public static void AllAddress(){
        for (int i = 0; i < address.size(); i++){
            Person addressDetails = address.get(i);
            System.out.println("----------------------------------------------------"+ "\n" +
                    "Contact Details For: " + addressDetails.getFirstName() +" "+ addressDetails.getLastName() + "\n" +
                    "First Name: " + addressDetails.getFirstName() + "\n" +
                    "Last Name: " + addressDetails.getLastName() + "\n" +
                    "Phone Number: " + addressDetails.getPhoneNumber() + "\n" +
                    "Email Address: " + addressDetails.getEmail()+ "\n" +
                    "Full Address: " + addressDetails.getFulladdresss()+ "\n" +
                    "----------------------------------------------------"
            );
        }
    }

    /**
     *
     * @param phoneNumberEntered
     * @return
     * This method will search the Address Book using the phoneNumberEntered by user
     */
    public static Person searchAddressBookByNumber(String phoneNumberEntered) {
        for (int i =0;  i < address.size(); i++){
            if (address.get(i).getPhoneNumber().equals(phoneNumberEntered)){
                return address.get(i);
            }else {
                System.out.println("Not Found");
            }
        }
        return null;
    }

    /**
     * This method will ask user to enter a phone number
     * it will display a menu and the user can select what they would like to update
     */
    public static void UpdatePhoneNumber() {
        System.out.println("Enter the Phone Number:");
        String phoneNumberEntered = scanner.nextLine();
        boolean gotperson = false;
        for (int i =0;  i < address.size(); i++){
            Person person = address.get(i);

            if(person.getPhoneNumber().equals(phoneNumberEntered)){
                System.out.println("""
                        Enter what you want to update --->\s
                        [1] FirstName
                        [2] Last Name
                        [3] Phone Number
                        [4] Email
                        [5] Full Address
                        """
                );
                //menu option choice saved in
                int menuChoice = scanner.nextInt();

                switch (menuChoice) {
                    case 1:
                        // menu choice 1
                        System.out.println("Please enter the new First Name :");
                        String fname = scanner.next();
                        person.setFirstName(fname);
                        System.out.println("Person:" + person.getFirstName()+ " " + person.getLastName()+" you have sucessfully updated");
                        gotperson = true;
                        break;
                    case 2:
                        System.out.println("Please enter the new Last Name :");
                        String lname = scanner.next();
                        person.setLastName(lname);
                        System.out.println("Person:" + person.getFirstName()+ " " +person.getLastName()+" you have sucessfully updated");
                        gotperson = true;
                        break;
                    case 3:
                        System.out.println("Please enter the new Phone Number :");
                        String phoneNumber = scanner.next();
                        person.setPhoneNumber(phoneNumber);
                        System.out.println("Person:" + person.getFirstName()+ " " +person.getLastName()+" you have sucessfully updated");
                        gotperson = true;
                        break;
                    case 4:
                        System.out.println("Please enter the new Email:");
                        String email = scanner.next();
                        person.setEmail(email);
                        System.out.println("Person:" + person.getFirstName()+ " " + person.getLastName()+" you have sucessfully updated");
                        gotperson = true;
                        break;
                    case 5:
                        System.out.println("Please enter the new Full Address :");
                        String fullAddress = scanner.next();
                        person.setFulladdresss(fullAddress);
                        System.out.println("Person:" + person.getFirstName()+ person.getLastName()+" you have sucessfully updated");
                        gotperson = true;
                        break;
                }
                System.out.println("Address Book Updated Successfully");
            }
        }if (!gotperson){
            System.out.println("Address Book Not Updated");
        }

    }

    /**
     * Method deleteAddress
     * the user will need to enter Phone number if found the person is deleted
     */
    public static void deleteAddress(){
        System.out.println("Enter the Phone Number of the person do you wants to delete");
        String phoneNumberEntered = scanner.nextLine();
        boolean wasAddressDeleted = false;
        for (int i =0;  i < address.size(); i++){
            if (address.get(i).getPhoneNumber().equals(phoneNumberEntered)) {
                System.out.println("Person successfully deleted!");
                address.remove(i);
                wasAddressDeleted = true;
            }
            i++;
        }
        if (!wasAddressDeleted){
            System.out.println("No Person found with that phone number.");
        }
    }

    /**
     * this will find person using the first name
     */
    public static void SearchByFname() {
        System.out.println("Enter the First Name:");
        String fNameEntered = scanner.nextLine();
        boolean gotperson = false;
        for (Person person : address) {
            if (person.getFirstName().equalsIgnoreCase(fNameEntered)) {
                person.printPersonsAddress();
                gotperson = true;
            }
        }
        if (!gotperson) {
            System.out.println("No Person found with that First Name.");
        }

    }

    public static void SearchByLname() {
        System.out.println("Enter the Last Name:");
        String fNameEntered = scanner.nextLine();
        boolean gotperson = false;
        for (Person person : address) {
            if (person.getFirstName().equalsIgnoreCase(fNameEntered)) {
                person.printPersonsAddress();
                gotperson = true;
            }
        }
        if (!gotperson) {
            System.out.println("No Person found with that Last Name.");
        }

    }

    public static void sortByFirstName() {
        Collections.sort(address, (firstName, firstName2) -> firstName.getFirstName().compareToIgnoreCase(firstName2.getFirstName()));

        {
            for (Person person : address) {
                person.printPersonsAddress();
            }

        }
    }
    public static void sortByLastName(){
        Collections.sort(address, (lastName, lastName2) -> lastName.getLastName().compareToIgnoreCase(lastName2.getLastName()));

        {
            for (Person person : address) {
                person.printPersonsAddress();
            }

        }
    }
}
