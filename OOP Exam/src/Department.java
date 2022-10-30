import java.util.ArrayList;
import java.util.List;

public class Department {
    String departmentName;
    ArrayList<Employee> listOfEmployee;

    public Department() {
        this.listOfEmployee= new ArrayList<>();
    }

    public void display(){
        System.out.println("Department name:" + departmentName);
        for (Employee employee: listOfEmployee ) {
            System.out.println(employee.toString());
        }
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


}
