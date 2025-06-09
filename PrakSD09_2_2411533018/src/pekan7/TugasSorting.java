package pekan7;

public class TugasSorting {
    public static void main(String[] args) {
        char[] a = new char[26];
        int b = 17;

        // Inisialisasi array dengan huruf dari z ke a
        for (int i = 0; i < 26; i++) {
            a[i] = (char) ('z' - i);
        }
        // Panggil metode insertion sort untuk n elemen pertama
        is(a, b);

        // Cetak seluruh isi array setelah sorting
        for (int i = 0; i < 26; i++) {
            System.out.print(a[i] + " ");
        }
    }
    // Metode insertion sort
    public static void is(char[] a, int n) {
        for (int i = 1; i < n; i++) {
            char key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
}
