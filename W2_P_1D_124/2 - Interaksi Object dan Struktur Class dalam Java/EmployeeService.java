package id.ac.polban.employee.service;

/**
 *
 * @author ZAHRA
 */
import java.util.HashMap;
import java.util.Map;
import id.ac.polban.employee.model.Employee;

// mengelola operasi yang berkaitan dengan data dan aturan bisnis 
public class EmployeeService {

    // map untuk menyimpan data karyawan, key = id karyawan
    private Map<Integer, Employee> employees = new HashMap<>();

    // menambah karyawan ke dalam sistem
    public void addEmployee(Employee emp) {
        employees.put(emp.getId(), emp);
    }

    // mengambil data karyawan berdasarkan id
    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    // menaikkan gaji karyawan berdasarkan persentase
    public void raiseSalary(int id, double percent) {
        Employee emp = employees.get(id);
        if (emp != null) {
            double gajiBaru = emp.getSalary() * (1 + percent / 100);
            emp.setSalary(gajiBaru);
        }
    }

    // static method - menghitung bonus tanpa membuat object EmployeeService
    public static double hitungBonus(double salary, double percent) {
        return salary * (percent / 100);
    }

    // menampilkan semua data karyawan
    public void tampilkanSemuaKaryawan() {
        System.out.println("===== Daftar Karyawan =====");
        for (Employee emp : employees.values()) {
            System.out.println("ID    : " + emp.getId());
            System.out.println("Nama  : " + emp.getName());
            System.out.println("Dept  : " + emp.getDepartment().getName());
            System.out.println("Tipe  : " + emp.getType().getType());
            System.out.println("Gaji  : Rp " + emp.getSalary());
            System.out.println("---------------------------");
        }
        System.out.println("Total Karyawan: " + Employee.getTotalEmployees());
    }
}