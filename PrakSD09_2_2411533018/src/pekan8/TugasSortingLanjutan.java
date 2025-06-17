package pekan8;

//Nama: Karimah Irsyadiyah
//NIM: 2411533018

import java.util.Arrays;

public class TugasSortingLanjutan {

 public static void main(String[] args) {
	 
     // Membuat deret bilangan prima dari 1 sampai 50
     int[] deretPrima = new int[15]; 
     int indeks = 0;

     for (int i = 1; i <= 50; i++) {
         boolean prima = true;
         if (i < 2) prima = false;
         else {
             for (int j = 2; j <= Math.sqrt(i); j++) {
                 if (i % j == 0) {
                     prima = false;
                     break;
                 }
             }
         }
         if (prima) {
             deretPrima[indeks++] = i;
         }
     }

     deretPrima = Arrays.copyOf(deretPrima, indeks);
     System.out.println("Deret awal: " + Arrays.toString(deretPrima));
     System.out.println("Algoritma: Merge Sort");

     mergeSort(deretPrima, 0, deretPrima.length - 1);

     System.out.println("Hasil: " + Arrays.toString(deretPrima));
 }

 public static void mergeSort(int[] array, int kiri, int kanan) {
     if (kiri < kanan) {
         int tengah = (kiri + kanan) / 2;
         mergeSort(array, kiri, tengah);
         mergeSort(array, tengah + 1, kanan);
         merge(array, kiri, tengah, kanan);

         // Tampilkan array setelah setiap proses merge
         System.out.println("Merge: " + Arrays.toString(Arrays.copyOfRange(array, kiri, kanan + 1)));
     }
 }

 // Proses penggabungan dua bagian array secara descending
 public static void merge(int[] array, int kiri, int tengah, int kanan) {
     int panjangKiri = tengah - kiri + 1;
     int panjangKanan = kanan - tengah;

     int[] kiriArray = new int[panjangKiri];
     int[] kananArray = new int[panjangKanan];

     for (int i = 0; i < panjangKiri; i++)
         kiriArray[i] = array[kiri + i];
     for (int j = 0; j < panjangKanan; j++)
         kananArray[j] = array[tengah + 1 + j];

     int i = 0, j = 0, k = kiri;

     while (i < panjangKiri && j < panjangKanan) {
         if (kiriArray[i] >= kananArray[j]) {
             array[k] = kiriArray[i];
             i++;
         } else {
             array[k] = kananArray[j];
             j++;
         }
         k++;
     }

     while (i < panjangKiri) {
         array[k] = kiriArray[i];
         i++;
         k++;
     }

     while (j < panjangKanan) {
         array[k] = kananArray[j];
         j++;
         k++;
     }
 }
}