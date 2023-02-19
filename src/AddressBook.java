import java.util.ArrayList;
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
    public static void addAddress(Person person) {
        address.add(person);
    }

    public static void AllAdsress(){
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
    public void updateAddress(){

    }
    public void deleteAddress(){

    }
    public void sortByFname(){

    }
    public void sortByLname(){

    }

}
