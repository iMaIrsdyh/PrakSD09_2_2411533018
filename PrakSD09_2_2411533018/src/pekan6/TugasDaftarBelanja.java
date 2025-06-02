package pekan6;

public class TugasDaftarBelanja {
    private TugasNode head;
    private TugasNode tail;

    public void tambahItem(String nama, int kuantitas, String kategori) {
        TugasItemBelanja item = new TugasItemBelanja(nama, kuantitas, kategori);
        TugasNode newNode = new TugasNode(item);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Item berhasil ditambahkan!");
    }

    public void hapusItem(String nama) {
        TugasNode current = head;

        while (current != null) {
            if (current.data.nama.equalsIgnoreCase(nama)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) head.prev = null;
                    else tail = null;
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Item berhasil dihapus.");
                return;
            }
            current = current.next;
        }

        System.out.println("Item tidak ditemukan.");
    }

    public void tampilkanSemuaItem() {
        if (head == null) {
            System.out.println("Daftar belanja kosong.");
            return;
        }

        System.out.println("--- Daftar Belanja ---");
        TugasNode current = head;
        while (current != null) {
            TugasItemBelanja item = current.data;
            System.out.printf("- %s (%d) [%s]%n", item.nama, item.kuantitas, item.kategori);
            current = current.next;
        }
    }

    public void tampilkanPerKategori(String kategori) {
        boolean ditemukan = false;
        TugasNode current = head;
        System.out.printf("--- Item dalam kategori '%s' ---%n", kategori);
        while (current != null) {
            if (current.data.kategori.equalsIgnoreCase(kategori)) {
                System.out.printf("- %s (%d)%n", current.data.nama, current.data.kuantitas);
                ditemukan = true;
            }
            current = current.next;
        }

        if (!ditemukan) {
            System.out.println("Tidak ada item dalam kategori tersebut.");
        }
    }

    public void cariItem(String nama) {
        TugasNode current = head;
        while (current != null) {
            if (current.data.nama.equalsIgnoreCase(nama)) {
                TugasItemBelanja item = current.data;
                System.out.printf("Item ditemukan: %s (%d) [%s]%n", item.nama, item.kuantitas, item.kategori);
                return;
            }
            current = current.next;
        }
        System.out.println("Item tidak ditemukan.");
    }
}
