package pekan9;

import java.util.*;

// Karimah Irsyadiyah
// 2411533018

//Jalur BFS dari A ke G:
//Urutan kunjungan BFS tergantung urutan tetangga dalam list. Dengan Arrays.asList(...) seperti di atas, maka BFS akan:
//Mulai dari A
//Antri tetangga B, C
//Kunjungi B, lalu tambahkan D
//Kunjungi C, tambahkan D (sudah ada) dan E
//Kunjungi D, tambahkan F
//Kunjungi E, tambahkan H
//Kunjungi F, tambahkan G
//Kunjungi H
//Kunjungi G dan selesai

public class TugasSearchingGraf {

    // Adjacency list untuk menyimpan graf
    private static Map<String, List<String>> graf = new HashMap<>();

    // Inisialisasi graf berdasarkan gambar
    static {
        graf.put("A", Arrays.asList("B", "C"));
        graf.put("B", Arrays.asList("A", "D"));
        graf.put("C", Arrays.asList("A", "D", "E"));
        graf.put("D", Arrays.asList("B", "C", "F"));
        graf.put("E", Arrays.asList("C", "F", "H"));
        graf.put("F", Arrays.asList("D", "E", "G"));
        graf.put("G", Arrays.asList("F", "H"));
        graf.put("H", Arrays.asList("E", "G"));
    }

    public static void search(String startNode, String goalNode) {
        System.out.println("Nama: Karimah Irsyadiyah");
        System.out.println("NIM: 2411533018");
        System.out.println("Node awal: " + startNode);
        System.out.println("Node tujuan: " + goalNode);
        System.out.println("Algoritma: BFS");

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();
        int langkah = 1;

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println("Langkah " + langkah + ": Kunjungi " + current);
            langkah++;

            if (current.equals(goalNode)) {
                // Bangun rute dari startNode ke goalNode
                List<String> path = new ArrayList<>();
                for (String node = goalNode; node != null; node = parent.get(node)) {
                    path.add(0, node);
                }
                System.out.println("Rute: " + String.join(" → ", path));
                return;
            }

            for (String neighbor : graf.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                }
            }
        }

        System.out.println("Node tujuan tidak ditemukan.");
    }

    public static void main(String[] args) {
        search("A", "G");
    }
}


