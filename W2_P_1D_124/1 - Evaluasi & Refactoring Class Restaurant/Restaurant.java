package Restaurants;

/**
 *
 * @author ZAHRA
 */
public class Restaurant{
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    public String getNamaMakanan(int id) {
        return nama_makanan[id];
    }

    public void setNamaMakanan(int id, String nama) {
        this.nama_makanan[id] = nama;
    }

    public double getHargaMakanan(int id) {
        return harga_makanan[id];
    }

    public void setHargaMakanan(int id, double harga) {
        this.harga_makanan[id] = harga;
    }

    public int getStok(int id) {
        return stok[id];
    }

    public void setStok(int id, int stokBaru) {
        if (stokBaru >= 0) {
            this.stok[id] = stokBaru;
        } else {
            System.out.println("Error: Stok tidak boleh bernilai negatif!");
        }
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        setNamaMakanan(id, nama);
        setHargaMakanan(id, harga);
        setStok(id, stok);
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i <= id; i++) {
            if (getNamaMakanan(i) != null && !isOutOfStock(i)) {
                System.out.println(getNamaMakanan(i) + "[" + getStok(i) + "]\tRp. " + getHargaMakanan(i));
            }
        }
    }

    public boolean isOutOfStock(int id) {
        return getStok(id) == 0;
    }

    public static void nextId() {
        id++;
    }

    public void pesanMakanan(String nama, int jumlah) {
        boolean menuDitemukan = false;
        
        for (int i = 0; i <= id; i++) {
            if (nama.equalsIgnoreCase(getNamaMakanan(i))) {
                menuDitemukan = true;
                
                if (getStok(i) >= jumlah) {
                    int stokBaru = getStok(i) - jumlah;
                    setStok(i, stokBaru); 
                    System.out.println("-> Pesanan BERHASIL: " + jumlah + " porsi " + nama);
                } else {
                    System.out.println("-> Pesanan DITOLAK: Stok " + nama + " tidak mencukupi. (Sisa: " + getStok(i) + ")");
                }
                break;
            }
        }
        
        if (!menuDitemukan) {
            System.out.println("-> Pesanan DITOLAK: Menu " + nama + " tidak ditemukan.");
        }
    }
}
