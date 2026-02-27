package tugas3;

/**
 *
 * @author ZAHRA
 */
public class EmployeeTest {
    public static void main(String[] args) {
        // Mendeklarasikan dan mengalokasikan array untuk 3 objek Employee
        Employee[] staff = new Employee[3];
        
        // Inisialisasi data karyawan
        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        // Menaikkan gaji setiap staf sebesar 5%
        for (int i = 0; i < 3; i++) {
            staff[i].raiseSalary(5);
        }
        
        // Mencetak data dari setiap staf
        System.out.println("--- DATA AWAL STAF ---");
        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }
        
        System.out.println("\n--- MENGUJI METODE COMPARE ---");
        System.out.println("Membandingkan staff[0] dengan staff[1]:");
        
        int result = staff[0].compare(staff[1]);
        
        if (result < 0) {
            System.out.println("Gaji staff[0] lebih kecil dari gaji staff[1]");
        } else if (result > 0) {
            System.out.println("Gaji staff[0] lebih besar dari gaji staff[1]");
        } else {
            System.out.println("Gaji keduanya sama");
        }

        // Test shell_sort (Pembuktian bahwa Sortable benar-benar bekerja)
        System.out.println("\n--- MENGUJI SHELL SORT (Gaji Diurutkan) ---");
        Sortable.shell_sort(staff);
        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }
    }
}