package w7_p_1d_124;

/**
 * @author ZAHRA
 */

class Account {
    int balance = 150;
}

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account();
        Account acc2 = new Account();

        // Thread 1: Menjumlahkan/ transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            synchronized (acc1) { // Mengunci acc1 agar tidak bisa diakses oleh thread lain (mutual exclusion)
                System.out.println("T1: Mengunci acc1, bersiap transfer dari acc1 ke acc2...");
                try { Thread.sleep(100); } catch (Exception e) {} // Simulasi dengan memberikan jeda. 
                                                                  // Exception wajib ditangani (try-catch) karena method sleep() bisa memicu InterruptedException jika thread diganggu/diinterupsi saat sedang tidur.

                synchronized (acc2) { // Mengunci acc2 untuk menerima saldo transfer
                    System.out.println("T1: Mengunci acc2, melakukan transfer: acc2 += acc1.balance");
                    acc2.balance += acc1.balance;
                }
            }
        });

        // Thread 2: Menjumlahkan/ transfer fulus dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            // Sebelumnya t2 mengunci acc2 duu, lalu acc1. Hal ini terbalik 
            synchronized (acc1) { // Mengunci acc1 terlebih dahulu (lock ordering) untuk mencegah deadlock
                System.out.println("T2: Mengunci acc1, bersiap transfer dari acc2 ke acc1..");
                try { Thread.sleep(100);} catch (Exception e) {}

                synchronized (acc2) { // Mengunci acc2 setelah acc1 berhasil diamankan
                    System.out.println("T2: Mengunci acc2, melakukan transfer: acc1 += acc2.balance");
                    acc1.balance += acc2.balance;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
		System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}
