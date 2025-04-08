package Kantin;

public class Pesanan {
    private String nama;
    private int jumlah;
    private double harga;

    public Pesanan(String nama, int jumlah, double harga) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public String getJenis() {
        return "Umum";
    }

    @Override
    public String toString() {
        return "Jenis: " + getJenis() + ", Nama: " + nama + ", Jumlah: " + jumlah + ", Harga: " + harga;
    }
}

