public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String fulladresss;

    public Person(String firstName, String lastName, String phoneNumber, String email, String fulladresss) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.fulladresss = fulladresss;
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

    public void setFulladresss(String fulladresss) {
        this.fulladresss = fulladresss;
    }
    public String getFulladresss() {
        return fulladresss;
    }
}
