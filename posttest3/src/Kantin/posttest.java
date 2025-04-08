package Kantin;
import java.util.ArrayList;
import java.util.Scanner;

public class posttest {
    private static ArrayList<Pesanan> daftarPesanan = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== Sistem Pemesanan Makanan Kantin ===");
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
        System.out.println("Pilih jenis pesanan:");
        System.out.println("1. Makanan");
        System.out.println("2. Minuman");
        System.out.print("Pilihan: ");
        int jenis = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan jumlah: ");
        int jumlah = scanner.nextInt();
        System.out.print("Masukkan harga: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();

        if (jenis == 1) {
            System.out.print("Apakah makanan pedas? (true/false): ");
            boolean pedas = scanner.nextBoolean();
            scanner.nextLine();
            daftarPesanan.add(new Makanan(nama, jumlah, harga, pedas));
        } else if (jenis == 2) {
            System.out.print("Apakah minuman dingin? (true/false): ");
            boolean dingin = scanner.nextBoolean();
            scanner.nextLine();
            daftarPesanan.add(new Minuman(nama, jumlah, harga, dingin));
        } else {
            System.out.println("Jenis pesanan tidak valid.");
        }

        System.out.println("Pesanan berhasil ditambahkan!");
    }

    public static void lihatPesanan() {
        if (daftarPesanan.isEmpty()) {
            System.out.println("Tidak ada pesanan.");
            return;
        }
        System.out.println("\n=== Daftar Pesanan ===");
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

            System.out.print("Masukkan nama baru: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan jumlah baru: ");
            int jumlah = scanner.nextInt();
            System.out.print("Masukkan harga baru: ");
            double harga = scanner.nextDouble();
            scanner.nextLine();

            pesanan.setNama(nama);
            pesanan.setJumlah(jumlah);
            pesanan.setHarga(harga);

            if (pesanan instanceof Makanan) {
                Makanan makanan = (Makanan) pesanan;
                System.out.print("Apakah makanan pedas? (true/false): ");
                boolean pedas = scanner.nextBoolean();
                scanner.nextLine();
                makanan.setPedas(pedas);
            } else if (pesanan instanceof Minuman) {
                Minuman minuman = (Minuman) pesanan;
                System.out.print("Apakah minuman dingin? (true/false): ");
                boolean dingin = scanner.nextBoolean();
                scanner.nextLine();
                minuman.setDingin(dingin);
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
