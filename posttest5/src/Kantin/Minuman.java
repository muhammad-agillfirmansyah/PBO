package Kantin;

public final class Minuman extends Pesanan {
    private boolean dingin;

    public Minuman(String nama, int jumlah, double harga, boolean dingin) {
        super(nama, jumlah, harga);
        this.dingin = dingin;
    }

    public boolean isDingin() {
        return dingin;
    }

    public void setDingin(boolean dingin) {
        this.dingin = dingin;
    }

    @Override
    public String getInfoTambahan() {
        return "Dingin: " + (dingin ? "Ya" : "Tidak");
    }
}
