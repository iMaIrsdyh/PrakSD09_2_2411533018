package pekan2;
import java.util.*;

public class Perpustakaan {
	class Buku {
		String judul, pengarang, isbn;
		Buku (String judul, String pengarang, String isbn) {
			this.judul = judul;
			this.pengarang = pengarang;
			this.isbn = isbn;
		}
	}
		LinkedList<Buku> koleksiBuku = new LinkedList<>();
		Queue<Buku> Peminjaman = new LinkedList<>();
		Stack<Buku> Pengembalian = new Stack<>();
		
//menggunakan LinkedList		
		void tambahBuku(String judul, String pengarang, String isbn) {
			koleksiBuku.add(new Buku(judul, pengarang, isbn));
	}

//Menggunakan queue
		void pinjamBuku(String judul) {
			for (Buku buku :koleksiBuku) {
				if (buku.judul.equals(judul)) {
					Peminjaman.add(buku);
					break;
				}
			}
		}
}
