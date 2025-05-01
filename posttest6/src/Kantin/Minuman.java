package Kantin;

public final class Minuman extends Pesanan {
    private String ukuran;

    public Minuman(String nama, int jumlah, double harga, String ukuran) {
        super(nama, jumlah, harga);
        this.ukuran = ukuran;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Minuman: " + nama + ", Ukuran: " + ukuran + ", Jumlah: " + jumlah + ", Harga: Rp" + harga);
    }

    @Override
    public String getInfoTambahan() {
        return "Ukuran Minuman: " + ukuran;
    }

    @Override
    public String getJenis() {
        return "Minuman";
    }
}
