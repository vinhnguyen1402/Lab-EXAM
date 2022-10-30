public class HourlyEmployee extends Employee {
    double wage=0;
    double workingHours=0;

    public HourlyEmployee(String snn, String firstName, String lastName, String birthDate, String phone, String email, double wage, double workingHours) {
        super(snn, firstName, lastName, birthDate, phone, email);
        this.wage = wage;
        this.workingHours = workingHours;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

}
