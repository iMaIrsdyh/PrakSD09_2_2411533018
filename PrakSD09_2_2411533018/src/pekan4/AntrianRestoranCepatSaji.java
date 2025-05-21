package pekan4;

import java.util.*;
import java.util.Queue;
import java.util.Scanner;

class Pelanggan {
    String id;
    int jumlahPesanan;

    public Pelanggan(String id, int jumlahPesanan) {
        this.id = id;
        this.jumlahPesanan = jumlahPesanan;
    }
}

public class AntrianRestoranCepatSaji {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Pelanggan> queue = new LinkedList<>();

        int n = scanner.nextInt(); // Membaca jumlah pelanggan

        // Membaca data pelanggan dan menambahkannya ke antrian
        for (int i = 0; i < n; i++) {
            String id = scanner.next();
            int jumlahPesanan = scanner.nextInt();
            queue.add(new Pelanggan(id, jumlahPesanan));
        }

        int waktuTotal = 0;

        // Memproses antrian pelanggan
        while (!queue.isEmpty()) {
            Pelanggan pelanggan = queue.poll(); // Mengambil pelanggan pertama dari antrian
            waktuTotal += pelanggan.jumlahPesanan; // Menambahkan waktu pesanan
            System.out.println(pelanggan.id + " selesai dalam " + waktuTotal + " menit");
        }

        scanner.close();
    }
}
