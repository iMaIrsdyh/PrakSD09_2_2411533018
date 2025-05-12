package pekan3;

import java.util.Scanner;
import java.util.Stack;

public class PerpustakaanMini {
    Stack<Buku> tumpukanBuku = new Stack<>();

    public void tambahBuku(Buku buku) {
        tumpukanBuku.push(buku);
        System.out.println("Buku \"" + buku.judul + "\" telah ditambahkan.");
    }

    public void ambilBuku() {
        if (!tumpukanBuku.isEmpty()) {
            Buku buku = tumpukanBuku.pop();
            System.out.println("Buku diambil: " + buku.judul);
        } else {
            System.out.println("Tumpukan kosong. Tidak ada buku yang bisa diambil.");
        }
    }

    public void lihatTumpukan() {
        if (tumpukanBuku.isEmpty()) {
            System.out.println("Tumpukan kosong.");
        } else {
            System.out.println("Tumpukan Buku Saat Ini:");
            for (int i = tumpukanBuku.size() - 1; i >= 0; i--) {
                System.out.println("- " + tumpukanBuku.get(i).judul);
            }
        }
    }

    public void cariBuku(String judul) {
        boolean ditemukan = false;
        for (Buku buku : tumpukanBuku) {
            if (buku.judul.equalsIgnoreCase(judul)) {
                ditemukan = true;
                break;
            }
        }
        if (ditemukan) {
            System.out.println("Buku \"" + judul + "\" ditemukan dalam tumpukan.");
        } else {
            System.out.println("Buku \"" + judul + "\" tidak ditemukan dalam tumpukan.");
        }
    }

    public static void main(String[] args) {
        PerpustakaanMini pm = new PerpustakaanMini();
        Scanner scanner = new Scanner(System.in);

        // Menambahkan 7 buku awal
        pm.tambahBuku(new Buku("Algoritma Dasar"));
        pm.tambahBuku(new Buku("Struktur Data"));
        pm.tambahBuku(new Buku("Basis Data"));
        pm.tambahBuku(new Buku("Pemrograman Java"));
        pm.tambahBuku(new Buku("Jaringan Komputer"));
        pm.tambahBuku(new Buku("Sistem Operasi"));
        pm.tambahBuku(new Buku("Kecerdasan Buatan"));

        int pilihan;

        do {
            System.out.println("\n=== MENU PERPUSTAKAAN MINI ===");
            System.out.println("1. Tambah Buku ke Tumpukan");
            System.out.println("2. Ambil Buku Teratas");
            System.out.println("3. Lihat Tumpukan Buku");
            System.out.println("4. Cari Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Judul Buku: ");
                    String judul = scanner.nextLine();
                    pm.tambahBuku(new Buku(judul));
                    break;
                case 2:
                    pm.ambilBuku();
                    break;
                case 3:
                    pm.lihatTumpukan();
                    break;
                case 4:
                    System.out.print("Masukkan Judul Buku yang Dicari: ");
                    String cari = scanner.nextLine();
                    pm.cariBuku(cari);
                    break;
                case 5:
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}

