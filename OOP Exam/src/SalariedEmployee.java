public class SalariedEmployee extends Employee {
    double commissionRate=0;
    double grossSalary=0;
    double basicSalary=0;

    public SalariedEmployee(String snn, String firstName, String lastName, String birthDate, String phone, String email, double commissionRate, double grossSalary, double basicSalary) {
        super(snn, firstName, lastName, birthDate, phone, email);
        this.commissionRate = commissionRate;
        this.grossSalary = grossSalary;
        this.basicSalary = basicSalary;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }


}
