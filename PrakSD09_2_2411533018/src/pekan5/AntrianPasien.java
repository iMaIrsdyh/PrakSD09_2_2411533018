package pekan5;

import java.util.Scanner;

public class AntrianPasien {
    static class Node {
        int noAntrian;
        String nama;
        String keluhan;
        Node next;

        Node(int noAntrian, String nama, String keluhan) {
            this.noAntrian = noAntrian;
            this.nama = nama;
            this.keluhan = keluhan;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void tambahPasien(int noAntrian, String nama, String keluhan) {
        Node newNode = new Node(noAntrian, nama, keluhan);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Data pasien berhasil ditambahkan!");
    }

    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("--- Daftar Antrian Pasien ---");
        Node current = head;
        int i = 1;
        while (current != null) {
            System.out.println(i + ". [" + current.noAntrian + "] " + current.nama + " - " + current.keluhan);
            current = current.next;
            i++;
        }
    }

    public void hapusPasienPertama() {
        if (isEmpty()) {
            System.out.println("Antrian kosong. Tidak ada pasien yang dapat dilayani.");
            return;
        }

        System.out.println("Pasien dengan nama " + head.nama + " telah dilayani (dihapus dari antrian).");
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    public void cariPasien(String nama) {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.nama.equalsIgnoreCase(nama)) {
                System.out.println("Data pasien ditemukan: [" + current.noAntrian + "] " + current.nama + " - " + current.keluhan);
                found = true;
                break;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Pasien dengan nama " + nama + " tidak ditemukan dalam antrian.");
        }
    }

    public int hitungPasien() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        AntrianPasien antrian = new AntrianPasien();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        System.out.println("=== SISTEM ANTRIAN PASIEN KLINIK ===");

        do {
            System.out.println("\n1. Tambah Pasien");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Layani Pasien (Hapus Antrian Pertama)");
            System.out.println("4. Cari Pasien");
            System.out.println("5. Jumlah Pasien");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Buang newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nomor Antrian: ");
                    int no = scanner.nextInt();
                    scanner.nextLine(); // Buang newline
                    System.out.print("Masukkan Nama Pasien: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Keluhan: ");
                    String keluhan = scanner.nextLine();
                    antrian.tambahPasien(no, nama, keluhan);
                    break;
                case 2:
                    antrian.tampilkanAntrian();
                    break;
                case 3:
                    antrian.hapusPasienPertama();
                    break;
                case 4:
                    System.out.print("Masukkan Nama Pasien yang dicari: ");
                    String cari = scanner.nextLine();
                    antrian.cariPasien(cari);
                    break;
                case 5:
                    int jumlah = antrian.hitungPasien();
                    System.out.println("Jumlah pasien saat ini: " + jumlah);
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan sistem.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 6);

        scanner.close();
    }
}
