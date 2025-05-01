package Kantin;

public class Makanan extends Pesanan {
    private String jenisMakanan;

    public Makanan(String nama, int jumlah, double harga, String jenisMakanan) {
        super(nama, jumlah, harga);
        this.jenisMakanan = jenisMakanan;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Makanan: " + nama + ", Jenis: " + jenisMakanan + ", Jumlah: " + jumlah + ", Harga: Rp" + harga);
    }

    @Override
    public String getInfoTambahan() {
        return "Jenis Makanan: " + jenisMakanan;
    }

    @Override
    public String getJenis() {
        return "Makanan";
    }
}
