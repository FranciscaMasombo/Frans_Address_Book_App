package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private static ArrayList<Person> address ;
    static  Scanner scanner = new Scanner(System.in);
    public AddressBook(){
        this.address = new ArrayList<Person>();
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
    public static void addAddress() {
        System.out.println("Currently Adding new person to Address Book: enter exit to leave");
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

        Person newPerson = new Person(firstName, lastName, phoneNumber, email, fulladresss);
        //add new person
        address.add(newPerson);

        Person testNewPerson = AddressBook.searchAddressBookByNumber(phoneNumber);
        if (testNewPerson != null){

            System.out.println("New Main.Person added successfully");
        }else {
            System.out.println("No new Main.Person added ");
        }


    }

    public static void AllAddress(){
        for (int i = 0; i < address.size(); i++){
            Person addressDetails = address.get(i);
            System.out.println("----------------------------------------------------"+ "\n" +
                    "Contact Details For: " + addressDetails.getFirstName() +" "+ addressDetails.getLastName() + "\n" +
                    "First Name: " + addressDetails.getFirstName() + "\n" +
                    "Last Name: " + addressDetails.getLastName() + "\n" +
                    "Phone Number: " + addressDetails.getPhoneNumber() + "\n" +
                    "Email Address: " + addressDetails.getEmail()+ "\n" +
                    "Full Address: " + addressDetails.getFulladresss()+ "\n" +
                    "----------------------------------------------------"
            );
        }
    }

    public static Person searchAddressBookByNumber(String phoneNumberEntered) {
        for (int i =0;  i < address.size(); i++){
            if (address.get(i).getPhoneNumber().equals(phoneNumberEntered)){
                return address.get(i);
            }
        }
        return null;
    }


    public static void UpdatePhoneNumber() {
        System.out.println("Enter the Phone Number:");
        String phoneNumberEntered = scanner.nextLine();

        for (int i =0;  i < address.size(); i++){
            Person person = address.get(i);

            if(person.getPhoneNumber().equals(phoneNumberEntered)){
                System.out.println("Enter Field to update ---> \n" +
                        "[1] FirstName\n" +
                        "[2] Last Name\n" +
                        "[3] Phone Number\n" +
                        "[4] Email\n" +
                        "[5] Full Addresss\n"
                );
                int opt = scanner.nextInt();
                switch (opt) {
                    case 1:
                        System.out.println("Please enter your new First Name :");
                        String fname = scanner.next();
                        person.setFirstName(fname);
                        System.out.println("Main.Person:" + person.getFirstName()+ " " + person.getLastName()+" you have sucessfully updated");
                        break;
                    case 2:
                        System.out.println("Please enter your new Last Name :");
                        String lname = scanner.next();
                        person.setLastName(lname);
                        System.out.println("Main.Person:" + person.getFirstName()+ " " +person.getLastName()+" you have sucessfully updated");
                        break;
                    case 3:
                        System.out.println("Please enter your new Phone Number :");
                        String phoneNumber = scanner.next();
                        person.setPhoneNumber(phoneNumber);
                        System.out.println("Main.Person:" + person.getFirstName()+ " " +person.getLastName()+" you have sucessfully updated");
                        break;
                    case 4:
                        System.out.println("Please enter your new Email:");
                        String email = scanner.next();
                        person.setEmail(email);
                        System.out.println("Main.Person:" + person.getFirstName()+ " " + person.getLastName()+" you have sucessfully updated");
                        break;
                    case 5:
                        System.out.println("Please enter your new Full Address :");
                        String fullAddress = scanner.next();
                        person.setFulladresss(fullAddress);
                        System.out.println("Main.Person:" + person.getFirstName()+ person.getLastName()+" you have sucessfully updated");
                        break;
                }
                System.out.println("Address Book Updated Successfully");
            }else {
                System.out.println("Address Book Not Updated");

            }
        }

    }

    public static void deleteAddress(){
        System.out.println("Enter the Phone Number of the person do you wants to delete");
        String phoneNumberEntered = scanner.nextLine();

        boolean wasAddressDeleted = false;
        for (int i =0;  i < address.size(); i++){
            if (address.get(i).getPhoneNumber().equals(phoneNumberEntered)) {
                System.out.println("Contact successfully deleted!");
                address.remove(i);
                wasAddressDeleted = true;
            }
            i++;
        }
        if (!wasAddressDeleted){
            System.out.println("No address found with that record.");
        }
    }


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
            System.out.println("Did not find record with that entry.");
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
            System.out.println("Did not find Persons Details.");
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

    public static void updateDetails() {
        System.out.println("Enter the Phone Number:");
        String phoneNumberEntered = scanner.nextLine();

    }

    public static List<Person> getAddressList() {
        return null;
    }
}
