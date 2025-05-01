package Kantin;

public abstract class Pesanan implements InfoPesanan {
    protected String nama;
    protected int jumlah;
    protected double harga;
    public static int totalPesanan = 0;
    public final String KATEGORI = "Kantin";

    public Pesanan(String nama, int jumlah, double harga) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
        totalPesanan++;
    }

    public abstract String getJenis();

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String toString() {
        return getJenis() + " - " + nama + " (x" + jumlah + ") - Rp" + harga;
    }
}
