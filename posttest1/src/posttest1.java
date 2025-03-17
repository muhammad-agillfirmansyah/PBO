import java.util.ArrayList;
import java.util.Scanner;

class Pesanan {
    String nama;
    int jumlah;
    double harga;

    public Pesanan(String nama, int jumlah, double harga) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Jumlah: " + jumlah + ", Harga: " + harga;
    }
}

public class posttest1 {
    static ArrayList<Pesanan> daftarPesanan = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\nSistem Pemesanan Makanan Kantin Berbasis Web");
            System.out.println("1. Tambah Pesanan");
            System.out.println("2. Lihat Pesanan");
            System.out.println("3. Ubah Pesanan");
            System.out.println("4. Hapus Pesanan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    tambahPesanan();
                    break;
                case 2:
                    lihatPesanan();
                    break;
                case 3:
                    ubahPesanan();
                    break;
                case 4:
                    hapusPesanan();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem pemesanan!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
    }

    public static void tambahPesanan() {
        System.out.print("Masukkan nama makanan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan jumlah: ");
        int jumlah = scanner.nextInt();
        System.out.print("Masukkan harga: ");
        double harga = scanner.nextDouble();
        scanner.nextLine(); // Membersihkan buffer

        daftarPesanan.add(new Pesanan(nama, jumlah, harga));
        System.out.println("Pesanan berhasil ditambahkan!");
    }

    public static void lihatPesanan() {
        if (daftarPesanan.isEmpty()) {
            System.out.println("Tidak ada pesanan.");
            return;
        }
        System.out.println("\nDaftar Pesanan:");
        for (int i = 0; i < daftarPesanan.size(); i++) {
            System.out.println((i + 1) + ". " + daftarPesanan.get(i));
        }
    }

    public static void ubahPesanan() {
        lihatPesanan();
        if (daftarPesanan.isEmpty()) return;

        System.out.print("Pilih nomor pesanan yang ingin diubah: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Membersihkan buffer

        if (index >= 0 && index < daftarPesanan.size()) {
            System.out.print("Masukkan nama makanan baru: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan jumlah baru: ");
            int jumlah = scanner.nextInt();
            System.out.print("Masukkan harga baru: ");
            double harga = scanner.nextDouble();
            scanner.nextLine(); // Membersihkan buffer

            daftarPesanan.set(index, new Pesanan(nama, jumlah, harga));
            System.out.println("Pesanan berhasil diubah!");
        } else {
            System.out.println("Nomor pesanan tidak valid.");
        }
    }

    public static void hapusPesanan() {
        lihatPesanan();
        if (daftarPesanan.isEmpty()) return;

        System.out.print("Pilih nomor pesanan yang ingin dihapus: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Membersihkan buffer

        if (index >= 0 && index < daftarPesanan.size()) {
            daftarPesanan.remove(index);
            System.out.println("Pesanan berhasil dihapus!");
        } else {
            System.out.println("Nomor pesanan tidak valid.");
        }
    }
}
