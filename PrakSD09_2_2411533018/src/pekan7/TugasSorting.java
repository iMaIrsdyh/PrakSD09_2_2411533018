package pekan7;

public class TugasSorting {
    public static void main(String[] args) {
        char[] a = new char[26];
        int b = 18; // Jumlah elemen yang akan diurutkan
        // Inisialisasi array dengan huruf dari z ke a
        for (int i = 0; i < 26; i++) {
            a[i] = (char) ('z' - i);
        }
        // Panggil metode bubble sort untuk 18 elemen pertama
        bubbleSort(a, b);
        // Cetak seluruh isi array setelah sorting sebagian
        for (int i = 0; i < 26; i++) {
            System.out.print(a[i] + " ");
        }
    }
    // Metode bubble sort untuk n elemen pertama dari array
    public static void bubbleSort(char[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    // Tukar elemen
                    char temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
