package w7_p_1d_124;

/**
 * @author ZAHRA
 */

class Resto {
    private int chickenStock = 100;

    public synchronized void serveCustomer(String cashierName) { 
    // Method serveCustomer() diakses oleh banyak thread secara bersamaan sehingga terjadi race condition, akibatnya stok bisa negatif dan tidak konsisten   
    // synchronized memastikan hanya satu thread yang dapat mengeksekusi method ini pada satu waktu (mutual exclusion)
        if (chickenStock > 0) {
            try { Thread.sleep(10); } catch (InterruptedException e) {}   
            chickenStock--; 
            System.out.println(cashierName + " berhasil menjual 1 ayam. Sisa stok: " + chickenStock);
        } else {
            System.out.println(cashierName + " gagal: Stok Habis!");
        }
    }

    public int getRemainingStock() {
        return chickenStock;
    }
}

public class RestoSimulasi {
    public static void main(String[] args) throws InterruptedException {
        Resto ayamJuicyLuicyGallagher = new Resto();

        Runnable task = () -> {
            for (int i = 0; i < 40; i++) {
                ayamJuicyLuicyGallagher.serveCustomer(Thread.currentThread().getName());
            }
        };

        Thread kasir1 = new Thread(task, "Kasir-A");
        Thread kasir2 = new Thread(task, "Kasir-B");
        Thread kasir3 = new Thread(task, "Kasir-C");

        kasir1.start();
        kasir2.start();
        kasir3.start();

        kasir1.join();
        kasir2.join(); 
        kasir3.join();

        System.out.println("--- HASIL AKHIR STOK: " + ayamJuicyLuicyGallagher.getRemainingStock() + " ---");
    }
}
