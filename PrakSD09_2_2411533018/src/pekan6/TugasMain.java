package pekan6;

import java.util.Scanner;

public class TugasMain {
    public static void main(String[] args) {
        TugasDaftarBelanja daftar = new TugasDaftarBelanja();
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU DAFTAR BELANJA ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Hapus Item");
            System.out.println("3. Tampilkan Semua Item");
            System.out.println("4. Tampilkan Item Berdasarkan Kategori");
            System.out.println("5. Cari Item");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // membersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama item: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan kuantitas: ");
                    int qty = input.nextInt();
                    input.nextLine(); // buffer
                    System.out.print("Masukkan kategori: ");
                    String kategori = input.nextLine();
                    daftar.tambahItem(nama, qty, kategori);
                    break;

                case 2:
                    System.out.print("Masukkan nama item yang ingin dihapus: ");
                    String hapusNama = input.nextLine();
                    daftar.hapusItem(hapusNama);
                    break;

                case 3:
                    daftar.tampilkanSemuaItem();
                    break;

                case 4:
                    System.out.print("Masukkan kategori: ");
                    String kat = input.nextLine();
                    daftar.tampilkanPerKategori(kat);
                    break;

                case 5:
                    System.out.print("Masukkan nama item yang ingin dicari: ");
                    String cari = input.nextLine();
                    daftar.cariItem(cari);
                    break;

                case 6:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 6);

        input.close();
    }
}
