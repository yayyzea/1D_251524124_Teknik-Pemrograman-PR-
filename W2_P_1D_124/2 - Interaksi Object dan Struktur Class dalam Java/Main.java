package id.ac.polban.employee.app;

/**
 *
 * @author ZAHRA
 */
import id.ac.polban.employee.model.Department;
import id.ac.polban.employee.model.Employee;
import id.ac.polban.employee.model.EmploymentType;
import id.ac.polban.employee.service.EmployeeService;

public class Main {

    public static void main(String[] args) {

        // membuat object department (aggregation)
        Department deptIT  = new Department("Informatics");
        Department deptHR  = new Department("Human Resources");

        // memanggil static method langsung dari nama class
        System.out.println("Total departemen dibuat: " + Department.getTotalDepartments());

        // membuat object EmploymentType
        EmploymentType fullTime = new EmploymentType("Full-Time");
        EmploymentType contract = new EmploymentType("Contract");

        // membuat object Employee
        Employee emp1 = new Employee(1, "Karyawan1",   deptIT, fullTime, 5000000);
        Employee emp2 = new Employee(2, "Karyawan2",    deptIT, contract, 4000000);
        Employee emp3 = new Employee(3, "Karyawan3",   deptHR, fullTime, 4500000);

        // memanggil static method dari Employee
        System.out.println("Total karyawan dibuat: " + Employee.getTotalEmployees());

        // menggunakan EmployeeService untuk mengelola karyawan (dependency)
        EmployeeService service = new EmployeeService();
        service.addEmployee(emp1);
        service.addEmployee(emp2);
        service.addEmployee(emp3);

        // menaikkan gaji karyawan id=1 sebesar 10%
        service.raiseSalary(1, 10);
        System.out.println("\nGaji Karyawan1 setelah naik 10%: Rp " + service.getEmployee(1).getSalary());

        // memanggil static method dari EmployeeService
        double bonus = EmployeeService.hitungBonus(5000000, 15);
        System.out.println("Bonus 15% dari gaji 5.000.000: Rp " + bonus);

        // tampilkan semua karyawan
        System.out.println();
        service.tampilkanSemuaKaryawan();
    }
}