import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class DepartmentManage {
    static ArrayList<Department> departmentList = new ArrayList<>() ;
    static ArrayList<Employee> employeeList = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }
    /**
     * MENU
     * */
    public static void mainMenu(){
        int mainMenuChoice=0;
        int addMenuChoice;
        int searchMenuChoice;
        String departmentChoice;
        String searchKeyWord;
        while (mainMenuChoice != 5){
            displayMainMenu();
            mainMenuChoice = in.nextInt();
            in.nextLine();
            switch (mainMenuChoice){
                case 1:
                    displayMenuAdd();
                    addMenuChoice= in.nextInt();
                    in.nextLine();
                    if (addMenuChoice==1){
                        inputDepartment();
                        break;
                    }
                    if(addMenuChoice==2){
                        if(departmentList.isEmpty()){
                            System.out.println("Can't not add employee. Please add department first.");
                        }else{
                            inputEmployee();
                        }
                        break;
                    }
                case 2:
                    displayEmployee();
                    break;
                case 3:
                    displayMenuSearch();
                    searchMenuChoice=in.nextInt();
                    in.nextLine();
                    if (searchMenuChoice==1){
                        displayDepartment();
                        departmentChoice=in.nextLine();

                        displayEmployeeInDepartment(departmentChoice);
                    }else{
                        System.out.println("Enter search keyword:");
                        searchKeyWord= in.nextLine();
                        searchEmployeeByName(searchKeyWord);
                    }
                    break;
                case 4:
                    getDepartmentStatistic();
                    break;
                default:
            }
        }
    }

    public static void displayMainMenu (){
        System.out.println("---MENU SELECTION---");
        System.out.println("1. Add");
        System.out.println("2. Show Employee");
        System.out.println("3. Search employee");
        System.out.println("4. Statistic");
        System.out.println("5. Exit");
    }
    public static void displayMenuAdd(){
        System.out.println("1. Add Department");
        System.out.println("2. Add Employee");
    }

    public static void displayMenuSearch(){
        System.out.println("1. By Department");
        System.out.println("2. By Name");
    }
    /**
     * INPUT DATA
     */
    public static void inputDepartment(){
        String name;
        String checkName;
        do{
            System.out.println("Enter department: ");
            name=in.nextLine();
        }while(name.isBlank()||isRepeatedDepartmentName(name));
        Department departmentName = new Department();
        departmentName.setDepartmentName(name);
        departmentList.add(departmentName);
    }

    public static boolean isRepeatedDepartmentName(String name) {
        for (Department department : departmentList) {
            if (Objects.equals(department.departmentName, name)) {
                return true;
            }
        }
        return false;

    }

    public static void inputEmployee() {
        String snn;
        String firstName;
        String lastName;
        String birthDate;
        String phone;
        String email;
        int employeeType;
        Employee employee;
        System.out.println("Enter snn: ");
        snn = in.nextLine();
        System.out.println("Enter first name: ");
        firstName = in.nextLine();
        System.out.println("Enter last name: ");
        lastName = in.nextLine();
        System.out.println("Enter birth date: ");
        birthDate = inputDOB();
        System.out.println("Enter phone: ");
        phone = inputPhone();
        System.out.println("Enter email: ");
        email = inputEmail();
        System.out.println("Enter type of employee, 1 for Hourly, 2 for Salary: ");
        employeeType=in.nextInt();
        in.nextLine();
        if(employeeType==1){
            double wage;
            double workingHours;
            System.out.println("Enter wage: ");
            wage = in.nextDouble();
            in.nextLine();
            System.out.println("Enter Working Hours: ");
            workingHours = in.nextDouble();
            in.nextLine();
            employee= new HourlyEmployee(snn,firstName,lastName,birthDate,phone,email,wage,workingHours);
        }else{
            double commissionRate;
            double grossSalary;
            double baseSalary;
            System.out.println("Enter commission rate: ");
            commissionRate=in.nextDouble();
            in.nextLine();
            System.out.println("Enter commission gross salary: ");
            grossSalary=in.nextDouble();
            in.nextLine();
            System.out.println("Enter commission base salary: ");
            baseSalary=in.nextDouble();
            in.nextLine();
            employee = new SalariedEmployee(snn,firstName,lastName,birthDate,phone,email,commissionRate,grossSalary,baseSalary);
        }
        chooseDepartment(employee);
        employeeList.add(employee);
    }

    public static void chooseDepartment(Employee employee){
        String departmentName;
        int i=0;
        System.out.println("Choose department.");
        for (Department department: departmentList ) {
            System.out.println(++i + "." + department.departmentName);
        }
        departmentName=in.nextLine();
        for (Department department: departmentList ) {
            if(Objects.equals(departmentName, department.departmentName)){
                department.listOfEmployee.add(employee);
            }

        }
    }

    public static String inputDOB() {
        String validDOB;
        validDOB = in.nextLine();
        while (!isValidDOB(validDOB)) {
            System.out.println("Re-enter birthdate: ");
            validDOB = in.nextLine();
        }
        return validDOB;
    }

    public static String inputPhone() {
        String validPhone;
        validPhone = in.nextLine();
        while (!isValidPhoneNumber(validPhone)) {
            System.out.println("Re-enter phone number: ");
            validPhone = in.nextLine();
        }
        return validPhone;
    }

    public static String inputEmail() {
        String validEmail;
        validEmail = in.nextLine();
        while (!isValidEmail(validEmail)) {
            System.out.println("Re-enter email: ");
            validEmail = in.nextLine();
        }
        return validEmail;
    }

    /**
     * DEPARTMENT
     * */
    public static void displayEmployeeInDepartment(String departmentName){
        for (Department department: departmentList ) {
            if (Objects.equals(department.departmentName, departmentName)){
                department.display();
            }else{
                System.out.println("Department doesn't exist.");
            }
        }
    }


    public static void displayDepartment(){
        int i=0;
        for (Department department : departmentList ) {
            System.out.println(++i +". " + department.departmentName);
        }
    }

    public static void getDepartmentStatistic(){

        for (Department department:departmentList ) {

            System.out.printf("%-10s %10s \n",department.departmentName, department.listOfEmployee.size());
        }
    }

    /**
     *  EMPLOYEE
     */

    public static void displayEmployee(){
        for (Employee employee:employeeList ) {
            employee.display();
        }
    }
    public static void searchEmployeeByName(String searchKeyWord){
        for ( Employee employee:employeeList ) {
            if(employee.firstName.toLowerCase().contains(searchKeyWord.toLowerCase())||employee.lastName.toLowerCase().contains(searchKeyWord.toLowerCase())){
                System.out.println(employee);
            }
        }
    }

    /**
     * Validator
     */
    public static boolean isValidDOB(String validDate) {
        return validDate.matches("^(0[1-9]|[12][0-9]|[3][01])/(0[1-9]|1[012])/\\d{4}$");
    }

    public static boolean isValidPhoneNumber(String phone) {
        return phone.matches("[0-9]{7}$");
    }

    public static boolean isValidEmail(String email) {
        return email.matches("[a-z0-9]+@gmail.com$");
    }
}