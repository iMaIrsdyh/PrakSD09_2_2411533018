package pekan6;

public class TugasNode {
    TugasItemBelanja data;
    TugasNode prev;
    TugasNode next;

    public TugasNode(TugasItemBelanja data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
