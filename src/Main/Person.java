package Main;

public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String fulladdresss;

    public Person(String firstName, String lastName, String phoneNumber, String email, String fulladdresss) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.fulladdresss = fulladdresss;
    }


    public void  setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setFulladdresss(String fulladdresss) {
        this.fulladdresss = fulladdresss;
    }
    public String getFulladdresss() {
        return fulladdresss;
    }

    public void printPersonsAddress(){
        System.out.println("----------------------------------------------------"+ "\n" +
                "Contact Details For: " +getFirstName() +" "+ getLastName() + "\n" +
                "Phone Number: " + getPhoneNumber() + "\n" +
                "Email Address: " + getEmail()+ "\n" +
                "Full Address: " + getFulladdresss()+ "\n" +
                "----------------------------------------------------"
        );
    }
}
