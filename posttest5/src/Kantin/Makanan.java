package Kantin;

public class Makanan extends Pesanan {
    private boolean pedas;

    public Makanan(String nama, int jumlah, double harga, boolean pedas) {
        super(nama, jumlah, harga);
        this.pedas = pedas;
    }

    public boolean isPedas() {
        return pedas;
    }

    public void setPedas(boolean pedas) {
        this.pedas = pedas;
    }

    @Override
    public String getInfoTambahan() {
        return "Pedas: " + (pedas ? "Ya" : "Tidak");
    }
}
