public class Nodegraph {
    String namaLokasi;
    int jarak;
    boolean visited;
    Edgegraph neighbors;
    Nodegraph prev;
    Nodegraph next;
    boolean isCabang;

    public Nodegraph(String namaLokasi) {
        this.namaLokasi = namaLokasi;
        this.jarak = Integer.MAX_VALUE;
        this.visited = false;
        this.neighbors = null;
        this.prev = null;
        this.next = null;
        this.isCabang = false; 
    }
    public void addNeighbor(Nodegraph target, int jarak) {
        Edgegraph edgegraph = new Edgegraph(target, jarak);
        if (neighbors == null) {
            neighbors = edgegraph;
        } else {
            Edgegraph current = neighbors;
            while (current.next != null) {
                current = current.next;
            }
            current.next = edgegraph;
        }
    }
}