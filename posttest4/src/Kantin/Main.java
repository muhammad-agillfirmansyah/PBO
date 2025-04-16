package Kantin;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Pesanan> daftarPesanan = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\nSistem Pemesanan Makanan Kantin");
            System.out.println("1. Tambah Pesanan");
            System.out.println("2. Lihat Pesanan");
            System.out.println("3. Ubah Pesanan");
            System.out.println("4. Hapus Pesanan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
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
                    System.out.println("Terima kasih telah menggunakan sistem pemesanan!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
    }

    public static void tambahPesanan() {
        System.out.println("\nJenis Pesanan:");
        System.out.println("1. Makanan");
        System.out.println("2. Minuman");
        System.out.print("Pilih jenis: ");
        int jenis = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Jumlah: ");
        int jumlah = scanner.nextInt();
        System.out.print("Harga: ");
        double harga = scanner.nextDouble();

        if (jenis == 1) {
            System.out.print("Apakah makanan pedas? (true/false): ");
            boolean pedas = scanner.nextBoolean();
            tambahPesanan(nama, jumlah, harga, pedas); // Overload makanan
        } else if (jenis == 2) {
            System.out.print("Apakah minuman dingin? (true/false): ");
            boolean dingin = scanner.nextBoolean();
            tambahPesanan(nama, jumlah, harga, dingin); // Overload minuman
        } else {
            System.out.println("Jenis pesanan tidak valid.");
        }
    }

    // Overloading
    public static void tambahPesanan(String nama, int jumlah, double harga, boolean pedas) {
        daftarPesanan.add(new Makanan(nama, jumlah, harga, pedas));
        System.out.println("Pesanan makanan berhasil ditambahkan.");
    }

    public static void tambahPesanan(String nama, int jumlah, double harga, Boolean dingin) {
        daftarPesanan.add(new Minuman(nama, jumlah, harga, dingin));
        System.out.println("Pesanan minuman berhasil ditambahkan.");
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
        scanner.nextLine();

        if (index >= 0 && index < daftarPesanan.size()) {
            Pesanan pesanan = daftarPesanan.get(index);

            System.out.print("Nama baru: ");
            String nama = scanner.nextLine();
            System.out.print("Jumlah baru: ");
            int jumlah = scanner.nextInt();
            System.out.print("Harga baru: ");
            double harga = scanner.nextDouble();
            scanner.nextLine();

            pesanan.setNama(nama);
            pesanan.setJumlah(jumlah);
            pesanan.setHarga(harga);

            if (pesanan instanceof Makanan) {
                System.out.print("Apakah makanan pedas? (true/false): ");
                boolean pedas = scanner.nextBoolean();
                ((Makanan) pesanan).setPedas(pedas);
            } else if (pesanan instanceof Minuman) {
                System.out.print("Apakah minuman dingin? (true/false): ");
                boolean dingin = scanner.nextBoolean();
                ((Minuman) pesanan).setDingin(dingin);
            }

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
        scanner.nextLine();

        if (index >= 0 && index < daftarPesanan.size()) {
            daftarPesanan.remove(index);
            System.out.println("Pesanan berhasil dihapus!");
        } else {
            System.out.println("Nomor pesanan tidak valid.");
        }
    }
}
