package Kantin;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Pesanan> daftarPesanan = new ArrayList<>();

    public static final void tampilMenu() {
        int pilihan;
        do {
            System.out.println("\n=== Menu Kantin ===");
            System.out.println("1. Tambah Pesanan");
            System.out.println("2. Lihat Pesanan");
            System.out.println("3. Ubah Pesanan");
            System.out.println("4. Hapus Pesanan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

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
                        System.out.println("Terima kasih telah menggunakan sistem pemesanan.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka.");
                scanner.nextLine(); // bersihkan buffer
                pilihan = 0;
            }
        } while (pilihan != 5);
    }

    public static void tambahPesanan() {
        try {
            System.out.print("Jenis (1. Makanan, 2. Minuman): ");
            int jenis = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Jumlah: ");
            int jumlah = scanner.nextInt();
            System.out.print("Harga: ");
            double harga = scanner.nextDouble();
            scanner.nextLine();

            if (jenis == 1) {
                System.out.print("Jenis Makanan (contoh: Nasi, Gorengan): ");
                String jenisMakanan = scanner.nextLine();
                daftarPesanan.add(new Makanan(nama, jumlah, harga, jenisMakanan));
            } else if (jenis == 2) {
                System.out.print("Ukuran Minuman (contoh: Besar, Sedang): ");
                String ukuran = scanner.nextLine();
                daftarPesanan.add(new Minuman(nama, jumlah, harga, ukuran));
            } else {
                System.out.println("Jenis tidak valid.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid!");
            scanner.nextLine();
        }
    }

    public static void lihatPesanan() {
        if (daftarPesanan.isEmpty()) {
            System.out.println("Belum ada pesanan.");
        } else {
            System.out.println("\nDaftar Pesanan:");
            for (int i = 0; i < daftarPesanan.size(); i++) {
                System.out.println((i + 1) + ". " + daftarPesanan.get(i));
            }
            System.out.println("Total pesanan: " + Pesanan.totalPesanan);
        }
    }

    public static void ubahPesanan() {
        lihatPesanan();
        if (daftarPesanan.isEmpty()) return;

        try {
            System.out.print("Pilih nomor pesanan yang ingin diubah: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index >= 0 && index < daftarPesanan.size()) {
                Pesanan pesanan = daftarPesanan.get(index);

                System.out.print("Nama baru: ");
                pesanan.setNama(scanner.nextLine());
                System.out.print("Jumlah baru: ");
                pesanan.setJumlah(scanner.nextInt());
                System.out.print("Harga baru: ");
                pesanan.setHarga(scanner.nextDouble());
                scanner.nextLine();

                System.out.println("Pesanan berhasil diubah.");
            } else {
                System.out.println("Nomor tidak valid.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid!");
            scanner.nextLine();
        }
    }

    public static void hapusPesanan() {
        lihatPesanan();
        if (daftarPesanan.isEmpty()) return;

        try {
            System.out.print("Pilih nomor pesanan yang ingin dihapus: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index >= 0 && index < daftarPesanan.size()) {
                daftarPesanan.remove(index);
                Pesanan.totalPesanan--;
                System.out.println("Pesanan berhasil dihapus.");
            } else {
                System.out.println("Nomor tidak valid.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid!");
            scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        tampilMenu();
    }
}
