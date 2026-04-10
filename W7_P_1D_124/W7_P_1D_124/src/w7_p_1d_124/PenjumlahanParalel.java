package w7_p_1d_124;

/**
 * @author ZAHRA
 */

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class PenjumlahanParalel {

    // Menggunakan AtomicLong untuk mengakumulasi hasil tanpa risiko Race Condition
    private static AtomicLong totalAkhir = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Jumlah Thread: ");
        int jumlahThread = scanner.nextInt();

        System.out.print("Masukkan Angka Akhir: ");
        long angkaAkhir = scanner.nextLong();

        Thread[] threads = new Thread[jumlahThread];
        long range = angkaAkhir / jumlahThread;
        long sisa = angkaAkhir % jumlahThread;

        long startAngka = 1;

        System.out.println("\n--- Memulai Perhitungan Paralel ---");

        for (int i = 0; i < jumlahThread; i++) {
            final int idThread = i + 1;
            final long start = startAngka;
            
            // Thread terakhir menangani sisa pembagian (jika ada)
            final long end = (i == jumlahThread - 1) ? (startAngka + range - 1 + sisa) : (startAngka + range - 1);

            threads[i] = new Thread(() -> {
                long hasilParsial = 0;
                
                // Menjumlahkan rentang angka pada thread masing-masing (Divide and Conquer)
                for (long j = start; j <= end; j++) {
                    hasilParsial += j;
                }

                System.out.println("Thread " + idThread + ": Menjumlahkan " + start + " - " + end + " | Hasil Parsial: " + hasilParsial);

                // Sinkronisasi secara atomic untuk memperbarui totalAkhir
                totalAkhir.addAndGet(hasilParsial);
            });

            startAngka = end + 1;
            threads[i].start();
        }

        // Memastikan main thread menunggu semua thread pekerja selesai
        for (int i = 0; i < jumlahThread; i++) {
            threads[i].join();
        }

        System.out.println("-----------------------------------");
        System.out.println("Hasil Akhir Penjumlahan: " + totalAkhir.get());
        
        // Membuktikan hasil thread dengan rumus deret aritmatika n * (n + 1) / 2
        long expected = angkaAkhir * (angkaAkhir + 1) / 2;
        System.out.println("Verifikasi Rumus n*(n+1)/2 : " + expected);
        System.out.println("Status Verifikasi          : " + (totalAkhir.get() == expected ? "BENAR (Aman dari Race Condition)" : "SALAH (Terjadi Race Condition)"));
        
        scanner.close();
    }
}