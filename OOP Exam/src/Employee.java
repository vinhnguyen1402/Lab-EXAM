public class Employee implements Payable {
    String snn;
    String firstName;
    String lastName;
    String birthDate;
    String phone;
    String email;

    public Employee() {
    }

    public Employee(String snn, String firstName, String lastName, String birthDate, String phone, String email) {
        this.snn = snn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
    }

    public String getSnn() {
        return snn;
    }

    public void setSnn(String snn) {
        this.snn = snn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public double getPayAmount() {
        return 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "snn='" + snn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void display(){
        System.out.println(this);
    }




}
