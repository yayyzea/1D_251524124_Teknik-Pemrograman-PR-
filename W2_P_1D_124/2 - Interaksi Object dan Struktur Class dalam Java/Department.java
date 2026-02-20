package id.ac.polban.employee.model;

/**
 *
 * @author ZAHRA
 */
public class Department {
    private String name;
    
    // static field - menghitung total department
    private static int totalDepartments = 0;

     // constructor
    public Department(String name) {
        this.name = name;
        totalDepartments++; 
    }

    // getter dan Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static int getTotalDepartments() {
        return totalDepartments;
    }
}
